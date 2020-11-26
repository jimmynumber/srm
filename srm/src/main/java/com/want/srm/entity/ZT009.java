package com.want.srm.entity;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "对账单信息ZT009")
public class ZT009 extends ZT009Key {
	@ApiModelProperty(value = "采购组织")
    private String ekorg;

	@ApiModelProperty(value = "采购凭证号")
    private String ebeln;

	@ApiModelProperty(value = "采购凭证的项目编号")
    private String ebelp;

	@ApiModelProperty(value = "凭证中的过帐日期")
    private String budat;

	
    private String btext;

    private String matnr;

    private String maktx;

    private BigDecimal bpmng;

    private String msehl;

    private String msehs;

    private String menge;

    private BigDecimal netpr;

    private Integer peinh;

    private BigDecimal dmbtr1;

    private BigDecimal dmbtr;

    private String qmnum;

    private String erdat;

    private BigDecimal mgeig;

    private BigDecimal pcje;

    private String gysfkzt;

    private String bdwcdat;

    private String werks;

    private String name1;

    private String lifnr;

    private String name;

    private String waers;

    private String unit;

    private String mblnr;

    private String mjahr;

    private String buzei;

    private String text1;

    private String vaedatum;

    private BigDecimal lsmng;

    private BigDecimal zsjdhje;

    private BigDecimal zcyl;

    private String mwskz;

    private String cpudt;

    public String getEkorg() {
        return ekorg;
    }

    public void setEkorg(String ekorg) {
        this.ekorg = ekorg == null ? null : ekorg.trim();
    }

    public String getEbeln() {
        return ebeln;
    }

    public void setEbeln(String ebeln) {
        this.ebeln = ebeln == null ? null : ebeln.trim();
    }

    public String getEbelp() {
        return ebelp;
    }

    public void setEbelp(String ebelp) {
        this.ebelp = ebelp == null ? null : ebelp.trim();
    }

    public String getBudat() {
        return budat;
    }

    public void setBudat(String budat) {
        this.budat = budat == null ? null : budat.trim();
    }

    public String getBtext() {
        return btext;
    }

    public void setBtext(String btext) {
        this.btext = btext == null ? null : btext.trim();
    }

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

    public String getMsehs() {
        return msehs;
    }

    public void setMsehs(String msehs) {
        this.msehs = msehs == null ? null : msehs.trim();
    }

    public String getMenge() {
        return menge;
    }

    public void setMenge(String menge) {
        this.menge = menge == null ? null : menge.trim();
    }

    public BigDecimal getNetpr() {
        return netpr;
    }

    public void setNetpr(BigDecimal netpr) {
        this.netpr = netpr;
    }

    public Integer getPeinh() {
        return peinh;
    }

    public void setPeinh(Integer peinh) {
        this.peinh = peinh;
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

    public String getGysfkzt() {
        return gysfkzt;
    }

    public void setGysfkzt(String gysfkzt) {
        this.gysfkzt = gysfkzt == null ? null : gysfkzt.trim();
    }

    public String getBdwcdat() {
        return bdwcdat;
    }

    public void setBdwcdat(String bdwcdat) {
        this.bdwcdat = bdwcdat == null ? null : bdwcdat.trim();
    }

    public String getWerks() {
        return werks;
    }

    public void setWerks(String werks) {
        this.werks = werks == null ? null : werks.trim();
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1 == null ? null : name1.trim();
    }

    public String getLifnr() {
        return lifnr;
    }

    public void setLifnr(String lifnr) {
        this.lifnr = lifnr == null ? null : lifnr.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getWaers() {
        return waers;
    }

    public void setWaers(String waers) {
        this.waers = waers == null ? null : waers.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getMblnr() {
        return mblnr;
    }

    public void setMblnr(String mblnr) {
        this.mblnr = mblnr == null ? null : mblnr.trim();
    }

    public String getMjahr() {
        return mjahr;
    }

    public void setMjahr(String mjahr) {
        this.mjahr = mjahr == null ? null : mjahr.trim();
    }

    public String getBuzei() {
        return buzei;
    }

    public void setBuzei(String buzei) {
        this.buzei = buzei == null ? null : buzei.trim();
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1 == null ? null : text1.trim();
    }

    public String getVaedatum() {
        return vaedatum;
    }

    public void setVaedatum(String vaedatum) {
        this.vaedatum = vaedatum == null ? null : vaedatum.trim();
    }

    public BigDecimal getLsmng() {
        return lsmng;
    }

    public void setLsmng(BigDecimal lsmng) {
        this.lsmng = lsmng;
    }

    public BigDecimal getZsjdhje() {
        return zsjdhje;
    }

    public void setZsjdhje(BigDecimal zsjdhje) {
        this.zsjdhje = zsjdhje;
    }

    public BigDecimal getZcyl() {
        return zcyl;
    }

    public void setZcyl(BigDecimal zcyl) {
        this.zcyl = zcyl;
    }

    public String getMwskz() {
        return mwskz;
    }

    public void setMwskz(String mwskz) {
        this.mwskz = mwskz == null ? null : mwskz.trim();
    }

    public String getCpudt() {
        return cpudt;
    }

    public void setCpudt(String cpudt) {
        this.cpudt = cpudt == null ? null : cpudt.trim();
    }

	@Override
	public String toString() {
		return "ZT009 [ekorg=" + ekorg + ", ebeln=" + ebeln + ", ebelp=" + ebelp + ", budat=" + budat + ", btext="
				+ btext + ", matnr=" + matnr + ", maktx=" + maktx + ", bpmng=" + bpmng + ", msehl=" + msehl + ", msehs="
				+ msehs + ", menge=" + menge + ", netpr=" + netpr + ", peinh=" + peinh + ", dmbtr1=" + dmbtr1
				+ ", dmbtr=" + dmbtr + ", qmnum=" + qmnum + ", erdat=" + erdat + ", mgeig=" + mgeig + ", pcje=" + pcje
				+ ", gysfkzt=" + gysfkzt + ", bdwcdat=" + bdwcdat + ", werks=" + werks + ", name1=" + name1 + ", lifnr="
				+ lifnr + ", name=" + name + ", waers=" + waers + ", unit=" + unit + ", mblnr=" + mblnr + ", mjahr="
				+ mjahr + ", buzei=" + buzei + ", text1=" + text1 + ", vaedatum=" + vaedatum + ", lsmng=" + lsmng
				+ ", zsjdhje=" + zsjdhje + ", zcyl=" + zcyl + ", mwskz=" + mwskz + ", cpudt=" + cpudt + "]";
	}
    
}