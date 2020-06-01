package br.Models.Morphia;

import dev.morphia.annotations.Embedded;
import lombok.*;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@ToString
@Embedded
public class MorphiaSize {

    public MorphiaSize(){}

    private Double h;
    private Double w;
    private String uom;
}