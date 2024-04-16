package project.assignment2.adminservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import project.assignment2.adminservice.entity.Product;

import java.util.List;

@FeignClient("Products-Service")
public interface ProductClient {

    @GetMapping("/product/all")
    public List<Product> getAllProducts();

    @GetMapping("/product/{productId}")
    public Product getProductById(@PathVariable long productId);

    @PostMapping("/product/add")
    public String addNewProduct(@RequestBody Product product);

    @DeleteMapping("/product/deleteAll")
    public String deleteAllProducts();

    @DeleteMapping("/product/delete/{productId}")
    public String deleteProductById(@PathVariable long productId);
}
