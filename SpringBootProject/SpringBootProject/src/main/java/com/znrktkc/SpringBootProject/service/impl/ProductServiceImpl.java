package com.znrktkc.SpringBootProject.service.impl;

import com.znrktkc.SpringBootProject.entity.Product;
import com.znrktkc.SpringBootProject.repo.ProductRepository;
import com.znrktkc.SpringBootProject.service.ProductService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProductsWithFilters(String name, String description, String detailDescription, int page,
                                                String sortField, String sortType, Pageable pageAndSort) {

        List<Product> filteredProducts = null;
        if (name != "") {
            if(description != "" && detailDescription != "") {
                filteredProducts = productRepository.findAllByNameContainingOrDescriptionContainingOrDetailDescriptionContaining
                        (name, description, detailDescription, pageAndSort);
            } else if(description != "") {
                filteredProducts = productRepository.findAllByNameContainingOrDescriptionContaining
                        (name, description, pageAndSort);
            } else if(detailDescription != "") {
                filteredProducts = productRepository.findAllByNameContainingOrDetailDescriptionContaining
                        (name, detailDescription, pageAndSort);
            } else {
                filteredProducts = productRepository.findAllByNameContaining(name, pageAndSort);
            }
        } else {
            if(description != "" && detailDescription != "") {
                filteredProducts = productRepository.findAllByDescriptionContainingOrDetailDescriptionContaining
                        (description, detailDescription, pageAndSort);
            } else if(description != "") {
                filteredProducts = productRepository.findAllByDescriptionContaining
                        (description, pageAndSort);
            } else if(detailDescription != "") {
                filteredProducts = productRepository.findAllByDetailDescriptionContaining
                        (detailDescription, pageAndSort);
            }
        }
        if(filteredProducts == null) {
            System.out.println("all filters are null, so all products get with sort paramaters.");
            filteredProducts = productRepository.findAllByNameContainingOrDescriptionContainingOrDetailDescriptionContaining
                    (name, description, detailDescription, pageAndSort);
        }
        return filteredProducts;
    }
}