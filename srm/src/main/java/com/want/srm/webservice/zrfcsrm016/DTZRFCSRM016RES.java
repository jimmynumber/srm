package com.want.srm.webservice.zrfcsrm016;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>DT_ZRFCSRM016_RES complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="DT_ZRFCSRM016_RES">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MESSAGE_E" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TYPE_E" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="T_QMEL_E" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="QMNUM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="EBELN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DT_ZRFCSRM016_RES", propOrder = {
    "messagee",
    "typee",
    "tqmele"
})
public class DTZRFCSRM016RES {

    @XmlElement(name = "MESSAGE_E")
    protected String messagee;
    @XmlElement(name = "TYPE_E")
    protected String typee;
    @XmlElement(name = "T_QMEL_E")
    protected DTZRFCSRM016RES.TQMELE tqmele;

    /**
     * 获取messagee属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMESSAGEE() {
        return messagee;
    }

    /**
     * 设置messagee属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMESSAGEE(String value) {
        this.messagee = value;
    }

    /**
     * 获取typee属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTYPEE() {
        return typee;
    }

    /**
     * 设置typee属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTYPEE(String value) {
        this.typee = value;
    }

    /**
     * 获取tqmele属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DTZRFCSRM016RES.TQMELE }
     *     
     */
    public DTZRFCSRM016RES.TQMELE getTQMELE() {
        return tqmele;
    }

    /**
     * 设置tqmele属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DTZRFCSRM016RES.TQMELE }
     *     
     */
    public void setTQMELE(DTZRFCSRM016RES.TQMELE value) {
        this.tqmele = value;
    }


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
     *         &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="QMNUM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="EBELN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "item"
    })
    public static class TQMELE {

        protected List<DTZRFCSRM016RES.TQMELE.Item> item;

        /**
         * Gets the value of the item property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the item property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getItem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DTZRFCSRM016RES.TQMELE.Item }
         * 
         * 
         */
        public List<DTZRFCSRM016RES.TQMELE.Item> getItem() {
            if (item == null) {
                item = new ArrayList<DTZRFCSRM016RES.TQMELE.Item>();
            }
            return this.item;
        }


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
         *         &lt;element name="QMNUM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="EBELN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "qmnum",
            "ebeln"
        })
        public static class Item {

            @XmlElement(name = "QMNUM")
            protected String qmnum;
            @XmlElement(name = "EBELN")
            protected String ebeln;

            /**
             * 获取qmnum属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getQMNUM() {
                return qmnum;
            }

            /**
             * 设置qmnum属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setQMNUM(String value) {
                this.qmnum = value;
            }

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

        }

    }

}
