package com.parula.pizzeria.service.dto;

import lombok.Data;

@Data//para crear los getters, setters, constructores
public class UpdatePizzaPriceDto {
    private int pizzaId;
    private double newPrice;

}
