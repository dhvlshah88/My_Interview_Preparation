package numberproblems;

import java.util.HashSet;

public class Shuffle {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

	String[] suits = {"Clubs", "Diamond", "Hearts", "Spades"};
	String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

	int SUITS = suits.length;
	int RANKS = ranks.length;
	int total = SUITS * RANKS;

	String[] deck = new String[total];

	for(int i=0; i<RANKS; i++){
	    for(int j=0; j<SUITS; j++){
		deck[SUITS*i + j] = ranks[i] + " of "  + suits[j];
	    }
	}


	// shuffle
	for (int i = 0; i < total; i++) {
	    int r = i + (int) (Math.random() * (total-i));
	    String t = deck[r];
	    deck[r] = deck[i];
	    deck[i] = t;
	}

	HashSet<String> set = new HashSet<>();
	for (String s : deck) {
	    set.add(s);
	}


	// print shuffled deck
	for (int i = 0; i < total; i++) {
	    System.out.println(deck[i]);
	}
	System.out.println(deck.length);
	System.out.println(set.size());
    }

}
