package uno;

import java.util.ArrayList;

public abstract class Player { // parent class to user_player and AI_player
	private ArrayList<Card> hand;
	
	public Player(ArrayList<Card> hand) {
		this.setHand(hand);
	}
	
	public void draw(Card c) {
		this.getHand().add(c);
	}
	
	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Card> hand) { // added getter and setter 
		this.hand = hand;
	}
	
	/**
	 * remove card from player's hand
	 * @param i index of the card
	 */
	public void removeCard(Card c) {
		for(int i=0; i<this.hand.size(); i++) {
			if(hand.get(i).equals(c)) {
				hand.remove(i);
				return;
			}
		}
	}
	
	public void printHand() {
		for(int i=0; i<hand.size(); i++) {
			System.out.println(hand.get(i).toString());
		}
	}

	
	/**
	 * According to the previousCard, show the list of cards
	 * which you can play
	 * @param previousCard
	 * @return a list of cards in your hand that you can play
	 */
	public ArrayList<Card> cardsCanPlay(Card previousCard){
		
		ArrayList<Card> playable = new ArrayList<Card>();
		
		for (Card c: getHand()) {
			 if(c.type == previousCard.type || c.value == previousCard.value || c.value == -1) {
				 playable.add(c);
			 }
		}
		return playable;
	}
	
	/**
	 * player choose one card to play
	 * and remove the card from hand
	 * @return the card to play
	 */
	public abstract Card play(Card previousCard);

	
}
