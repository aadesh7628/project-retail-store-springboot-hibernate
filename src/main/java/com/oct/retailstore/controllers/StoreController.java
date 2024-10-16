package com.oct.retailstore.controllers;


import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oct.retailstore.domain.store.Store;
import com.oct.retailstore.repositories.StoreRepository;

@RestController
@RequestMapping("/api/admin/stores")
@CrossOrigin(origins = "http://localhost:3000")
public class StoreController {
	public static final Logger logger = LoggerFactory.getLogger(StoreRepository.class);
	
	@Autowired
	private StoreRepository storeRepositories;
	
	@PostMapping("/add")
	public ResponseEntity<Store> createStore(@RequestBody Store store){
		logger.info(store.toString());
		storeRepositories.save(store);
		return ResponseEntity.ok(store);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Store>> getStores(){
		List<Store> stores = storeRepositories.getAllStores();
		return stores != null ? ResponseEntity.ok(stores) : ResponseEntity.notFound().build();
	}
	
//	@GetMapping("/{id}")
}
