package de.neuefische.catjpademo.dto;

import java.util.List;

public record CatOwnerWithCatsDto(
        String id,
        String name,
        List<CatWithoutOwnerDto> cats
) {
}
