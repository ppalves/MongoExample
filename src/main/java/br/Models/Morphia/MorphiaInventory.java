package br.Models.Morphia;

import dev.morphia.annotations.Embedded;
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import lombok.*;
import org.bson.types.ObjectId;

import java.util.List;

@AllArgsConstructor()
@ToString
@Getter
@Setter
@Entity
public class MorphiaInventory {

    public MorphiaInventory(){}

    @Id
    private ObjectId id;
    private String item;
    private double qty;
    private String status;
    @Embedded
    private MorphiaSize morphiaSize;
    private List<String> tags;

}
