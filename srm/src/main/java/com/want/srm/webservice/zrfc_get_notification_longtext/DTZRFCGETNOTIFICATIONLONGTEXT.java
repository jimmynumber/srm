package com.want.srm.webservice.zrfc_get_notification_longtext;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>DT_ZRFC_GET_NOTIFICATION_LONGTEXT complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="DT_ZRFC_GET_NOTIFICATION_LONGTEXT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="QMNUM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LINES" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="TDFORMAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="TDLINE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "DT_ZRFC_GET_NOTIFICATION_LONGTEXT", propOrder = {
    "qmnum",
    "lines"
})
public class DTZRFCGETNOTIFICATIONLONGTEXT {

    @XmlElement(name = "QMNUM")
    protected String qmnum;
    @XmlElement(name = "LINES")
    protected DTZRFCGETNOTIFICATIONLONGTEXT.LINES lines;

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
     * 获取lines属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DTZRFCGETNOTIFICATIONLONGTEXT.LINES }
     *     
     */
    public DTZRFCGETNOTIFICATIONLONGTEXT.LINES getLINES() {
        return lines;
    }

    /**
     * 设置lines属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DTZRFCGETNOTIFICATIONLONGTEXT.LINES }
     *     
     */
    public void setLINES(DTZRFCGETNOTIFICATIONLONGTEXT.LINES value) {
        this.lines = value;
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
     *                   &lt;element name="TDFORMAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="TDLINE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    public static class LINES {

        protected List<DTZRFCGETNOTIFICATIONLONGTEXT.LINES.Item> item;

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
         * {@link DTZRFCGETNOTIFICATIONLONGTEXT.LINES.Item }
         * 
         * 
         */
        public List<DTZRFCGETNOTIFICATIONLONGTEXT.LINES.Item> getItem() {
            if (item == null) {
                item = new ArrayList<DTZRFCGETNOTIFICATIONLONGTEXT.LINES.Item>();
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
         *         &lt;element name="TDFORMAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="TDLINE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "tdformat",
            "tdline"
        })
        public static class Item {

            @XmlElement(name = "TDFORMAT")
            protected String tdformat;
            @XmlElement(name = "TDLINE")
            protected String tdline;

            /**
             * 获取tdformat属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTDFORMAT() {
                return tdformat;
            }

            /**
             * 设置tdformat属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTDFORMAT(String value) {
                this.tdformat = value;
            }

            /**
             * 获取tdline属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTDLINE() {
                return tdline;
            }

            /**
             * 设置tdline属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTDLINE(String value) {
                this.tdline = value;
            }

        }

    }

}
