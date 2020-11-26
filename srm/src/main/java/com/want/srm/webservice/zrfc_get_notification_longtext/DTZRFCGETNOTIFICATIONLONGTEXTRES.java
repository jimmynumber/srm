package com.want.srm.webservice.zrfc_get_notification_longtext;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>DT_ZRFC_GET_NOTIFICATION_LONGTEXT_RES complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="DT_ZRFC_GET_NOTIFICATION_LONGTEXT_RES">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HEADER" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="TDOBJECT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="TDNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="TDID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="TDSPRAS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="TDTITLE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="TDFORM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="TDSTYLE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="TDVERSION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="TDFUSER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="TDFRELES" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="TDFDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="TDFTIME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="TDLUSER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="TDLRELES" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="TDLDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="TDLTIME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="TDLINESIZE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="TDTXTLINES" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="TDHYPHENAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="TDOSPRAS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="TDTRANSTAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="TDMACODE1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="TDMACODE2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="TDREFOBJ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="TDREFNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="TDREFID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="TDTEXTTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="TDCOMPRESS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="MANDT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="TDOCLASS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="LOGSYS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="LINES" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ITEM" maxOccurs="unbounded" minOccurs="0">
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
@XmlType(name = "DT_ZRFC_GET_NOTIFICATION_LONGTEXT_RES", propOrder = {
    "header",
    "lines"
})
public class DTZRFCGETNOTIFICATIONLONGTEXTRES {

    @XmlElement(name = "HEADER")
    protected DTZRFCGETNOTIFICATIONLONGTEXTRES.HEADER header;
    @XmlElement(name = "LINES")
    protected DTZRFCGETNOTIFICATIONLONGTEXTRES.LINES lines;

    /**
     * 获取header属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DTZRFCGETNOTIFICATIONLONGTEXTRES.HEADER }
     *     
     */
    public DTZRFCGETNOTIFICATIONLONGTEXTRES.HEADER getHEADER() {
        return header;
    }

    /**
     * 设置header属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DTZRFCGETNOTIFICATIONLONGTEXTRES.HEADER }
     *     
     */
    public void setHEADER(DTZRFCGETNOTIFICATIONLONGTEXTRES.HEADER value) {
        this.header = value;
    }

    /**
     * 获取lines属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DTZRFCGETNOTIFICATIONLONGTEXTRES.LINES }
     *     
     */
    public DTZRFCGETNOTIFICATIONLONGTEXTRES.LINES getLINES() {
        return lines;
    }

