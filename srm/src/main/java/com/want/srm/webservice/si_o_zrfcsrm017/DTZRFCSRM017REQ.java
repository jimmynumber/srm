
package com.want.srm.webservice.si_o_zrfcsrm017;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>DT_ZRFCSRM017_REQ complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="DT_ZRFCSRM017_REQ">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="I_BUKRS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="I_WERKS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DT_ZRFCSRM017_REQ", propOrder = {
    "ibukrs",
    "iwerks"
})
public class DTZRFCSRM017REQ {

    @XmlElement(name = "I_BUKRS")
    protected String ibukrs;
    @XmlElement(name = "I_WERKS")
    protected String iwerks;

    /**
     * 获取ibukrs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIBUKRS() {
        return ibukrs;
    }

    /**
     * 设置ibukrs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIBUKRS(String value) {
        this.ibukrs = value;
    }

    /**
     * 获取iwerks属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIWERKS() {
        return iwerks;
    }

    /**
     * 设置iwerks属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIWERKS(String value) {
        this.iwerks = value;
    }

}
