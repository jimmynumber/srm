package com.want.srm.webservice.zrfcsrm016;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the zrfcsrm016.zrfcsrm016 package. 
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

    private final static QName _MTZRFCSRM016RES_QNAME = new QName("http://pi.want-want.com/ZRFCSRM016/Sender_Syn", "MT_ZRFCSRM016_RES");
    private final static QName _MTZRFCSRM016REQ_QNAME = new QName("http://pi.want-want.com/ZRFCSRM016/Sender_Syn", "MT_ZRFCSRM016_REQ");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: zrfcsrm016.zrfcsrm016
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DTZRFCSRM016RES }
     * 
     */
    public DTZRFCSRM016RES createDTZRFCSRM016RES() {
        return new DTZRFCSRM016RES();
    }

    /**
     * Create an instance of {@link DTZRFCSRM016RES.TQMELE }
     * 
     */
    public DTZRFCSRM016RES.TQMELE createDTZRFCSRM016RESTQMELE() {
        return new DTZRFCSRM016RES.TQMELE();
    }

    /**
     * Create an instance of {@link DTZRFCSRM016REQ }
     * 
     */
    public DTZRFCSRM016REQ createDTZRFCSRM016REQ() {
        return new DTZRFCSRM016REQ();
    }

    /**
     * Create an instance of {@link DTZRFCSRM016REQ.TQMELE }
     * 
     */
    public DTZRFCSRM016REQ.TQMELE createDTZRFCSRM016REQTQMELE() {
        return new DTZRFCSRM016REQ.TQMELE();
    }

    /**
     * Create an instance of {@link DTZRFCSRM016RES.TQMELE.Item }
     * 
     */
    public DTZRFCSRM016RES.TQMELE.Item createDTZRFCSRM016RESTQMELEItem() {
        return new DTZRFCSRM016RES.TQMELE.Item();
    }

    /**
     * Create an instance of {@link DTZRFCSRM016REQ.TQMELE.ITEM }
     * 
     */
    public DTZRFCSRM016REQ.TQMELE.ITEM createDTZRFCSRM016REQTQMELEITEM() {
        return new DTZRFCSRM016REQ.TQMELE.ITEM();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DTZRFCSRM016RES }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pi.want-want.com/ZRFCSRM016/Sender_Syn", name = "MT_ZRFCSRM016_RES")
    public JAXBElement<DTZRFCSRM016RES> createMTZRFCSRM016RES(DTZRFCSRM016RES value) {
        return new JAXBElement<DTZRFCSRM016RES>(_MTZRFCSRM016RES_QNAME, DTZRFCSRM016RES.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DTZRFCSRM016REQ }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pi.want-want.com/ZRFCSRM016/Sender_Syn", name = "MT_ZRFCSRM016_REQ")
    public JAXBElement<DTZRFCSRM016REQ> createMTZRFCSRM016REQ(DTZRFCSRM016REQ value) {
        return new JAXBElement<DTZRFCSRM016REQ>(_MTZRFCSRM016REQ_QNAME, DTZRFCSRM016REQ.class, null, value);
    }

}
