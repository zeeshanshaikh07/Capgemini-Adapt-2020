import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


interface AdminService{
    public void insertBook(Book book);
    public void writeBooks();
    public List<Book> readBooks();
}

interface CustomerService{
    public void insertCustomer(Customer customer);
    public void writeCustomer();
    public List<Customer> readCustomer();
}


class AdminServiceImpl implements AdminService
{
//  public static Book booksArray[]=new Book[5];
 
 public static ArrayList<Book> bookList = new ArrayList<Book>();
 
 File f1 = new File("book.txt");
 FileOutputStream fos = null;
 FileInputStream fis = null;
 ObjectOutputStream oos =null;
 ObjectInputStream ois =null;
 
 public void insertBook(Book book)
 {
     bookList.add(book);

 }
 public void writeBooks()
 {
    try{
      fos = new FileOutputStream(f1);
  }
  catch(FileNotFoundException fnfe1){
      System.out.println("NOT FOUND");
  }
  
  try{
      oos = new ObjectOutputStream(fos);
      
      for(Book b:bookList){
          oos.writeObject(b);
      }
      oos.close();
  }
  catch(IOException io){
      System.out.println("NOT");
  }
 }
 
 public List<Book> readBooks()
 {
    try{
      fis = new FileInputStream(f1);
  }
  catch(FileNotFoundException fnfe2){
    System.out.println("NOT");
  }
  try{
      ois = new ObjectInputStream(fis);
      if(ois.available()>0){
          try{
              bookList.add((Book) ois.readObject());
          }
          catch(ClassNotFoundException cnfe2){
                    System.out.println("NOT");
          }
      }
      ois.close();
  }
  catch(IOException ioe4){
    System.out.println("NOT");

  }
  return bookList;
 }
}

class CustomerServiceImpl implements CustomerService
{
 
 public static Customer[] customerArray=new Customer[5];
 public static ArrayList<Customer> customerList = new ArrayList<Customer>();
 
 File f2 = new File("customer.txt");
 FileOutputStream fos = null;
 FileInputStream fis = null;
 ObjectOutputStream oos =null;
 ObjectInputStream ois =null;


public void insertCustomer(Customer customer)
{
  customerList.add(customer);
}
public void writeCustomer()
{
  try{
      fos = new FileOutputStream(f2);
  }
  catch(FileNotFoundException fnfe){
      System.out.println("NOT FOUND");
  }
  
  try{
      oos = new ObjectOutputStream(fos);
      
      for(Customer c:customerList){
          oos.writeObject(c);
      }
      oos.close();
  }
  catch(IOException io){
      System.out.println("NOT");
  }
}


public List<Customer> readCustomer()
{
  try{
      fis = new FileInputStream(f2);
  }
  catch(FileNotFoundException fnfe2){
    System.out.println("NOT");
  }
  try{
      ois = new ObjectInputStream(fis);
      if(ois.available()>0){
          try{
              customerList.add((Customer) ois.readObject());
          }
          catch(ClassNotFoundException cnfe2){
                    System.out.println("NOT");
          }
      }
      ois.close();
  }
  catch(IOException ioe4){
    System.out.println("NOT");

  }
  return customerList;
  
}
}

// Class name should be "Source",
// otherwise solution won't be accepted
public class Source {
	public static void main(String args[] ) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		
		Scanner sc = new Scanner(System.in);
		
//  Customer(int userId,String emailId,String password,String firstName,String lastName,
//     String city,String gender,long phoneNumber,Address address)
        
        int bookId;
        String title;
        String description;
        String author;
        int totalQuantity;
        int availableQuantity;
        double price;
        double rentPerDay;
			
	int userId;
    String email;
    String password;
    String fName;
    String lName;
    String city;
    String gender;
    long phoneNumber;
    Address add;	
			
