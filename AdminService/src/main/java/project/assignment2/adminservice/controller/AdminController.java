package project.assignment2.adminservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.assignment2.adminservice.client.OrdersClient;
import project.assignment2.adminservice.client.ProductClient;
import project.assignment2.adminservice.entity.Orders;
import project.assignment2.adminservice.entity.Product;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {
    private final ProductClient productClient;
    private final OrdersClient ordersClient;

    @CrossOrigin
    @GetMapping("/allProducts")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(productClient.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable long productId){
        return new ResponseEntity<>(productClient.getProductById(productId), HttpStatus.OK);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<String> addNewProduct(@RequestBody Product product){
        productClient.addNewProduct(product);
        return new ResponseEntity<>("Product added successfully by ADMIN", HttpStatus.OK);
    }

    @DeleteMapping("/deleteAllProducts")
    public ResponseEntity<String> deleteAllProducts(){
        productClient.deleteAllProducts();
        return new ResponseEntity<>("ALl products has been deleted by ADMIN", HttpStatus.OK);
    }

    @DeleteMapping("/deleteProduct/{productId}")
    public ResponseEntity<String> deleteProductById(@PathVariable long productId){
        productClient.deleteProductById(productId);
        return new ResponseEntity<>("Products has been deleted by ADMIN", HttpStatus.OK);
    }

    @PutMapping("/updateProduct/{productId}")
    public ResponseEntity<String> updateProductById(@PathVariable long productId, @RequestBody Product product){
        Product _product = productClient.getProductById(productId);
        _product.setName(product.getName());
        _product.setDescription(product.getDescription());
        _product.setPrice(product.getPrice());
        _product.setImageId(product.getImageId());
        _product.setStockAvailability(product.getStockAvailability());
        productClient.addNewProduct(_product);
        return new ResponseEntity<>("Product updated successfully by ADMIN", HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/allOrders")
    public ResponseEntity<List<Orders>> getAllOrders(){
        return new ResponseEntity<>(ordersClient.getAllOrders(), HttpStatus.OK);
    }

    @GetMapping("/orderById/{orderId}")
    public ResponseEntity<Optional<Orders>> getOrderById(@PathVariable long orderId){
        if(ordersClient.getOrderById(orderId).isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ordersClient.getOrderById(orderId), HttpStatus.OK);
    }
}
