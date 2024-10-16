package com.oct.retailstore.repositories;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oct.retailstore.domain.store.Store;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class StoreRepository {
    public static final Logger logger = LoggerFactory.getLogger(StoreRepository.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Store store) {
        entityManager.persist(store);
    }

    @Transactional
    public Store findById(Long id) {
        return entityManager.find(Store.class, id);
    }

    @Transactional
    public void delete(Long id) {
        Store store = findById(id);
        if (store != null) {
            entityManager.remove(store);
        }
    }

    @Transactional
    public List<Store> getAllStores() {
    	
    	List<Store> s =  entityManager.createQuery("SELECT s FROM Store s", Store.class).getResultList();
    	logger.info(s.toString());
    	return s;
    }
}
