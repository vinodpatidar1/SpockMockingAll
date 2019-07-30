
public class Customer {

	  private String firstName;
	  private String lastName;
	  private int salary;
	  
	  public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Customer(final String firstName, final String lastName) {
	    this.firstName = firstName;
	    this.lastName = lastName;
	  }

	  public String getFirstName() {
	    return firstName;
	  }

	  public void setFirstName(final String firstName) {
	    this.firstName = firstName;
	  }

	  public String getLastName() {
	    return lastName;
	  }

	  public void setLastName(final String lastName) {
	    this.lastName = lastName;
	  }

/*	  @Override
	  public String toString() {
	    return "Customer{" + ", firstName='" + getFirstName() + '\'' + ", lastName='"
	        + getLastName() + '\'' + '}';
	  }*/
	  
	  public static Customer getByFirstName(String fName) {
		  return null;
	  }

	@Override
	  public boolean equals(final Object that) {
	    boolean isEqual = false;
	    if (this == that) {
	      isEqual = true;
	    } else if (that != null && getClass() == that.getClass()) {
	      final Customer customer = (Customer) that;
	      if (getFirstName() == customer.getFirstName()) {
	        isEqual = true;
	      }
	    }
	    return isEqual;
	  }

	public void printCustomerInfo() {
		System.out.println("Customer Information::");
		System.out.println(toString());
		System.out.println("-----------------------------------------------------------------------");
	}
	
}

class CustomerService {
	
	public Customer getCustomer(String fName, String lName) {
		Customer customerInstance = Customer.getByFirstName(fName);
		if(customerInstance == null)
		{
			customerInstance = createCustomer(fName, lName);
		}
		return customerInstance;
	}

	private Customer createCustomer(String fName, String lName) {
		return new Customer(fName, lName);
	}

}

