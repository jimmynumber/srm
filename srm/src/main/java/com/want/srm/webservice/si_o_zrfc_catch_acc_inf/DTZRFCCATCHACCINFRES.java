package com.want.srm.webservice.si_o_zrfc_catch_acc_inf;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>DT_ZRFC_CATCH_ACC_INF_RES complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="DT_ZRFC_CATCH_ACC_INF_RES">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="O_CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="O_MSG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OT_DATA" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="WERKS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="NAME1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="LIFNR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="EBELN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="EBELP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="BUDAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="MBLNR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="BUZEL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="MJAHR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="MATNR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="MAKTX" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="BPMNG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="MSEHL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="MSEJS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="MENGE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="NETPR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="PEINH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="WAERS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="DMBTR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="KBETR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="TEXT1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="EKORG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="VAEDATUM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="LSMNG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ZSJDHJE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ZCYL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="BTEXT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="MWSKZ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ZSJWERKS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ZSJWERKS_DESC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CPUDT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *         &lt;element name="S_BSART" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="SIGN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="OPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="LOW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="HIGH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *         &lt;element name="S_BUDAT" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="SIGN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="OPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="LOW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="HIGH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *         &lt;element name="S_BWART" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="SIGN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="OPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="LOW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="HIGH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *         &lt;element name="S_CPUDT" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="SIGN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="OPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="LOW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="HIGH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *         &lt;element name="S_EBELN" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="SIGN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="OPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="LOW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="HIGH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *         &lt;element name="S_EKGRP" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="SIGN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="OPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="LOW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="HIGH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *         &lt;element name="S_EKORG" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="SIGN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="OPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="LOW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="HIGH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *         &lt;element name="S_LIFNR" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="SIGN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="OPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="LOW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="HIGH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *         &lt;element name="S_MATNR" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="SIGN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="OPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="LOW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="HIGH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *         &lt;element name="S_MTART" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="SIGN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="OPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="LOW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="HIGH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *         &lt;element name="S_WERKS" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="SIGN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="OPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="LOW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="HIGH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "DT_ZRFC_CATCH_ACC_INF_RES", propOrder = {
    "ocode",
    "omsg",
    "otdata",
    "sbsart",
    "sbudat",
    "sbwart",
    "scpudt",
    "sebeln",
    "sekgrp",
    "sekorg",
    "slifnr",
    "smatnr",
    "smtart",
    "swerks"
})
public class DTZRFCCATCHACCINFRES {

    @XmlElement(name = "O_CODE")
    protected String ocode;
    @XmlElement(name = "O_MSG")
    protected String omsg;
    @XmlElement(name = "OT_DATA")
    protected DTZRFCCATCHACCINFRES.OTDATA otdata;
    @XmlElement(name = "S_BSART")
    protected DTZRFCCATCHACCINFRES.SBSART sbsart;
    @XmlElement(name = "S_BUDAT")
    protected DTZRFCCATCHACCINFRES.SBUDAT sbudat;
    @XmlElement(name = "S_BWART")
    protected DTZRFCCATCHACCINFRES.SBWART sbwart;
    @XmlElement(name = "S_CPUDT")
    protected DTZRFCCATCHACCINFRES.SCPUDT scpudt;
    @XmlElement(name = "S_EBELN")
    protected DTZRFCCATCHACCINFRES.SEBELN sebeln;
    @XmlElement(name = "S_EKGRP")
    protected DTZRFCCATCHACCINFRES.SEKGRP sekgrp;
    @XmlElement(name = "S_EKORG")
    protected DTZRFCCATCHACCINFRES.SEKORG sekorg;
    @XmlElement(name = "S_LIFNR")
    protected DTZRFCCATCHACCINFRES.SLIFNR slifnr;
    @XmlElement(name = "S_MATNR")
    protected DTZRFCCATCHACCINFRES.SMATNR smatnr;
    @XmlElement(name = "S_MTART")
    protected DTZRFCCATCHACCINFRES.SMTART smtart;
    @XmlElement(name = "S_WERKS")
    protected DTZRFCCATCHACCINFRES.SWERKS swerks;

