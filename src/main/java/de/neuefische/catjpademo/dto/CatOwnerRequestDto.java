package de.neuefische.catjpademo.dto;

import java.util.List;

public record CatOwnerRequestDto(
        String name,
        List<CatWithoutOwnerDto> cats
) {
}
