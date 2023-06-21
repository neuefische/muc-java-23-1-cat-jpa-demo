package de.neuefische.catjpademo.controller;

import de.neuefische.catjpademo.entity.Cat;
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
    public List<Cat> getAllCats() {
        return catService.getAllCats();
    }

    @GetMapping("/{id}")
    public Cat getCatById(@PathVariable Long id) {
        return catService.getCatById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cat addCat(@RequestBody Cat cat) {
        return catService.addCat(cat);
    }

    @PutMapping("/{id}")
    public Cat updateCat(@PathVariable Long id, @RequestBody Cat cat) {
        return catService.updateCat(id, cat);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCat(@PathVariable Long id) {
        catService.deleteCat(id);
    }

}
