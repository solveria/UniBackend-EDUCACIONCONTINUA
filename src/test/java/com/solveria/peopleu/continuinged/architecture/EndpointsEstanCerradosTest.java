package com.solveria.peopleu.continuinged.architecture;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Ningun endpoint del servicio puede quedar sin {@code @PreAuthorize}.
 *
 * <p>Existe porque ya paso en otro servicio de la plataforma: nueve controladores de un capitulo
 * estuvieron sin una sola comprobacion de permisos y las pruebas no lo detectaron, porque en el
 * perfil de test {@code security.jwt.enabled=false} y las capabilities siempre dan {@code true}. Un
 * test funcional no sirve para esto; hace falta uno que mire las anotaciones.
 *
 * <p>Se lee del bytecode y no del texto de los archivos a proposito: un {@code grep} tambien
 * encuentra la anotacion dentro de un comentario.
 *
 * <p>Mientras el servicio no tenga ningun controlador (el esqueleto recien creado) la prueba se
 * salta con un aviso, no pasa en silencio: en cuanto exista el primero, vigila.
 */
class EndpointsEstanCerradosTest {

    private static final String BASE = "com.solveria.peopleu.continuinged";

    private static final List<Class<? extends Annotation>> MAPEOS =
            List.of(
                    GetMapping.class,
                    PostMapping.class,
                    PutMapping.class,
                    PatchMapping.class,
                    DeleteMapping.class,
                    RequestMapping.class);

    @Test
    @DisplayName("todo metodo con @...Mapping en un @RestController lleva @PreAuthorize")
    void everyEndpointIsGuarded() throws Exception {
        List<Class<?>> controllers = controllers();
        assumeFalse(
                controllers.isEmpty(),
                "todavia no hay ningun @RestController en el servicio: nada que vigilar");

        List<String> abiertos = new ArrayList<>();
        for (Class<?> controller : controllers) {
            for (Method method : controller.getDeclaredMethods()) {
                if (method.isSynthetic() || !esEndpoint(method)) {
                    continue;
                }
                if (method.getAnnotation(PreAuthorize.class) == null) {
                    abiertos.add(controller.getSimpleName() + "." + method.getName() + "()");
                }
            }
        }

        assertThat(abiertos)
                .as(
                        "estos endpoints no comprueban ninguna capability; con"
                                + " security.jwt.enabled=true los alcanza cualquiera que haya iniciado"
                                + " sesion")
                .isEmpty();
    }

    private boolean esEndpoint(Method method) {
        return MAPEOS.stream().anyMatch(mapeo -> method.getAnnotation(mapeo) != null);
    }

    /** Recorre las clases compiladas: no depende de que alguien mantenga una lista al dia. */
    private List<Class<?>> controllers() throws IOException {
        Path raiz = Path.of("target", "classes", BASE.replace('.', '/'));
        if (!Files.isDirectory(raiz)) {
            return List.of();
        }
        try (Stream<Path> archivos = Files.walk(raiz)) {
            return archivos.filter(p -> p.toString().endsWith("Controller.class"))
                    .<Class<?>>map(this::cargar)
                    .filter(c -> c != null && c.getAnnotation(RestController.class) != null)
                    .toList();
        }
    }

    private Class<?> cargar(Path archivo) {
        // El separador de Path.relativize().toString() es el del SO: hay que normalizar ambos o
        // Class.forName() recibe un nombre invalido y el descubrimiento vuelve vacio en silencio.
        String nombre =
                Path.of("target", "classes")
                        .relativize(archivo)
                        .toString()
                        .replace(".class", "")
                        .replace('/', '.')
                        .replace('\\', '.');
        try {
            return Class.forName(nombre, false, getClass().getClassLoader());
        } catch (ClassNotFoundException | NoClassDefFoundError e) {
            return null;
        }
    }
}
