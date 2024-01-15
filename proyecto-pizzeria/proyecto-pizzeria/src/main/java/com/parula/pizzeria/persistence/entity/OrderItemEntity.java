package com.parula.pizzeria.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_item")
@Getter
@Setter
@NoArgsConstructor
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item", nullable = false)
    private Integer idItem;

    @Column(nullable = false, name = "id_order")
    private Integer idOrder;

    @Column(nullable = false, name = "id_pizza")
    private Integer idPizza;

    @Column(nullable = false, columnDefinition = "DECIMAL(2,1)")
    private Double quantity;

    @Column(nullable = false, columnDefinition = "DECIMAL(5,2)")
    private Double price;

}
