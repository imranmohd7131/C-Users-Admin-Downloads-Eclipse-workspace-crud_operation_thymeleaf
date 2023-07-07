package com.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@jakarta.persistence.Entity
@Table(name="tbl_login")
public class Login {
		@Id
		private String email;
		//private String pswd;
		
		public Login(String email, String pswd) {
			super();
			this.email = email;
			//this.pswd = pswd;
		}
		public Login() {
			
		}
		
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
//		public String getPswd() {
//			return pswd;
//		}
//		public void setPswd(String pswd) {
//			this.pswd = pswd;
//		}
		
		@Override
		public String toString() {
			return "Entity [email=" + email + "]";
		}
		
}
