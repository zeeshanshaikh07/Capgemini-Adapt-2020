class CustomerNotFoundException extends RuntimeException{
	public CustomerNotFoundException() {
		
	}
}
class Address {
	String city;
	String State;
	int zip;
	String Country;
	public Address(String city, String state, int zip, String country) {
		super();
		this.city = city;
		State = state;
		this.zip = zip;
		Country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		this.State = state;
	}
	
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		this.Country = country;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + State + ", zip=" + zip + ", country=" + Country + "]";
	}
}
class Customer {
	int userId;
	String emailId;
	String password;
	String firstName;
	String lastName;
	String city;
	String gender;
	long phoneNumber;
	Address address;
	public Customer(){
	    
	}
	public Customer(int userId, String emailId, String password, String firstName, String lastName, String city,
			String gender, long phoneNumber, Address address) {
		this.userId = userId;
		this.emailId = emailId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", emailId=" + emailId + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", city=" + city + ", gender=" + gender + ", phoneNumber="
				+ phoneNumber + ", address=" + address + "]";
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
interface CustomerService{
    void createCustomer(Customer customer);
	Customer updateCustomer(Customer customer);
	void deleteCustomer(int id);
	Customer searchCustomer(int id);
	Customer[] getCustomers();
}
class CustomerServiceImpl implements CustomerService{
    public static Customer customerArray[]= new Customer[5];
    public static int count=0;
  
	@Override
	public void createCustomer(Customer customer) {
		customerArray[count]=customer;
		count++;
		
	}
	@Override
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException{
		
		for(int i=0;i<5;i++)
		{
			if(customer.getUserId()==customerArray[i].userId)
			{
				customerArray[i]=customer;
				return customerArray[i];				
			}				
		}
		throw new  CustomerNotFoundException();
		
	}
	@Override
	public void deleteCustomer(int id) throws CustomerNotFoundException {
		for(int i=0;i<5;i++)
		{
			if(customerArray[i].getUserId()==id) {
				customerArray[i]=null;
				break;
			}				
		}throw new  CustomerNotFoundException();
		
	}
	@Override
	public Customer searchCustomer(int id) throws CustomerNotFoundException {
		
		for(int i=0;i<5;i++)
		{
			if(customerArray[i].getUserId()==id) {
				return customerArray[i];
			}
		}
		throw new  CustomerNotFoundException();
	}
	@Override
	public Customer[] getCustomers() {
		
		return customerArray;
	}    
}
