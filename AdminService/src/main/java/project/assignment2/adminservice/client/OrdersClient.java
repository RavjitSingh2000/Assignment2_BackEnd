package project.assignment2.adminservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import project.assignment2.adminservice.entity.Orders;

import java.util.List;
import java.util.Optional;

@FeignClient("Orders-Service")
public interface OrdersClient {

    @GetMapping("/orders/allOrders")
    public List<Orders> getAllOrders();

    @GetMapping("/orders/getOrderById/{orderId}")
    public Optional<Orders> getOrderById(@PathVariable long orderId);
}
