package de.neuefische.catjpademo.dto;

public record CatRequestDto(
        String name,
        CatOwnerWithoutCatsDto owner
) {
}
