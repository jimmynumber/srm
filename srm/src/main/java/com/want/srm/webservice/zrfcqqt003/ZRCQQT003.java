package com.want.srm.webservice.zrfcqqt003;

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
 *         &lt;element name="IT_EBELN" type="{http://www.example.org/ZRFCQQT003/}IT_EBELNType" maxOccurs="unbounded"/>
 *         &lt;element name="IT_SYDAT" type="{http://www.example.org/ZRFCQQT003/}IT_SYDATType" maxOccurs="unbounded"/>
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
    "itebeln",
    "itsydat"
})
@XmlRootElement(name = "ZRCQQT003")
public class ZRCQQT003 {

    @XmlElement(name = "IT_EBELN", required = true)
    protected List<ITEBELNType> itebeln;
    @XmlElement(name = "IT_SYDAT", required = true)
    protected List<ITSYDATType> itsydat;

    /**
     * Gets the value of the itebeln property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itebeln property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getITEBELN().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ITEBELNType }
     * 
     * 
     */
    public List<ITEBELNType> getITEBELN() {
        if (itebeln == null) {
            itebeln = new ArrayList<ITEBELNType>();
        }
        return this.itebeln;
    }

    /**
     * Gets the value of the itsydat property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itsydat property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getITSYDAT().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ITSYDATType }
     * 
     * 
     */
    public List<ITSYDATType> getITSYDAT() {
        if (itsydat == null) {
            itsydat = new ArrayList<ITSYDATType>();
        }
        return this.itsydat;
    }

}
