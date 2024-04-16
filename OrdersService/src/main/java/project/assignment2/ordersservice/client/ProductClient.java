package project.assignment2.ordersservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import project.assignment2.ordersservice.entity.Product;

@FeignClient("Products-Service")
public interface ProductClient {
    @GetMapping("/product/{productId}")
    public Product getProductById(@PathVariable long productId);
}
