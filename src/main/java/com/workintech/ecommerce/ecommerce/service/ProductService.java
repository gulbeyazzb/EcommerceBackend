package com.workintech.ecommerce.ecommerce.service;

import com.workintech.ecommerce.ecommerce.dto.response.ProductResponse;
import com.workintech.ecommerce.ecommerce.entity.Products;

import java.util.List;

public interface ProductService {

    Products saveProduct(Products product);
    List<ProductResponse> saveAll(List<Products> productsList);
    ProductResponse findByProductName(String name);
    List<Products> getProductsByCategoryId(long categoryID);
    List<ProductResponse> searchByName(String name);
    List<ProductResponse> highestToLowestSorting();
    List<ProductResponse> lowestToHighestSorting();
    List<ProductResponse> worstToBestSorting();
    List<ProductResponse> bestToWorstSorting();
    List<ProductResponse> searchAndLowestSorting(String name);
    List<ProductResponse> searchAndHighestSorting(String name);
    List<ProductResponse> searchAndWorstSorting(String name);
    List<ProductResponse> searchAndBestSorting(String name);
    List<Products> getAllProducts();
    Products deleteProduct(long id);
    Products getProductById(long id);
    List<Products> searchByNameAndCategory(String name,long categoryID);
    List<Products> searchAndWorstSortAndCategory(long categoryID,String name);
    List<Products> searchAndBestSortAndCategory(long categoryID,String name);
    List<Products> searchAndAscSortAndCategory(long categoryID,String name);
    List<Products> searchAndDescSortAndCategory(long categoryID,String name);
    List<Products> highestToLowestSortingAndCategory(long categoryID);
    List<Products> lowestToHighestSortingAndCategory(long categoryID);
    List<Products> worstToBestSortingAndCategory(long categoryID);
    List<Products> bestToWorstSortingAndCategory(long categoryID);
}
