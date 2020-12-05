package com.znrktkc.SpringBootProject.repo;
import com.znrktkc.SpringBootProject.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    /**
     * here i want to find productlist with writed clauses.
     */
    Page<Product> findAllByNameContainingOrDescriptionContainingOrDetailDescriptionContaining(String name, String description, String detailDescription, Pageable pageable);
    Page<Product> findAllByNameContaining(String name, Pageable pageable);
    Page<Product> findAllByNameContainingOrDescriptionContaining(String name, String description, Pageable pageable);
    Page<Product> findAllByNameContainingOrDetailDescriptionContaining(String name, String detailDescription, Pageable pageable);
    Page<Product> findAllByDescriptionContaining(String description, Pageable pageable);
    Page<Product> findAllByDescriptionContainingOrDetailDescriptionContaining(String description, String detailDescription, Pageable pageable);
    Page<Product>findAllByDetailDescriptionContaining(String detailDescription, Pageable pageable);

}