package model;

public class SignUpLogic {

		public boolean isValidUserId(String userId) {
			String regex = "^[a-zA-Z0-9]{4,20}$";
			return userId.matches(regex);
		}
		public boolean isValidPass(String pass) {
			String regex = "^[a-z0-9]{8,16}$";
			return pass.matches(regex);
		}
		}
	 
			 

