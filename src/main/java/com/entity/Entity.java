package com.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@jakarta.persistence.Entity
@Table(name="tbl_entity")
public class Entity {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String name;
		private String loc;
		
		public Entity() {
			
		}
		public Entity(int id) {
			this.id = id;
		}
		public Entity(String name, String loc) {
			this.name = name;
			this.loc = loc;
		}
		public Entity(int id, String name, String loc) {
			this.id = id;
			this.name = name;
			this.loc = loc;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getLoc() {
			return loc;
		}
		public void setLoc(String loc) {
			this.loc = loc;
		}
		@Override
		public String toString() {
			return "Entity [id=" + id + ", name=" + name + ", loc=" + loc + "]";
		}
		
}