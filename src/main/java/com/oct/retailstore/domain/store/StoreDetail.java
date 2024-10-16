package com.oct.retailstore.domain.store;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class StoreDetail {
		@Id
		@GeneratedValue(strategy= GenerationType.IDENTITY)
		private Integer detail_id;
		private String city;
		private String contact_number;
		
		@OneToOne
		@JoinColumn(name="store_id",referencedColumnName="store_id")
		private Store store;

		public StoreDetail() {
			super();
			// TODO Auto-generated constructor stub
		}

		public StoreDetail(String city, String contact_number) {
			super();
			this.city = city;
			this.contact_number = contact_number;
		}

		public Integer getDetais_id() {
			return detail_id;
		}

		public void setDetais_id(Integer detais_id) {
			this.detail_id = detais_id;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getContact_number() {
			return contact_number;
		}

		public void setContact_number(String contact_number) {
			this.contact_number = contact_number;
		}

		public Store getStore() {
			return store;
		}

		public void setStore(Store store) {
			this.store = store;
		}

		@Override
		public String toString() {
			return "StoreDetail [detail_id=" + detail_id + ", city=" + city + ", contact_number=" + contact_number
					+ "]";
		}
		
		
		
}