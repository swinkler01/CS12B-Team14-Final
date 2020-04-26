package uno;

import java.util.Collections;
import java.util.LinkedList;

public class Deck {

	private LinkedList<Card> deck = new LinkedList<Card>();
	private LinkedList<Card> discard = new LinkedList<Card>();

	private final String[] colors = { "Blue", "Yellow", "Green", "Red" };
	
	public Deck() {
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

	public void Shuffle() {
		Collections.shuffle(this.deck);
	}
	
	
	/*
	public static void main(String[] args) {
		Deck d = new Deck();
		d.Shuffle();
		for (Card card : d.deck) {
			System.out.println(card);
		}
	}

	**/
}