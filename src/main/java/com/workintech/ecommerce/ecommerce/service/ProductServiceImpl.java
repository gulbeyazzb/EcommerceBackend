package com.workintech.ecommerce.ecommerce.service;

import com.workintech.ecommerce.ecommerce.converter.Converter;
import com.workintech.ecommerce.ecommerce.dto.response.ProductResponse;
import com.workintech.ecommerce.ecommerce.entity.Products;
import com.workintech.ecommerce.ecommerce.exception.CommerceException;
import com.workintech.ecommerce.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Products saveProduct(Products product) {
        Optional<Products> foundProduct = productRepository.findByProductName(product.getName());
        if(foundProduct.isPresent()){
            throw new CommerceException("There is a product with the given name!", HttpStatus.BAD_REQUEST);
        }
        return productRepository.save(product);
    }

    @Override
    public List<ProductResponse> saveAll(List<Products> productsList) {
        return Converter.findProducts(productRepository.saveAll(productsList));
    }

    @Override
    public ProductResponse findByProductName(String name) {
        Optional<Products> optionalProduct = productRepository.findByProductName(name);
        if(optionalProduct.isPresent()){
            return Converter.findProduct(optionalProduct.get());
        }
        throw new CommerceException("The product is not found!", HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Products> getProductsByCategoryId(long categoryID) {
        return productRepository.getProductsByCategoryId(categoryID);
    }

    @Override
    public List<ProductResponse> searchByName(String name) {
        return Converter.findProducts(productRepository.searchByName(name));
    }

    @Override
    public List<ProductResponse> highestToLowestSorting() {
        return Converter.findProducts(productRepository.highestToLowestSorting());
    }

    @Override
    public List<ProductResponse> lowestToHighestSorting() {
        return Converter.findProducts(productRepository.lowestToHighestSorting());
    }

    @Override
    public List<ProductResponse> worstToBestSorting() {
        return Converter.findProducts(productRepository.worstToBestSorting());
    }

    @Override
    public List<ProductResponse> bestToWorstSorting() {
        return Converter.findProducts(productRepository.bestToWorstSorting());
    }

    @Override
    public List<ProductResponse> searchAndLowestSorting(String name) {
        return Converter.findProducts(productRepository.searchAndLowestSorting(name));
    }

    @Override
    public List<ProductResponse> searchAndHighestSorting(String name) {
        return Converter.findProducts(productRepository.searchAndHighestSorting(name));
    }

    @Override
    public List<ProductResponse> searchAndWorstSorting(String name) {
        return Converter.findProducts(productRepository.searchAndWorstSorting(name));
    }

    @Override
    public List<ProductResponse> searchAndBestSorting(String name) {
        return Converter.findProducts(productRepository.searchAndBestSorting(name));
    }

    @Override
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Products deleteProduct(long id) {
        Products deletedProduct=new Products();
      Optional<Products> product = productRepository.findById(id);
        if(product.isPresent()){
            deletedProduct=product.get();
            productRepository.delete(deletedProduct);
            return deletedProduct;
        }
        throw new CommerceException("The product is not found!", HttpStatus.NOT_FOUND);
    }

    @Override
    public Products getProductById(long id) {
        Products product=new Products();
        Optional<Products> optionalProduct= productRepository.findById(id);
        if(optionalProduct.isPresent()){
          product= optionalProduct.get();
        }
        return product;
    }

    @Override
    public List<Products> searchByNameAndCategory(String name, long categoryID) {
        return productRepository.searchByNameAndCategory(name,categoryID);
    }

    @Override
    public List<Products> searchAndWorstSortAndCategory(long categoryID, String name) {
        return productRepository.searchAndWorstSortAndCategory(categoryID,name);
    }

    @Override
    public List<Products> searchAndBestSortAndCategory(long categoryID, String name) {
        return productRepository.searchAndBestSortAndCategory(categoryID,name);
    }

    @Override
    public List<Products> searchAndAscSortAndCategory(long categoryID, String name) {
        return searchAndAscSortAndCategory(categoryID, name);
    }

    @Override
    public List<Products> searchAndDescSortAndCategory(long categoryID, String name) {
        return productRepository.searchAndDescSortAndCategory(categoryID, name);
    }

    @Override
    public List<Products> highestToLowestSortingAndCategory(long categoryID) {
        return productRepository.highestToLowestSortingAndCategory(categoryID);
    }

    @Override
    public List<Products> lowestToHighestSortingAndCategory(long categoryID) {
        return productRepository.lowestToHighestSortingAndCategory(categoryID);
    }

    @Override
    public List<Products> worstToBestSortingAndCategory(long categoryID) {
        return productRepository.worstToBestSortingAndCategory(categoryID);
    }

    @Override
    public List<Products> bestToWorstSortingAndCategory(long categoryID) {
        return productRepository.bestToWorstSortingAndCategory(categoryID);
    }



}
