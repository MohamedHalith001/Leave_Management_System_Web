package com.elms.mohamed.model;

public class Employee {
		String name;
		int id;
		String username;
		String password;
		int sickLeave = 3;
		int casualLeave = 3;
		int earnLeave = 1;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getSickLeave() {
			return sickLeave;
		}
		public void setSickLeave(int sickLeave) {
			this.sickLeave = sickLeave;
		}
		public int getCasualLeave() {
			return casualLeave;
		}
		public void setCasualLeave(int casualLeave) {
			this.casualLeave = casualLeave;
		}
		public int getEarnLeave() {
			return earnLeave;
		}
		public void setEarnLeave(int earnLeave) {
			this.earnLeave = earnLeave;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String toString() {
			return "Employee [name=" + name + ", id=" + id + ", username=" + username + ", password=" + password
					+ ", sickLeave=" + sickLeave + ", casualLeave=" + casualLeave + ", earnLeave=" + earnLeave + "]";
		}
	}
