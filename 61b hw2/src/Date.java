
public class Date {
	int month,day,year;
	
	public Date(int month,int day,int year){
		if(isValidDate(month,day,year)){
			this.day=day;
			this.month=month;
			this.year=year;
		}
		else
			System.exit(0);
	}
	
	public Date(String s){
		String[] d = s.split("/");
		if(d[0].length()>=1&&d[0].length()<=2&&d[1].length()>=1&&d[1].length()<=2
				&&d[2].length()>=1&&d[2].length()<=4){
			this.month=Integer.parseInt(d[0]);
			this.day=Integer.parseInt(d[1]);
			this.year=Integer.parseInt(d[2]);
		}
		else 
			System.exit(0);
	}

	public static boolean isLeapYear(int year){
		if((year%4==0&&year%100!=0)||year%400==0)
			return true;
		else
			return false;
	}
	
	public static int daysInMonth(int month,int year){
		if(month==2){
			if(isLeapYear(year)) return 28;
			else return 29; 
		}
		else if(month==4||month==6||month==9||month==11)
			return 30;
		else 
			return 31;
	}
	
	public static boolean isValidDate(int month,int day,int year){
		if(year>0&&month<13&&month>0&&day<=daysInMonth(month,year)&&day>0)
			return true;
		else
			return false;
	}
	
	public String toString(){
		return(this.month+"/"+this.day+"/"+this.year);
	}
	
	public boolean isBefore(Date d){
		if(this.year<d.year||(this.year==d.year&&this.month<d.month)||(this.year==d.year&&
				this.month==d.month&&this.day<d.day))
			return true;
		else
			return false;
	}
	
	public boolean isAfter(Date d){
		if(isBefore(d)==false&&!this.equals(d))
			return true;
		else 
			return false;
	}
	
	public int dayInYear(Date d){
		int result=0;
		for(int i=1;i<d.month;i++){
			result+=daysInMonth(i,d.year);
		}
		result+=d.day;
		return result;
	}
	
	public int difference(Date d){
		return dayInYear(this)-dayInYear(d);
	}
}
