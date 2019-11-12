class BikeTest{
	String colour;
	int currentspeed;
	int highestspeed;
	BikeTest(String c,int cs,int h){
		this.colour=c;
		this.currentspeed=cs;
		this.highestspeed=h;
	}
	public void paint(String colour){
		System.out.println("这辆自行车是"+colour+"的");
	}
	public void highSpeed(){
		for(int i=0;i<15;i++){
		currentspeed+=5;
		if(currentspeed>highestspeed){
			currentspeed=highestspeed;
			}
			System.out.println(currentspeed);
		}
	}
	 public void lowSpeed(){
		 for(int i=0;i<15;i++){
			 currentspeed-=5;
		if(currentspeed<=0){
			currentspeed=0;
			}
			System.out.println(currentspeed);
		 }
	}
	public static void main(String[] args){
		BikeTest b=new BikeTest("紫色",30,100);
		b.paint("紫色");
		b.highSpeed();
		b.lowSpeed();
		
		
	}
}
		
		