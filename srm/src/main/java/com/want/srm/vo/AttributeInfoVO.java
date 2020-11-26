package com.want.srm.vo;

import java.io.Serializable;

public class AttributeInfoVO implements Serializable{

	private static final long serialVersionUID = -348648607440910434L;
	private String attributeKey ;
	private String attributeValue ;
	private String attributeId ;
	private String attributeName;
	public String getAttributeKey() {
		return attributeKey;
	}
	public void setAttributeKey(String attributeKey) {
		this.attributeKey = attributeKey;
	}
	public String getAttributeValue() {
		return attributeValue;
	}
	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}
	public String getAttributeId() {
		return attributeId;
	}
	public void setAttributeId(String attributeId) {
		this.attributeId = attributeId;
	}
	public String getAttributeName() {
		return attributeName;
	}
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
	@Override
	public String toString() {
		return "AttributeInfoVO [attributeKey=" + attributeKey + ", attributeValue=" + attributeValue + ", attributeId="
				+ attributeId + ", attributeName=" + attributeName + "]";
	}
}