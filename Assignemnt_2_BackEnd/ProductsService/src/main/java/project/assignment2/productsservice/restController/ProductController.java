package project.assignment2.productsservice.restController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.assignment2.productsservice.entity.Product;
import project.assignment2.productsservice.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable Long productId){
        if(productService.getProductById(productId).isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productService.getProductById(productId), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addNewProduct(@RequestBody Product product){
        productService.createProduct(product);
        return new ResponseEntity<>("Product Added successfully", HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllProducts(){
        List<Product> allProducts = productService.getAllProducts();
        if(allProducts.isEmpty()){
            return new ResponseEntity<>("Nothing to delete", HttpStatus.NO_CONTENT);
        }
        productService.deleteAllProducts();
        return new ResponseEntity<>("Products Deleted", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<String> deleteProductsById(@PathVariable Long productId){
        if(!productService.deleteProductById(productId)){
            return new ResponseEntity<>("Product not found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
    }
}
