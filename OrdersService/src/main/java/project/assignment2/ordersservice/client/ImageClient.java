package project.assignment2.ordersservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import project.assignment2.ordersservice.entity.Image;

@FeignClient("Image-Service")
public interface ImageClient {

    @GetMapping("/addImage/{productId}")
    public Image addImage(@RequestBody Image image, @PathVariable long productId);
}
