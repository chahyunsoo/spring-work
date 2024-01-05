package vac.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vac.spring.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}