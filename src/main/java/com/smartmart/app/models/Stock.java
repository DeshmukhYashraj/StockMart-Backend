package com.smartmart.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock extends Product {
	private int stock_id ;
	private int product_id;
	private int quantity;
}
