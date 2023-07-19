package de.neuefische.catjpademo.service;

import de.neuefische.catjpademo.dto.CatOwnerWithoutCatsDto;
import de.neuefische.catjpademo.dto.CatWithOwnerDto;
import de.neuefische.catjpademo.dto.CatWithoutOwnerDto;
import de.neuefische.catjpademo.entity.Cat;
import de.neuefische.catjpademo.entity.CatOwner;
import de.neuefische.catjpademo.repository.CatOwnerRepository;
import de.neuefische.catjpademo.repository.CatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CatService {

    private final CatRepository catRepository;
    private final CatOwnerRepository catOwnerRepository;

    public List<CatWithoutOwnerDto> getAllCatsWithoutOwner() {
        return catRepository
                .findAll()
                .stream()
                .map(cat -> new CatWithoutOwnerDto(
                        cat.getCatId(),
                        cat.getName())
                )
                .toList();
    }

    public CatWithOwnerDto getCatWithOwnerById(String id) {
        Cat cat = catRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Cat with id " + id + " not found"));
        if(cat.getOwner() == null) {
            return new CatWithOwnerDto(cat.getCatId(), cat.getName(), null);
        }
        CatOwner owner = catOwnerRepository.findById(cat.getOwner().getCatOwnerId()).orElseThrow(() -> new NoSuchElementException("Owner with id " + cat.getOwner().getCatOwnerId() + " not found"));
        return new CatWithOwnerDto(cat.getCatId(), cat.getName(), new CatOwnerWithoutCatsDto(owner.getCatOwnerId(), owner.getName()));
    }

    public CatWithoutOwnerDto getCatWithoutOwnerById(String id) {
        Cat cat = catRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Cat with id " + id + " not found"));
        return new CatWithoutOwnerDto(cat.getCatId(), cat.getName());
    }

    public CatWithoutOwnerDto addCatWithoutOwner(CatWithoutOwnerDto cat) {
        Cat savedCat = catRepository.save(
                new Cat(null,
                        cat.name(),
                        null));

        return new CatWithoutOwnerDto(
                savedCat.getCatId(),
                savedCat.getName()
        );
    }

    public CatWithOwnerDto addCatWithOwner(CatWithOwnerDto cat) {
        CatOwner owner = catOwnerRepository.findById(cat.owner().id())
                .orElseThrow(() -> new NoSuchElementException("Owner with id " + cat.owner().id() + " not found"));

        Cat savedCat = catRepository.save(new Cat(null, cat.name(), owner));

        return new CatWithOwnerDto(
                savedCat.getCatId(),
                savedCat.getName(),
                new CatOwnerWithoutCatsDto(
                        owner.getCatOwnerId(),
                        owner.getName()
                )
        );
    }

    public CatWithOwnerDto updateCatWithOwner(String id, CatWithOwnerDto cat) {
        CatOwner ownerToUpdate = catOwnerRepository.findById(cat.owner().id()).orElseThrow(() -> new NoSuchElementException("Owner with id " + cat.owner().id() + " not found"));

        Cat savedCat = catRepository.save(
                new Cat(
                        id,
                        cat.name(),
                        ownerToUpdate
                )
        );

        return new CatWithOwnerDto(
                savedCat.getCatId(),
                savedCat.getName(),
                new CatOwnerWithoutCatsDto(
                        ownerToUpdate.getCatOwnerId(),
                        ownerToUpdate.getName()
                )
        );
    }

    public CatWithoutOwnerDto updateCatWithoutOwner(String id, CatWithoutOwnerDto cat) {
        Cat catToUpdate = catRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Cat with id " + id + " not found"));

        catToUpdate.setName(cat.name());

        Cat savedCat = catRepository.save(catToUpdate);

        return new CatWithoutOwnerDto(
                savedCat.getCatId(),
                savedCat.getName()
        );
    }

    public void deleteCatById(String id) {
        catRepository.deleteById(id);
    }

}
