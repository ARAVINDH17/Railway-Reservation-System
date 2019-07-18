package Railways;
import java.util.Scanner;
public class Passenger {
	String name;
	char source,destination;
	int id,status,pnr,no_of_tickets;
	Scanner sc=new Scanner(System.in);
     Passenger(){
    	 this.name=getName();
    	 this.source=getSource();
    	 this.destination=getDestination();
    	 this.no_of_tickets=getTickets();
    	}
     public String getName(){
    	 System.out.println("Enter the Name");
    	 String uname=sc.next();
    	 return uname;
     }
     public void assignPNR(int pnr){
    	 this.pnr=pnr;
     }
     public void assignStatus(int status){
    	 this.status=status;
     }
     public void assignID(int id){
    	 this.id=id;
     }
     public char getSource(){
    	 System.out.print("Enter the Source");
    	 char s=sc.next().charAt(0);
    	 return s;
     }
	public char getDestination(){
    	 System.out.print("Enter the Destination");
    	 char d=sc.next().charAt(0);
    	 return d;
     }
	public int getTickets(){
		System.out.println("Enter the number of tickets");
		int no_of_tickets=sc.nextInt();
		return no_of_tickets;
	}
	public int get_no_of_tickets(){
		return no_of_tickets;
	}
	
	@Override
	public String toString() {
		return "Passenger:"+name+"\nSource:"+source+"\nDestination:"+destination+"\nno_of_tickets:"
	                +no_of_tickets+"\nid:"+id+"\npnr:"+pnr+"\nstatus:"+status+"\n";
     
}
}