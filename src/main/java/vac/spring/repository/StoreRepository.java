package vac.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vac.spring.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}