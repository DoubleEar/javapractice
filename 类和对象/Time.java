class Time{
	private int hour;
	private int minute;
	private int second;
	Time(int hour,int minute,int second){
		if(hour>23||hour<0){
		System.out.println("不支持的小时");
		}
		if(minute>59||minute<0){
		System.out.println("不支持的分钟");
		}
		if(second>59||second<0){
		System.out.println("不支持的秒");
		}
		this.hour=hour;
		this.minute=minute;
		this.second=second;
	}
	
	@Override
	public String toString() {
		return String.format("%02d:%02d:%02d",hour, minute,second);
	}
	public void Add(int second){
		if(second<0){
			System.out.println("请使用Sub");
			return;
		}
		this.second+=second;
		while(this.second>=60){
		this.second-=60;
		minute+=1;
		if(minute>=60){
			minute-=1;
			hour+=1;
			if(hour>24){
				hour-=24;
			}
		}
	}
}
	public void Sub(int second){
		this.second-=second;
		while(this.second<0){
			this.second+=60;
			minute-=1;
		if(minute<0){
			minute+=60;
			hour-=1;
		}
		if(hour<0){
			hour=23;
		}
	}
}
	public static void main(String[] args){
		Time t1=new Time(12,20,30);
		Time t2=new Time(9,45,03);
		t1.Add(500);
		System.out.println(t1);
		t2.Sub(60);
		System.out.println(t2);
	}
}