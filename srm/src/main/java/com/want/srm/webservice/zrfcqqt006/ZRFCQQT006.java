
package com.want.srm.webservice.zrfcqqt006;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ZRFCQQT006", targetNamespace = "http://www.example.org/ZRFCQQT006/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ZRFCQQT006 {


    /**
     * 
     * @param otITEM
     * @param iEBELN
     * @param otHEAD
     */
    @WebMethod(operationName = "ZRFCQQT006", action = "http://www.example.org/ZRFCQQT006/ZRFCQQT006")
    @RequestWrapper(localName = "ZRFCQQT006", targetNamespace = "http://www.example.org/ZRFCQQT006/", className = "zrfcqqt006.zrfcqqt006.ZRFCQQT006_Type")
    @ResponseWrapper(localName = "ZRFCQQT006Response", targetNamespace = "http://www.example.org/ZRFCQQT006/", className = "zrfcqqt006.zrfcqqt006.ZRFCQQT006Response")
    public void zrfcqqt006(
        @WebParam(name = "I_EBELN", targetNamespace = "")
        String iEBELN,
        @WebParam(name = "OT_HEAD", targetNamespace = "", mode = WebParam.Mode.OUT)
        Holder<List<OTHEADType>> otHEAD,
        @WebParam(name = "OT_ITEM", targetNamespace = "", mode = WebParam.Mode.OUT)
        Holder<List<OTITEMType>> otITEM);

}
