package de.neuefische.catjpademo.service;

import de.neuefische.catjpademo.dto.CatOwnerGetRequest;
import de.neuefische.catjpademo.entity.CatOwner;
import de.neuefische.catjpademo.repository.CatOwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CatOwnerService {

    private final CatOwnerRepository catOwnerRepository;
    private final CatService catService;

    public List<CatOwnerGetRequest> getAllCatOwners() {
        List<CatOwner> allCatOwners = catOwnerRepository.findAll();
        List<CatOwnerGetRequest> allCatOwnersDto = new ArrayList<>(allCatOwners.size());
        allCatOwners.forEach(catOwner -> allCatOwnersDto.add(mapToDto(catOwner)));
    }

}
