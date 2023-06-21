package de.neuefische.catjpademo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CatOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long catOwnerId;
    private String name;
    @OneToMany(mappedBy = "owner")
    private List<Cat> cats;

}
