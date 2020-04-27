package uno;

public class Card {

	String type;
	int value;

	/*
	 * generic constructor for cards
	 */
	public Card(String type, int value) {
		this.type = type;
		this.value = value;
	}

	/*
	 * special constructor for wildcards
	 */
	public Card(String type) {
		this.type = type;
		this.value = -1;
	}

	/*
	 * prints out the correct card name based on value
	 */
	public String toString() {
		switch (this.value) {
		case -1:
			return "Type: " + this.type;
		case 10:
			return "Type: " + this.type + ", Value: Skip";
		case 11:
			return "Type: " + this.type + ", Value: Reverse";
		case 12:
			return "Type: " + this.type + ", Value: Draw 2";
		default:
			return "Type: " + this.type + ", Value: " + this.value;
		}
	}

	/*
	 * tests if two cards are equal in type and value
	 */
	public boolean equals(Object o) {
		if (o instanceof Card) {
			Card other = (Card) o;
			return (other.value == this.value && other.type.equals(this.type));
		} else {
			return false;
		}
	}
	/*
	public static void main(String[] args) {
		Card c1 = new Card("Red", 11);
		Card c2 = new Card("Red", 5);
		Card c3 = new Card("Red", 11);

		System.out.println(c1.equals(c2));
		System.out.println(c1.equals(c3));
	}
	*/
}
