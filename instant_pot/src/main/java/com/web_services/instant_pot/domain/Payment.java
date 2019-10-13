package com.web_services.instant_pot.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Payment {
	@Id
	@Column (name="payment_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

}
