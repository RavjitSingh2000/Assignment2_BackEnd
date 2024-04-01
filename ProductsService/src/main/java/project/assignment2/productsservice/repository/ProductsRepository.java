package project.assignment2.productsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.assignment2.productsservice.entity.Product;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {
}
