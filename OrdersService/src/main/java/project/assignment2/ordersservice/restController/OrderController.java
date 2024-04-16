package project.assignment2.ordersservice.restController;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.assignment2.ordersservice.client.ImageClient;
import project.assignment2.ordersservice.client.ProductClient;
import project.assignment2.ordersservice.entity.Orders;
import project.assignment2.ordersservice.entity.Product;
import project.assignment2.ordersservice.service.OrdersService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrdersService ordersService;
    private ProductClient productClient;
    private ImageClient imageClient;

    private long _productId = 0;
    private int productQuantity = 1;

    private double productPrice;

    public OrderController(OrdersService ordersService, ProductClient productClient, ImageClient imageClient) {
        this.ordersService = ordersService;
        this.productClient = productClient;
        this.imageClient = imageClient;
    }

    @PostMapping("/new")
    public ResponseEntity<String> addNewOrder(@RequestBody Orders newOrder){
        _productId = newOrder.getProductId();
        Product _product = productClient.getProductById(_productId);
        productPrice = _product.getPrice();
        if(_product.getId() == _productId){
            newOrder.setOrderDate(LocalDateTime.now());
            productQuantity = newOrder.getQuantity();
            newOrder.setTotalPrice(productPrice*productQuantity);
            ordersService.addNewOrder(newOrder);
            return new ResponseEntity<>("Order added successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Order could not be processed as product not found!", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/allOrders")
    public ResponseEntity<List<Orders>> getALlOrders(){
        return new ResponseEntity<>(ordersService.getOrders(), HttpStatus.OK);
    }

    @GetMapping("/getOrderById/{orderId}")
    public ResponseEntity<Optional<Orders>> getOrderById(@PathVariable long orderId){
        if(ordersService.getOrdersById(orderId).isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ordersService.getOrdersById(orderId), HttpStatus.OK);
    }
}
