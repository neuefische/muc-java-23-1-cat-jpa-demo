package de.neuefische.catjpademo.dto;

import de.neuefische.catjpademo.entity.CatOwner;

public record CatGetRequest(
        Long id,
        String name,
        CatOwnerGetRequest owner
) {
}
