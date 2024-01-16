package com.parula.pizzeria.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_item")
/*idClass para indicarle por JPA a la entity que tiene una clave compuesta*/
/*Y la clase OrderItemId sera la que tiene esos atributos*/
@IdClass(OrderItemId.class)
@Getter
@Setter
@NoArgsConstructor
public class OrderItemEntity {

    @Id
    @Column(name = "id_item", nullable = false)
    private Integer idItem;

    @Id
    @Column(nullable = false, name = "id_order")
    private Integer idOrder;

    @Column(nullable = false, name = "id_pizza")
    private Integer idPizza;

    @Column(nullable = false, columnDefinition = "DECIMAL(2,1)")
    private Double quantity;

    @Column(nullable = false, columnDefinition = "DECIMAL(5,2)")
    private Double price;

    @OneToOne
    @JoinColumn(name="id_pizza", referencedColumnName = "id_pizza", insertable = false, updatable = false) //insertable = false, updatable = false xq no quiero que inserte o actaulice elemento en la tabla padre
    private PizzaEntity pizza;

    @ManyToOne
    @JoinColumn(name = "id_order", referencedColumnName = "id_order", insertable = false, updatable = false)
    @JsonIgnore//cuando estemos serializando este objeto no tenga en cuenta esta propiedad
    private OrderEntity order;



}
