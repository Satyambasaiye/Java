package Com.core;

import static utils.CustomerValidation.*;
import java.time.LocalDate;
import custome_exception.CustomeException;

public class Customer {

	private int id;
	private String fName, lname, email, password, address;
	private boolean subscription=true;
	public String getPassword() {
		return password;
	}

	LocalDate RegisterDate, planEndDate;
	private String PhoneNo;
	MessPlan Plan;
	public void setSubscription(boolean subscription) {
		this.subscription = subscription;
	}

	double finalAmount;

	public Customer(int custId, String fName, String lname, String email, String password, String address,
			LocalDate registerDate, String phoneNo, MessPlan plan) throws CustomeException {
//		this.id=cust++;
		this.id = custId;
		this.fName = fName;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.address = address;
		RegisterDate = registerDate;
		this.planEndDate = calcEndDate(registerDate, plan);
		PhoneNo = phoneNo;
		Plan = plan;
		this.finalAmount = plan.rate;

	}

	public int getId() {
		return id;
	}

	public String getfName() {
		return fName;
	}

	public String getLname() {
		return lname;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public LocalDate getRegisterDate() {
		return RegisterDate;
	}

	public LocalDate getPlanEndDate() {
		return planEndDate;
	}

	public String getPhoneNo() {
		return PhoneNo;
	}

	public MessPlan getPlan() {
		return Plan;
	}

	public double getFinalAmount() {
		return finalAmount;
	}

	public LocalDate calcEndDate(LocalDate dt, MessPlan plan) {

		return dt.plusMonths(plan.getMonths());

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return  id+" "  + fName +" " + lname + ", email=" + email + ", address="
				+ address + ", Register Date=" + RegisterDate + ", End Date=" + planEndDate + ", PhoneNo=" + PhoneNo
				+ ", Plan=" + Plan + ", finalAmount=" + finalAmount+" status"+subscription ;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setRegisterDate(LocalDate registerDate) {
		RegisterDate = registerDate;
	}

	public void setPlanEndDate(LocalDate planEndDate) {
		this.planEndDate = planEndDate;
	}

	public void setPhoneNo(String phoneNo) {
		PhoneNo = phoneNo;
	}

	public void setPlan(MessPlan plan) {
		Plan = plan;
	}

	public void setFinalAmount(double finalAmount) {
		this.finalAmount = finalAmount;
	}

}
