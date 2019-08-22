package br.code;

import lombok.Data;

import java.util.UUID;

@Data
public class Product {

    private UUID uuid;
    private String name;

}
