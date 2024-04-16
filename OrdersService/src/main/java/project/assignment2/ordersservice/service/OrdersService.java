package project.assignment2.ordersservice.service;

import org.springframework.stereotype.Service;
import project.assignment2.ordersservice.entity.Orders;
import project.assignment2.ordersservice.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

    private final OrderRepository orderRepository;

    public OrdersService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Orders addNewOrder(Orders order){
        return orderRepository.save(order);
    }

    public List<Orders> getOrders(){
        return orderRepository.findAll();
    }

    public Optional<Orders> getOrdersById(long orderId){
        return orderRepository.findById(orderId);
    }
}
