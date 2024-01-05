package vac.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vac.spring.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
