package vac.spring.service.StoreService;

import vac.spring.domain.Store;

import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
}