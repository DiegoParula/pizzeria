package com.parula.pizzeria.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
public class CustomerEntity {

    @Id
    @Column(nullable = false, columnDefinition = "VARCHAR(15)", name = "id_customer")
    private String idCustomer;

    @Column(nullable = false, columnDefinition = "VARCHAR(60)")
    private String name;

    @Column(nullable = false, columnDefinition = "VARCHAR(100)")
    private String address;

    @Column(nullable = false, columnDefinition = "VARCHAR(50)", unique = true)
    private String email;

    @Column(nullable = false, columnDefinition = "VARCHAR(20)", name = "phone_number")
    private String phoneNumber;
}

