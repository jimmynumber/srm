package com.want.srm.webservice.zrfcsrm016;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>DT_ZRFCSRM016_REQ complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="DT_ZRFCSRM016_REQ">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="QMNUM_I" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="T_QMEL_E" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ITEM" maxOccurs="unbounded" minOccurs="0">
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
@XmlType(name = "DT_ZRFCSRM016_REQ", propOrder = {
    "qmnumi",
    "tqmele"
})
public class DTZRFCSRM016REQ {

    @XmlElement(name = "QMNUM_I")
    protected String qmnumi;
    @XmlElement(name = "T_QMEL_E")
    protected DTZRFCSRM016REQ.TQMELE tqmele;

    /**
     * 获取qmnumi属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQMNUMI() {
        return qmnumi;
    }

    /**
     * 设置qmnumi属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQMNUMI(String value) {
        this.qmnumi = value;
    }

    /**
     * 获取tqmele属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DTZRFCSRM016REQ.TQMELE }
     *     
     */
    public DTZRFCSRM016REQ.TQMELE getTQMELE() {
        return tqmele;
    }

    /**
     * 设置tqmele属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DTZRFCSRM016REQ.TQMELE }
     *     
     */
    public void setTQMELE(DTZRFCSRM016REQ.TQMELE value) {
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
     *         &lt;element name="ITEM" maxOccurs="unbounded" minOccurs="0">
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

        @XmlElement(name = "ITEM")
        protected List<DTZRFCSRM016REQ.TQMELE.ITEM> item;

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
         *    getITEM().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DTZRFCSRM016REQ.TQMELE.ITEM }
         * 
         * 
         */
        public List<DTZRFCSRM016REQ.TQMELE.ITEM> getITEM() {
            if (item == null) {
                item = new ArrayList<DTZRFCSRM016REQ.TQMELE.ITEM>();
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
        public static class ITEM {

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
