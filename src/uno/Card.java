package uno;

public class Card {

	String type;
	int value;

	public Card(String type, int value) {
		this.type = type;
		this.value = value;
	}

	public Card(String type) {
		this.type = type;
		this.value = -1;
	}

	public String toString() {
		return "Type: " + this.type + ", Value:" + this.value;
	}

}
