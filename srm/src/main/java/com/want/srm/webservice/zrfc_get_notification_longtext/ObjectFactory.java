package com.want.srm.webservice.zrfc_get_notification_longtext;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the zrfcsrm016.zrfc_get_notification_longtext package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _MTZRFCGETNOTIFICATIONLONGTEXTRES_QNAME = new QName("http://pi.want-want.com/ZRFC_GET_NOTIFICATION_LONGTEXT/Sender_Syn", "MT_ZRFC_GET_NOTIFICATION_LONGTEXT_RES");
    private final static QName _MTZRFCGETNOTIFICATIONLONGTEXTREQ_QNAME = new QName("http://pi.want-want.com/ZRFC_GET_NOTIFICATION_LONGTEXT/Sender_Syn", "MT_ZRFC_GET_NOTIFICATION_LONGTEXT_REQ");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: zrfcsrm016.zrfc_get_notification_longtext
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DTZRFCGETNOTIFICATIONLONGTEXTRES }
     * 
     */
    public DTZRFCGETNOTIFICATIONLONGTEXTRES createDTZRFCGETNOTIFICATIONLONGTEXTRES() {
        return new DTZRFCGETNOTIFICATIONLONGTEXTRES();
    }

    /**
     * Create an instance of {@link DTZRFCGETNOTIFICATIONLONGTEXTRES.LINES }
     * 
     */
    public DTZRFCGETNOTIFICATIONLONGTEXTRES.LINES createDTZRFCGETNOTIFICATIONLONGTEXTRESLINES() {
        return new DTZRFCGETNOTIFICATIONLONGTEXTRES.LINES();
    }

    /**
     * Create an instance of {@link DTZRFCGETNOTIFICATIONLONGTEXT }
     * 
     */
    public DTZRFCGETNOTIFICATIONLONGTEXT createDTZRFCGETNOTIFICATIONLONGTEXT() {
        return new DTZRFCGETNOTIFICATIONLONGTEXT();
    }

    /**
     * Create an instance of {@link DTZRFCGETNOTIFICATIONLONGTEXT.LINES }
     * 
     */
    public DTZRFCGETNOTIFICATIONLONGTEXT.LINES createDTZRFCGETNOTIFICATIONLONGTEXTLINES() {
        return new DTZRFCGETNOTIFICATIONLONGTEXT.LINES();
    }

    /**
     * Create an instance of {@link DTZRFCGETNOTIFICATIONLONGTEXTRES.HEADER }
     * 
     */
    public DTZRFCGETNOTIFICATIONLONGTEXTRES.HEADER createDTZRFCGETNOTIFICATIONLONGTEXTRESHEADER() {
        return new DTZRFCGETNOTIFICATIONLONGTEXTRES.HEADER();
    }

    /**
     * Create an instance of {@link DTZRFCGETNOTIFICATIONLONGTEXTRES.LINES.ITEM }
     * 
     */
    public DTZRFCGETNOTIFICATIONLONGTEXTRES.LINES.ITEM createDTZRFCGETNOTIFICATIONLONGTEXTRESLINESITEM() {
        return new DTZRFCGETNOTIFICATIONLONGTEXTRES.LINES.ITEM();
    }

    /**
     * Create an instance of {@link DTZRFCGETNOTIFICATIONLONGTEXT.LINES.Item }
     * 
     */
    public DTZRFCGETNOTIFICATIONLONGTEXT.LINES.Item createDTZRFCGETNOTIFICATIONLONGTEXTLINESItem() {
        return new DTZRFCGETNOTIFICATIONLONGTEXT.LINES.Item();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DTZRFCGETNOTIFICATIONLONGTEXTRES }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pi.want-want.com/ZRFC_GET_NOTIFICATION_LONGTEXT/Sender_Syn", name = "MT_ZRFC_GET_NOTIFICATION_LONGTEXT_RES")
    public JAXBElement<DTZRFCGETNOTIFICATIONLONGTEXTRES> createMTZRFCGETNOTIFICATIONLONGTEXTRES(DTZRFCGETNOTIFICATIONLONGTEXTRES value) {
        return new JAXBElement<DTZRFCGETNOTIFICATIONLONGTEXTRES>(_MTZRFCGETNOTIFICATIONLONGTEXTRES_QNAME, DTZRFCGETNOTIFICATIONLONGTEXTRES.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DTZRFCGETNOTIFICATIONLONGTEXT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pi.want-want.com/ZRFC_GET_NOTIFICATION_LONGTEXT/Sender_Syn", name = "MT_ZRFC_GET_NOTIFICATION_LONGTEXT_REQ")
    public JAXBElement<DTZRFCGETNOTIFICATIONLONGTEXT> createMTZRFCGETNOTIFICATIONLONGTEXTREQ(DTZRFCGETNOTIFICATIONLONGTEXT value) {
        return new JAXBElement<DTZRFCGETNOTIFICATIONLONGTEXT>(_MTZRFCGETNOTIFICATIONLONGTEXTREQ_QNAME, DTZRFCGETNOTIFICATIONLONGTEXT.class, null, value);
    }

}
