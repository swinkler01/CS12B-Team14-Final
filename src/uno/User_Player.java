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
		System.out.print("Your current hand: ");
		for(Card i : userPlayer_cards) { 
			System.out.print(" "+i+" ");
		}
		System.out.println("Which card do you wish to play? (Enter in the 'Type' then enter the cards 'Value' )");
		String user_cardType = in.next();
		int user_cardValue = in.nextInt();
		Card user_Card = new Card(user_cardType, user_cardValue);
		
		while (tester) { //while statement will go on till users choice matches on in his hand that is possible to play 
			for(Card i : userPlayer_cards) {
				if(i.type == user_Card.type && i.value == user_Card.value) {
					this.removeCard(i);
					return user_Card;
				}
				
				if(previousCard.value == -1) {
					if(user_Card.type == previousCard.type) {
						this.removeCard(i);
						return user_Card;
					}
				}
			}
			
			System.out.println("Sorry but this card does not exist in your hand, please try again." // prompt user to change
					+ " (Enter in the 'Type' then enter the cards 'Value' )"); //Should show the user the format for the type/value ie Upper-lower
			System.out.print("Your current hand: ");
			for(Card i : userPlayer_cards) { 
				System.out.print(" "+i+" ");
			}
			user_cardType = in.next();
			user_cardValue = in.nextInt();
			user_Card = new Card(user_cardType, user_cardValue);
			}
		return null;
	}

}	
 

	
/*
	while (tester == true) {
		for(Card i : userPlayer_cards) {
			if(user_Card.type == i.type && user_Card.value == i.value) {
				this.removeCard(userPlayer_cards.indexOf(i));
				tester = false;
			}
		
		if(tester == true) {
			System.out.println("Sorry but this card does not exsist in your hand, please try again."
			+ " (Enter in the 'Type' then enter the cards 'Value' )");
			user_cardType = in.next();
			user_cardValue = in.nextInt();
			user_Card = new Card(user_cardType, user_cardValue);
				}	
		}
	}
	return user_Card;
		 
}
*/



