package fr.m2i.crm.soap.service.customer.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import fr.m2i.crm.soap.service.customer.generated.CustomerService;
import fr.m2i.crm.soap.service.customer.generated.CustomerWrapper;
import fr.m2i.crm.soap.service.customer.generated.ObjectFactory;
import fr.m2i.crm.soap.service.customer.generated.UserDefinedException;
import fr.m2i.crm.soap.service.customer.generated.UserDefinedFault;
import fr.m2i.crm.soap.service.customer.generated.CustomerIdWrapper;
import fr.m2i.crm.soap.service.customer.generated.CustomerInfo;
import fr.m2i.crm.soap.service.customer.generated.CustomerInfoWrapper;

@WebService(endpointInterface = "fr.m2i.crm.soap.service.customer.generated.CustomerService")
public class CustomerServiceImpl implements CustomerService {

	ObjectFactory of = new ObjectFactory();
	 
    @Override
    public CustomerInfoWrapper customer(CustomerIdWrapper customerIdList) throws UserDefinedException {
        if (customerIdList.getCid().isEmpty()) {
            UserDefinedFault e = of.createUserDefinedFault();
            e.setMessage("Client ID vide");
            throw new UserDefinedException("Merci de renseigner un identifiant", e);
        }
 
        CustomerInfoWrapper eWrapper = of.createCustomerInfoWrapper();
        List<CustomerInfo> allCustomers = getCustomers(customerIdList.getCid());
        eWrapper.getCustomerInfo().addAll(allCustomers);
        return eWrapper;
    }
    
    @Override
    public CustomerIdWrapper createCustomer(CustomerWrapper createCustomer) throws UserDefinedException {
    	return new CustomerIdWrapper();
    }
 
    /**
     * Récupération des customers
     * @param ids
     * @return
     */
    private List<CustomerInfo> getCustomers(List<String> ids) {
        List<CustomerInfo> emps = new ArrayList<>();
        for (String id : ids) {
            emps.add(buildDummyCustomer(id));
        }
 
        return emps;
    }
 
    /**
     * Construction d'un customer
     * @param id l'identifiant
     * @return
     */
    private CustomerInfo buildDummyCustomer(String id) {
    	CustomerInfo emp = of.createCustomerInfo();
        emp.setCid(id);
        emp.setFirstname("Firstname_" + id);
        emp.setLastname("Lastname_" + id);
        emp.setCompany("Company_" + id);
        emp.setMail("Firstname_" + id + "@test.fr");
        emp.setPhone("Phone_" + id);
        emp.setMobile("Mobile_" + id);
        emp.setActive(true);
        return emp;
    }

}
