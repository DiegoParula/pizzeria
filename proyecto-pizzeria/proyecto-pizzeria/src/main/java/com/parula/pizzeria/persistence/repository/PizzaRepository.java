package com.parula.pizzeria.persistence.repository;

import com.parula.pizzeria.persistence.entity.PizzaEntity;
import com.parula.pizzeria.service.dto.UpdatePizzaPriceDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer> {

    List<PizzaEntity> findAllByAvailableTrueOrderByPrice();
    Optional<PizzaEntity>  findFirstByAvailableTrueAndNameIgnoreCase(String name);

    List<PizzaEntity> findAllByAvailableTrueAndDescriptionContainingIgnoreCase(String description);

    List<PizzaEntity> findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(String description);
    List<PizzaEntity> findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(double  price);
    int countByVeganTrue();

   /* @Query(value =
            "UPDATE pizza " +
            "SET price = :newPrice " +
            "WHERE id_pizza = :idPizza", nativeQuery = true    )
    void updatePrice(@Param("idPizza") int idPizza, @Param("newPrice") double newPrice);
    */

    //otra forma con Spring Expression Language (SpEL for short)

    @Query(value =
            "UPDATE pizza " +
                    "SET price = :#{#newPizzaPrice.newPrice} " +
                    "WHERE id_pizza = :#{#newPizzaPrice.pizzaId}", nativeQuery = true    )
   @Modifying//para que permita update, delete, etc si no va solo prmite hacer select
    void updatePrice(@Param("newPizzaPrice")UpdatePizzaPriceDto newPizzaPrice);
}


