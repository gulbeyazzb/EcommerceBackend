package com.workintech.ecommerce.ecommerce.service;

import com.workintech.ecommerce.ecommerce.converter.Converter;
import com.workintech.ecommerce.ecommerce.dto.response.ProductResponse;
import com.workintech.ecommerce.ecommerce.entity.Products;
import com.workintech.ecommerce.ecommerce.exception.CommerceException;
import com.workintech.ecommerce.ecommerce.repository.ProductRepository;
import com.workintech.ecommerce.ecommerce.util.validations.GeneralValidation;
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
            throw new CommerceException(GeneralValidation.IS_PRODUCT_PRESENT, HttpStatus.BAD_REQUEST);
        }
        GeneralValidation.checkEmptyOrNull(product.getName(),"name");
        GeneralValidation.checkEmptyOrNull(product.getDescription(),"description");
        GeneralValidation.checkEmptyOrNull(product.getImage(),"image");
        GeneralValidation.isValid(product.getPrice(),"price");
        GeneralValidation.isValid(product.getRating(),"rating");
        GeneralValidation.isValid(product.getSellCount(),"sell count");
        GeneralValidation.isCategoryIdValid("category id", product.getCategoryId());
        GeneralValidation.isValid(product.getStock(),"stock");
        return productRepository.save(product);
    }

    @Override
    public List<ProductResponse> saveAll(List<Products> productsList) {
        return Converter.findProducts(productRepository.saveAll(productsList));
    }

    @Override
    public ProductResponse findByProductName(String filter) {
        Optional<Products> optionalProduct = productRepository.findByProductName(filter);
        if(optionalProduct.isPresent()){
            return Converter.findProduct(optionalProduct.get());
        }
        GeneralValidation.checkEmptyOrNull(filter,"filter");
        throw new CommerceException(GeneralValidation.IS_NOT_PRODUCT_PRESENT, HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Products> getProductsByCategoryId(long categoryID) {
        GeneralValidation.isCategoryIdValid("category id",categoryID);
        return productRepository.getProductsByCategoryId(categoryID);
    }

    @Override
    public List<ProductResponse> searchByName(String filter) {
        GeneralValidation.checkEmptyOrNull(filter,"filter");
        return Converter.findProducts(productRepository.searchByName(filter));
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
    public List<ProductResponse> searchAndLowestSorting(String filter) {
        GeneralValidation.checkEmptyOrNull(filter,"filter");
        return Converter.findProducts(productRepository.searchAndLowestSorting(filter));
    }

    @Override
    public List<ProductResponse> searchAndHighestSorting(String filter) {
        GeneralValidation.checkEmptyOrNull(filter,"filter");
        return Converter.findProducts(productRepository.searchAndHighestSorting(filter));
    }

    @Override
    public List<ProductResponse> searchAndWorstSorting(String filter) {
        GeneralValidation.checkEmptyOrNull(filter,"filter");
        return Converter.findProducts(productRepository.searchAndWorstSorting(filter));
    }

    @Override
    public List<ProductResponse> searchAndBestSorting(String filter) {
        GeneralValidation.checkEmptyOrNull(filter,"filter");
        return Converter.findProducts(productRepository.searchAndBestSorting(filter));
    }

    @Override
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Products deleteProduct(long id) {
        GeneralValidation.isValid(id,"id");
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
        GeneralValidation.isValid(id,"id");
        Products product=new Products();
        Optional<Products> optionalProduct= productRepository.findById(id);
        if(optionalProduct.isPresent()){
          product= optionalProduct.get();
        }
        return product;
    }

    @Override
    public List<Products> searchByNameAndCategory(String filter, long categoryID) {
        GeneralValidation.isCategoryIdValid("category id",categoryID);
        GeneralValidation.checkEmptyOrNull(filter,"filter ");
        return productRepository.searchByNameAndCategory(filter,categoryID);
    }

    @Override
    public List<Products> searchAndWorstSortAndCategory(long categoryID, String filter) {
        GeneralValidation.isCategoryIdValid("category id",categoryID);
        GeneralValidation.checkEmptyOrNull(filter,"filter ");
        return productRepository.searchAndWorstSortAndCategory(categoryID,filter);
    }

    @Override
    public List<Products> searchAndBestSortAndCategory(long categoryID, String filter) {
        GeneralValidation.isCategoryIdValid("category id",categoryID);
        GeneralValidation.checkEmptyOrNull(filter,"filter ");
        return productRepository.searchAndBestSortAndCategory(categoryID,filter);
    }

    @Override
    public List<Products> searchAndAscSortAndCategory(long categoryID, String filter) {
        GeneralValidation.isCategoryIdValid("category id",categoryID);
        GeneralValidation.checkEmptyOrNull(filter,"filter ");
        return searchAndAscSortAndCategory(categoryID, filter);
    }

    @Override
    public List<Products> searchAndDescSortAndCategory(long categoryID, String filter) {
        GeneralValidation.isCategoryIdValid("category id",categoryID);
        GeneralValidation.checkEmptyOrNull(filter,"filter ");
        return productRepository.searchAndDescSortAndCategory(categoryID, filter);
    }

    @Override
    public List<Products> highestToLowestSortingAndCategory(long categoryID) {
        GeneralValidation.isCategoryIdValid("category id",categoryID);
        return productRepository.highestToLowestSortingAndCategory(categoryID);
    }

    @Override
    public List<Products> lowestToHighestSortingAndCategory(long categoryID) {
        GeneralValidation.isCategoryIdValid("category id",categoryID);
        return productRepository.lowestToHighestSortingAndCategory(categoryID);
    }

    @Override
    public List<Products> worstToBestSortingAndCategory(long categoryID) {
        GeneralValidation.isCategoryIdValid("category id",categoryID);
        return productRepository.worstToBestSortingAndCategory(categoryID);
    }

    @Override
    public List<Products> bestToWorstSortingAndCategory(long categoryID) {
        GeneralValidation.isCategoryIdValid("category id",categoryID);
        return productRepository.bestToWorstSortingAndCategory(categoryID);
    }



}
