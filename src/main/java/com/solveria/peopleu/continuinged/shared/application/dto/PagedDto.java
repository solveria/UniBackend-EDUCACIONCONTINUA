package com.solveria.peopleu.continuinged.shared.application.dto;

import java.util.List;
import java.util.Map;

/**
 * El envoltorio de todo listado del servicio: {@code data} mas {@code page}, {@code sort} y {@code
 * filters}. Es la convencion de paginacion de la plataforma; vive en {@code shared} porque es el
 * mismo sobre para todos los modulos y una copia por modulo se separa en cuanto alguien toca una.
 */
public record PagedDto<T>(
        List<T> data, PageInfo page, List<SortInfo> sort, Map<String, Object> filters) {

    public record PageInfo(
            int number,
            int size,
            long totalElements,
            int totalPages,
            boolean first,
            boolean last,
            boolean hasNext,
            boolean hasPrevious) {

        public static PageInfo of(int number, int size, long total) {
            int safeSize = size <= 0 ? 20 : size;
            int totalPages = (int) Math.ceil((double) total / safeSize);
            return new PageInfo(
                    number,
                    safeSize,
                    total,
                    totalPages,
                    number == 0,
                    number >= totalPages - 1,
                    number < totalPages - 1,
                    number > 0);
        }
    }

    public record SortInfo(String field, String direction) {}
}
