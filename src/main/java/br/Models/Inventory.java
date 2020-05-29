package br.Models;

import lombok.*;

import java.util.List;

@AllArgsConstructor()
@ToString
@Getter
@Setter
public class Inventory {

    public Inventory(){}

    private String item;
    private double qty;
    private String status;
    private Size size;
    private List<String> tags;
}