    /**
     * 获取ocode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOCODE() {
        return ocode;
    }

    /**
     * 设置ocode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOCODE(String value) {
        this.ocode = value;
    }

    /**
     * 获取omsg属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOMSG() {
        return omsg;
    }

    /**
     * 设置omsg属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOMSG(String value) {
        this.omsg = value;
    }

    /**
     * 获取otdata属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DTZRFCCATCHACCINFRES.OTDATA }
     *     
     */
    public DTZRFCCATCHACCINFRES.OTDATA getOTDATA() {
        return otdata;
    }

    /**
     * 设置otdata属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DTZRFCCATCHACCINFRES.OTDATA }
     *     
     */
    public void setOTDATA(DTZRFCCATCHACCINFRES.OTDATA value) {
        this.otdata = value;
    }

    /**
     * 获取sbsart属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DTZRFCCATCHACCINFRES.SBSART }
     *     
     */
    public DTZRFCCATCHACCINFRES.SBSART getSBSART() {
        return sbsart;
    }

    /**
     * 设置sbsart属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DTZRFCCATCHACCINFRES.SBSART }
     *     
     */
    public void setSBSART(DTZRFCCATCHACCINFRES.SBSART value) {
        this.sbsart = value;
    }

    /**
     * 获取sbudat属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DTZRFCCATCHACCINFRES.SBUDAT }
     *     
     */
    public DTZRFCCATCHACCINFRES.SBUDAT getSBUDAT() {
        return sbudat;
    }

    /**
     * 设置sbudat属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DTZRFCCATCHACCINFRES.SBUDAT }
     *     
     */
    public void setSBUDAT(DTZRFCCATCHACCINFRES.SBUDAT value) {
        this.sbudat = value;
    }

    /**
     * 获取sbwart属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DTZRFCCATCHACCINFRES.SBWART }
     *     
     */
    public DTZRFCCATCHACCINFRES.SBWART getSBWART() {
        return sbwart;
    }

    /**
     * 设置sbwart属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DTZRFCCATCHACCINFRES.SBWART }
     *     
     */
    public void setSBWART(DTZRFCCATCHACCINFRES.SBWART value) {
        this.sbwart = value;
    }

    /**
     * 获取scpudt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DTZRFCCATCHACCINFRES.SCPUDT }
     *     
     */
    public DTZRFCCATCHACCINFRES.SCPUDT getSCPUDT() {
        return scpudt;
    }

    /**
     * 设置scpudt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DTZRFCCATCHACCINFRES.SCPUDT }
     *     
     */
    public void setSCPUDT(DTZRFCCATCHACCINFRES.SCPUDT value) {
        this.scpudt = value;
    }

    /**
     * 获取sebeln属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DTZRFCCATCHACCINFRES.SEBELN }
     *     
     */
    public DTZRFCCATCHACCINFRES.SEBELN getSEBELN() {
        return sebeln;
    }

    /**
     * 设置sebeln属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DTZRFCCATCHACCINFRES.SEBELN }
     *     
     */
    public void setSEBELN(DTZRFCCATCHACCINFRES.SEBELN value) {
        this.sebeln = value;
    }

    /**
     * 获取sekgrp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DTZRFCCATCHACCINFRES.SEKGRP }
     *     
     */
    public DTZRFCCATCHACCINFRES.SEKGRP getSEKGRP() {
        return sekgrp;
    }

    /**
     * 设置sekgrp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DTZRFCCATCHACCINFRES.SEKGRP }
     *     
     */
    public void setSEKGRP(DTZRFCCATCHACCINFRES.SEKGRP value) {
        this.sekgrp = value;
    }

    /**
     * 获取sekorg属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DTZRFCCATCHACCINFRES.SEKORG }
     *     
     */
    public DTZRFCCATCHACCINFRES.SEKORG getSEKORG() {
        return sekorg;
    }

    /**
     * 设置sekorg属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DTZRFCCATCHACCINFRES.SEKORG }
     *     
     */
    public void setSEKORG(DTZRFCCATCHACCINFRES.SEKORG value) {
        this.sekorg = value;
    }

