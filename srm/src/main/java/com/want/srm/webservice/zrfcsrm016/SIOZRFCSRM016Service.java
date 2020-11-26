package com.want.srm.webservice.zrfcsrm016;

import java.net.Authenticator;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.want.srm.utils.PropertiesUtil;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "SI_O_ZRFCSRM016Service", targetNamespace = "http://pi.want-want.com/ZRFCSRM016/Sender_Syn", wsdlLocation = "http://epdev.want-want.com:50000/dir/wsdl?p=sa/dc8ac3ccc7ac34b194fdd5923e44b024")
@org.springframework.stereotype.Service
public class SIOZRFCSRM016Service
    extends Service
{
    private final static QName SIOZRFCSRM016SERVICE_QNAME = new QName("http://pi.want-want.com/ZRFCSRM016/Sender_Syn", "SI_O_ZRFCSRM016Service");

    private static URL getWsdlLocation(String webserviceUrl, String account, String password) {
        Authenticator.setDefault(new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(account, password.toCharArray());
            }
        });
        URL url = null;
        try {
            url = new URL(webserviceUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    @Autowired
    public SIOZRFCSRM016Service(@Value("${zrfcsrm016.URL}") final String webserviceUrl, @Value("${service.account}") final String account, @Value("${service.password}") final String password) {
        super(getWsdlLocation(webserviceUrl, account, password), SIOZRFCSRM016SERVICE_QNAME);
    }
    
    public SIOZRFCSRM016Service(String webserviceUrl, String account, String password, WebServiceFeature... features) {
        super(getWsdlLocation(webserviceUrl, account, password), SIOZRFCSRM016SERVICE_QNAME, features);
    }

    public SIOZRFCSRM016Service(URL wsdlLocation) {
        super(wsdlLocation, SIOZRFCSRM016SERVICE_QNAME);
    }

    public SIOZRFCSRM016Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SIOZRFCSRM016SERVICE_QNAME, features);
    }

    public SIOZRFCSRM016Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SIOZRFCSRM016Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SIOZRFCSRM016
     */
    @WebEndpoint(name = "HTTP_Port")
    public SIOZRFCSRM016 getHTTPPort() {
        return super.getPort(new QName("http://pi.want-want.com/ZRFCSRM016/Sender_Syn", "HTTP_Port"), SIOZRFCSRM016.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SIOZRFCSRM016
     */
    @WebEndpoint(name = "HTTP_Port")
    public SIOZRFCSRM016 getHTTPPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://pi.want-want.com/ZRFCSRM016/Sender_Syn", "HTTP_Port"), SIOZRFCSRM016.class, features);
    }

    /**
     * 
     * @return
     *     returns SIOZRFCSRM016
     */
    @WebEndpoint(name = "HTTPS_Port")
    public SIOZRFCSRM016 getHTTPSPort() {
        return super.getPort(new QName("http://pi.want-want.com/ZRFCSRM016/Sender_Syn", "HTTPS_Port"), SIOZRFCSRM016.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SIOZRFCSRM016
     */
    @WebEndpoint(name = "HTTPS_Port")
    public SIOZRFCSRM016 getHTTPSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://pi.want-want.com/ZRFCSRM016/Sender_Syn", "HTTPS_Port"), SIOZRFCSRM016.class, features);
    }

}