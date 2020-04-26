package uno;

import java.util.ArrayList;

public class AI_Player extends Player{
	private ArrayList<Card> hand; 

	public AI_Player(ArrayList<Card> hand) {
		super(hand);
	
	}

	public void draw(Card c) {
		super.getHand().add(c);
	}
	
	
	public ArrayList<Card> cardsCanPlay(Card previousCard){
		return null;
	}

}
