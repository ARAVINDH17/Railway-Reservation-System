package Railways;

public class Train {
	static boolean flag;
	public static void stations(){
		char ch='A';
		for(int i=1;i<=5;i++){
			Booking.railway.put(ch++,8);
		}
    }
	public static void waitstations(){
		char ch='A';
		for(int i=1;i<=5;i++){
			Booking.waitrailway.put(ch++,16);
		}
	}
	String name;
	char source,destination;
	int no_of_tickets;
	static int id=1,pnr=1000;
	public static int book(Passenger p){
		int source=(p.source)-'A';
		char src=p.source;
		int destination=(p.destination)-'A';
		int no_of_tickets=p.no_of_tickets;
		for(int i=source;i<destination;i++){
		if(no_of_tickets<=Booking.railway.get(src))
		{
			Booking.railway.put(src,Booking.railway.get(src)-no_of_tickets);
			src++;
			flag=true;
		}
		else{
			flag=false;
			break;
		}
		}
		if(flag){
			p.assignID(id++);
			p.assignPNR(pnr++);
			p.assignStatus(1);
		}
		if(!flag){
			return 0;
		}
		else{
			return 1;
		}
	}
	
	
	public static int waitbook(Passenger p){
		int source=(p.source)-'A';
		char src=p.source;
		int destination=(p.destination)-'A';
		int no_of_tickets=p.no_of_tickets;
		for(int i=source;i<destination;i++){
		if(no_of_tickets<=Booking.waitrailway.get(src))
		{
			Booking.waitrailway.put(src,Booking.waitrailway.get(src)-no_of_tickets);
			src++;
			flag=true;
		}
		else{
			flag=false;
			break;
		}
		}
		if(flag){
			p.assignID(id++);
			p.assignPNR(pnr++);
			p.assignStatus(0);
		}
		if(!flag){
			return 0;
		}
		else{
			return 1;
		}
	}		
	@Override
	public String toString() {
		return "Train [name=" + name + ", source=" + source + ", destination="
				+ destination + ", no_of_tickets=" + no_of_tickets + "]";
	}
	
}
