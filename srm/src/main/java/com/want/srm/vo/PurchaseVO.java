package com.want.srm.vo;

import java.io.Serializable;

public class PurchaseVO implements Serializable{
 
	private static final long serialVersionUID = 1L;
	
	private String purchaseId;
	
	private String purchaseName;
	
	
	public String getPurchaseId() {
		return purchaseId;
	}


	public void setPurchaseId(String purchaseId) {
		this.purchaseId = purchaseId;
	}


	public String getPurchaseName() {
		return purchaseName;
	}


	public void setPurchaseName(String purchaseName) {
		this.purchaseName = purchaseName;
	}


	@Override
	public String toString() {
		return "SupplierVO [supplierId=" + purchaseId + ", supplierName=" + purchaseName + "]";
	}
}
