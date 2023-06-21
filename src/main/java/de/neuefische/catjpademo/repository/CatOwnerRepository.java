package de.neuefische.catjpademo.repository;

import de.neuefische.catjpademo.entity.CatOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatOwnerRepository extends JpaRepository<CatOwner, Long> {
}
