package project.assignment2.adminservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    private long orderId;
    private LocalDateTime orderDate;
    private int quantity;
    private Long productId;
    private double totalPrice;
}