    /**
     * 获取slifnr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DTZRFCCATCHACCINFRES.SLIFNR }
     *     
     */
    public DTZRFCCATCHACCINFRES.SLIFNR getSLIFNR() {
        return slifnr;
    }

    /**
     * 设置slifnr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DTZRFCCATCHACCINFRES.SLIFNR }
     *     
     */
    public void setSLIFNR(DTZRFCCATCHACCINFRES.SLIFNR value) {
        this.slifnr = value;
    }

    /**
     * 获取smatnr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DTZRFCCATCHACCINFRES.SMATNR }
     *     
     */
    public DTZRFCCATCHACCINFRES.SMATNR getSMATNR() {
        return smatnr;
    }

    /**
     * 设置smatnr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DTZRFCCATCHACCINFRES.SMATNR }
     *     
     */
    public void setSMATNR(DTZRFCCATCHACCINFRES.SMATNR value) {
        this.smatnr = value;
    }

    /**
     * 获取smtart属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DTZRFCCATCHACCINFRES.SMTART }
     *     
     */
    public DTZRFCCATCHACCINFRES.SMTART getSMTART() {
        return smtart;
    }

    /**
     * 设置smtart属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DTZRFCCATCHACCINFRES.SMTART }
     *     
     */
    public void setSMTART(DTZRFCCATCHACCINFRES.SMTART value) {
        this.smtart = value;
    }

    /**
     * 获取swerks属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DTZRFCCATCHACCINFRES.SWERKS }
     *     
     */
    public DTZRFCCATCHACCINFRES.SWERKS getSWERKS() {
        return swerks;
    }