    /**
     * 设置lines属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DTZRFCGETNOTIFICATIONLONGTEXTRES.LINES }
     *     
     */
    public void setLINES(DTZRFCGETNOTIFICATIONLONGTEXTRES.LINES value) {
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
     *         &lt;element name="TDOBJECT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="TDNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="TDID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="TDSPRAS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="TDTITLE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="TDFORM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="TDSTYLE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="TDVERSION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="TDFUSER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="TDFRELES" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="TDFDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="TDFTIME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="TDLUSER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="TDLRELES" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="TDLDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="TDLTIME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="TDLINESIZE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="TDTXTLINES" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="TDHYPHENAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="TDOSPRAS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="TDTRANSTAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="TDMACODE1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="TDMACODE2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="TDREFOBJ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="TDREFNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="TDREFID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="TDTEXTTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="TDCOMPRESS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="MANDT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="TDOCLASS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="LOGSYS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "tdobject",
        "tdname",
        "tdid",
        "tdspras",
        "tdtitle",
        "tdform",
        "tdstyle",
        "tdversion",
        "tdfuser",
        "tdfreles",
        "tdfdate",
        "tdftime",
        "tdluser",
        "tdlreles",
        "tdldate",
        "tdltime",
        "tdlinesize",
        "tdtxtlines",
        "tdhyphenat",
        "tdospras",
        "tdtranstat",
        "tdmacode1",
        "tdmacode2",
        "tdrefobj",
        "tdrefname",
        "tdrefid",
        "tdtexttype",
        "tdcompress",
        "mandt",
        "tdoclass",
        "logsys"
    })
    public static class HEADER {

        @XmlElement(name = "TDOBJECT")
        protected String tdobject;
        @XmlElement(name = "TDNAME")
        protected String tdname;
        @XmlElement(name = "TDID")
        protected String tdid;
        @XmlElement(name = "TDSPRAS")
        protected String tdspras;
        @XmlElement(name = "TDTITLE")
        protected String tdtitle;
        @XmlElement(name = "TDFORM")
        protected String tdform;
        @XmlElement(name = "TDSTYLE")
        protected String tdstyle;
        @XmlElement(name = "TDVERSION")
        protected String tdversion;
        @XmlElement(name = "TDFUSER")
        protected String tdfuser;
        @XmlElement(name = "TDFRELES")
        protected String tdfreles;
        @XmlElement(name = "TDFDATE")
        protected String tdfdate;
        @XmlElement(name = "TDFTIME")
        protected String tdftime;
        @XmlElement(name = "TDLUSER")
        protected String tdluser;
        @XmlElement(name = "TDLRELES")
        protected String tdlreles;
        @XmlElement(name = "TDLDATE")
        protected String tdldate;
        @XmlElement(name = "TDLTIME")
        protected String tdltime;
        @XmlElement(name = "TDLINESIZE")
        protected String tdlinesize;
        @XmlElement(name = "TDTXTLINES")
        protected String tdtxtlines;
        @XmlElement(name = "TDHYPHENAT")
        protected String tdhyphenat;
        @XmlElement(name = "TDOSPRAS")
        protected String tdospras;
        @XmlElement(name = "TDTRANSTAT")
        protected String tdtranstat;
        @XmlElement(name = "TDMACODE1")
        protected String tdmacode1;
        @XmlElement(name = "TDMACODE2")
        protected String tdmacode2;
        @XmlElement(name = "TDREFOBJ")
        protected String tdrefobj;
        @XmlElement(name = "TDREFNAME")
        protected String tdrefname;
        @XmlElement(name = "TDREFID")
        protected String tdrefid;
        @XmlElement(name = "TDTEXTTYPE")
        protected String tdtexttype;
        @XmlElement(name = "TDCOMPRESS")
        protected String tdcompress;
        @XmlElement(name = "MANDT")
        protected String mandt;
        @XmlElement(name = "TDOCLASS")
        protected String tdoclass;
        @XmlElement(name = "LOGSYS")
        protected String logsys;

        /**
         * 获取tdobject属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTDOBJECT() {
            return tdobject;
        }

        /**
         * 设置tdobject属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTDOBJECT(String value) {
            this.tdobject = value;
        }

        /**
         * 获取tdname属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTDNAME() {
            return tdname;
        }

        /**
         * 设置tdname属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTDNAME(String value) {
            this.tdname = value;
        }

        /**
         * 获取tdid属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTDID() {
            return tdid;
        }

        /**
         * 设置tdid属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTDID(String value) {
            this.tdid = value;
        }

        /**
         * 获取tdspras属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTDSPRAS() {
            return tdspras;
        }

        /**
         * 设置tdspras属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTDSPRAS(String value) {
            this.tdspras = value;
        }

        /**
         * 获取tdtitle属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTDTITLE() {
            return tdtitle;
        }

        /**
         * 设置tdtitle属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTDTITLE(String value) {
            this.tdtitle = value;
        }

        /**
         * 获取tdform属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTDFORM() {
            return tdform;
        }

        /**
         * 设置tdform属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTDFORM(String value) {
            this.tdform = value;
        }

        /**
         * 获取tdstyle属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTDSTYLE() {
            return tdstyle;
        }

        /**
         * 设置tdstyle属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTDSTYLE(String value) {
            this.tdstyle = value;
        }

        /**
         * 获取tdversion属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTDVERSION() {
            return tdversion;
        }

        /**
         * 设置tdversion属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTDVERSION(String value) {
            this.tdversion = value;
        }

        /**
         * 获取tdfuser属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTDFUSER() {
            return tdfuser;
        }

        /**
         * 设置tdfuser属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTDFUSER(String value) {
            this.tdfuser = value;
        }

        /**
         * 获取tdfreles属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTDFRELES() {
            return tdfreles;
        }

        /**
         * 设置tdfreles属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTDFRELES(String value) {
            this.tdfreles = value;
        }

        /**
         * 获取tdfdate属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTDFDATE() {
            return tdfdate;
        }

        /**
         * 设置tdfdate属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTDFDATE(String value) {
            this.tdfdate = value;
        }

        /**
         * 获取tdftime属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTDFTIME() {
            return tdftime;
        }

        /**
         * 设置tdftime属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTDFTIME(String value) {
            this.tdftime = value;
        }

        /**
         * 获取tdluser属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTDLUSER() {
            return tdluser;
        }

        /**
         * 设置tdluser属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTDLUSER(String value) {
            this.tdluser = value;
        }

        /**
         * 获取tdlreles属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTDLRELES() {
            return tdlreles;
        }

        /**
         * 设置tdlreles属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTDLRELES(String value) {
            this.tdlreles = value;
        }

        /**
         * 获取tdldate属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTDLDATE() {
            return tdldate;
        }

        /**
         * 设置tdldate属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTDLDATE(String value) {
            this.tdldate = value;
        }

        /**
         * 获取tdltime属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTDLTIME() {
            return tdltime;
        }

        /**
         * 设置tdltime属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTDLTIME(String value) {
            this.tdltime = value;
        }

        /**
         * 获取tdlinesize属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTDLINESIZE() {
            return tdlinesize;
        }

        /**
         * 设置tdlinesize属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTDLINESIZE(String value) {
            this.tdlinesize = value;
        }

        /**
         * 获取tdtxtlines属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTDTXTLINES() {
            return tdtxtlines;
        }

        /**
         * 设置tdtxtlines属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTDTXTLINES(String value) {
            this.tdtxtlines = value;
        }

        /**
         * 获取tdhyphenat属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTDHYPHENAT() {
            return tdhyphenat;
        }

        /**
         * 设置tdhyphenat属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTDHYPHENAT(String value) {
            this.tdhyphenat = value;
        }

        /**
         * 获取tdospras属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTDOSPRAS() {
            return tdospras;
        }

        /**
         * 设置tdospras属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTDOSPRAS(String value) {
            this.tdospras = value;
        }

        /**
         * 获取tdtranstat属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTDTRANSTAT() {
            return tdtranstat;
        }

        /**
         * 设置tdtranstat属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTDTRANSTAT(String value) {
            this.tdtranstat = value;
        }

        /**
         * 获取tdmacode1属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTDMACODE1() {
            return tdmacode1;
        }

        /**
         * 设置tdmacode1属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTDMACODE1(String value) {
            this.tdmacode1 = value;
        }

        /**
         * 获取tdmacode2属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTDMACODE2() {
            return tdmacode2;
        }

        /**
         * 设置tdmacode2属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTDMACODE2(String value) {
            this.tdmacode2 = value;
        }

        /**
         * 获取tdrefobj属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTDREFOBJ() {
            return tdrefobj;
        }

        /**
         * 设置tdrefobj属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTDREFOBJ(String value) {
            this.tdrefobj = value;
        }

        /**
         * 获取tdrefname属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTDREFNAME() {
            return tdrefname;
        }

        /**
         * 设置tdrefname属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTDREFNAME(String value) {
            this.tdrefname = value;
        }

        /**
         * 获取tdrefid属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTDREFID() {
            return tdrefid;
        }

        /**
         * 设置tdrefid属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTDREFID(String value) {
            this.tdrefid = value;
        }

        /**
         * 获取tdtexttype属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTDTEXTTYPE() {
            return tdtexttype;
        }

        /**
         * 设置tdtexttype属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTDTEXTTYPE(String value) {
            this.tdtexttype = value;
        }

        /**
         * 获取tdcompress属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTDCOMPRESS() {
            return tdcompress;
        }

        /**
         * 设置tdcompress属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTDCOMPRESS(String value) {
            this.tdcompress = value;
        }

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
         * 获取tdoclass属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTDOCLASS() {
            return tdoclass;
        }

        /**
         * 设置tdoclass属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTDOCLASS(String value) {
            this.tdoclass = value;
        }

        /**
         * 获取logsys属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLOGSYS() {
            return logsys;
        }

        /**
         * 设置logsys属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLOGSYS(String value) {
            this.logsys = value;
        }

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

        @XmlElement(name = "ITEM")
        protected List<DTZRFCGETNOTIFICATIONLONGTEXTRES.LINES.ITEM> item;

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
         * {@link DTZRFCGETNOTIFICATIONLONGTEXTRES.LINES.ITEM }
         * 
         * 
         */
        public List<DTZRFCGETNOTIFICATIONLONGTEXTRES.LINES.ITEM> getITEM() {
            if (item == null) {
                item = new ArrayList<DTZRFCGETNOTIFICATIONLONGTEXTRES.LINES.ITEM>();
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
        public static class ITEM {

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
