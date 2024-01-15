package com.workintech.ecommerce.ecommerce.service;

import com.workintech.ecommerce.ecommerce.converter.Converter;
import com.workintech.ecommerce.ecommerce.dto.response.ProductResponse;
import com.workintech.ecommerce.ecommerce.entity.Products;
import com.workintech.ecommerce.ecommerce.exception.CommerceException;
import com.workintech.ecommerce.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<ProductResponse> getProductsByCategoryId(int categoryID) {
        return Converter.findProducts(productRepository.getProductsByCategoryId(categoryID));
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
        return null;
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return Converter.findProducts(productRepository.findAll());
    }

    @Override
    public Products getProductByID(long id) {
        Optional<Products> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()){
            return productOptional.get();
        }
        throw new CommerceException("The product is not found!", HttpStatus.NOT_FOUND);
    }

    @Override
    public Products deleteProduct(long id) {
        Products product = getProductByID(id);
        if(product != null){
            productRepository.deleteById(id);
            return product;
        }
        throw new CommerceException("The product is not found!", HttpStatus.NOT_FOUND);
    }
}
