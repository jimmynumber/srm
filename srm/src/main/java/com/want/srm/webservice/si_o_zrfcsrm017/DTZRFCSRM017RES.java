
package com.want.srm.webservice.si_o_zrfcsrm017;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>DT_ZRFCSRM017_RES complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="DT_ZRFCSRM017_RES">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="O_ZSMYW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="T_TAB" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="MANDT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="BUKRS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="WERKS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ZZHXDC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ZBCXB" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ZWERKS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ZZBATCH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ZPLANT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ZSRMF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="SXDAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CFDAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="DFDAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="LPLANT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ZSMYW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ZLYJC1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ZGLNP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ZWMTS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ZYGDD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="MENDT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ZYZQY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "DT_ZRFCSRM017_RES", propOrder = {
    "ozsmyw",
    "ttab"
})
public class DTZRFCSRM017RES {

    @XmlElement(name = "O_ZSMYW")
    protected String ozsmyw;
    @XmlElement(name = "T_TAB")
    protected DTZRFCSRM017RES.TTAB ttab;

    /**
     * 获取ozsmyw属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOZSMYW() {
        return ozsmyw;
    }

    /**
     * 设置ozsmyw属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOZSMYW(String value) {
        this.ozsmyw = value;
    }

    /**
     * 获取ttab属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DTZRFCSRM017RES.TTAB }
     *     
     */
    public DTZRFCSRM017RES.TTAB getTTAB() {
        return ttab;
    }

