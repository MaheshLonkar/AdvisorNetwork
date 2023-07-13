package com.mahindrafin.advisornetwork.dto;

public class AuthResponseDTO {
	 private String authToken;
	    private Long userId;
		public AuthResponseDTO(String authToken, Long userId) {
			super();
			this.authToken = authToken;
			this.userId = userId;
		}
		public String getAuthToken() {
			return authToken;
		}
		public void setAuthToken(String authToken) {
			this.authToken = authToken;
		}
		public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}
	    
	    
	
}
