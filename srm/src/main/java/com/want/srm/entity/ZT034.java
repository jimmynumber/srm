package com.want.srm.entity;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

public class ZT034 extends ZT034Key {
	@ApiModelProperty(value = "通知单号")
    private String qmnum;

	@ApiModelProperty(value = "异常日期")
    private String erdat;

	@ApiModelProperty(value = "表单完成日期")
    private String bdwcdat;

	@ApiModelProperty(value = "异常数量")
    private BigDecimal mgeig;

	@ApiModelProperty(value = "扣款金额")
    private BigDecimal pcje;

    public String getQmnum() {
        return qmnum;
    }

    public void setQmnum(String qmnum) {
        this.qmnum = qmnum == null ? null : qmnum.trim();
    }

    public String getErdat() {
        return erdat;
    }

    public void setErdat(String erdat) {
        this.erdat = erdat == null ? null : erdat.trim();
    }

    public String getBdwcdat() {
        return bdwcdat;
    }

    public void setBdwcdat(String bdwcdat) {
        this.bdwcdat = bdwcdat == null ? null : bdwcdat.trim();
    }

    public BigDecimal getMgeig() {
        return mgeig;
    }

    public void setMgeig(BigDecimal mgeig) {
        this.mgeig = mgeig;
    }

    public BigDecimal getPcje() {
        return pcje;
    }

    public void setPcje(BigDecimal pcje) {
        this.pcje = pcje;
    }

	@Override
	public String toString() {
		return "ZT034 [qmnum=" + qmnum + ", erdat=" + erdat + ", bdwcdat=" + bdwcdat + ", mgeig=" + mgeig + ", pcje="
				+ pcje + "]";
	}
    
}