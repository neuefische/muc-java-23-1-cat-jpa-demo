package de.neuefische.catjpademo.controller;

import de.neuefische.catjpademo.dto.CatWithOwnerDto;
import de.neuefische.catjpademo.dto.CatWithoutOwnerDto;
import de.neuefische.catjpademo.service.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cats")
@RequiredArgsConstructor
public class CatController {

    private final CatService catService;

    @GetMapping
    public List<CatWithoutOwnerDto> getAllCats() {
        return catService.getAllCatsWithoutOwner();
    }

    @GetMapping("/without-owner/{id}")
    public CatWithoutOwnerDto getCatById(@PathVariable String id) {
        return catService.getCatWithoutOwnerById(id);
    }

    @GetMapping("/with-owner/{id}")
    public CatWithOwnerDto getCatWithOwnerById(@PathVariable String id) {
        return catService.getCatWithOwnerById(id);
    }

    @PostMapping("/without-owner/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CatWithoutOwnerDto addCat(@RequestBody CatWithoutOwnerDto cat) {
        return catService.addCatWithoutOwner(cat);
    }

    @PostMapping("/with-owner/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CatWithOwnerDto addCatWithOwner(@RequestBody CatWithOwnerDto cat) {
        return catService.addCatWithOwner(cat);
    }

    @PutMapping("/without-owner/update/{id}")
    public CatWithoutOwnerDto updateCat(@PathVariable String id, @RequestBody CatWithoutOwnerDto cat) {
        return catService.updateCatWithoutOwner(id, cat);
    }

    @PutMapping("/with-owner/update/{id}")
    public CatWithOwnerDto updateCatWithOwner(@PathVariable String id, @RequestBody CatWithOwnerDto cat) {
        return catService.updateCatWithOwner(id, cat);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCat(@PathVariable String id) {
        catService.deleteCatById(id);
    }

}
