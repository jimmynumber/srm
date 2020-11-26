package com.want.srm.vo;

import java.io.Serializable;

public class SupplierVO implements Serializable{
 
	private static final long serialVersionUID = 1L;
	private String supplierId;
	private String supplierName;
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	@Override
	public String toString() {
		return "SupplierVO [supplierId=" + supplierId + ", supplierName=" + supplierName + "]";
	}
}
