package com.psl.dto;

import javax.persistence.Entity;

@Entity
public class TwoWheeler extends Vehicle {
	private String steeringHandle;

	public TwoWheeler() {
		super();
	}

	public TwoWheeler(String steeringHandle) {
		super();
		this.steeringHandle = steeringHandle;
	}

	public String getSteeringHandle() {
		return steeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}
}
