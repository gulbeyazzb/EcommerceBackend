package com.workintech.ecommerce.ecommerce.service;

import com.workintech.ecommerce.ecommerce.dto.response.ProductResponse;
import com.workintech.ecommerce.ecommerce.entity.Products;

import java.util.List;

public interface ProductService {

    Products saveProduct(Products product);
    List<ProductResponse> saveAll(List<Products> productsList);
    ProductResponse findByProductName(String name);
    List<ProductResponse> getProductsByCategoryId(int categoryID);
    List<ProductResponse> searchByName(String name);
    List<ProductResponse> highestToLowestSorting();
    List<ProductResponse> lowestToHighestSorting();
    List<ProductResponse> worstToBestSorting();
    List<ProductResponse> bestToWorstSorting();
    List<ProductResponse> searchAndLowestSorting(String name);
    List<ProductResponse> searchAndHighestSorting(String name);
    List<ProductResponse> searchAndWorstSorting(String name);
    List<ProductResponse> searchAndBestSorting(String name);
    List<ProductResponse> getAllProducts();
    Products getProductByID(long id);
    Products deleteProduct(long id);

}
