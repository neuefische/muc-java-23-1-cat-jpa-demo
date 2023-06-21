package de.neuefische.catjpademo.dto;

public record CatWithOwnerDto(
        Long id,
        String name,
        CatOwnerWithoutCatsDto owner
) {
}
