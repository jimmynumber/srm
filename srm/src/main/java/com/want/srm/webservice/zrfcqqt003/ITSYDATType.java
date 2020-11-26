package com.want.srm.webservice.zrfcqqt003;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>IT_SYDATType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="IT_SYDATType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SIGN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LOW" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="HIGH" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IT_SYDATType", propOrder = {
    "sign",
    "option",
    "low",
    "high"
})
public class ITSYDATType {

    @XmlElement(name = "SIGN")
    protected String sign;
    @XmlElement(name = "OPTION")
    protected String option;
    @XmlElement(name = "LOW")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar low;
    @XmlElement(name = "HIGH")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar high;

    /**
     * 获取sign属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSIGN() {
        return sign;
    }

    /**
     * 设置sign属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSIGN(String value) {
        this.sign = value;
    }

    /**
     * 获取option属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOPTION() {
        return option;
    }

    /**
     * 设置option属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOPTION(String value) {
        this.option = value;
    }

    /**
     * 获取low属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLOW() {
        return low;
    }

    /**
     * 设置low属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLOW(XMLGregorianCalendar value) {
        this.low = value;
    }

    /**
     * 获取high属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getHIGH() {
        return high;
    }

    /**
     * 设置high属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setHIGH(XMLGregorianCalendar value) {
        this.high = value;
    }

}
