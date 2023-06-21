package de.neuefische.catjpademo.controller;

import de.neuefische.catjpademo.dto.CatOwnerGetRequest;
import de.neuefische.catjpademo.dto.CatOwnerPostRequest;
import de.neuefische.catjpademo.service.CatOwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
@RequiredArgsConstructor
public class CatOwnerController {

    private final CatOwnerService catOwnerService;

    @GetMapping
    public List<CatOwnerGetRequest> getAllCatOwners() {
        return catOwnerService.getAllCatOwners();
    }

    @GetMapping("/{id}")
    public CatOwnerGetRequest getCatOwnerById(@PathVariable Long id) {
        return catOwnerService.getCatOwnerById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CatOwnerGetRequest addCatOwner(@RequestBody CatOwnerPostRequest catOwnerPostRequest) {
        return catOwnerService.addCatOwner(catOwnerPostRequest);
    }

}
