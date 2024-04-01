package project.assignment2.imageservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.assignment2.imageservice.entity.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
