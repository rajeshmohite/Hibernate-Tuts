package com.psl.dto;

import javax.persistence.Entity;

@Entity
public class FourWheeler extends Vehicle {
	private String steeringWheel;

	public FourWheeler() {
		super();
	}

	public FourWheeler(String steeringWheel) {
		super();
		this.steeringWheel = steeringWheel;
	}

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}
}
