package de.neuefische.catjpademo.dto;

public record CatWithOwnerDto(
        String id,
        String name,
        CatOwnerWithoutCatsDto owner
) {
}
