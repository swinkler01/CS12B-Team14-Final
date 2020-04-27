package uno;

import java.util.ArrayList;

public class UnoGame {
	/**
	 * Number of players in the game
	 * Assume the last one is an User Player
	 * while everyone else is AI Player
	 */
	private int playerNumber;
	/**
	 * Number of initial cards in hand
	 */
	private int initialHandNum = 7;
	/**
	 * list of players
	 */
	private Player[] players;
	/**
	 * deck of cards in the game
	 */
	private Deck deck;
	/**
	 * direction of the game, 
	 * true if next player is to the right,
	 * false if next player is to the left
	 */
	private boolean playDirection = true;
	/**
	 * index of the last Player in the players list
	 */
	private int lastPlayer;
	/**
	 * number of cards a player should draw if the player has no cards to play
	 */
	private int penalty = 1;
	/**
	 * Card that was last played
	 */
	private Card lastPlayedCard;
	
	public UnoGame(int playerNum) {
		this.playerNumber = playerNum;
		this.players = new Player[playerNum];
		this.deck = new Deck();
		// Assume user player is the first one to play
		this.lastPlayer = playerNum;
	}
	
	/**
	 * initiate the game
	 * add players to the player list
	 * draw initial hands to the players
	 */
//	public void initiate() {
//		// add players #1 to #(playerNum-1), they are AI_players
//		deck.shuffle();
//		for(int i=0; i<playerNumber-1; i++) {
//			ArrayList<Card> tempHand = new ArrayList<Card>();
//			for(int j=0; j<initialHandNum; j++) {
//				tempHand.add(deck.drawCard());
//			}
//		players[i] = new AI_Player(tempHand);
//		}
//		// add player # playerNum, the last one is User_Player
//		ArrayList<Card> userHand = new ArrayList<Card>();
//		for(int j=0; j<initialHandNum; j++) {
//			userHand.add(deck.drawCard());
//		}
//		players[playerNumber-1] = new User_Player(userHand);
//		// draw one card from the deck, set it as the lastPlayedCard
//		lastPlayedCard = deck.drawCard();
//		System.out.println("UNO! Game Start!");
//		System.out.printf("Initial card is %s \n", lastPlayedCard.toString());
//	}
	
	// test AI_Players
	public void initiate() {
		deck.shuffle();
		for(int i=0; i<playerNumber; i++) {
			ArrayList<Card> tempHand = new ArrayList<Card>();
			for(int j=0; j<initialHandNum; j++) {
				tempHand.add(deck.drawCard());
			}
		players[i] = new AI_Player(tempHand);
		}
		
		//draw one card from the deck, set it as the lastPlayedCard
		lastPlayedCard = deck.drawCard();
		System.out.println("UNO! Game Start!");
		System.out.printf("Initial card is %s \n", lastPlayedCard.toString());
	}
	
	/**
	 * Check if game is over
	 * @return true if game is done
	 */
	public boolean gameDone() {
		// if there is one player's hand is size 0, game is done
		for(Player p: players) {
			if(p.getHand().size()==0) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * return the index of the next player
	 * and change the play direction, lastPlayer if necessary
	 * @return index of the next player
	 */
	public int updateNextPlayer() {
		if(playDirection) {// play direction is to the right
			if(lastPlayedCard.value==11) {// lastPlayedCard is Reverse
				if(lastPlayer-1<0) {
					lastPlayer = lastPlayer-1+playerNumber;
				}else {
					lastPlayer -= 1;
				}
				playDirection = false; // reverse the play direction
				return lastPlayer;
			}else if(lastPlayedCard.value==10) {// lastPlayedCard is Skip
				lastPlayer = (lastPlayer+2)%playerNumber;
				return lastPlayer;
			}else {// lastPlayedCard is normal card
				lastPlayer = (lastPlayer+1)%playerNumber;
				return lastPlayer;
			}				
		}else {// play direction is to the left
			if(lastPlayedCard.value==11) {// lastPlayedCard is Reverse
				lastPlayer = (lastPlayer+1)%playerNumber;
				playDirection = true; // reverse the play direction
				return lastPlayer;
			}else if(lastPlayedCard.value==10) {// lastPlayedCard is Skip
				if(lastPlayer-2<0) {
					lastPlayer = lastPlayer-2+playerNumber;
				}else {
					lastPlayer -= 2;
				}
				return lastPlayer;
			}else {// lastPlayedCard is normal card
				if(lastPlayer-1<0) {
					lastPlayer = lastPlayer-1+playerNumber;
				}else {
					lastPlayer -= 1;
				}
				return lastPlayer;
			}
		}
	}
	
	public void updatePenalty() {
		if(lastPlayedCard.value==12) {// last played card is +2
			if(penalty==1) {
				penalty = 2;
			}else {
				penalty += 2;
			}			
		}else if(lastPlayedCard.value==-1 && lastPlayedCard.type.equals("Wild+4")) {// last card is +4
			if(penalty==1) {
				penalty = 4;
			}else {
				penalty += 4;
			}
		}
	}
	
	/**
	 * move to the next round
	 * change the lastPlayedCard and playDirection
	 * next Player choose one card to play,
	 * if no card can be played, draw
	 */
	public void oneRound() {
		lastPlayer = this.updateNextPlayer();
		if(players[lastPlayer].cardsCanPlay(lastPlayedCard).size()!=0) {// next player have card to play
			// choose one card to play
			lastPlayedCard = players[lastPlayer].play(lastPlayedCard);
			this.updatePenalty();
			System.out.printf("Player %d played card %s \n", lastPlayer, lastPlayedCard.toString());
		}else { // next player have no card to play
			// draw cards according to the penalty
			for(int i=0; i<penalty; i++) {
				players[lastPlayer].draw(deck.drawCard());
			}
			System.out.printf("Player %d has no cards to play, and draw %d times \n", lastPlayer, penalty);
			// change the penalty to default value 
			penalty = 1;
			
		}
		
				

	}
	
	public void run() {
		while(!gameDone()) {
			this.oneRound();
		}
		System.out.println("Game is over");
		// print out the winner
		//System.out.printf("Winner is Player%s", playerNumber);
		
		
	}
	
	public static void main(String[] args) {
		UnoGame testGame = new UnoGame(2);
		testGame.initiate();
//		System.out.println(testGame.players[0].getHand().get(0).toString());
//		System.out.println(testGame.players[0].getHand().get(1).toString());
//		System.out.println(testGame.players[0].getHand().get(2).toString());
//		System.out.println(testGame.players[0].getHand().get(3).toString());
//		System.out.println(testGame.players[0].getHand().get(4).toString());
		
//		System.out.println("player 0's hand: **************");
//		testGame.players[0].printHand();
//		System.out.println("player 1's hand: **************");
//		testGame.players[1].printHand();
//		
//		testGame.oneRound();
//		System.out.println("player 0's hand: **************");
//		testGame.players[0].printHand();
//		System.out.println("player 1's hand: **************");
//		testGame.players[1].printHand();
//		System.out.println(" ");
//		
//		testGame.oneRound();
//		System.out.println("player 0's hand: **************");
//		testGame.players[0].printHand();
//		System.out.println("player 1's hand: **************");
//		testGame.players[1].printHand();
		
		
		testGame.run();
		
			
		
	}

}
