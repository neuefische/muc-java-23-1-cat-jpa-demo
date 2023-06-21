package de.neuefische.catjpademo.dto;

import java.util.List;

public record CatOwnerPostRequest(
        String name,
        List<CatPostRequest> cats
) {
}
