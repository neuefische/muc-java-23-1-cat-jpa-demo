package de.neuefische.catjpademo.dto;

import java.util.List;

public record CatOwnerWithCatsDto(
        Long id,
        String name,
        List<CatWithoutOwnerDto> cats
) {
}
