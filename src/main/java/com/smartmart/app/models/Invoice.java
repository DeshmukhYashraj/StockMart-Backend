package com.smartmart.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
	private  int invoice_id;
	private int order_id;
	private int total_amount;
	private String payment_status;
}
