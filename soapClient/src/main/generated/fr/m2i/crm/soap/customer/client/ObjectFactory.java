
package fr.m2i.crm.soap.customer.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.m2i.crm.soap.customer.client package. 
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

    private final static QName _CustomerIdList_QNAME = new QName("http://m2i/crm/soap", "CustomerIdList");
    private final static QName _CustomerInfoList_QNAME = new QName("http://m2i/crm/soap", "CustomerInfoList");
    private final static QName _UserDefinedFault_QNAME = new QName("http://m2i/crm/soap", "UserDefinedFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.m2i.crm.soap.customer.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CustomerIdWrapper }
     * 
     */
    public CustomerIdWrapper createCustomerIdWrapper() {
        return new CustomerIdWrapper();
    }

    /**
     * Create an instance of {@link CustomerInfoWrapper }
     * 
     */
    public CustomerInfoWrapper createCustomerInfoWrapper() {
        return new CustomerInfoWrapper();
    }

    /**
     * Create an instance of {@link UserDefinedFault }
     * 
     */
    public UserDefinedFault createUserDefinedFault() {
        return new UserDefinedFault();
    }

    /**
     * Create an instance of {@link CustomerInfo }
     * 
     */
    public CustomerInfo createCustomerInfo() {
        return new CustomerInfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerIdWrapper }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CustomerIdWrapper }{@code >}
     */
    @XmlElementDecl(namespace = "http://m2i/crm/soap", name = "CustomerIdList")
    public JAXBElement<CustomerIdWrapper> createCustomerIdList(CustomerIdWrapper value) {
        return new JAXBElement<CustomerIdWrapper>(_CustomerIdList_QNAME, CustomerIdWrapper.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerInfoWrapper }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CustomerInfoWrapper }{@code >}
     */
    @XmlElementDecl(namespace = "http://m2i/crm/soap", name = "CustomerInfoList")
    public JAXBElement<CustomerInfoWrapper> createCustomerInfoList(CustomerInfoWrapper value) {
        return new JAXBElement<CustomerInfoWrapper>(_CustomerInfoList_QNAME, CustomerInfoWrapper.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserDefinedFault }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UserDefinedFault }{@code >}
     */
    @XmlElementDecl(namespace = "http://m2i/crm/soap", name = "UserDefinedFault")
    public JAXBElement<UserDefinedFault> createUserDefinedFault(UserDefinedFault value) {
        return new JAXBElement<UserDefinedFault>(_UserDefinedFault_QNAME, UserDefinedFault.class, null, value);
    }

}
