import java.util.*;
public class head {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deck d1 = new Deck();
		War();
	}

	public static void War() {
		System.out.println("Welcome to War!\nEnter quit at anytime to end the game\n");
		int pscore = 0; int cscore = 0;
		Deck d1 = new Deck();
		
		Scanner kb = new Scanner(System.in);
		
		while(d1.deck.size() > 0) {
			String command;
			
			System.out.print("Press enter to draw a card: ");
			command = kb.nextLine();
			if(command.toLowerCase().equals("quit")) {
				break;
			}
			String p = d1.pickCard();
			String c = d1.pickCard();
			System.out.println("You drew " + d1.cardName(p));
			System.out.println("The computer drew " + d1.cardName(c));
			
			System.out.println();
		}
	}
}
