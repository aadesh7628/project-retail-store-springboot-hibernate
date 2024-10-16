package com.oct.retailstore.domain.store;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer store_id;
	private String store_name;

	@OneToOne(mappedBy = "store", cascade = CascadeType.ALL)
	private StoreDetail storeDetail;

	public Store() {

	}

	public Store(String store_name) {
		this.store_name = store_name;
	}

	public Integer getStore_id() {
		return store_id;
	}

	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public StoreDetail getStoreDetail() {
		return storeDetail;
	}

	public void setStoreDetail(StoreDetail storeDetail) {
		this.storeDetail = storeDetail;
		storeDetail.setStore(this);
	}

	@Override
	public String toString() {
		return "Store [store_id=" + store_id + ", store_name=" + store_name + ", storeDetail=" + storeDetail + "]";
	}

	
}