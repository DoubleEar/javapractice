class Book{
	String name;
	String author;
	double price;
	String publisher;
	Book(String a){
		this.name="白日梦想家";
		this.author=a;
		this.price=100;
		this.publisher="耳耳出版社";
	}
	void setAuthor(String a){
		this.author=a;
	}
	String getAuthor(){
		return author;
	}
	String appendAuthor(String author){
		this.author=this.author+" "+author;
		return this.author;
	}
	double getDiscount(double discount){
		return price*discount;
	}
	public static void main(String[] args){
		Book b=new Book("耳耳");
		b.setAuthor("耳耳");
		System.out.println(b.name);
		System.out.println(b.price);
		System.out.println(b.appendAuthor("十日"));
		System.out.println(b.getDiscount(0.8));
	}
}