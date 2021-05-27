package fr.m2i.crm.soap.service.customer;

import java.net.MalformedURLException;
import java.net.URL;

import fr.m2i.crm.soap.customer.client.CustomerIdWrapper;
import fr.m2i.crm.soap.customer.client.CustomerInfoWrapper;
import fr.m2i.crm.soap.customer.client.CustomerService;
import fr.m2i.crm.soap.customer.client.CustomerServiceImplService;
import fr.m2i.crm.soap.customer.client.UserDefinedException;
import fr.m2i.crm.soap.customer.client.UserDefinedFault;

public class CustomerServiceClient {

	private String serviceUrl;
    
    public CustomerServiceClient(String serviceUrl) {
        super();
        this.serviceUrl = serviceUrl;
    }
     
    public CustomerInfoWrapper getCustomer(CustomerIdWrapper customerIdList) throws UserDefinedException {
 
        try {
            URL url = new URL(serviceUrl);
            CustomerServiceImplService empService = new CustomerServiceImplService(url);
            CustomerService eSrc = empService.getCustomerServiceImplPort();
            return eSrc.customer(customerIdList);
        } catch (MalformedURLException e) {
            UserDefinedFault fault = new UserDefinedFault();
            fault.setMessage(e.getMessage());
            throw new UserDefinedException("MalformedURLException", fault);
        }
 
    }

}
