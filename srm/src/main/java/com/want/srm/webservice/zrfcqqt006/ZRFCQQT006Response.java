
package com.want.srm.webservice.zrfcqqt006;

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
 *         &lt;element name="OT_HEAD" type="{http://www.example.org/ZRFCQQT006/}OT_HEADType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="OT_ITEM" type="{http://www.example.org/ZRFCQQT006/}OT_ITEMType" maxOccurs="unbounded" minOccurs="0"/>
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
    "othead",
    "otitem"
})
@XmlRootElement(name = "ZRFCQQT006Response")
public class ZRFCQQT006Response {

    @XmlElement(name = "OT_HEAD")
    protected List<OTHEADType> othead;
    @XmlElement(name = "OT_ITEM")
    protected List<OTITEMType> otitem;

    /**
     * Gets the value of the othead property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the othead property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOTHEAD().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OTHEADType }
     * 
     * 
     */
    public List<OTHEADType> getOTHEAD() {
        if (othead == null) {
            othead = new ArrayList<OTHEADType>();
        }
        return this.othead;
    }

    /**
     * Gets the value of the otitem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the otitem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOTITEM().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OTITEMType }
     * 
     * 
     */
    public List<OTITEMType> getOTITEM() {
        if (otitem == null) {
            otitem = new ArrayList<OTITEMType>();
        }
        return this.otitem;
    }

}
