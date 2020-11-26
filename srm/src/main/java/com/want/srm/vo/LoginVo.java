package com.want.srm.vo;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

public class LoginVo implements Serializable {
	private static final long serialVersionUID = 218387398141574862L;
	
	@ApiModelProperty(value = "用户名")
	@NotBlank(message="用户名不能为空")
	private String userId;      //       
	
	@ApiModelProperty(value = "密码")
	@NotBlank(message="密码不能为空")
	private String password;    //         
	private String deviceid;    //  设备Id       
	private String osType;      //  设备类型     
	private String ipAdress;    //  部门  
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDeviceid() {
		return deviceid;
	}
	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}
	public String getOsType() {
		return osType;
	}
	public void setOsType(String osType) {
		this.osType = osType;
	}
	
	public String getIpAdress() {
		return ipAdress;
	}
	public void setIpAdress(String ipAdress) {
		this.ipAdress = ipAdress;
	}
	@Override
	public String toString() {
		return "LoginVo [userId=" + userId + ", password=" + password + ", deviceid=" + deviceid + ", osType=" + osType
				+ ", ipAdress=" + ipAdress + "]";
	}
}
