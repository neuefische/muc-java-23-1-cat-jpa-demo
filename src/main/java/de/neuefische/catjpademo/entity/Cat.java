package de.neuefische.catjpademo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "cats")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Cat {

    @MongoId
    private String catId;
    private String name;
    @DBRef(db = "catOwners")
    private CatOwner owner;

}
