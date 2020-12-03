package com.znrktkc.SpringBootProject.service;

import com.znrktkc.SpringBootProject.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<Product> getProductsWithFilters(String name, String description, String detailDescription, int page, String sortField, String sortType, Pageable pageable);
}
