package com.smartmart.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {
	private int user_id;
	private String first_name;
	private String last_name;
	private String email;
	private String  phone_number;
	private String address;
	private String profile_picture_url;
	private String username;
    private String password;
    private String role;
}
