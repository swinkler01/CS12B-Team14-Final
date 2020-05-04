package uno;

import java.util.ArrayList;
import java.util.Scanner; 

public class User_Player extends Player {
	
	public User_Player(ArrayList<Card> hand) {
		super(hand);
	}
	
	@Override
	public Card play(Card previousCard) {
		
		boolean tester = true;
		
		Scanner in = new Scanner(System.in); 
		
		ArrayList<Card> userPlayer_cards = super.cardsCanPlay(previousCard); //code will prompt user to enter a card and will check if the card was playable
		System.out.println("Your current hand: ");
		ArrayList<Card> userPlayer_allCards = this.getHand();
		for(Card i : userPlayer_allCards) { 
			System.out.println(" "+i+" ");
		}
		System.out.println("Cards can be played: ");
		for(Card i : userPlayer_cards) { 
			System.out.println(" "+i+" ");
		}
		System.out.println("Which card do you wish to play? (Enter in the 'Type' ie Red,Green,Yellow,Blue,Wild,Wild draw 4. then enter the cards 'Value' ie 7,Skip,Draw 4)"); //added for user formatting purposes
		System.out.println("Please note if you choose a Wild card, enter value -1");
		
		
		String user_cardType = in.nextLine().toUpperCase();
		int user_cardValue = -1;
		if(in.hasNextInt()) {
			user_cardValue = in.nextInt();
		}else {// next input is not Integer, like Skip or Reverse
			if(in.next().toLowerCase().equals("skip")) { // user input "skip"
				user_cardValue = 10;
			}else if(in.next().toLowerCase().equals("reverse")) { // user input "reverse"
				user_cardValue = 11;
			}else if(in.next().toLowerCase().equals("draw 2")) { // user input "draw 2"
				user_cardValue = 12;
			}
		}
		
		
		Card user_Card = new Card(user_cardType, user_cardValue);
		
		while (tester) { //while statement will go on till users choice matches on in his hand that is possible to play 
			for(Card i : userPlayer_cards) {
				if(i.equals(user_Card)) {
					this.removeCard(i);
					return user_Card;
				}
				
				if(previousCard.value == -1) { //contingency if the last played card is a Wild + 4 card
					if(user_Card.type == previousCard.type) {
						this.removeCard(i);
						return user_Card;
					}
				}
			}
			
			System.out.println("Sorry but this card does not exist in your hand, please try again." // prompt user to change
					+ " (Enter in the 'Type' then enter the cards 'Value' )"); //Should show the user the format for the type/value ie Upper-lower
			System.out.println("Cards can be played: ");
			for(Card i : userPlayer_cards) { 
				System.out.println(" "+i+" ");
			}
			user_cardType = in.next();
			user_cardValue = in.nextInt();
			user_Card = new Card(user_cardType, user_cardValue); // create player card
			}
		return null;
	}

}	
