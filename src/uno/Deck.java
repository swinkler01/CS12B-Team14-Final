package uno;

import java.util.Collections;
import java.util.LinkedList;

public class Deck {

	private LinkedList<Card> deck = new LinkedList<Card>();
	private LinkedList<Card> discard = new LinkedList<Card>();
	private Card latestCard;

	private final String[] colors = { "Blue", "Yellow", "Green", "Red" };
	
	public Deck() {
		this.addCards();
	}
	
	private void addCards() {
		for (String i : colors) {
			for (int j = 0; j <= 12; j++) {
				this.deck.add(new Card(i, j));
				if (j > 0) {
					this.deck.add(new Card(i, j));
				}
			}
		}
		for (int i = 0; i < 4; i++) {
			this.deck.add(new Card("Wild"));
			this.deck.add(new Card("Wild+4"));
		}
	}

	public void shuffle() {
		Collections.shuffle(this.deck);
	}
	
	public void addToDiscard(Card c) {
		this.discard.add(c);
	}
	
	public Card drawCard() {
		if(this.deck.size() > 0) {
			return this.deck.poll();
		} else {
			this.resetDeck();
			return this.deck.poll();
		}
		
	}
	
	public void resetDeck() {
		this.latestCard = this.discard.getLast();
		this.discard.clear();
		this.discard.add(this.latestCard);
		this.deck.clear();
		this.addCards();
		this.shuffle();
	}
	
	public void printSize() { //for testing purposes
		System.out.println(this.deck.size()+", "+this.discard.size());
	}
	
	
	/*
	public static void main(String[] args) {
		Deck d = new Deck();
		d.shuffle();
		d.printSize();
		Card test = d.drawCard();
		d.addToDiscard(test);
		d.printSize();
		d.resetDeck();
		d.printSize();
		
	}
	**/
	
}