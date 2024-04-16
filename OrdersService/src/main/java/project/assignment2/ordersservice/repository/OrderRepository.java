package project.assignment2.ordersservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.assignment2.ordersservice.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
}
