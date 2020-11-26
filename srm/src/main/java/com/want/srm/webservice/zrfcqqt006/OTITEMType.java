
package com.want.srm.webservice.zrfcqqt006;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>OT_ITEMType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="OT_ITEMType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EBELP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MATNR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TXZ01" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OITXT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LTEX1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LTEX2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MENGE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NETPR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EINDT" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OT_ITEMType", propOrder = {
    "ebelp",
    "matnr",
    "txz01",
    "oitxt",
    "ltex1",
    "ltex2",
    "menge",
    "netpr",
    "eindt"
})
public class OTITEMType {

    @XmlElement(name = "EBELP")
    protected String ebelp;
    @XmlElement(name = "MATNR")
    protected String matnr;
    @XmlElement(name = "TXZ01")
    protected String txz01;
    @XmlElement(name = "OITXT")
    protected String oitxt;
    @XmlElement(name = "LTEX1")
    protected String ltex1;
    @XmlElement(name = "LTEX2")
    protected String ltex2;
    @XmlElement(name = "MENGE")
    protected String menge;
    @XmlElement(name = "NETPR")
    protected String netpr;
    @XmlElement(name = "EINDT")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar eindt;

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
     * 获取oitxt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOITXT() {
        return oitxt;
    }

    /**
     * 设置oitxt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOITXT(String value) {
        this.oitxt = value;
    }

    /**
     * 获取ltex1属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLTEX1() {
        return ltex1;
    }

    /**
     * 设置ltex1属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLTEX1(String value) {
        this.ltex1 = value;
    }

    /**
     * 获取ltex2属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLTEX2() {
        return ltex2;
    }

    /**
     * 设置ltex2属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLTEX2(String value) {
        this.ltex2 = value;
    }

    /**
     * 获取menge属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMENGE() {
        return menge;
    }

    /**
     * 设置menge属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMENGE(String value) {
        this.menge = value;
    }

    /**
     * 获取netpr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNETPR() {
        return netpr;
    }

    /**
     * 设置netpr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNETPR(String value) {
        this.netpr = value;
    }

    /**
     * 获取eindt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEINDT() {
        return eindt;
    }

    /**
     * 设置eindt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEINDT(XMLGregorianCalendar value) {
        this.eindt = value;
    }

}
