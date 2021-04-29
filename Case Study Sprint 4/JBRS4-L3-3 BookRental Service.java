import java.util.Date;
import java.util.regex.Pattern;

interface BookRentalService {
	void createBookRental(BookRental bookRental);

	BookRental updateBookRental(BookRental bookRental);

	void deleteBookRental(int rentalId);

	BookRental[] getBookRentals();

	BookRental[] searchByCustomerId(int customerId);

	BookRental[] searchByBookId(int bookId);
}

class BookRentalServiceImpl implements BookRentalService {
	public static BookRental[] bookRentalArray = new BookRental[5];
	public static int size = 0;

	@Override
	public void createBookRental(BookRental bookRental) {
		bookRentalArray[size] = bookRental;
		size++;
	}

	@Override
	public BookRental updateBookRental(BookRental bookRental) {
		int ctr;
		for (ctr = 0; ctr < size; ctr++) {
			if (bookRentalArray[ctr] == bookRental) {
				bookRentalArray[ctr] = bookRental;
				break;
			}
		}
		return bookRentalArray[ctr];
	}

	@Override
	public void deleteBookRental(int rentalId) {
		for (int ctr = 0; ctr < size; ctr++) {
			if (bookRentalArray[ctr].getRentalId() == rentalId) {
				bookRentalArray[ctr] = null;
			}
		}
	}

	@Override
	public BookRental[] getBookRentals() {
		return bookRentalArray;
	}

	@Override
	public BookRental[] searchByCustomerId(int customerId) {
		BookRental[] result = new BookRental[2];
		int rindex = 0;
		for (int ctr = 0; ctr < 5; ctr++) {
			if (customerId == bookRentalArray[ctr].getUserId()) {
				result[rindex] = bookRentalArray[ctr];
				rindex++;
			}
		}
		return result;
	}

	@Override
	public BookRental[] searchByBookId(int bookId) {
		BookRental[] result = new BookRental[2];
		int rindex = 0;
		for (int ctr = 0; ctr < 5; ctr++) {
			if (bookId == bookRentalArray[ctr].getBookId()) {
				result[rindex] = bookRentalArray[ctr];
				rindex++;
			}
		}
		return result;
	}

}

class BookRental {
	private int rentalId;
	private int bookId;
	private int userId;
	private int quantity;
	private Date startDate;
	private Date endDate;
	private double totalAmount;
	private Date returnedDate;

	public BookRental(int rentalId, int bookId, int userId, int quantity, Date startDate, Date endDate,
			double totalAmount, Date returnedDate) {
		this.rentalId = rentalId;
		this.bookId = bookId;
		this.userId = userId;
		this.quantity = quantity;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalAmount = totalAmount;
		this.returnedDate = returnedDate;
	}

	public int getRentalId() {
		return rentalId;
	}

	public void setRentalId(int rentalId) {
		this.rentalId = rentalId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getReturnedDate() {
		return returnedDate;
	}

	public void setReturnedDate(Date returnedDate) {
		this.returnedDate = returnedDate;
	}

}

interface CustomerService {
	public void createCustomer(Customer customer);

	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException;

	public void deleteCustomer(int id) throws CustomerNotFoundException;

	public Customer searchCustomer(int id) throws CustomerNotFoundException;

	public Customer[] getCustomers();

	public BookRental[] rentBook(BookRental bookRental);

	public BookRental[] getRentalBookDetails(int customerId);

}

class CustomerServiceImpl implements CustomerService {

	BookRentalService service = new BookRentalServiceImpl();

	static Customer[] customerArray = new Customer[5];
	int size = 0, count = 0;

	@Override
	public void createCustomer(Customer customer) {
		customerArray[size] = customer;
		size++;
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
		int flag = 0;
		for (int ctr = 0; ctr < 5; ctr++) {
			if (customer.equals(customerArray[ctr])) {
				flag = 1;
				break;
			}
		}
		if (flag == 0) {
			throw new CustomerNotFoundException();
		}
		return customer;
	}

	@Override
	public void deleteCustomer(int id) throws CustomerNotFoundException {
		int flag = 0;
		for (int ctr = 0; ctr < size; ctr++) {
			if (id == customerArray[ctr].getUserId()) {
				flag = 1;
				break;
			}
		}
		if (flag == 0) {
			throw new CustomerNotFoundException();
		}
	}

	@Override
	public Customer searchCustomer(int id) throws CustomerNotFoundException {
		int flag = 0, ctr;
		for (ctr = 0; ctr < size; ctr++) {
			if (id == customerArray[ctr].getUserId()) {
				flag = 1;
				break;
			}
		}
		if (flag == 0) {
			throw new CustomerNotFoundException();
		}
		return customerArray[ctr];
	}

	@Override
	public Customer[] getCustomers() {
		return customerArray;
	}

	@Override
	public BookRental[] rentBook(BookRental bookRental) {
		service.createBookRental(bookRental);
		return service.getBookRentals();
	}

	@Override
	public BookRental[] getRentalBookDetails(int customerId) {
		return (service.searchByCustomerId(customerId));
	}
}

class Customer {
	private int userId;
	private String emailId;
	private String password;
	private String firstName;
	private String lastName;
	private String city;
	private String gender;
	private long phoneNumber;
	private Address address;
	private int result;

	Customer() {

	}

	public Customer(int userId, String emailId, String password, String firstName, String lastName, String city,
			String gender, long phoneNumber, Address address) throws InvalidNameException {
		this.userId = userId;
		this.emailId = emailId;
		this.password = password;
		result = Pattern.matches("^[A-Za-z]{6,}", firstName) ? 1 : -1;
		if (result == 1) {
			this.firstName = firstName;
		} else {
			throw new InvalidNameException();
		}
		result = Pattern.matches("^[A-Za-z]{6,}", firstName) ? 1 : -1;
		if (result == 1) {
			this.lastName = lastName;
		} else {
			throw new InvalidNameException();
		}
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public long getUserId() {
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

	public void setFirstName(String firstName) throws InvalidNameException {
		int result = Pattern.matches("^[A-Za-z]{6,}", firstName) ? 1 : -1;
		if (result == 1) {
			this.firstName = firstName;
		} else {
			throw new InvalidNameException();
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) throws InvalidNameException {
		int result = Pattern.matches("^[A-Za-z]{6,}", lastName) ? 1 : -1;
		if (result == 1) {
			this.lastName = lastName;
		} else {
			throw new InvalidNameException();
		}
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

	@Override
	public String toString() {
		return String.format(
				"Customer [userId=%s, emailId=%s, password=%s, firstName=%s, lastName=%s, city=%s, gender=%s, phoneNumber=%s, address=%s]",
				userId, emailId, password, firstName, lastName, city, gender, phoneNumber, address);
	}

}

class Address {
	private String city;
	private String state;
	private int zip;
	private String country;

	Address() {

	}

	public Address(String city, String state, int zip, String country) {
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
		return String.format("Address [city=%s, state=%s, zip=%s, country=%s]", city, state, zip, country);
	}

}

class InvalidNameException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidNameException() {
	}

	public InvalidNameException(String message) {
		super(message);
	}

	public InvalidNameException(Throwable cause) {
		super(cause);
	}

	public InvalidNameException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidNameException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException() {
	}

	public CustomerNotFoundException(String message) {
		super(message);
	}

	public CustomerNotFoundException(Throwable cause) {
		super(cause);
	}

	public CustomerNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomerNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

public class Source {
	public static void main(String[] args) {

	}
}
