package com.parula.pizzeria.service;

import com.parula.pizzeria.persistence.entity.PizzaEntity;
import com.parula.pizzeria.persistence.repository.PizzaPagSort;
import com.parula.pizzeria.persistence.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {
    private final PizzaRepository pizzaRepository;
    private final PizzaPagSort pizzaPagSort;

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository, PizzaPagSort pizzaPagSort) {
        this.pizzaRepository = pizzaRepository;

        this.pizzaPagSort = pizzaPagSort;
    }

    /*
    public List<PizzaEntity> getAll(){
        return this.pizzaRepository.findAll();
    }*/

    public Page<PizzaEntity> getAll(int page, int elements){
        Pageable pageRequest = PageRequest.of(page, elements);
        return this.pizzaPagSort.findAll(pageRequest);
    }

    /*
    public List<PizzaEntity> getAvailable() {
        System.out.println(this.pizzaRepository.countByVeganTrue());
        return this.pizzaRepository.findAllByAvailableTrueOrderByPrice();
    }*/

    public Page<PizzaEntity> getAvailable(int page, int elements, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageRequest = PageRequest.of(page, elements, sort);
        System.out.println(this.pizzaRepository.countByVeganTrue());
        return this.pizzaPagSort.findByAvailableTrue(pageRequest);
    }
    public PizzaEntity getByName(String name){
        return this.pizzaRepository.findFirstByAvailableTrueAndNameIgnoreCase(name).orElseThrow(() -> new RuntimeException("La pizza no existe"));
    }

    public List<PizzaEntity> getWith(String description){
        return this.pizzaRepository.findAllByAvailableTrueAndDescriptionContainingIgnoreCase(description);
    }

    public List<PizzaEntity> getWithOut(String ingredient){
        return this.pizzaRepository.findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(ingredient);
    }

    public List<PizzaEntity> getCheapest(double price){
        return this.pizzaRepository.findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(price);
    }

    public PizzaEntity get(int idPizza){
        return this.pizzaRepository.findById(idPizza).orElse(null);
    }

    public PizzaEntity save(PizzaEntity pizza){
        return this.pizzaRepository.save(pizza);
    }

    public void delete(int idPizza){
        this.pizzaRepository.deleteById(idPizza);
    }

    public boolean exists(int idPizza){
        return this.pizzaRepository.existsById(idPizza);
    }


}
