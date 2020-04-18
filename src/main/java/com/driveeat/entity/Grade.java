package com.driveeat.entity;

public enum Grade {
	A(1),B(2),C(3),D(4),E(5);
	public int val;
	private Grade(int x) {
		this.val = x;
	}
    
}
