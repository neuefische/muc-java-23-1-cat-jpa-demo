package de.neuefische.catjpademo.repository;

import de.neuefische.catjpademo.entity.CatOwner;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatOwnerRepository extends MongoRepository<CatOwner, String> {
}
