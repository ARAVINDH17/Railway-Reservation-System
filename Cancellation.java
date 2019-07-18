package Railways;

import java.util.Scanner;

public class Cancellation {

	public static void cancelTicket(Passenger p) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
                System.out.println("\n1.Full Cancellation\n2.Partial Cancellation");
                int choice=sc.nextInt();
                if(choice==1){
                	System.out.print("Are You sure to cancel"+" "+p.no_of_tickets+" "+"tickets");
                	System.out.println("\n1.Yes\n2.No");
                	int n=sc.nextInt();
                	if(n==1){
        		char srce = p.source;
        		char desti = p.destination;
			    int  src = srce-'A';
				int  dest = desti-'A';
				for(int j=src;j<dest;j++){
					Booking.railway.put(srce,Booking.railway.get(srce)+p.no_of_tickets);
					srce++;
				}
				Booking.passenger.remove(p);
				Booking.cancelpassenger.add(p);
				System.out.println(Booking.railway);
				checkWaitList(p);
                	}
	}
                else{
                	System.out.println("Enter the no of tickets to be cancelled");
                	int tickets=sc.nextInt();
                	if(tickets<=(p.no_of_tickets)/2){
                		char srce = p.source;
                		char desti = p.destination;
        			    int  src = srce-'A';
        				int  dest = desti-'A';
        				for(int j=src;j<dest;j++){
        					Booking.railway.put(srce,Booking.railway.get(srce)+tickets);
        					srce++;
        				}
        				p.no_of_tickets=tickets;
        				Booking.cancelpassenger.add(p);
        				System.out.println(Booking.railway);
                	}
                	else{
                		System.out.println("You can cancel only "+" "+p.no_of_tickets/2+" "+"tickets");
                	}
                }
                checkWaitList(p);
  }
		
		
	public static void checkWaitList(Passenger p){
		for(int i=0;i<Booking.waitpassenger.size();i++){
			char srce=Booking.waitpassenger.get(i).source;
			char desti=Booking.waitpassenger.get(i).destination;
			int src=srce-'A';
			int dest=desti-'A';
			boolean flag=false;
			for(int j=src;j<dest;j++){
			if(Booking.waitpassenger.get(i).no_of_tickets <= Booking.railway.get(srce)){
				flag=true;
				srce++;
			}
		}
			if(flag){
				System.out.print("Tickets Available");
				}
			}
			System.out.println(Booking.railway);
		}

	@Override
	public String toString() {
		return "Cancellation:"+Booking.railway;
	}

	
}
