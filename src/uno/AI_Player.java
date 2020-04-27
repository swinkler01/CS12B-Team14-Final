package uno;

import java.util.Random;

import java.util.ArrayList;

public class AI_Player extends Player{ 

	public AI_Player(ArrayList<Card> hand) {
		super(hand);
	
	}
	
	public Card AI_Playcard(Card previousCard){
		
		ArrayList<Card> AI_cards = super.cardsCanPlay(previousCard);
		Random rand = new Random(AI_cards.size());
		return AI_cards.get(rand.nextInt()); 
	}
	
	@Override
	public Card play(Card previousCard) {
		// return the 1st card you can play
		return super.cardsCanPlay(previousCard).get(0);
	}
	
	/*
	public void draw(Card c) {
		super.getHand().add(c);
	}
	
	
	public ArrayList<Card> cardsCanPlay(Card previousCard){
		/*
		ArrayList<Card> playable = new ArrayList<Card>();
		
		for (Card c: super.getHand()) {
			 if(c.type == previousCard.type || c.value == previousCard.value || c.value == -1) {
				 playable.add(c);
			 }
		}
		
		return playable;
	}
*/
}
