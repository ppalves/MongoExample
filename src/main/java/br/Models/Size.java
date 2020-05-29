package br.Models;

import lombok.*;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@ToString
public class Size {

    public Size(){}
    private Double h;
    private Double w;
    private String uom;
}
