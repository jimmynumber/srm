
package com.want.srm.webservice.zrfcqqt006;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>OT_HEADType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="OT_HEADType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EBELN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BUTXT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BATXT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NAME1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UATTN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TELFX" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NAME2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="URFAX" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BEDAT" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="STREET" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BUTXT1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VTEXT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TEXT1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EVTXT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ZQNAM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ZQTEL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OTTXT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BANFN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ZNAME3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ZNAME2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Z009" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OT_HEADType", propOrder = {
    "ebeln",
    "butxt",
    "batxt",
    "name1",
    "uattn",
    "telfx",
    "name2",
    "urfax",
    "bedat",
    "street",
    "butxt1",
    "vtext",
    "text1",
    "evtxt",
    "zqnam",
    "zqtel",
    "ottxt",
    "banfn",
    "zname3",
    "zname2",
    "uname",
    "z009"
})
public class OTHEADType {

    @XmlElement(name = "EBELN")
    protected String ebeln;
    @XmlElement(name = "BUTXT")
    protected String butxt;
    @XmlElement(name = "BATXT")
    protected String batxt;
    @XmlElement(name = "NAME1")
    protected String name1;
    @XmlElement(name = "UATTN")
    protected String uattn;
    @XmlElement(name = "TELFX")
    protected String telfx;
    @XmlElement(name = "NAME2")
    protected String name2;
    @XmlElement(name = "URFAX")
    protected String urfax;
    @XmlElement(name = "BEDAT")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar bedat;
    @XmlElement(name = "STREET")
    protected String street;
    @XmlElement(name = "BUTXT1")
    protected String butxt1;
    @XmlElement(name = "VTEXT")
    protected String vtext;
    @XmlElement(name = "TEXT1")
    protected String text1;
    @XmlElement(name = "EVTXT")
    protected String evtxt;
    @XmlElement(name = "ZQNAM")
    protected String zqnam;
    @XmlElement(name = "ZQTEL")
    protected String zqtel;
    @XmlElement(name = "OTTXT")
    protected String ottxt;
    @XmlElement(name = "BANFN")
    protected String banfn;
    @XmlElement(name = "ZNAME3")
    protected String zname3;
    @XmlElement(name = "ZNAME2")
    protected String zname2;
    @XmlElement(name = "UNAME")
    protected String uname;
    @XmlElement(name = "Z009")
    protected String z009;

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
     * 获取butxt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBUTXT() {
        return butxt;
    }

    /**
     * 设置butxt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBUTXT(String value) {
        this.butxt = value;
    }

    /**
     * 获取batxt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBATXT() {
        return batxt;
    }

    /**
     * 设置batxt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBATXT(String value) {
        this.batxt = value;
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
     * 获取uattn属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUATTN() {
        return uattn;
    }

    /**
     * 设置uattn属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUATTN(String value) {
        this.uattn = value;
    }

    /**
     * 获取telfx属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTELFX() {
        return telfx;
    }

    /**
     * 设置telfx属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTELFX(String value) {
        this.telfx = value;
    }

    /**
     * 获取name2属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNAME2() {
        return name2;
    }

    /**
     * 设置name2属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNAME2(String value) {
        this.name2 = value;
    }

    /**
     * 获取urfax属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getURFAX() {
        return urfax;
    }

    /**
     * 设置urfax属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setURFAX(String value) {
        this.urfax = value;
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
     * 获取street属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTREET() {
        return street;
    }

    /**
     * 设置street属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTREET(String value) {
        this.street = value;
    }

    /**
     * 获取butxt1属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBUTXT1() {
        return butxt1;
    }

    /**
     * 设置butxt1属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBUTXT1(String value) {
        this.butxt1 = value;
    }

    /**
     * 获取vtext属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVTEXT() {
        return vtext;
    }

    /**
     * 设置vtext属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVTEXT(String value) {
        this.vtext = value;
    }

    /**
     * 获取text1属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTEXT1() {
        return text1;
    }

    /**
     * 设置text1属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTEXT1(String value) {
        this.text1 = value;
    }

    /**
     * 获取evtxt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEVTXT() {
        return evtxt;
    }

    /**
     * 设置evtxt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEVTXT(String value) {
        this.evtxt = value;
    }

    /**
     * 获取zqnam属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZQNAM() {
        return zqnam;
    }

    /**
     * 设置zqnam属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZQNAM(String value) {
        this.zqnam = value;
    }

    /**
     * 获取zqtel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZQTEL() {
        return zqtel;
    }

    /**
     * 设置zqtel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZQTEL(String value) {
        this.zqtel = value;
    }

    /**
     * 获取ottxt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOTTXT() {
        return ottxt;
    }

    /**
     * 设置ottxt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOTTXT(String value) {
        this.ottxt = value;
    }

    /**
     * 获取banfn属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBANFN() {
        return banfn;
    }

    /**
     * 设置banfn属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBANFN(String value) {
        this.banfn = value;
    }

    /**
     * 获取zname3属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZNAME3() {
        return zname3;
    }

    /**
     * 设置zname3属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZNAME3(String value) {
        this.zname3 = value;
    }

    /**
     * 获取zname2属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZNAME2() {
        return zname2;
    }

    /**
     * 设置zname2属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZNAME2(String value) {
        this.zname2 = value;
    }

    /**
     * 获取uname属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUNAME() {
        return uname;
    }

    /**
     * 设置uname属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUNAME(String value) {
        this.uname = value;
    }

    /**
     * 获取z009属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZ009() {
        return z009;
    }

    /**
     * 设置z009属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZ009(String value) {
        this.z009 = value;
    }

}
