package uno;

import java.util.Collections;
import java.util.LinkedList;

public class Deck {

	/*
	 * Stores the unplayed cards to be drawn from
	 */
	private LinkedList<Card> deck = new LinkedList<Card>();
	/*
	 * Stores the cards that have already been played
	 */
	private LinkedList<Card> discard = new LinkedList<Card>();
	/*
	 * Keeps track of the last played card- useful for when the deck is reset
	 */
	private Card latestCard;

	/*
	 * used in addCards to loop over card types
	 */
	private final String[] colors = { "BLUE", "YELLOW", "GREEN", "RED" };

	/*
	 * Constructor, adds cards to the deck
	 */
	public Deck() {
		this.addCards();
	}

	/*
	 * Adds the cards to the deck: each color 0,9; duplicates of 1,9; 
	 * 2 skip/reverse/+2 for each color; 4 wildcards, 4 wild+4
	 */
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
			this.deck.add(new Card("WILD"));
			this.deck.add(new Card("WILD DRAW 4"));
		}
	}

	/*
	 * randomizes the card order
	 */
	public void shuffle() {
		Collections.shuffle(this.deck);
	}

	/*
	 * adds a card to the discard pile after it has been played
	 */
	public void addToDiscard(Card c) {
		this.discard.add(c);
	}

	/*
	 * draws a card from the deck, and calls resetDeck if the deck is empty
	 */
	public Card drawCard() {
		if (this.deck.size() > 0) {
			return this.deck.poll();
		} else {
			this.resetDeck();
			return this.deck.poll();
		}

	}

	/*
	 * refills the deck with cards, and empties the discard pile
	 */
	public void resetDeck() {
		this.latestCard = this.discard.getLast();
		this.discard.clear();
		this.discard.add(this.latestCard);
		this.deck.clear();
		this.addCards();
		this.deck.remove(this.latestCard);
		this.shuffle();
	}

	/*
	public void printSize() { //for testing purposes
		System.out.println(this.deck.size()+", "+this.discard.size());
	}
	
	
	
	public static void main(String[] args) {
		Deck d = new Deck();
		d.shuffle();
		d.printSize();
		
		for (Card s:d.deck) {
			System.out.println(s);
		}
		
		Card test = d.drawCard();
		d.addToDiscard(test);
		Card e = d.drawCard();
		d.addToDiscard(test);
		Card x = d.drawCard();
		d.addToDiscard(test);
		d.printSize();
		d.resetDeck();
		d.printSize();
			
	}
	*/
	
}