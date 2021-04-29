class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(){}
}
class Book {
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
interface AdminService{
    void createBook(Book book);
	Book updateBook(Book book);
	void deleteBook(int id);
	Book searchBook(int id);
	Book[] getBooks();
}
class AdminServiceImpl implements AdminService{
	public static Book bookArray[]=new Book[5];
	public static int count=0;
	@Override
	public void createBook(Book book) {
		bookArray[count]=book;
		count++;		
	}

	@Override
	public Book updateBook(Book book) throws BookNotFoundException{
		
		for(int i=0;i<5;i++)
		{
			if(book.getBookId()==bookArray[i].bookId)
			{
				bookArray[i]=book;
				return bookArray[i];				
			}				
		}
		throw new  BookNotFoundException();
	}

	@Override
	public void deleteBook(int id) {
		
		for(int i=0;i<5;i++)
		{
			if(id==bookArray[i].bookId)
			{
				bookArray[i]=null;
				break;
			}				
		}
		throw new  BookNotFoundException();
	}

	@Override
	public Book searchBook(int id) {
		
		for(int i=0;i<5;i++)
		{
			if(bookArray[i].getBookId()==id) {
				return bookArray[i];
			}
		}
		throw new  BookNotFoundException();
	}

	@Override
	public Book[] getBooks() {
		return bookArray;
	}
}
