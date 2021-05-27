package fr.m2i.crm.soap.service.customer.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.sun.xml.ws.developer.SchemaValidation;

import fr.m2i.crm.soap.dao.CustomerDao;
import fr.m2i.crm.soap.dao.impl.CustomerDaoImpl;
import fr.m2i.crm.soap.exception.DaoException;
import fr.m2i.crm.soap.model.Customer;
import fr.m2i.crm.soap.service.customer.generated.CustomerData;
import fr.m2i.crm.soap.service.customer.generated.CustomerIdWrapper;
import fr.m2i.crm.soap.service.customer.generated.CustomerInfo;
import fr.m2i.crm.soap.service.customer.generated.CustomerInfoWrapper;
import fr.m2i.crm.soap.service.customer.generated.CustomerService;
import fr.m2i.crm.soap.service.customer.generated.CustomerWrapper;
import fr.m2i.crm.soap.service.customer.generated.ObjectFactory;
import fr.m2i.crm.soap.service.customer.generated.UserDefinedException;
import fr.m2i.crm.soap.service.customer.generated.UserDefinedFault;

@WebService(endpointInterface = "fr.m2i.crm.soap.service.customer.generated.CustomerService")
@SchemaValidation
public class CustomerServiceImpl implements CustomerService {

	ObjectFactory of = new ObjectFactory();
	
	CustomerDaoImpl customerDao;
	 
    @Override
    public CustomerInfoWrapper customer(CustomerIdWrapper customerIdList) throws UserDefinedException {
        if (customerIdList.getCid().isEmpty()) {
            UserDefinedFault e = of.createUserDefinedFault();
            e.setMessage("Client ID vide");
            throw new UserDefinedException("Merci de renseigner un identifiant", e);
        }
        
        customerDao = new CustomerDaoImpl();
 
        CustomerInfoWrapper eWrapper = of.createCustomerInfoWrapper();
        List<CustomerInfo> allCustomers = getCustomers(customerIdList.getCid());
        eWrapper.getCustomerInfo().addAll(allCustomers);
        return eWrapper;
    }
    
    @Override
    public CustomerIdWrapper createCustomer(CustomerWrapper createCustomer) throws UserDefinedException {
    	List<CustomerData> customers = createCustomer.getCustomerData();
    	Customer customer;
    	customerDao = new CustomerDaoImpl();
    	CustomerIdWrapper response = new CustomerIdWrapper();
    	for (CustomerData customerData : customers) {
    		customer = new Customer();
    		customer.setFirstname(customerData.getFirstname());
    		customer.setLastname(customerData.getLastname());
    		customer.setCompany(customerData.getCompany());
    		customer.setMail(customerData.getMail());
    		customer.setPhone(customerData.getPhone());
    		customer.setMobile(customerData.getMobile());
    		customer.setActive(customerData.isActive());
    		customer.setNotes(customerData.getNotes());
    		try {
    			customerDao.getEm().getTransaction().begin();
    			customerDao.createCustomer(customer);
    			customerDao.getEm().getTransaction().commit();
    		} catch (DaoException e) {
    			customerDao.getEm().getTransaction().rollback();
    			UserDefinedFault udf = of.createUserDefinedFault();
                udf.setMessage("Erreur lors de la création : " + e.getMessage());
                throw new UserDefinedException("Erreur", udf);
    		}
    		response.getCid().add(customer.getId().toString());
    	}
    	return response;
    }
 
    /**
     * Récupération des customers
     * @param ids
     * @return
     */
    private List<CustomerInfo> getCustomers(List<String> ids) throws UserDefinedException {
        List<CustomerInfo> emps = new ArrayList<>();
        Integer customerId;
        for (String id : ids) {
        	try {
        		customerId = Integer.parseInt(id);
        	} catch (Exception e) {
        		UserDefinedFault udf = of.createUserDefinedFault();
        		udf.setMessage("Identifiant au mauvais format");
        		throw new UserDefinedException("Merci de renseigner un identifiant valide", udf);
        	}
        	Customer customer = customerDao.getCustomerById(customerId);
        	if (null != customer) {
        		emps.add(mapCustomerToCustomerInfo(customer));
        	}
        	//emps.add(buildDummyCustomer(id));
        }
 
        return emps;
    }
    
    /**
     * Transformation d'un customer en customerInfo
     * @param customer
     * @return
     */
    private CustomerInfo mapCustomerToCustomerInfo(Customer customer) {
    	CustomerInfo customerInfo = of.createCustomerInfo();
    	customerInfo.setCid(customer.getId().toString());
    	customerInfo.setFirstname(customer.getFirstname());
    	customerInfo.setLastname(customer.getLastname());
    	customerInfo.setCompany(customer.getCompany());
    	customerInfo.setMail(customer.getMail());
    	customerInfo.setPhone(customer.getPhone());
    	customerInfo.setMobile(customer.getMobile());
    	customerInfo.setActive((customer.isActive() == null ? Boolean.FALSE : customer.isActive()));
        return customerInfo;
    }
    
    /**
     * Construction d'un customer
     * @param id l'identifiant
     * @return
     */
    private CustomerInfo buildDummyCustomer(String id) {
    	CustomerInfo customer = of.createCustomerInfo();
    	customer.setCid(id);
    	customer.setFirstname("Firstname_" + id);
    	customer.setLastname("Lastname_" + id);
    	customer.setCompany("Company_" + id);
    	customer.setMail("Firstname_" + id + "@test.fr");
    	customer.setPhone("Phone_" + id);
    	customer.setMobile("Mobile_" + id);
    	customer.setActive(true);
        return customer;
    }

}
