package utils;

import Com.core.*;
import static utils.CustomerValidation.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import Com.core.Customer;
import custome_exception.CustomeException;

public class CustomerUtils {
	static int cust = 1;

	public static Map<Integer, Customer> customerMap;
	static {
		try {
			customerMap = populateMap(populateList());
		} catch (CustomeException e) {
			e.printStackTrace();
		}
	}

	public static void addCustomer(String fName, String lname, String email, String password, String address,
			String registerDate, String phoneNo, String plan) throws CustomeException {
		if(findByEmail( email).isPresent())
			throw new CustomeException("customer already exists");
		customerMap.put(cust, new Customer(cust++, fName, lname, email, password, address, LocalDate.parse(registerDate),
				phoneNo, MessPlan.valueOf(plan.toUpperCase())));

	}

	
	public static Optional <Customer> loggedIn(String email,String password) throws CustomeException {
		Optional <Customer> cust=findByEmail(email);
			if(!cust.get().getPassword().equals(password))
				throw new CustomeException("invalid password");
			return cust;
	}
	
	public static void changePassword(String email,String password,String newPassword) throws CustomeException {
		Optional<Customer>cust=loggedIn(email, password);
		cust.get().setPassword(newPassword);
		System.out.println("password changed");
	}
	
	public static void sortByFname() {
		Comparator<Customer> comp=(c1,c2)->c1.getfName().compareTo(c2.getfName());
		customerMap.values().stream().sorted(comp).forEach(c->System.out.println(c));
	}

// sort by plan
	public static void sortByPlan() {
		Comparator<Customer>comp=(c1,c2)->c1.getPlan().toString().compareTo(c2.getPlan().toString());
		customerMap.values().stream().sorted(comp).forEach(s->System.out.println(s));
	}
// Sort by Regestration date
	public static void sortByRegDate() {
		Comparator<Customer>comp=(c1,c2)->c1.getRegisterDate().compareTo(c2.getRegisterDate());
		customerMap.values().stream().sorted(comp).forEach(c->System.out.println(c));
	}
	public static void removeByPlan(String plan) {
	customerMap.values().stream()
	.filter(s->s.getPlan()==MessPlan.valueOf(plan))
	.filter(s->s.getPlanEndDate().isBefore(LocalDate.now()))
	.forEach(s->{
		s.setSubscription(false);
		System.out.println(s);
	});
		
	}
	public static List<Customer> populateList() throws CustomeException {
		List<Customer> list = new ArrayList<>();
		list.add(new Customer(cust++, "pratik", "warade", "w@gmail.com", "pass", "buldhana", LocalDate.parse("2023-01-23"),"2323", MessPlan.QUARTERLY));
		list.add(new Customer(cust++, "himanshu", "trivedi", "ht@gmail.com", "hass", "ch.sambhajinagar", LocalDate.parse("2023-05-23"),"58", MessPlan.MONTHLY));
		list.add(new Customer(cust++, "shivanshu", "singh", "ss@gmail.com", "sass", "Noida", LocalDate.parse("2023-09-23"),"2323", MessPlan.HALFYEAR));
		list.add(new Customer(cust++, "satyam", "basaiye", "sb@gmail.com", "sass", "ch.sambhajinagar", LocalDate.parse("2023-10-23"),"54646", MessPlan.YEARLY));
		list.add(new Customer(cust++, "amar", "pardeshi", "ap@gmail.com", "aass", "ch.sambhajinagar", LocalDate.parse("2023-09-03"),"664", MessPlan.HALFYEAR));
		list.add(new Customer(cust++, "tushar", "makude", "tm@gmail.com", "tass", "ch.sambhajinagar", LocalDate.parse("2023-08-13"),"5446", MessPlan.QUARTERLY));
		list.add(new Customer(cust++, "arjun", "dontKnow", "ad@gmail.com", "aass", "UK", LocalDate.parse("2023-05-23"),"6546", MessPlan.YEARLY));
		return list;
	}
	public static Map<Integer, Customer> populateMap(List<Customer> list) {
		Map<Integer, Customer> customerMap = new HashMap<>();
		list.forEach(s -> customerMap.put(s.getId(), s));
		return customerMap;

	}
}
