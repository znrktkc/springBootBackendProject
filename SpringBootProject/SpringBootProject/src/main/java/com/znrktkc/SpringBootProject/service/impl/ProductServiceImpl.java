package com.znrktkc.SpringBootProject.service.impl;
import com.znrktkc.SpringBootProject.controller.UserController;
import com.znrktkc.SpringBootProject.entity.Product;
import com.znrktkc.SpringBootProject.repo.ProductRepository;
import com.znrktkc.SpringBootProject.service.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.HashMap;

@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger logger = LogManager.getLogger(ProductServiceImpl.class);
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * this method created to bring products suitable for the filter
     * @param name
     * @param description
     * @param detailDescription
     * @param page
     * @param sortField
     * @param sortType
     * @param pageAndSort
     * @return hashMap {data: Obj, totalElements: int, totalPages: int}
     */
    @Override
    public HashMap<String, Object> getProductsWithFilters(String name, String description, String detailDescription, int page,
                                                String sortField, String sortType, Pageable pageAndSort) {

        Page<Product> filteredProducts = null;
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
            logger.debug("all filters are null, so all products get with sort paramaters.");
            filteredProducts = productRepository.findAllByNameContainingOrDescriptionContainingOrDetailDescriptionContaining
                    (name, description, detailDescription, pageAndSort);
        }

        HashMap<String, Object> map = new HashMap<>();
        map.put("data", filteredProducts);
        map.put("totalElements", filteredProducts.getTotalElements());
        map.put("totalPages", filteredProducts.getTotalPages());
        return map;
    }
}