package de.neuefische.catjpademo.dto;

import de.neuefische.catjpademo.entity.CatOwner;

public record CatPostRequest(
        String name,
        CatOwnerPostRequest owner
) {
}
