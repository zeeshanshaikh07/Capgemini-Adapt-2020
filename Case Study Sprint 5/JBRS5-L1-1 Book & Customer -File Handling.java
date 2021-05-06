import java.util.Scanner;
import java.io.*;

class Source{
    public static void main(String args[])
    {
    	
}}
class Address implements Serializable{
	
	String city;
	String State;
	int zip;
	String Country;
	public Address(String city, String state, int zip, String country) {
	
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
		return "Address [city=" + city + ", State=" + State + ", zip=" + zip + ", Country=" + Country + "]";
	}	
}
class Book implements Serializable{
	
	
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
interface AdminService{
    Book[] readBooks() ;
    void writeBooks();
    void insertBooks(Book book);
}
class AdminServiceImpl implements AdminService {
	   public static Book booksArray[] = new Book[5];
	   public static int count = 0;
	   File f1 = new File("books.txt");
	   FileOutputStream fos = null;
	   FileInputStream fis = null;
	   ObjectOutputStream oos = null;
	   ObjectInputStream ois = null;

	   public void insertBooks(Book book) {
		   booksArray[count] = book;
	      count++;
	   }

	   public void writeBooks() {
	      try {
	         fos = new FileOutputStream(f1);
	      } catch (FileNotFoundException fnfe) {
	         System.out.println("FileNotFoundException");
	      }
	      try {
	         oos = new ObjectOutputStream(fos);
	         for (int i = 0; i < booksArray.length; i++) {
	            if (booksArray[i] != null) {
	               oos.writeObject(booksArray[i]);
	            } else {
	               break;
	            }
	         }
	         oos.close();
	      } catch (IOException ioe) {
	         System.out.println("IOException");
	      }

	   }

	   public Book[] readBooks() {
	      try {
	         fis = new FileInputStream(f1);
	      } catch (FileNotFoundException fnfe2) {
	         System.out.println("FileNotFoundException2");
	      }
	      try {
	         ois = new ObjectInputStream(fis);
	         for (int i = 0; i < booksArray.length; i++) {
	            if (ois.available() > 0) {
	               try {
	                  booksArray[i] = (Book) ois.readObject();
	               } catch (ClassNotFoundException cnfe) {
	                  System.out.println("ClassNotFoundException");
	               }

	            } else {
	               break;
	            }
	         }
	         ois.close();
	      } catch (IOException ioe2) {
	         System.out.println("IOException2");
	      }

	      return booksArray;
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
	 void writeCustomer();
	 Customer[] readCustomer();
	 void insertCustomer(Customer customer);
}
class CustomerServiceImpl implements CustomerService {
	   public static Customer[] customerArray = new Customer[5];
	   public static int count = 0;
	   File f2 = new File("customer.txt");
	   FileOutputStream fos = null;
	   FileInputStream fis = null;
	   ObjectOutputStream oos = null;
	   ObjectInputStream ois = null;

	   public void insertCustomer(Customer customer) {
	      customerArray[count] = customer;
	      count++;
	   }

	   public void writeCustomer() {
	      try {
	         fos = new FileOutputStream(f2);
	      } catch (FileNotFoundException fnfe3) {
	         System.out.println("FileNotFoundException3");
	      }
	      try {
	         oos = new ObjectOutputStream(fos);
	         for (int i = 0; i < customerArray.length; i++) {
	            if (customerArray[i] != null) {
	               oos.writeObject(customerArray[i]);
	            } else {
	               break;
	            }
	         }
	         oos.close();
	      } catch (IOException ioe3) {
	         System.out.println("IOException3");
	      }

	   }

	   public Customer[] readCustomer() {
	      try {
	         fis = new FileInputStream(f2);
	      } catch (FileNotFoundException fnfe4) {
	         System.out.println("FileNotFoundException4");
	      }
	      try {
	         ois = new ObjectInputStream(fis);
	         for (int i = 0; i < customerArray.length; i++) {
	            if (ois.available() > 0) {
	               try {
	                  customerArray[i] = (Customer) ois.readObject();
	               } catch (ClassNotFoundException cnfe2) {
	                  System.out.println("ClassNotFoundException2");
	               }

	            } else {
	               break;
	            }
	         }
	         ois.close();
	      } catch (IOException ioe4) {
	         System.out.println("IOException4");
	      }

	      return customerArray;
	   }
	}
