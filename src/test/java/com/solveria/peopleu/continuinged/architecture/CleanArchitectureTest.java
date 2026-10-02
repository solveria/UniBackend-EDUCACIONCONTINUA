package com.solveria.peopleu.continuinged.architecture;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

/**
 * Las reglas de capas, iguales en todos los servicios de la plataforma: el dominio no conoce
 * frameworks y la aplicacion no conoce ni la API ni la infraestructura.
 *
 * <p>La tercera regla es propia de PeopleU: ningun modulo toca las clases de otro. Lo que un modulo
 * necesita de otro lo pide por un puerto propio, que un adaptador de infraestructura resuelve en
 * proceso o por HTTP, y asi cualquier modulo puede salir a su propio servicio sin reescribir a los
 * demas.
 */
class CleanArchitectureTest {

    private static final String BASE = "com.solveria.peopleu.continuinged";

    @Test
    void domainDoesNotDependOnFrameworks() {
        var classes = imported();
        noClasses()
                .that()
                .resideInAPackage("..domain..")
                .should()
                .dependOnClassesThat()
                .resideInAnyPackage(
                        "org.springframework..", "jakarta.persistence..", "jakarta.servlet..")
                .allowEmptyShould(true)
                .check(classes);
    }

    @Test
    void applicationDoesNotDependOnApiOrInfrastructure() {
        var classes = imported();
        noClasses()
                .that()
                .resideInAPackage("..application..")
                .should()
                .dependOnClassesThat()
                .resideInAnyPackage(BASE + "..api..", BASE + "..infrastructure..")
                .allowEmptyShould(true)
                .check(classes);
    }

    @Test
    void modulesDoNotReachIntoEachOther() {
        var classes = imported();
        for (String module : Modules.ALL) {
            String[] others =
                    Modules.ALL.stream()
                            .filter(other -> !other.equals(module))
                            .map(other -> BASE + "." + other + "..")
                            .toArray(String[]::new);
            noClasses()
                    .that()
                    .resideInAPackage(BASE + "." + module + "..")
                    .should()
                    .dependOnClassesThat()
                    .resideInAnyPackage(others)
                    .allowEmptyShould(true)
                    .check(classes);
        }
    }

    private static com.tngtech.archunit.core.domain.JavaClasses imported() {
        return new ClassFileImporter()
                .withImportOption(new ImportOption.DoNotIncludeTests())
                .importPackages(BASE);
    }
}
