package de.neuefische.catjpademo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document(collection = "catOwners")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CatOwner {

    @MongoId
    private String catOwnerId;
    private String name;
    @DBRef(db = "cats")
    private List<Cat> cats;

}
