package com.solveria.peopleu.continuinged.architecture;

import java.util.List;

/** Los paquetes de modulo de este servicio, uno por capitulo de los documentos maestros. */
final class Modules {

    private Modules() {}

    static final List<String> ALL =
            List.of(
                    "ec01_portafolio_microcredenciales",
                    "ec02_ediciones_oferta_cohortes",
                    "ec03_comercializacion_precios_becas",
                    "ec04_inscripcion_participantes",
                    "ec05_docentes_facilitadores",
                    "ec06_asistencia_participacion",
                    "ec07_evaluacion_completion",
                    "ec08_certificados_credenciales",
                    "ec09_formacion_corporativa",
                    "ec10_trayectoria_stacking",
                    "ec11_feedback_impacto",
                    "ec12_calidad_portafolio");
}
