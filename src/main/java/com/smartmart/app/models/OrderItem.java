package com.smartmart.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem extends Product{
	private int id;
	private int order_id ;
	private int product_id;
	private int quantity ;
	private int  price;
}
