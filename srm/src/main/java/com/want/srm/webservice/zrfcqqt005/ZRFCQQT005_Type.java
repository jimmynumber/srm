package com.want.srm.webservice.zrfcqqt005;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="I_EBELN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IT_EKES" type="{http://www.example.org/ZRFCQQT005/}ItemType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "iebeln",
    "itekes"
})
@XmlRootElement(name = "ZRFCQQT005")
public class ZRFCQQT005_Type {

    @XmlElement(name = "I_EBELN")
    protected String iebeln;
    @XmlElement(name = "IT_EKES")
    protected List<ItemType> itekes;

    /**
     * 获取iebeln属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIEBELN() {
        return iebeln;
    }

    /**
     * 设置iebeln属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIEBELN(String value) {
        this.iebeln = value;
    }

    /**
     * Gets the value of the itekes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itekes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getITEKES().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemType }
     * 
     * 
     */
    public List<ItemType> getITEKES() {
        if (itekes == null) {
            itekes = new ArrayList<ItemType>();
        }
        return this.itekes;
    }

}
