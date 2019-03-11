import java.util.*;

public class Deck {
	private String[] suits = {"D", "H", "S", "C"};
	private String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "K", "Q", "A"};
	Set<String> deck;
	Set<String> discard;
	
	public Deck() {
		deck = new TreeSet<String>();
		discard = new TreeSet<String>();
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 13; j++) {
				deck.add(suits[i] + ranks[j]);
			}
		}
	}
	
	public void printDeck() {
		Iterator iter = deck.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
	}
	
	public String pickCard() {
		int r = new Random().nextInt(deck.size());
		int i = 0;
		String card = "";
		
		Iterator<String> iter = deck.iterator();
		while(i <= r) {
			if(i == r) {
				card = (String) iter.next();
				deck.remove(card);
				discard.add(card);
				i++;
			} else {
				iter.next();
				i++;
			}
		}
		
		return(card);
	}
	
	public void refresh() {
		deck.addAll(discard);
		discard.removeAll(discard);
	}
	
	public String cardName(String s1) {
		String s2 = "";
		
		switch(s1.substring(1)) {
		case "2":
			s2 = "Two of ";
			break;
		case "3":
			s2 = "Three of ";
			break;
		case "4":
			s2 = "Four of ";
			break;
		case "5":
			s2 = "Five of ";
			break;
		case "6":
			s2 = "Six of ";
			break;
		case "7":
			s2 = "Seven of ";
			break;
		case "8":
			s2 = "Eight of ";
			break;
		case "9":
			s2 = "Nine of ";
			break;
		case "10":
			s2 = "Ten of ";
			break;
		case "J":
			s2 = "Jack of ";
			break;
		case "Q":
			s2 = "Queen of ";
			break;
		case "K":
			s2 = "King of ";
			break;
		case "A":
			s2 = "Ace of ";
			break;
		}
		
		switch(s1.substring(0,1)) {
		case "H":
			s2 += "Hearts";
			break;
		case "D":
			s2 += "Diamonds";
			break;
		case "S":
			s2 += "Spades";
			break;
		case "C":
			s2 += "Clubs";
			break;
		}
			
		return s2;
	}
	
	public String compare(String c1, String c2) {
		String r1 = c1.substring(1);
		String r2 = c2.substring(1);
		
		int s1, s2;
		s1 = 0;
		s2 = 0;
		
		try {
			s1 = Integer.parseInt(r1);
			s2 = Integer.parseInt(r2);
		} catch (NumberFormatException e) {
			switch (r1) {
			case "J":
				s1 = 11;
				break;
			case "Q":
				s1 = 12;
				break;
			case "K":
				s1 = 13;
				break;
			case "A":
				s1 = 14;
				break;
			//default:
				//return("Invalid Card");
			}
			
			switch (r2) {
			case "J":
				s2 = 11;
				break;
			case "Q":
				s2 = 12;
				break;
			case "K":
				s2 = 13;
				break;
			case "A":
				s2 = 14;
				break;
			//default:
				//return("Invalid Card");
			}
		}
	
		if (s1 > s2) {
			return ("c1");
		} else if (s2 > s1) {
			return ("c2");
		} else {
			return ("tie");
		}
	}
}
