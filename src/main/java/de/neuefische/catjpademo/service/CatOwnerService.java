package de.neuefische.catjpademo.service;

import de.neuefische.catjpademo.dto.CatOwnerWithCatsDto;
import de.neuefische.catjpademo.dto.CatOwnerWithoutCatsDto;
import de.neuefische.catjpademo.dto.CatWithoutOwnerDto;
import de.neuefische.catjpademo.entity.Cat;
import de.neuefische.catjpademo.entity.CatOwner;
import de.neuefische.catjpademo.repository.CatOwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CatOwnerService {

    private final CatOwnerRepository catOwnerRepository;

    public List<CatOwnerWithoutCatsDto> getAllCatOwnersWithoutCats() {
        return catOwnerRepository
                .findAll()
                .stream()
                .map(catOwner -> new CatOwnerWithoutCatsDto(
                        catOwner.getCatOwnerId(),
                        catOwner.getName())
                )
                .toList();
    }

    @Transactional
    public CatOwnerWithCatsDto getCatOwnerWithCatsById(Long id) {
        CatOwner catOwner = catOwnerRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("CatOwner with id " + id + " not found"));
        List<CatWithoutOwnerDto> cats = catOwner.getCats().stream().map(cat -> new CatWithoutOwnerDto(cat.getCatId(), cat.getName())).toList();
        return new CatOwnerWithCatsDto(catOwner.getCatOwnerId(), catOwner.getName(), cats);
    }

    public CatOwnerWithoutCatsDto getCatsOwnerWithoutCatsById(Long id) {
        return catOwnerRepository
                .findById(id)
                .map(catOwner -> new CatOwnerWithoutCatsDto(
                        catOwner.getCatOwnerId(),
                        catOwner.getName())
                )
                .orElseThrow(() -> new RuntimeException("CatOwner with id " + id + " not found"));
    }

    public CatOwnerWithoutCatsDto addCatOwnerWithoutCats(CatOwnerWithoutCatsDto catOwner) {
        CatOwner savedCatowner = catOwnerRepository
                .save(new CatOwner(null, catOwner.name(), new ArrayList<>()));

        return new CatOwnerWithoutCatsDto(
                savedCatowner.getCatOwnerId(),
                savedCatowner.getName()
        );
    }

    public CatOwnerWithCatsDto addCatOwnerWithCats(CatOwnerWithCatsDto catOwner) {
        CatOwner savedCatowner = catOwnerRepository
                .save(new CatOwner(null, catOwner.name(), catOwner.cats().stream().map(cat -> new Cat(null, cat.name(), null)).toList()));

        return new CatOwnerWithCatsDto(
                savedCatowner.getCatOwnerId(),
                savedCatowner.getName(),
                savedCatowner.getCats().stream().map(cat -> new CatWithoutOwnerDto(
                        cat.getCatId(),
                        cat.getName()
                )).toList()
        );
    }

    public CatOwnerWithCatsDto updateCatOwnerWithCats(Long id, CatOwnerWithCatsDto catOwner) {
        CatOwner catOwnerToUpdate = catOwnerRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("CatOwner with id " + id + " not found"));

        catOwnerToUpdate.setName(catOwner.name());
        catOwnerToUpdate.setCats(catOwner.cats().stream().map(cat -> new Cat(null, cat.name(), null)).toList());

        CatOwner savedCatowner = catOwnerRepository.save(catOwnerToUpdate);

        return new CatOwnerWithCatsDto(
                savedCatowner.getCatOwnerId(),
                savedCatowner.getName(),
                savedCatowner.getCats().stream().map(cat -> new CatWithoutOwnerDto(
                        cat.getCatId(),
                        cat.getName()
                )).toList()
        );
    }

    public CatOwnerWithoutCatsDto updateCatOwnerWithoutCats(Long id, CatOwnerWithoutCatsDto catOwner) {
        CatOwner catOwnerToUpdate = catOwnerRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("CatOwner with id " + id + " not found"));

        catOwnerToUpdate.setName(catOwner.name());

        CatOwner savedCatowner = catOwnerRepository.save(catOwnerToUpdate);

        return new CatOwnerWithoutCatsDto(
                savedCatowner.getCatOwnerId(),
                savedCatowner.getName()
        );
    }

    public void deleteCatOwnerById(Long id) {
        catOwnerRepository.deleteById(id);
    }

}
