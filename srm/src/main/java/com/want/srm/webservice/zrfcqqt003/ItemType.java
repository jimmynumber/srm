package com.want.srm.webservice.zrfcqqt003;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>ItemType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ItemType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EBELN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EBELP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lIFNR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BEDAT" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="EEIND" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="MATNR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TXZ01" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MENGE" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="MEINS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NETPR" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="WKURS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PEINH" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="BPRME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VALUE" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ZTERM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MWSKZ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="KBETR" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="WERKS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WERKS1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NAME1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LOEKZ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DATVR" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="UHRVR" type="{http://www.w3.org/2001/XMLSchema}time" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemType", propOrder = {
    "ebeln",
    "ebelp",
    "lifnr",
    "bedat",
    "eeind",
    "matnr",
    "txz01",
    "menge",
    "meins",
    "netpr",
    "wkurs",
    "peinh",
    "bprme",
    "value",
    "zterm",
    "mwskz",
    "kbetr",
    "werks",
    "name",
    "werks1",
    "name1",
    "loekz",
    "datvr",
    "uhrvr"
})
public class ItemType {

    @XmlElement(name = "EBELN")
    protected String ebeln;
    @XmlElement(name = "EBELP")
    protected String ebelp;
    @XmlElement(name = "lIFNR")
    protected String lifnr;
    @XmlElement(name = "BEDAT")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar bedat;
    @XmlElement(name = "EEIND")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar eeind;
    @XmlElement(name = "MATNR")
    protected String matnr;
    @XmlElement(name = "TXZ01")
    protected String txz01;
    @XmlElement(name = "MENGE")
    protected BigDecimal menge;
    @XmlElement(name = "MEINS")
    protected String meins;
    @XmlElement(name = "NETPR")
    protected BigDecimal netpr;
    @XmlElement(name = "WKURS")
    protected String wkurs;
    @XmlElement(name = "PEINH")
    protected BigDecimal peinh;
    @XmlElement(name = "BPRME")
    protected String bprme;
    @XmlElement(name = "VALUE")
    protected BigDecimal value;
    @XmlElement(name = "ZTERM")
    protected String zterm;
    @XmlElement(name = "MWSKZ")
    protected String mwskz;
    @XmlElement(name = "KBETR")
    protected BigDecimal kbetr;
    @XmlElement(name = "WERKS")
    protected String werks;
    @XmlElement(name = "NAME")
    protected String name;
    @XmlElement(name = "WERKS1")
    protected String werks1;
    @XmlElement(name = "NAME1")
    protected String name1;
    @XmlElement(name = "LOEKZ")
    protected String loekz;
    @XmlElement(name = "DATVR")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datvr;
    @XmlElement(name = "UHRVR")
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar uhrvr;

    /**
     * 获取ebeln属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEBELN() {
        return ebeln;
    }

    /**
     * 设置ebeln属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEBELN(String value) {
        this.ebeln = value;
    }

    /**
     * 获取ebelp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEBELP() {
        return ebelp;
    }

    /**
     * 设置ebelp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEBELP(String value) {
        this.ebelp = value;
    }

    /**
     * 获取lifnr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLIFNR() {
        return lifnr;
    }

    /**
     * 设置lifnr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLIFNR(String value) {
        this.lifnr = value;
    }

    /**
     * 获取bedat属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBEDAT() {
        return bedat;
    }

    /**
     * 设置bedat属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBEDAT(XMLGregorianCalendar value) {
        this.bedat = value;
    }

    /**
     * 获取eeind属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEEIND() {
        return eeind;
    }

    /**
     * 设置eeind属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEEIND(XMLGregorianCalendar value) {
        this.eeind = value;
    }

    /**
     * 获取matnr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMATNR() {
        return matnr;
    }

    /**
     * 设置matnr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMATNR(String value) {
        this.matnr = value;
    }

    /**
     * 获取txz01属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTXZ01() {
        return txz01;
    }

    /**
     * 设置txz01属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTXZ01(String value) {
        this.txz01 = value;
    }

    /**
     * 获取menge属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMENGE() {
        return menge;
    }

    /**
     * 设置menge属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMENGE(BigDecimal value) {
        this.menge = value;
    }

    /**
     * 获取meins属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMEINS() {
        return meins;
    }

    /**
     * 设置meins属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMEINS(String value) {
        this.meins = value;
    }

    /**
     * 获取netpr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNETPR() {
        return netpr;
    }

    /**
     * 设置netpr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNETPR(BigDecimal value) {
        this.netpr = value;
    }

    /**
     * 获取wkurs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWKURS() {
        return wkurs;
    }

    /**
     * 设置wkurs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWKURS(String value) {
        this.wkurs = value;
    }

    /**
     * 获取peinh属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPEINH() {
        return peinh;
    }

    /**
     * 设置peinh属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPEINH(BigDecimal value) {
        this.peinh = value;
    }

    /**
     * 获取bprme属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBPRME() {
        return bprme;
    }

    /**
     * 设置bprme属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBPRME(String value) {
        this.bprme = value;
    }

    /**
     * 获取value属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVALUE() {
        return value;
    }

    /**
     * 设置value属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVALUE(BigDecimal value) {
        this.value = value;
    }

    /**
     * 获取zterm属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZTERM() {
        return zterm;
    }

    /**
     * 设置zterm属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZTERM(String value) {
        this.zterm = value;
    }

    /**
     * 获取mwskz属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMWSKZ() {
        return mwskz;
    }

    /**
     * 设置mwskz属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMWSKZ(String value) {
        this.mwskz = value;
    }

    /**
     * 获取kbetr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getKBETR() {
        return kbetr;
    }

    /**
     * 设置kbetr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setKBETR(BigDecimal value) {
        this.kbetr = value;
    }

    /**
     * 获取werks属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWERKS() {
        return werks;
    }

    /**
     * 设置werks属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWERKS(String value) {
        this.werks = value;
    }

    /**
     * 获取name属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNAME() {
        return name;
    }

    /**
     * 设置name属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNAME(String value) {
        this.name = value;
    }

    /**
     * 获取werks1属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWERKS1() {
        return werks1;
    }

    /**
     * 设置werks1属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWERKS1(String value) {
        this.werks1 = value;
    }

    /**
     * 获取name1属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNAME1() {
        return name1;
    }

    /**
     * 设置name1属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNAME1(String value) {
        this.name1 = value;
    }

    /**
     * 获取loekz属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLOEKZ() {
        return loekz;
    }

    /**
     * 设置loekz属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLOEKZ(String value) {
        this.loekz = value;
    }

    /**
     * 获取datvr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDATVR() {
        return datvr;
    }

    /**
     * 设置datvr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDATVR(XMLGregorianCalendar value) {
        this.datvr = value;
    }

    /**
     * 获取uhrvr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUHRVR() {
        return uhrvr;
    }

    /**
     * 设置uhrvr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUHRVR(XMLGregorianCalendar value) {
        this.uhrvr = value;
    }

}
