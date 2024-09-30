package com.royaldrop.main.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryRequestDTO {
	 private Long productId;
	    private Long agentId;
	    private int quantity;
}
