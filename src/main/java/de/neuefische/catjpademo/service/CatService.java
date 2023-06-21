package de.neuefische.catjpademo.service;

import de.neuefische.catjpademo.entity.Cat;
import de.neuefische.catjpademo.repository.CatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CatService {

    private final CatRepository catRepository;

    public List<Cat> getAllCats() {
        return catRepository.findAll();
    }

    public Cat getCatById(Long id) {
        return catRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Cat with id " + id + " not found"));
    }

    public Cat addCat(Cat cat) {
        return catRepository.save(cat);
    }

    public Cat updateCat(Long id, Cat cat) {
        Cat catToUpdate = getCatById(id);
        catToUpdate.setName(cat.getName());
        catToUpdate.setOwner(cat.getOwner());
        return catRepository.save(catToUpdate);
    }

    public void deleteCat(Long id) {
        Cat catToDelete = getCatById(id);
        catRepository.delete(catToDelete);
    }
}