		while(sc.hasNext()){
		    int ch = sc.nextInt();
		    switch(ch){
		       case 1:
		       userId = sc.nextInt();
               gender=sc.nextLine();
               fName = sc.nextLine();
                lName = sc.nextLine();
               password = sc.nextLine();
               city = sc.nextLine();
               email = sc.nextLine();
               phoneNumber=sc.nextInt();
               add = new Address(null, city, 00000, "India");
               
               Customer cs = new Customer(userId, email,password,fName,lName,city,gender,
               phoneNumber,add);
               CustomerService csi = new CustomerServiceImpl();
               csi.insertCustomer(cs);
               csi.writeCustomer();
               System.out.println("Successfully Registered");
               break;
               
               case 2:
                CustomerService csi2 = new CustomerServiceImpl();
               // custArr=csi2.readCustomer();
               ArrayList<Customer> custlist = new ArrayList<Customer>(csi2.readCustomer());
               for (Customer c : custlist) {
                  System.out.println(c);
               }
               break;
               
               case 3:
                    bookId  = sc.nextInt();
	                title   =  sc.nextLine();
	                description=sc.nextLine();
	                author = sc.nextLine();
	                totalQuantity = sc.nextInt();
	            availableQuantity = sc.nextInt();
	                        price = sc.nextInt();
	                   rentPerDay = sc.nextInt();
	           
	       Book b = new Book(bookId,title,description, author,
	       totalQuantity, availableQuantity,
			 price, rentPerDay);
			 
			 AdminService asi = new AdminServiceImpl();
			 asi.insertBook(b);
			 asi.writeBooks();
			 System.out.println("Book added Successfully");
	       break;
               
               case 4:
                   AdminService asi2 = new AdminServiceImpl();
                   ArrayList<Book> bookList = new ArrayList<Book>(asi2.readBooks());
                   
                   for(Book b1: bookList){
                       System.out.println(b1);
                   }
                   break;
		           default:
               System.out.println("Invalid choice");
		    }
		}
	
	}
}

class Book implements Serializable {
	
	int bookId;
	String title;
	String description;
	String author;
	int totalQuantity;
	int availableQuantity;
	double price;
	double rentPerDay;
	
	public Book(int bookId, String title, String description, String author, int totalQuantity, int availableQuantity,
			double price, double rentPerDay) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.description = description;
		this.author = author;
		this.totalQuantity = totalQuantity;
		this.availableQuantity = availableQuantity;
		this.price = price;
		this.rentPerDay = rentPerDay;
	}
	public Book() {}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getTotalQuantity() {
		return totalQuantity;
	}
	
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public int getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getRentPerDay() {
		return rentPerDay;
	}
	public void setRentPerDay(double rentPerDay) {
		this.rentPerDay = rentPerDay;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", description=" + description + ", author=" + author
				+ ", totalQuantity=" + totalQuantity + ", availableQuantity=" + availableQuantity + ", price=" + price
				+ ", rentPerDay=" + rentPerDay + "]";
	}
}



class Address implements Serializable{
 String city;
 String state;
 int zip;
 String country;
    
 public Address(){
     
 }    
    
 Address(String city,String state,int zip,String country){
     this.city = city;
     this.state = state;
     this.zip = zip;
     this.country = country;
 } 
 
 public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getState() {
      return state;
   }

   public void setState(String state) {
      this.state = state;
   }

   public int getZip() {
      return zip;
   }

   public void setZip(int zip) {
      this.zip = zip;
   }

   public String getCountry() {
      return country;
   }

   public void setCountry(String country) {
      this.country = country;
   }
   
   @Override
   public String toString() {
      String result = "Address [city="+city + ", ";
      result += "state="+state + ", ";
      result += "zip="+zip + ", ";
      result += "country="+country+"]";
      return result;
   }
}

class Customer implements Serializable{
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
    
    Customer(int userId,String emailId,String password,String firstName,String lastName,
    String city,String gender,long phoneNumber,Address address){
    this.userId = userId;
    this.emailId= emailId;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.city = city;
    this.gender = gender;
    this.phoneNumber =phoneNumber;
    this.address = address;
    }
    
    public int getUserId(){
        return this.userId;
    }
    
    public void setUserId(int userId){
        this.userId = userId;
    }
    
    public String getEmailId(){
        return this.emailId;
    }
    
    public void setEmailId(String emailId){
        this.emailId = emailId;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getFirstName(){
        return this.firstName;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
     public String getLastName(){
        return this.lastName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public String getCity(){
        return this.city;
    }
    
    public void setCity(String city){
        this.city = city;
    }
    
     public String getGender(){
        return this.gender;
    }
    
    public void setGender(String gender){
        this.gender = gender;
    }
    
     public long getPhoneNumber(){
        return this.phoneNumber;
    }
    
    public void setPhoneNumber(long phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    
     public Address getAddress(){
        return this.address;
    }
    
    public void setAddress(Address address){
        this.address = address;
    }
    
    @Override
    public String toString(){
        String res = userId+",";
        res+=emailId+",";
        res+=password+",";
        res+=firstName+",";
        res+=lastName+",";
        res+=city+",";
        res+=phoneNumber+",";
        res+=address;
        
        return res;
    }
    
    
    
    
}

