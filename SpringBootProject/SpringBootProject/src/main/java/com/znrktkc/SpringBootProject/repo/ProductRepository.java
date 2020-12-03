package com.znrktkc.SpringBootProject.repo;

import com.znrktkc.SpringBootProject.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    //here i want to find productlist with writed clauses.
    List<Product> findAllByPrice(double price, Pageable pageable);
    List<Product> findAllByNameContainingOrDescriptionContainingOrDetailDescriptionContaining(String name, String description, String detailDescription, Pageable pageable);
    List<Product> findAllByNameContaining(String name, Pageable pageable);
    List<Product> findAllByNameContainingOrDescriptionContaining(String name, String description, Pageable pageable);
    List<Product> findAllByNameContainingOrDetailDescriptionContaining(String name, String detailDescription, Pageable pageable);
    List<Product> findAllByDescriptionContaining(String description, Pageable pageable);
    List<Product> findAllByDescriptionContainingOrDetailDescriptionContaining(String description, String detailDescription, Pageable pageable);
    List<Product> findAllByDetailDescriptionContaining(String detailDescription, Pageable pageable);

}