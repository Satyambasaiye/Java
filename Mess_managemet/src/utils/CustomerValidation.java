package utils;

import java.util.Optional;
import static utils.CustomerUtils.customerMap;

import custome_exception.CustomeException;

import Com.core.Customer;

public class CustomerValidation {
	public static Optional<Customer> findByEmail( String email) throws CustomeException {
		validateEmail(email);
		Optional<Customer>cust=customerMap.values().stream().filter(s->s.getEmail().equals(email)).findFirst();
		return cust;
	}

	public static void validateEmail(String email) throws CustomeException {
		if(!email.matches("[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}"))
			throw new CustomeException("Please enter valid email");
	}

}
