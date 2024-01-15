package com.workintech.ecommerce.ecommerce.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.workintech.ecommerce.ecommerce.converter.Converter;
import com.workintech.ecommerce.ecommerce.dto.response.ProductResponse;
import com.workintech.ecommerce.ecommerce.entity.Category;
import com.workintech.ecommerce.ecommerce.entity.Products;
import com.workintech.ecommerce.ecommerce.service.CategoryService;
import com.workintech.ecommerce.ecommerce.service.ProductService;
import jakarta.persistence.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/products")
public class ProductController {
    private ProductService productService;
    private RestTemplateBuilder restTemplateBuilder;
    private CategoryService categoryService;
    private static final String GET_PRODUCTS = "https://workintech-fe-ecommerce.onrender.com/products";

    @Autowired
    public ProductController(ProductService productService, RestTemplateBuilder restTemplateBuilder) {
        this.productService = productService;
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping("/all")
    public List<ProductResponse> saveAll() {
        List<String> imagesList = new ArrayList<>();
        List<Products> productList = new ArrayList<>();

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<JsonNode> responses = restTemplate.getForEntity(GET_PRODUCTS, JsonNode.class);

        for (JsonNode node : responses.getBody().get("products")) {
            Products product = new Products();
            product.setName(node.get("name").asText());
            product.setDescription(node.get("description").asText());
            product.setPrice(node.get("price").asDouble());
            product.setStock(node.get("stock").asInt());
            product.setCategoryId(node.get("category_id").asLong());
            product.setRating(node.get("rating").asDouble());
            product.setImage(node.get("images").get(0).get("url").asText());
            productList.add(product);
        }
        return productService.saveAll(productList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getAllProducts(@PathVariable long id){
        return new ResponseEntity<>(Converter.findProduct(productService.getProductByID(id)), HttpStatus.OK);
    }

}
