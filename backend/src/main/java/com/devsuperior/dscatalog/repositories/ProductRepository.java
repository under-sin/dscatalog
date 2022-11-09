package com.devsuperior.dscatalog.repositories;

import com.devsuperior.dscatalog.entities.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// o JpaRepository espera dois tipos, o tipo da entidade e o tipo do id
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
