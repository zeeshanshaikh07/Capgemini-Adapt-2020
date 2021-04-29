import java.util.regex.Pattern;

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

class InvalidPhoneNumberExcception extends Exception {

  private static final long serialVersionUID = 1L;

  public InvalidPhoneNumberExcception() {
  }

  public InvalidPhoneNumberExcception(String message) {
    super(message);
  }

  public InvalidPhoneNumberExcception(Throwable cause) {
    super(cause);
  }

  public InvalidPhoneNumberExcception(String message, Throwable cause) {
    super(message, cause);
  }

  public InvalidPhoneNumberExcception(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
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
      String gender, long phoneNumber, Address address) throws InvalidNameException, InvalidPhoneNumberExcception {
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
    String phone = Long.toString(phoneNumber);
    int mobileChecker = Pattern.matches("^[6-9][0-9]{9}$", phone) ? 1 : -1;
    if (mobileChecker == 1) {
      this.phoneNumber = phoneNumber;
    } else {
      throw new InvalidPhoneNumberExcception();
    }
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
