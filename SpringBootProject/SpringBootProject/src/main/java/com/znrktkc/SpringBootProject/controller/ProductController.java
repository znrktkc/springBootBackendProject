package com.znrktkc.SpringBootProject.controller;

import com.znrktkc.SpringBootProject.entity.Product;
import com.znrktkc.SpringBootProject.repo.ProductRepository;
import com.znrktkc.SpringBootProject.service.ProductService;
import com.znrktkc.SpringBootProject.service.impl.ProductServiceImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductRepository productRepository;
    private ProductServiceImpl productServiceImpl;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @GetMapping(value = "/getProducts")
    @CrossOrigin
    public ResponseEntity<List<Product>> getProducts() {
        System.out.println("getProducts started.");
        return ResponseEntity.ok(productRepository.findAll());
    }

    @GetMapping(value = "/getProductsWithFilters")
    @CrossOrigin
    public ResponseEntity<List<Product>> getProductsWithFilters(@RequestParam String name, @RequestParam String description,
                                                                @RequestParam String detailDescription, @RequestParam int page,
                                                                @RequestParam String sortField, @RequestParam String sortType) {

        Sort sort = Sort.by(sortField);
        if(sortType.charAt(0) == 'd') {
            sort = sort.descending();
        } else {
            sort = sort.ascending();
        }
        Pageable pageAndSort = PageRequest.of(page, 20, sort);
        List<Product> filteredProducts = productServiceImpl.getProductsWithFilters(name, description, detailDescription, page, sortField, sortType, pageAndSort);

        System.out.println("getProductsWithFilters end.");
        return ResponseEntity.ok(filteredProducts);
    }
}

