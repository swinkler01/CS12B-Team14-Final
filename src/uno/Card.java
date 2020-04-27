package uno;

public class Card {

	String type;
	int value;

	public Card(String type, int value) { //creates the cards 
		this.type = type;
		this.value = value;
	}

	public Card(String type) {
		this.type = type;
		this.value = -1;
	}

	public String toString() {
		return "Type: " + this.type + ", Value: " + this.value;
	}
	
	public boolean equals(Object o) {
		if(o instanceof Card) {
			Card other = (Card) o;
			return (other.value==this.value && other.type.equals(this.type));
		}else {
			return false;
		}
	}
	
//	public static void main(String[] args) {
//		Card c1 = new Card("Red", 11);
//		Card c2 = new Card("Red", 5);
//		Card c3 = new Card("Red", 11);
//		
//		System.out.println(c1.equals(c2));
//		System.out.println(c1.equals(c3));
//	}

}
