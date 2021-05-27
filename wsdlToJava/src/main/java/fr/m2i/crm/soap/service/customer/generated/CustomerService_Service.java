
package fr.m2i.crm.soap.service.customer.generated;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "customerService", targetNamespace = "http://m2i/crm/soap", wsdlLocation = "file:/C:/projets/m2i/cursus-java-poec/crm-jax-ws/wsdlToJava/src/main/resources/wsdl/customerService.wsdl")
public class CustomerService_Service
    extends Service
{

    private final static URL CUSTOMERSERVICE_WSDL_LOCATION;
    private final static WebServiceException CUSTOMERSERVICE_EXCEPTION;
    private final static QName CUSTOMERSERVICE_QNAME = new QName("http://m2i/crm/soap", "customerService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/projets/m2i/cursus-java-poec/crm-jax-ws/wsdlToJava/src/main/resources/wsdl/customerService.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CUSTOMERSERVICE_WSDL_LOCATION = url;
        CUSTOMERSERVICE_EXCEPTION = e;
    }

    public CustomerService_Service() {
        super(__getWsdlLocation(), CUSTOMERSERVICE_QNAME);
    }

    public CustomerService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), CUSTOMERSERVICE_QNAME, features);
    }

    public CustomerService_Service(URL wsdlLocation) {
        super(wsdlLocation, CUSTOMERSERVICE_QNAME);
    }

    public CustomerService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CUSTOMERSERVICE_QNAME, features);
    }

    public CustomerService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CustomerService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CustomerService
     */
    @WebEndpoint(name = "customerPort")
    public CustomerService getCustomerPort() {
        return super.getPort(new QName("http://m2i/crm/soap", "customerPort"), CustomerService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CustomerService
     */
    @WebEndpoint(name = "customerPort")
    public CustomerService getCustomerPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://m2i/crm/soap", "customerPort"), CustomerService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CUSTOMERSERVICE_EXCEPTION!= null) {
            throw CUSTOMERSERVICE_EXCEPTION;
        }
        return CUSTOMERSERVICE_WSDL_LOCATION;
    }

}
