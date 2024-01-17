package com.parula.pizzeria.persistence.repository;

import com.parula.pizzeria.persistence.entity.PizzaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface PizzaPagSort extends ListPagingAndSortingRepository<PizzaEntity, Integer > {

    Page<PizzaEntity> findByAvailableTrue(Pageable pageable);

}


