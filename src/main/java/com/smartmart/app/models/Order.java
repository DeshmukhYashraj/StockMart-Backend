package com.smartmart.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order extends OrderItem {
	private int  order_id;
	private int user_id;
	private int total_amount;
	private String  status;
	
}
