package com.znrktkc.SpringBootProject.controller;
import com.znrktkc.SpringBootProject.service.impl.ProductServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;

/**
 * this class is an controller for product api
 */
@RestController
@RequestMapping("/api/product")
public class ProductController {
    private static final Logger logger = LogManager.getLogger(ProductController.class);

    private ProductServiceImpl productServiceImpl;

    public ProductController(ProductServiceImpl productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }

    /**
     * this path created to bring products suitable for the filter
     * @param name
     * @param description
     * @param detailDescription
     * @param page
     * @param sortField
     * @param sortType
     * @return hashMap {data: Obj, totalElements: int, totalPages: int}
     */
    @GetMapping(value = "/getProductsWithFilters")
    @CrossOrigin
    public HashMap<String, Object> getProductsWithFilters(@RequestParam String name, @RequestParam String description,
                                                          @RequestParam String detailDescription, @RequestParam int page,
                                                          @RequestParam String sortField, @RequestParam String sortType) {
        logger.debug("getProductsWithFilter started.");

        if(sortField == "") {
            sortField = "name";
        }
        Sort sort = Sort.by(sortField);
        if(sortType.charAt(0) == 'd') {
            sort = sort.descending();
        } else {
            sort = sort.ascending();
        }
        Pageable pageAndSort = PageRequest.of(page, 10, sort);
        HashMap<String, Object> filteredProducts = productServiceImpl.getProductsWithFilters(name, description, detailDescription, page, sortField, sortType, pageAndSort);

        logger.debug("getProductsWithFilters end.");
        return filteredProducts;
    }
}

