package com.want.srm.entity;

import java.math.BigDecimal;

public class ZT038 extends ZT038Key {
    private String matnr;

    private String maktx;

    private BigDecimal bpmng;

    private String msehl;

    private BigDecimal menge;

    private String msehs;

    private BigDecimal dmbtr1;

    private BigDecimal dmbtr;

    public String getMatnr() {
        return matnr;
    }

    public void setMatnr(String matnr) {
        this.matnr = matnr == null ? null : matnr.trim();
    }

    public String getMaktx() {
        return maktx;
    }

    public void setMaktx(String maktx) {
        this.maktx = maktx == null ? null : maktx.trim();
    }

    public BigDecimal getBpmng() {
        return bpmng;
    }

    public void setBpmng(BigDecimal bpmng) {
        this.bpmng = bpmng;
    }

    public String getMsehl() {
        return msehl;
    }

    public void setMsehl(String msehl) {
        this.msehl = msehl == null ? null : msehl.trim();
    }

    public BigDecimal getMenge() {
        return menge;
    }

    public void setMenge(BigDecimal menge) {
        this.menge = menge;
    }

    public String getMsehs() {
        return msehs;
    }

    public void setMsehs(String msehs) {
        this.msehs = msehs == null ? null : msehs.trim();
    }

    public BigDecimal getDmbtr1() {
        return dmbtr1;
    }

    public void setDmbtr1(BigDecimal dmbtr1) {
        this.dmbtr1 = dmbtr1;
    }

    public BigDecimal getDmbtr() {
        return dmbtr;
    }

    public void setDmbtr(BigDecimal dmbtr) {
        this.dmbtr = dmbtr;
    }

	@Override
	public String toString() {
		return "ZT038 [matnr=" + matnr + ", maktx=" + maktx + ", bpmng=" + bpmng + ", msehl=" + msehl + ", menge="
				+ menge + ", msehs=" + msehs + ", dmbtr1=" + dmbtr1 + ", dmbtr=" + dmbtr + "]";
	}
    
}