package uno;

import java.util.ArrayList;

public class Player {
	private ArrayList<Card> hand;
	
	public Player(ArrayList<Card> hand) {
		this.setHand(hand);
	}
	
	public void draw(Card c) {
		this.getHand().add(c);
	}
	
	/**
	 * According to the previousCard, show the list of cards
	 * which you can play
	 * @param previousCard
	 * @return a list of cards in your hand that you can play
	 */
	public ArrayList<Card> cardsCanPlay(Card previousCard){
		return null;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Card> hand) { // added getter and setter 
		this.hand = hand;
	}

}
