package de.neuefische.catjpademo.dto;

import de.neuefische.catjpademo.entity.Cat;
import de.neuefische.catjpademo.entity.CatOwner;

import java.util.List;

public record CatOwnerGetRequest(
        Long id,
        String name,
        List<CatGetRequest> cats
) {
}
