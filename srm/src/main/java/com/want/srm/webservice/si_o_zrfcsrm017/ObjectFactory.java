
package com.want.srm.webservice.si_o_zrfcsrm017;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the si_o_zrfcsrm017.si_o_zrfcsrm017 package. 
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

    private final static QName _MTZRFCSRM017REQ_QNAME = new QName("http://pi.want-want.com/ZRFCSRM017/Sender_Syn", "MT_ZRFCSRM017_REQ");
    private final static QName _MTZRFCSRM017RES_QNAME = new QName("http://pi.want-want.com/ZRFCSRM017/Sender_Syn", "MT_ZRFCSRM017_RES");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: si_o_zrfcsrm017.si_o_zrfcsrm017
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DTZRFCSRM017RES }
     * 
     */
    public DTZRFCSRM017RES createDTZRFCSRM017RES() {
        return new DTZRFCSRM017RES();
    }

    /**
     * Create an instance of {@link DTZRFCSRM017RES.TTAB }
     * 
     */
    public DTZRFCSRM017RES.TTAB createDTZRFCSRM017RESTTAB() {
        return new DTZRFCSRM017RES.TTAB();
    }

    /**
     * Create an instance of {@link DTZRFCSRM017REQ }
     * 
     */
    public DTZRFCSRM017REQ createDTZRFCSRM017REQ() {
        return new DTZRFCSRM017REQ();
    }

    /**
     * Create an instance of {@link DTZRFCSRM017RES.TTAB.Item }
     * 
     */
    public DTZRFCSRM017RES.TTAB.Item createDTZRFCSRM017RESTTABItem() {
        return new DTZRFCSRM017RES.TTAB.Item();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DTZRFCSRM017REQ }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pi.want-want.com/ZRFCSRM017/Sender_Syn", name = "MT_ZRFCSRM017_REQ")
    public JAXBElement<DTZRFCSRM017REQ> createMTZRFCSRM017REQ(DTZRFCSRM017REQ value) {
        return new JAXBElement<DTZRFCSRM017REQ>(_MTZRFCSRM017REQ_QNAME, DTZRFCSRM017REQ.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DTZRFCSRM017RES }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pi.want-want.com/ZRFCSRM017/Sender_Syn", name = "MT_ZRFCSRM017_RES")
    public JAXBElement<DTZRFCSRM017RES> createMTZRFCSRM017RES(DTZRFCSRM017RES value) {
        return new JAXBElement<DTZRFCSRM017RES>(_MTZRFCSRM017RES_QNAME, DTZRFCSRM017RES.class, null, value);
    }

}
