
package fr.m2i.crm.soap.service.customer.generated;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebService(name = "customerService", targetNamespace = "http://m2i/crm/soap")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CustomerService {


    /**
     * 
     * @param customerIdList
     * @return
     *     returns fr.m2i.crm.soap.service.customer.generated.CustomerInfoWrapper
     * @throws UserDefinedException
     */
    @WebMethod(action = "http://m2i/crm/soap/customer")
    @WebResult(name = "CustomerInfoList", targetNamespace = "http://m2i/crm/soap", partName = "customerInfoList")
    public CustomerInfoWrapper customer(
        @WebParam(name = "CustomerIdList", targetNamespace = "http://m2i/crm/soap", partName = "customerIdList")
        CustomerIdWrapper customerIdList)
        throws UserDefinedException
    ;

    /**
     * 
     * @param createCustomer
     * @return
     *     returns fr.m2i.crm.soap.service.customer.generated.CustomerIdWrapper
     * @throws UserDefinedException
     */
    @WebMethod(action = "http://m2i/crm/soap/createCustomer")
    @WebResult(name = "CreatedCustomerId", targetNamespace = "http://m2i/crm/soap", partName = "customerId")
    public CustomerIdWrapper createCustomer(
        @WebParam(name = "CreateCustomer", targetNamespace = "http://m2i/crm/soap", partName = "createCustomer")
        CustomerWrapper createCustomer)
        throws UserDefinedException
    ;

}