    /**
     * 设置swerks属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DTZRFCCATCHACCINFRES.SWERKS }
     *     
     */
    public void setSWERKS(DTZRFCCATCHACCINFRES.SWERKS value) {
        this.swerks = value;
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
     *                   &lt;element name="WERKS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="NAME1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="LIFNR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="EBELN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="EBELP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="BUDAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="MBLNR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="BUZEL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="MJAHR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="MATNR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="MAKTX" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="BPMNG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="MSEHL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="MSEJS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="MENGE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="NETPR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="PEINH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="WAERS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="DMBTR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="KBETR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="TEXT1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="EKORG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="VAEDATUM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="LSMNG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ZSJDHJE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ZCYL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="BTEXT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="MWSKZ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ZSJWERKS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ZSJWERKS_DESC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CPUDT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    public static class OTDATA {

        protected List<DTZRFCCATCHACCINFRES.OTDATA.Item> item;

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
         * {@link DTZRFCCATCHACCINFRES.OTDATA.Item }
         * 
         * 
         */
        public List<DTZRFCCATCHACCINFRES.OTDATA.Item> getItem() {
            if (item == null) {
                item = new ArrayList<DTZRFCCATCHACCINFRES.OTDATA.Item>();
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
         *         &lt;element name="WERKS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="NAME1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="LIFNR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="EBELN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="EBELP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="BUDAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="MBLNR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="BUZEL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="MJAHR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="MATNR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="MAKTX" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="BPMNG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="MSEHL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="MSEJS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="MENGE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="NETPR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="PEINH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="WAERS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="DMBTR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="KBETR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="TEXT1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="EKORG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="VAEDATUM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="LSMNG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ZSJDHJE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ZCYL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="BTEXT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="MWSKZ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ZSJWERKS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ZSJWERKS_DESC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="CPUDT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "werks",
            "name1",
            "lifnr",
            "name",
            "ebeln",
            "ebelp",
            "budat",
            "mblnr",
            "buzel",
            "mjahr",
            "matnr",
            "maktx",
            "bpmng",
            "msehl",
            "msejs",
            "menge",
            "netpr",
            "peinh",
            "waers",
            "dmbtr",
            "kbetr",
            "text1",
            "ekorg",
            "vaedatum",
            "lsmng",
            "zsjdhje",
            "zcyl",
            "btext",
            "mwskz",
            "zsjwerks",
            "zsjwerksdesc",
            "cpudt"
        })
        public static class Item {

            @XmlElement(name = "WERKS")
            protected String werks;
            @XmlElement(name = "NAME1")
            protected String name1;
            @XmlElement(name = "LIFNR")
            protected String lifnr;
            @XmlElement(name = "NAME")
            protected String name;
            @XmlElement(name = "EBELN")
            protected String ebeln;
            @XmlElement(name = "EBELP")
            protected String ebelp;
            @XmlElement(name = "BUDAT")
            protected String budat;
            @XmlElement(name = "MBLNR")
            protected String mblnr;
            @XmlElement(name = "BUZEL")
            protected String buzel;
            @XmlElement(name = "MJAHR")
            protected String mjahr;
            @XmlElement(name = "MATNR")
            protected String matnr;
            @XmlElement(name = "MAKTX")
            protected String maktx;
            @XmlElement(name = "BPMNG")
            protected String bpmng;
            @XmlElement(name = "MSEHL")
            protected String msehl;
            @XmlElement(name = "MSEJS")
            protected String msejs;
            @XmlElement(name = "MENGE")
            protected String menge;
            @XmlElement(name = "NETPR")
            protected String netpr;
            @XmlElement(name = "PEINH")
            protected String peinh;
            @XmlElement(name = "WAERS")
            protected String waers;
            @XmlElement(name = "DMBTR")
            protected String dmbtr;
            @XmlElement(name = "KBETR")
            protected String kbetr;
            @XmlElement(name = "TEXT1")
            protected String text1;
            @XmlElement(name = "EKORG")
            protected String ekorg;
            @XmlElement(name = "VAEDATUM")
            protected String vaedatum;
            @XmlElement(name = "LSMNG")
            protected String lsmng;
            @XmlElement(name = "ZSJDHJE")
            protected String zsjdhje;
            @XmlElement(name = "ZCYL")
            protected String zcyl;
            @XmlElement(name = "BTEXT")
            protected String btext;
            @XmlElement(name = "MWSKZ")
            protected String mwskz;
            @XmlElement(name = "ZSJWERKS")
            protected String zsjwerks;
            @XmlElement(name = "ZSJWERKS_DESC")
            protected String zsjwerksdesc;
            @XmlElement(name = "CPUDT")
            protected String cpudt;

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
             * 获取lifnr属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLIFNR() {
                return lifnr;
            }

            /**
             * 设置lifnr属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLIFNR(String value) {
                this.lifnr = value;
            }

            /**
             * 获取name属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNAME() {
                return name;
            }

            /**
             * 设置name属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNAME(String value) {
                this.name = value;
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
             * 获取budat属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBUDAT() {
                return budat;
            }

            /**
             * 设置budat属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBUDAT(String value) {
                this.budat = value;
            }

            /**
             * 获取mblnr属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMBLNR() {
                return mblnr;
            }

            /**
             * 设置mblnr属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMBLNR(String value) {
                this.mblnr = value;
            }

            /**
             * 获取buzel属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBUZEL() {
                return buzel;
            }

            /**
             * 设置buzel属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBUZEL(String value) {
                this.buzel = value;
            }

            /**
             * 获取mjahr属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMJAHR() {
                return mjahr;
            }

            /**
             * 设置mjahr属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMJAHR(String value) {
                this.mjahr = value;
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
             * 获取maktx属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMAKTX() {
                return maktx;
            }

            /**
             * 设置maktx属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMAKTX(String value) {
                this.maktx = value;
            }

            /**
             * 获取bpmng属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBPMNG() {
                return bpmng;
            }

            /**
             * 设置bpmng属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBPMNG(String value) {
                this.bpmng = value;
            }

            /**
             * 获取msehl属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMSEHL() {
                return msehl;
            }

            /**
             * 设置msehl属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMSEHL(String value) {
                this.msehl = value;
            }

            /**
             * 获取msejs属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMSEJS() {
                return msejs;
            }

            /**
             * 设置msejs属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMSEJS(String value) {
                this.msejs = value;
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
             * 获取peinh属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPEINH() {
                return peinh;
            }

            /**
             * 设置peinh属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPEINH(String value) {
                this.peinh = value;
            }

            /**
             * 获取waers属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getWAERS() {
                return waers;
            }

            /**
             * 设置waers属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setWAERS(String value) {
                this.waers = value;
            }

            /**
             * 获取dmbtr属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDMBTR() {
                return dmbtr;
            }

            /**
             * 设置dmbtr属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDMBTR(String value) {
                this.dmbtr = value;
            }

            /**
             * 获取kbetr属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getKBETR() {
                return kbetr;
            }

            /**
             * 设置kbetr属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setKBETR(String value) {
                this.kbetr = value;
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
             * 获取ekorg属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEKORG() {
                return ekorg;
            }

            /**
             * 设置ekorg属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEKORG(String value) {
                this.ekorg = value;
            }

            /**
             * 获取vaedatum属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getVAEDATUM() {
                return vaedatum;
            }

            /**
             * 设置vaedatum属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setVAEDATUM(String value) {
                this.vaedatum = value;
            }

            /**
             * 获取lsmng属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLSMNG() {
                return lsmng;
            }

            /**
             * 设置lsmng属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLSMNG(String value) {
                this.lsmng = value;
            }

            /**
             * 获取zsjdhje属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getZSJDHJE() {
                return zsjdhje;
            }

            /**
             * 设置zsjdhje属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setZSJDHJE(String value) {
                this.zsjdhje = value;
            }

            /**
             * 获取zcyl属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getZCYL() {
                return zcyl;
            }

            /**
             * 设置zcyl属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setZCYL(String value) {
                this.zcyl = value;
            }

            /**
             * 获取btext属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBTEXT() {
                return btext;
            }

            /**
             * 设置btext属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBTEXT(String value) {
                this.btext = value;
            }

            /**
             * 获取mwskz属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMWSKZ() {
                return mwskz;
            }

            /**
             * 设置mwskz属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMWSKZ(String value) {
                this.mwskz = value;
            }

            /**
             * 获取zsjwerks属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getZSJWERKS() {
                return zsjwerks;
            }

            /**
             * 设置zsjwerks属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setZSJWERKS(String value) {
                this.zsjwerks = value;
            }

            /**
             * 获取zsjwerksdesc属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getZSJWERKSDESC() {
                return zsjwerksdesc;
            }

            /**
             * 设置zsjwerksdesc属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setZSJWERKSDESC(String value) {
                this.zsjwerksdesc = value;
            }

            /**
             * 获取cpudt属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCPUDT() {
                return cpudt;
            }

            /**
             * 设置cpudt属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCPUDT(String value) {
                this.cpudt = value;
            }

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
     *         &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="SIGN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="OPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="LOW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="HIGH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    public static class SBSART {

        protected List<DTZRFCCATCHACCINFRES.SBSART.Item> item;

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
         * {@link DTZRFCCATCHACCINFRES.SBSART.Item }
         * 
         * 
         */
        public List<DTZRFCCATCHACCINFRES.SBSART.Item> getItem() {
            if (item == null) {
                item = new ArrayList<DTZRFCCATCHACCINFRES.SBSART.Item>();
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
         *         &lt;element name="SIGN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="OPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="LOW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="HIGH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "sign",
            "option",
            "low",
            "high"
        })
        public static class Item {

            @XmlElement(name = "SIGN")
            protected String sign;
            @XmlElement(name = "OPTION")
            protected String option;
            @XmlElement(name = "LOW")
            protected String low;
            @XmlElement(name = "HIGH")
            protected String high;

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
             *     {@link String }
             *     
             */
            public String getLOW() {
                return low;
            }

            /**
             * 设置low属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLOW(String value) {
                this.low = value;
            }

            /**
             * 获取high属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getHIGH() {
                return high;
            }

            /**
             * 设置high属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setHIGH(String value) {
                this.high = value;
            }

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
     *         &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="SIGN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="OPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="LOW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="HIGH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    public static class SBUDAT {

        protected List<DTZRFCCATCHACCINFRES.SBUDAT.Item> item;

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
         * {@link DTZRFCCATCHACCINFRES.SBUDAT.Item }
         * 
         * 
         */
        public List<DTZRFCCATCHACCINFRES.SBUDAT.Item> getItem() {
            if (item == null) {
                item = new ArrayList<DTZRFCCATCHACCINFRES.SBUDAT.Item>();
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
         *         &lt;element name="SIGN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="OPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="LOW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="HIGH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "sign",
            "option",
            "low",
            "high"
        })
        public static class Item {

            @XmlElement(name = "SIGN")
            protected String sign;
            @XmlElement(name = "OPTION")
            protected String option;
            @XmlElement(name = "LOW")
            protected String low;
            @XmlElement(name = "HIGH")
            protected String high;

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
             *     {@link String }
             *     
             */
            public String getLOW() {
                return low;
            }

            /**
             * 设置low属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLOW(String value) {
                this.low = value;
            }

            /**
             * 获取high属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getHIGH() {
                return high;
            }

            /**
             * 设置high属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setHIGH(String value) {
                this.high = value;
            }

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
     *         &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="SIGN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="OPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="LOW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="HIGH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    public static class SBWART {

        protected List<DTZRFCCATCHACCINFRES.SBWART.Item> item;

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
         * {@link DTZRFCCATCHACCINFRES.SBWART.Item }
         * 
         * 
         */
        public List<DTZRFCCATCHACCINFRES.SBWART.Item> getItem() {
            if (item == null) {
                item = new ArrayList<DTZRFCCATCHACCINFRES.SBWART.Item>();
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
         *         &lt;element name="SIGN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="OPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="LOW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="HIGH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "sign",
            "option",
            "low",
            "high"
        })
        public static class Item {

            @XmlElement(name = "SIGN")
            protected String sign;
            @XmlElement(name = "OPTION")
            protected String option;
            @XmlElement(name = "LOW")
            protected String low;
            @XmlElement(name = "HIGH")
            protected String high;

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
             *     {@link String }
             *     
             */
            public String getLOW() {
                return low;
            }

            /**
             * 设置low属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLOW(String value) {
                this.low = value;
            }

            /**
             * 获取high属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getHIGH() {
                return high;
            }

            /**
             * 设置high属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setHIGH(String value) {
                this.high = value;
            }

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
     *         &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="SIGN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="OPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="LOW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="HIGH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    public static class SCPUDT {

        protected List<DTZRFCCATCHACCINFRES.SCPUDT.Item> item;

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
         * {@link DTZRFCCATCHACCINFRES.SCPUDT.Item }
         * 
         * 
         */
        public List<DTZRFCCATCHACCINFRES.SCPUDT.Item> getItem() {
            if (item == null) {
                item = new ArrayList<DTZRFCCATCHACCINFRES.SCPUDT.Item>();
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
         *         &lt;element name="SIGN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="OPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="LOW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="HIGH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "sign",
            "option",
            "low",
            "high"
        })
        public static class Item {

            @XmlElement(name = "SIGN")
            protected String sign;
            @XmlElement(name = "OPTION")
            protected String option;
            @XmlElement(name = "LOW")
            protected String low;
            @XmlElement(name = "HIGH")
            protected String high;

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
             *     {@link String }
             *     
             */
            public String getLOW() {
                return low;
            }

            /**
             * 设置low属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLOW(String value) {
                this.low = value;
            }

            /**
             * 获取high属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getHIGH() {
                return high;
            }

            /**
             * 设置high属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setHIGH(String value) {
                this.high = value;
            }

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
     *         &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="SIGN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="OPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="LOW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="HIGH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    public static class SEBELN {

        protected List<DTZRFCCATCHACCINFRES.SEBELN.Item> item;

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
         * {@link DTZRFCCATCHACCINFRES.SEBELN.Item }
         * 
         * 
         */
        public List<DTZRFCCATCHACCINFRES.SEBELN.Item> getItem() {
            if (item == null) {
                item = new ArrayList<DTZRFCCATCHACCINFRES.SEBELN.Item>();
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
         *         &lt;element name="SIGN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="OPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="LOW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="HIGH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "sign",
            "option",
            "low",
            "high"
        })
        public static class Item {

            @XmlElement(name = "SIGN")
            protected String sign;
            @XmlElement(name = "OPTION")
            protected String option;
            @XmlElement(name = "LOW")
            protected String low;
            @XmlElement(name = "HIGH")
            protected String high;

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
             *     {@link String }
             *     
             */
            public String getLOW() {
                return low;
            }

            /**
             * 设置low属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLOW(String value) {
                this.low = value;
            }

            /**
             * 获取high属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getHIGH() {
                return high;
            }

            /**
             * 设置high属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setHIGH(String value) {
                this.high = value;
            }

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
     *         &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="SIGN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="OPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="LOW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="HIGH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    public static class SEKGRP {

        protected List<DTZRFCCATCHACCINFRES.SEKGRP.Item> item;

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
         * {@link DTZRFCCATCHACCINFRES.SEKGRP.Item }
         * 
         * 
         */
        public List<DTZRFCCATCHACCINFRES.SEKGRP.Item> getItem() {
            if (item == null) {
                item = new ArrayList<DTZRFCCATCHACCINFRES.SEKGRP.Item>();
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
         *         &lt;element name="SIGN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="OPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="LOW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="HIGH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "sign",
            "option",
            "low",
            "high"
        })
        public static class Item {

            @XmlElement(name = "SIGN")
            protected String sign;
            @XmlElement(name = "OPTION")
            protected String option;
            @XmlElement(name = "LOW")
            protected String low;
            @XmlElement(name = "HIGH")
            protected String high;

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
             *     {@link String }
             *     
             */
            public String getLOW() {
                return low;
            }

            /**
             * 设置low属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLOW(String value) {
                this.low = value;
            }

            /**
             * 获取high属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getHIGH() {
                return high;
            }

            /**
             * 设置high属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setHIGH(String value) {
                this.high = value;
            }

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
     *         &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="SIGN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="OPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="LOW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="HIGH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    public static class SEKORG {

        protected List<DTZRFCCATCHACCINFRES.SEKORG.Item> item;

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
         * {@link DTZRFCCATCHACCINFRES.SEKORG.Item }
         * 
         * 
         */
        public List<DTZRFCCATCHACCINFRES.SEKORG.Item> getItem() {
            if (item == null) {
                item = new ArrayList<DTZRFCCATCHACCINFRES.SEKORG.Item>();
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
         *         &lt;element name="SIGN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="OPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="LOW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="HIGH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "sign",
            "option",
            "low",
            "high"
        })
        public static class Item {

            @XmlElement(name = "SIGN")
            protected String sign;
            @XmlElement(name = "OPTION")
            protected String option;
            @XmlElement(name = "LOW")
            protected String low;
            @XmlElement(name = "HIGH")
            protected String high;

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
             *     {@link String }
             *     
             */
            public String getLOW() {
                return low;
            }

            /**
             * 设置low属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLOW(String value) {
                this.low = value;
            }

            /**
             * 获取high属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getHIGH() {
                return high;
            }

            /**
             * 设置high属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setHIGH(String value) {
                this.high = value;
            }

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
     *         &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="SIGN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="OPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="LOW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="HIGH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    public static class SLIFNR {

        protected List<DTZRFCCATCHACCINFRES.SLIFNR.Item> item;

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
         * {@link DTZRFCCATCHACCINFRES.SLIFNR.Item }
         * 
         * 
         */
        public List<DTZRFCCATCHACCINFRES.SLIFNR.Item> getItem() {
            if (item == null) {
                item = new ArrayList<DTZRFCCATCHACCINFRES.SLIFNR.Item>();
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
         *         &lt;element name="SIGN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="OPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="LOW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="HIGH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "sign",
            "option",
            "low",
            "high"
        })
        public static class Item {

            @XmlElement(name = "SIGN")
            protected String sign;
            @XmlElement(name = "OPTION")
            protected String option;
            @XmlElement(name = "LOW")
            protected String low;
            @XmlElement(name = "HIGH")
            protected String high;

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
             *     {@link String }
             *     
             */
            public String getLOW() {
                return low;
            }

            /**
             * 设置low属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLOW(String value) {
                this.low = value;
            }

            /**
             * 获取high属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getHIGH() {
                return high;
            }

            /**
             * 设置high属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setHIGH(String value) {
                this.high = value;
            }

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
     *         &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="SIGN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="OPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="LOW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="HIGH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    public static class SMATNR {

        protected List<DTZRFCCATCHACCINFRES.SMATNR.Item> item;

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
         * {@link DTZRFCCATCHACCINFRES.SMATNR.Item }
         * 
         * 
         */
        public List<DTZRFCCATCHACCINFRES.SMATNR.Item> getItem() {
            if (item == null) {
                item = new ArrayList<DTZRFCCATCHACCINFRES.SMATNR.Item>();
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
         *         &lt;element name="SIGN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="OPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="LOW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="HIGH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "sign",
            "option",
            "low",
            "high"
        })
        public static class Item {

            @XmlElement(name = "SIGN")
            protected String sign;
            @XmlElement(name = "OPTION")
            protected String option;
            @XmlElement(name = "LOW")
            protected String low;
            @XmlElement(name = "HIGH")
            protected String high;

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
             *     {@link String }
             *     
             */
            public String getLOW() {
                return low;
            }

            /**
             * 设置low属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLOW(String value) {
                this.low = value;
            }

            /**
             * 获取high属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getHIGH() {
                return high;
            }

            /**
             * 设置high属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setHIGH(String value) {
                this.high = value;
            }

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
     *         &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="SIGN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="OPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="LOW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="HIGH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    public static class SMTART {

        protected List<DTZRFCCATCHACCINFRES.SMTART.Item> item;

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
         * {@link DTZRFCCATCHACCINFRES.SMTART.Item }
         * 
         * 
         */
        public List<DTZRFCCATCHACCINFRES.SMTART.Item> getItem() {
            if (item == null) {
                item = new ArrayList<DTZRFCCATCHACCINFRES.SMTART.Item>();
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
         *         &lt;element name="SIGN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="OPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="LOW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="HIGH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "sign",
            "option",
            "low",
            "high"
        })
        public static class Item {

            @XmlElement(name = "SIGN")
            protected String sign;
            @XmlElement(name = "OPTION")
            protected String option;
            @XmlElement(name = "LOW")
            protected String low;
            @XmlElement(name = "HIGH")
            protected String high;

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
             *     {@link String }
             *     
             */
            public String getLOW() {
                return low;
            }

            /**
             * 设置low属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLOW(String value) {
                this.low = value;
            }

            /**
             * 获取high属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getHIGH() {
                return high;
            }

            /**
             * 设置high属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setHIGH(String value) {
                this.high = value;
            }

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
     *         &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="SIGN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="OPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="LOW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="HIGH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    public static class SWERKS {

        protected List<DTZRFCCATCHACCINFRES.SWERKS.Item> item;

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
         * {@link DTZRFCCATCHACCINFRES.SWERKS.Item }
         * 
         * 
         */
        public List<DTZRFCCATCHACCINFRES.SWERKS.Item> getItem() {
            if (item == null) {
                item = new ArrayList<DTZRFCCATCHACCINFRES.SWERKS.Item>();
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
         *         &lt;element name="SIGN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="OPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="LOW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="HIGH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "sign",
            "option",
            "low",
            "high"
        })
        public static class Item {

            @XmlElement(name = "SIGN")
            protected String sign;
            @XmlElement(name = "OPTION")
            protected String option;
            @XmlElement(name = "LOW")
            protected String low;
            @XmlElement(name = "HIGH")
            protected String high;

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
             *     {@link String }
             *     
             */
            public String getLOW() {
                return low;
            }

            /**
             * 设置low属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLOW(String value) {
                this.low = value;
            }

            /**
             * 获取high属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getHIGH() {
                return high;
            }

            /**
             * 设置high属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setHIGH(String value) {
                this.high = value;
            }

        }

    }

}
