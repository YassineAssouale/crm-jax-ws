package fr.m2i.crm.soap.service.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import fr.m2i.crm.soap.customer.client.CustomerIdWrapper;
import fr.m2i.crm.soap.customer.client.CustomerInfoWrapper;
import fr.m2i.crm.soap.customer.client.UserDefinedException;

class CustomerServiceClientTest {
	
	private CustomerServiceClient monClientWS = new CustomerServiceClient(
            //"http://WJNP2020002:8080?wsdl");
			"http://localhost:9990/CustomerService?wsdl");
    @Test
    void customer_found() throws UserDefinedException {
        CustomerIdWrapper customerIdList = new CustomerIdWrapper();
        customerIdList.getCid().add("100");
        CustomerInfoWrapper ret = monClientWS.getCustomer(customerIdList);
        assertEquals(1, ret.getCustomerInfo().size());
        assertEquals("100", ret.getCustomerInfo().get(0).getCid());
    }
     
    @Test
    void customer_not_found() throws UserDefinedException {
        CustomerIdWrapper customerIdList = new  CustomerIdWrapper();
        assertThrows(UserDefinedException.class, () -> {monClientWS.getCustomer(customerIdList); });     
    }

}
