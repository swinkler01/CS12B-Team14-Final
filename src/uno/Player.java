package uno;

import java.util.ArrayList;

public class Player {
	ArrayList<Card> hand;
	
	public Player(ArrayList<Card> hand) {
		this.hand = hand;
	}
	
	public void draw(Card c) {
		this.hand.add(c);
	}
	
	/**
	 * According to the preciousCard, show the list of cards
	 * which you can play
	 * @param previousCard
	 * @return a list of cards in your hand that you can play
	 */
	public ArrayList<Card> cardsCanPlay(Card previousCard){
		return null;
	}

}
