package com.want.srm.po;

public enum Login {
	
	TOKEN("token"),
	VT("vt");
	
	private Login(String val) {
		this.val = val;
	}

	private final String val;

	public String getVal() {
		return val;
	}
	
	
}
