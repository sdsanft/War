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
			
			String result = d1.compare(p, c);
			
			if(result.equals("c1")) {
				System.out.printf("%s wins!\n", d1.cardName(p));
				pscore++;
			} else if (result.equals("c2")) {
				System.out.printf("%s wins!\n", d1.cardName(c));
				cscore++;
			} else if (result.equals("tie")) {
				System.out.println("It's a tie");
			} else {
				System.out.println(result);
			}
			System.out.printf("Player %d - %d Computer\n", pscore, cscore);
			
			System.out.println();
		}
		
		System.out.println("Game Over! All the cards in the deck are gone!");
	}
}
