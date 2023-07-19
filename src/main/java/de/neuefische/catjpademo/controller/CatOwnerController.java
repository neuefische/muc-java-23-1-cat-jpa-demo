package de.neuefische.catjpademo.controller;

import de.neuefische.catjpademo.dto.CatOwnerWithCatsDto;
import de.neuefische.catjpademo.dto.CatOwnerWithoutCatsDto;
import de.neuefische.catjpademo.service.CatOwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cat-owners")
@RequiredArgsConstructor
public class CatOwnerController {

    private final CatOwnerService catOwnerService;

    @GetMapping
    public List<CatOwnerWithoutCatsDto> getAllCatOwnersWithoutCats() {
        return catOwnerService.getAllCatOwnersWithoutCats();
    }

    @GetMapping("/with-cats/{id}")
    public CatOwnerWithCatsDto getCatOwnerWithoutCatsById(@PathVariable String id) {
        return catOwnerService.getCatOwnerWithCatsById(id);
    }

    @GetMapping("/without-cats/{id}")
    public CatOwnerWithoutCatsDto getCatOwnerWithCatsById(@PathVariable String id) {
        return catOwnerService.getCatsOwnerWithoutCatsById(id);
    }

    @PostMapping("/without-cats/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CatOwnerWithoutCatsDto addCatOwnerWithoutCats(@RequestBody CatOwnerWithoutCatsDto catOwner) {
        return catOwnerService.addCatOwnerWithoutCats(catOwner);
    }

    @PostMapping("/with-cats/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CatOwnerWithCatsDto addCatOwnerWithCats(@RequestBody CatOwnerWithCatsDto catOwner) {
        return catOwnerService.addCatOwnerWithCats(catOwner);
    }

    @PutMapping("/with-cats/{id}")
    public CatOwnerWithCatsDto updateCatOwnerWithCats(@PathVariable String id, @RequestBody CatOwnerWithCatsDto catOwner) {
        return catOwnerService.updateCatOwnerWithCats(id, catOwner);
    }

    @PutMapping("/without-cats/{id}")
    public CatOwnerWithoutCatsDto updateCatOwnerWithoutCats(@PathVariable String id, @RequestBody CatOwnerWithoutCatsDto catOwner) {
        return catOwnerService.updateCatOwnerWithoutCats(id, catOwner);
    }

    @DeleteMapping("/with-cats/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCatOwnerWithCats(@PathVariable String id) {
        catOwnerService.deleteCatOwnerById(id);
    }

}