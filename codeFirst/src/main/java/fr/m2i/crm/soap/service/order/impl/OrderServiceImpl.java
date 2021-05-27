package fr.m2i.crm.soap.service.order.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import fr.m2i.crm.soap.exception.UserDefinedException;
import fr.m2i.crm.soap.exception.UserDefinedFault;
import fr.m2i.crm.soap.model.Customer;
import fr.m2i.crm.soap.model.Order;

@WebService
public class OrderServiceImpl {
	
	@WebMethod
    public Order order(@WebParam(name = "id") String id) throws UserDefinedException {
		if (null == id || "".equals(id)) {
            UserDefinedFault e = new UserDefinedFault();
            e.setMessage("Order id vide");
            throw new UserDefinedException("Merci de renseigner un identifiant", e);
        }
		return getOrder(id);
		
	}
	
	/**
     * Récupération des orders
     * @param ids
     * @return
     */
    private Order getOrder(String id) {
    	Order order = new Order();
		order.setId(Integer.valueOf(1));
		order.setLabel("Intitulé commande");
		order.setNumberOfDays(Double.valueOf(3));
		order.setAdrEt(Double.valueOf(450));
		order.setStatus("En cours");
		order.setTva(Double.valueOf(20.0));
		order.setNotes("Notes");
		order.setCustomer(buildDummyCustomer(id));
        return order;
    }

    /**
     * Construction d'un customer
     * @param id l'identifiant
     * @return
     */
    private Customer buildDummyCustomer(String id) {
    	Customer customer = new Customer();
    	customer.setId(Integer.valueOf(id));
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
