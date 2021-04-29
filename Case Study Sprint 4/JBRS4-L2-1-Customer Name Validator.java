import java.util.regex.Pattern;

import javax.naming.InvalidNameException;

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
