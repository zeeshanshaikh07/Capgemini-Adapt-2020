
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.InvalidNameException;

class Address {
	
	private String city;
	private String state;
	private int zip;
	private String country;
	
	public Address(String city, String state, int zip, String country) {
		super();
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
	}
}
class Customer implements Serializable{

	private int userId;
	 String emailId;
	 String password;
	private String firstName;
	private String lastName;
	private String city;
	private String gender;
	private long phoneNumber;
	private Address address;
	public Customer(int userId, String emailId, String password, String firstName, String lastName, String city,
			String gender, long phoneNumber, Address address) {
		super();
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
	public Customer()
	{
		
	}
	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", emailId=" + emailId + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", city=" + city + ", gender=" + gender + ", phoneNumber="
				+ phoneNumber + ", address=" + address + "]";
	}
}
class Admin
{
	private String name;
	 String email;
	 String password;
	public Admin()
	{
		
	}
	public Admin(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	
}
interface AdminService{
    public boolean validateAdmin(String email,String password);
}
class AdminServiceImpl implements AdminService
{
    public static Admin[] adminArray=new Admin[5];
    
    AdminServiceImpl()
    {
        adminArray[0]=new Admin("Krithick","krithick@gmail.com","krithi");
        adminArray[1]=new Admin("Raja","rajan@gmail.com","rajan#345");
        adminArray[2]=new Admin("Chandrav","chand@gmail.com","wel$234");
        adminArray[3]=new Admin("Ankit","ankit@gmail.com","kit@56");
        adminArray[4]=new Admin("Akilan","akilan@gmail.com","ak*76");
    }
    
@Override
	public boolean validateAdmin(String email, String password) {
		// TODO Auto-generated method stub
		for(int i=0;i<5;i++){
		    if(adminArray[i].email.equals(email) && adminArray[i].password.equals(password)){
		        return true;
		    }
		}
		return true;
	}
}
interface CustomerService {

	public boolean validateCustomer(String email,String password);

}


class CustomerServiceImpl implements CustomerService{
	
	public static Customer[] customerArray=new Customer[5];
    public CustomerServiceImpl()
    {
    customerArray[0]=
    		new Customer(101,"raj@gmail.com","xxxxxx","Raj","Kunar","Chennai","Male",
					9001018761l,new Address("Chennai","TamilNadu",600075,"India"));
    customerArray[1]=
    		new Customer(102,"krithick@gmail.com","xxxxxx","Krithick","Rajan","Chennai","Male",
					9001018761l,new Address("Chennai","TamilNadu",600075,"India"));
    customerArray[2]=
    		new Customer(103,"chandrav@gmail.com","xxxxxx","Chandrav","Rajan","Bangalore","Male",
					9001018761l,new Address("Chennai","TamilNadu",600075,"India"));
    customerArray[3]=
		new Customer(104,"shan@mail.com","an#2","Rajan","Arun","Bangalore","Male",
					9001018761l,new Address("Chennai","TamilNadu",600075,"India"));
    customerArray[4]=
		new Customer(105,"akshay@gmail.com","xxxxxx","Akshay","Kumar","Mumbai","Male",
					9001018761l,new Address("Chennai","TamilNadu",600075,"India"));
	
	
    }
	@Override
	public boolean validateCustomer(String email, String password) {
		// TODO Auto-generated method stub
		for(int i=0;i<5;i++){
		    if(customerArray[i].emailId.equals(email) && customerArray[i].password.equals(password)){
		        return true;
		    }
		}
		return true;
	}
}

class Source{
    
    public static void main(String args[])
    {
        
    }
}
