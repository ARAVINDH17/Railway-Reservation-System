package Railways;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Booking {

	/**
	 * @param args
	 */
	static ArrayList<Passenger> passenger = new ArrayList<>();
	static ArrayList<Passenger> waitpassenger = new ArrayList<>();
	static ArrayList<Passenger> cancelpassenger= new ArrayList<>();
	static HashMap<Character,Integer> waitrailway = new HashMap<>();
	static HashMap<Character,Integer> railway = new HashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Train.stations();
		Train.waitstations();
		System.out.println(railway);
		System.out.print(waitrailway);
		while(true){
        System.out.print("\n1.Book \n2.Cancel \n3.Chart \n4.WaitList Details \n5.Confirmed Ticket Details \n6.Cancellation details \n 7.Exit");
        int choice =sc.nextInt();
        
        if(choice==1){
		Passenger p=new Passenger();
		int bookstatus=Train.book(p);
		if(bookstatus==1){
			passenger.add(p);
			System.out.println("YOUR TICKET SUCCESSFULLY BOOKED");
		}
		else{
		int waitBook=Train.waitbook(p);
		if(waitBook==1){
		waitpassenger.add(p);
		System.out.println("Your ticket is in waiting List");
		}
		else{
			System.out.println("Ticket full.Cannot Be Booked");
		}
	    }
        }
		
	else if(choice==2){
		System.out.println("Enter the PNR no");
		int pnr=sc.nextInt();
		for(int i=0;i<passenger.size();i++)
			if(passenger.get(i).pnr==pnr){
		Cancellation.cancelTicket(passenger.get(i));
		}
	}
		else if(choice == 3){
			printchart();
		}
		else if (choice == 4){
			for(int i=0;i<waitpassenger.size();i++)
				System.out.print("\n"+waitpassenger.get(i));
		}
		else if(choice == 5){
			for(int i=0;i<passenger.size();i++)
				System.out.print("\n"+passenger.get(i));
		}
		else if(choice == 6){
			for(int i=0;i<cancelpassenger.size();i++)
				System.out.print("\n"+cancelpassenger.get(i));
         }
		}
	}
	public static void printchart(){
		System.out.println("  1 2 3 4 5 6 7 8 ");
		char c='A';
		for(int i=1;i<=5;i++){
			int l=8-railway.get(c);
			for(int j=0;j<=l;j++){
				if(j==0){
					System.out.print(c+++" ");
				}
				else
					System.out.print("* ");
			}
			System.out.println();
			
		}
	}
	
}
