package project.assignment2.productsservice.service;

import org.springframework.stereotype.Service;
import project.assignment2.productsservice.entity.Product;
import project.assignment2.productsservice.repository.ProductsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductsRepository productsRepository;

    public ProductService(ProductsRepository productsRepository){
        this.productsRepository = productsRepository;
    }

    //Creating the product
    public void createProduct(Product product)
    {
        productsRepository.save(product);
    }

    //Getting all the products
    public List<Product> getAllProducts(){
        return productsRepository.findAll();
    }

    //Getting the product by ID
    public Optional<Product> getProductById(Long productId){
        Optional<Product> product = productsRepository.findById(productId);
        return product;
    }

    //Deleting all the products
    public void deleteAllProducts(){
        productsRepository.deleteAll();
    }

    //Deleting the product by ID
    public boolean deleteProductById(Long productId){
        Optional<Product> product = getProductById(productId);
        if(product.isEmpty()){
            return false;
        }
        productsRepository.deleteById(productId);
        return true;
    }
}