    /**
     * 设置ttab属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DTZRFCSRM017RES.TTAB }
     *     
     */
    public void setTTAB(DTZRFCSRM017RES.TTAB value) {
        this.ttab = value;
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
     *                   &lt;element name="MANDT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="BUKRS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="WERKS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ZZHXDC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ZBCXB" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ZWERKS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ZZBATCH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ZPLANT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ZSRMF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="SXDAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CFDAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="DFDAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="LPLANT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ZSMYW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ZLYJC1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ZGLNP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ZWMTS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ZYGDD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="MENDT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ZYZQY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    public static class TTAB {

        protected List<DTZRFCSRM017RES.TTAB.Item> item;

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
         * {@link DTZRFCSRM017RES.TTAB.Item }
         * 
         * 
         */
        public List<DTZRFCSRM017RES.TTAB.Item> getItem() {
            if (item == null) {
                item = new ArrayList<DTZRFCSRM017RES.TTAB.Item>();
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
         *         &lt;element name="MANDT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="BUKRS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="WERKS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ZZHXDC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ZBCXB" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ZWERKS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ZZBATCH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ZPLANT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ZSRMF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="SXDAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="CFDAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="DFDAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="LPLANT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ZSMYW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ZLYJC1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ZGLNP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ZWMTS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ZYGDD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="MENDT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ZYZQY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "mandt",
            "bukrs",
            "werks",
            "zzhxdc",
            "zbcxb",
            "zwerks",
            "zzbatch",
            "zplant",
            "zsrmf",
            "sxdat",
            "cfdat",
            "dfdat",
            "lplant",
            "zsmyw",
            "zlyjc1",
            "zglnp",
            "zwmts",
            "zygdd",
            "mendt",
            "zyzqy"
        })
        public static class Item {

            @XmlElement(name = "MANDT")
            protected String mandt;
            @XmlElement(name = "BUKRS")
            protected String bukrs;
            @XmlElement(name = "WERKS")
            protected String werks;
            @XmlElement(name = "ZZHXDC")
            protected String zzhxdc;
            @XmlElement(name = "ZBCXB")
            protected String zbcxb;
            @XmlElement(name = "ZWERKS")
            protected String zwerks;
            @XmlElement(name = "ZZBATCH")
            protected String zzbatch;
            @XmlElement(name = "ZPLANT")
            protected String zplant;
            @XmlElement(name = "ZSRMF")
            protected String zsrmf;
            @XmlElement(name = "SXDAT")
            protected String sxdat;
            @XmlElement(name = "CFDAT")
            protected String cfdat;
            @XmlElement(name = "DFDAT")
            protected String dfdat;
            @XmlElement(name = "LPLANT")
            protected String lplant;
            @XmlElement(name = "ZSMYW")
            protected String zsmyw;
            @XmlElement(name = "ZLYJC1")
            protected String zlyjc1;
            @XmlElement(name = "ZGLNP")
            protected String zglnp;
            @XmlElement(name = "ZWMTS")
            protected String zwmts;
            @XmlElement(name = "ZYGDD")
            protected String zygdd;
            @XmlElement(name = "MENDT")
            protected String mendt;
            @XmlElement(name = "ZYZQY")
            protected String zyzqy;

            /**
             * 获取mandt属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMANDT() {
                return mandt;
            }

            /**
             * 设置mandt属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMANDT(String value) {
                this.mandt = value;
            }

            /**
             * 获取bukrs属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBUKRS() {
                return bukrs;
            }

            /**
             * 设置bukrs属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBUKRS(String value) {
                this.bukrs = value;
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
             * 获取zzhxdc属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getZZHXDC() {
                return zzhxdc;
            }

            /**
             * 设置zzhxdc属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setZZHXDC(String value) {
                this.zzhxdc = value;
            }

            /**
             * 获取zbcxb属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getZBCXB() {
                return zbcxb;
            }

            /**
             * 设置zbcxb属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setZBCXB(String value) {
                this.zbcxb = value;
            }

            /**
             * 获取zwerks属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getZWERKS() {
                return zwerks;
            }

            /**
             * 设置zwerks属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setZWERKS(String value) {
                this.zwerks = value;
            }

            /**
             * 获取zzbatch属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getZZBATCH() {
                return zzbatch;
            }

            /**
             * 设置zzbatch属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setZZBATCH(String value) {
                this.zzbatch = value;
            }

            /**
             * 获取zplant属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getZPLANT() {
                return zplant;
            }

            /**
             * 设置zplant属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setZPLANT(String value) {
                this.zplant = value;
            }

            /**
             * 获取zsrmf属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getZSRMF() {
                return zsrmf;
            }

            /**
             * 设置zsrmf属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setZSRMF(String value) {
                this.zsrmf = value;
            }

            /**
             * 获取sxdat属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSXDAT() {
                return sxdat;
            }

            /**
             * 设置sxdat属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSXDAT(String value) {
                this.sxdat = value;
            }

            /**
             * 获取cfdat属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCFDAT() {
                return cfdat;
            }

            /**
             * 设置cfdat属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCFDAT(String value) {
                this.cfdat = value;
            }

            /**
             * 获取dfdat属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDFDAT() {
                return dfdat;
            }

            /**
             * 设置dfdat属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDFDAT(String value) {
                this.dfdat = value;
            }

            /**
             * 获取lplant属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLPLANT() {
                return lplant;
            }

            /**
             * 设置lplant属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLPLANT(String value) {
                this.lplant = value;
            }

            /**
             * 获取zsmyw属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getZSMYW() {
                return zsmyw;
            }

            /**
             * 设置zsmyw属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setZSMYW(String value) {
                this.zsmyw = value;
            }

            /**
             * 获取zlyjc1属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getZLYJC1() {
                return zlyjc1;
            }

            /**
             * 设置zlyjc1属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setZLYJC1(String value) {
                this.zlyjc1 = value;
            }

            /**
             * 获取zglnp属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getZGLNP() {
                return zglnp;
            }

            /**
             * 设置zglnp属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setZGLNP(String value) {
                this.zglnp = value;
            }

            /**
             * 获取zwmts属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getZWMTS() {
                return zwmts;
            }

            /**
             * 设置zwmts属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setZWMTS(String value) {
                this.zwmts = value;
            }

            /**
             * 获取zygdd属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getZYGDD() {
                return zygdd;
            }

            /**
             * 设置zygdd属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setZYGDD(String value) {
                this.zygdd = value;
            }

            /**
             * 获取mendt属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMENDT() {
                return mendt;
            }

            /**
             * 设置mendt属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMENDT(String value) {
                this.mendt = value;
            }

            /**
             * 获取zyzqy属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getZYZQY() {
                return zyzqy;
            }

            /**
             * 设置zyzqy属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setZYZQY(String value) {
                this.zyzqy = value;
            }

        }

    }

}
