package Tester;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import Com.core.Customer;
import Com.core.MessPlan;

import static utils.CustomerUtils.*;


public class Tester {
	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in))
		{
		boolean exit=false;
		
		while(!exit) {
			try {
				System.out.println("1:Sign up \n2:Sign in \n3:Change password \n4:sort\n5:unsubscribe according to plan \n6:Diaplay all\n7:display first name\n8:Registered in january \n0:Exit");
				
				switch(sc.nextInt()) {
				
				case 1:
					System.out.println("First Name, Last name, email, password, address,  registerDate, phoneNo, plan");					

					addCustomer(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next());
						System.out.println("added");
						break;
				case 2:
					System.out.println("enter email and password");
//					if(findByEmail(sc.next));
					Optional<Customer>cust=loggedIn(sc.next(), sc.next());
					System.out.println("welcome back "+cust.get().getfName()+"!!!");
					break;
				case 3:
					System.out.println("enter email password and new password");
					changePassword(sc.next(), sc.next(), sc.next());
					break;
				case 4:
					System.out.println("1:by fname 2:by plan 3:by date of registration");
					switch(sc.nextInt()) {
					case 1:
						sortByFname();
						break;
					case 2:
						sortByPlan();
						break;
					case 3:
						sortByRegDate();
						break;
					default:
						System.out.println("invalid choice !");
						break;
						
					}
					break;
				case 5:
					System.out.println("enter plan");
					removeByPlan(sc.next().toUpperCase());
					break;
				case 6:
					customerMap.forEach((s,v)->System.out.println(v));
					break;
				case 7:
					customerMap.values().stream().map(s->s.getfName().substring(0, 1).toUpperCase()+s.getfName().substring(1))
					.forEach(System.out::println);
				case 8:
					customerMap.values().stream().filter(c->c.getRegisterDate().getMonth()==Month.JANUARY).forEach(s->System.out.println(s));

					break;
				case 0:
					exit=true;
				break;
				default:
					System.out.println("invalid choice");
					
				}
				System.out.println();
			}catch(Exception e) {
				System.out.println(e);
				e.printStackTrace();
				sc.nextLine();
			}
		}

		}
		
//		satyam basaiye s@.com pass dfd 2023-10-10 3233 monthly

}}
