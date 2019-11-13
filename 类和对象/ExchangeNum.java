class ExchangeNum{
	int a;
	int b;
	ExchangeNum(int a,int b){
		this.a=a;
		this.b=b;
	}
	void Exchange(){
		int tmp=0;
		tmp=this.a;
		this.a=this.b;
		this.b=tmp;
		System.out.println("a="+this.a);
		System.out.println("b="+this.b);
	}
	public static void main(String[] args){
		ExchangeNum en=new ExchangeNum(10,5);
		en.Exchange();
	}
}