
package fr.m2i.crm.soap.exception;

import javax.xml.ws.WebFault;

@WebFault(name = "UserDefinedFault", targetNamespace = "http://m2i/crm/soap")
public class UserDefinedException extends Exception {

    private UserDefinedFault faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public UserDefinedException(String message, UserDefinedFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public UserDefinedException(String message, UserDefinedFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: UserDefinedFault
     */
    public UserDefinedFault getFaultInfo() {
        return faultInfo;
    }

}
