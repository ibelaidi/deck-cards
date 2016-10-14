/**
 *
 */
package gb.ilias.ubs.deck.cards.game;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Tester class
 *
 * @author ilias
 * @since Oct 14, 2016
 */
public class GameTester {

	@Test
	public void gameTest() {

		final List<Card> hand = new ArrayList<Card>();
		final Card card;
		final ArrayList<Card> deckOfCards = new ArrayList<Card>();
		final Deck deckTester;

		// Suits
		final String hearts = "Hearts";
		final String clubs = "Clubs";
		final String spades = "Spades";
		final String diamonds = "Diamonds";
		// Ranks
		final String queen = "Queen";
		final String king = "King";
		final String jack = "Jack";
		final String ace = "Ace";
		// Possible Suits
		final String[] suits = { hearts, hearts, hearts, hearts, hearts, clubs, clubs, clubs, clubs, clubs,
				hearts, clubs, diamonds, spades, hearts, hearts, diamonds, clubs, hearts, diamonds, diamonds,
				diamonds, diamonds, diamonds, diamonds, hearts, diamonds, spades, clubs, clubs, spades,
				hearts, clubs, diamonds, clubs, diamonds, hearts, diamonds, hearts, hearts, hearts, diamonds,
				diamonds, clubs, spades, hearts, clubs, diamonds, clubs, spades };
		// Possible Ranks
		final String[] ranks = { ace, "10", jack, queen, king, "2", "3", "4", "5", "6", "9", "9", "9", "9",
				"4", queen, queen, queen, "5", "5", "4", "6", "8", "2", "9", "4", "5", "6", "7", "8", "4",
				"4", "4", "7", "6", "5", "5", jack, jack, king, jack, jack, "4", "6", "8", jack, "4", "9",
				"8", "6" };

		//
	}
}
