package de.neuefische.catjpademo.repository;

import de.neuefische.catjpademo.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {
}
