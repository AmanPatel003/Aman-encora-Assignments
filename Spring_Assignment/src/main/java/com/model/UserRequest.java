package com.model;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
public class UserRequest {
		@NotBlank
		private String name;
		
		@Min(18)
		private int age;
		// getters and setters
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		
		public UserRequest() {
			// TODO Auto-generated constructor stub
		}
		public UserRequest(@NotBlank String name, @Min(18) int age) {
			super();
			this.name = name;
			this.age = age;
		}
		
		
}