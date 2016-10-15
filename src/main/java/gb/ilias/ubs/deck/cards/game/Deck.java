/**
 *
 */
package gb.ilias.ubs.deck.cards.game;

import gb.ilias.ubs.deck.cards.game.internal.FaceRank;
import gb.ilias.ubs.deck.cards.game.internal.Suit;

/**
 * An object of type Deck represents a deck of playing cards. The deck
 * is a regular poker deck that contains 52 regular cards and that can
 * also optionally include two Jokers.
 *
 * @author ilias
 * @since Oct 14, 2016
 */
public class Deck {

	/**
	 * An array of 52 or 54 cards. A 54-card deck contains two Jokers,
	 * in addition to the 52 cards of a regular poker deck.
	 */
	private Card[]	deck;

	/**
	 * Keeps track of the number of cards that have been dealt from
	 * the deck so far.
	 */
	private int		cardsUsed;

	/**
	 * Constructs a regular 52-card poker deck.
	 */
	public Deck() {
		this(false);
	}

	/**
	 * Constructs a poker deck of playing cards, The deck contains
	 * the usual 52 cards and can optionally contain two Jokers
	 * in addition, for a total of 54 cards. Initially the cards
	 * are in a sorted order. The shuffle() method can be called to
	 * randomize the order.
	 *
	 * @param includeJokers
	 *            if true, two Jokers are included in the deck; if false,
	 *            there are no Jokers in the deck.
	 */
	public Deck(boolean includeJokers) {
		if (includeJokers) {
			this.deck = new Card[54];
		} else {
			this.deck = new Card[52];
		}
		int cardCt = 0;
		for (int suit = 0; suit <= 3; suit++) {
			for (int value = 1; value <= 13; value++) {
				this.deck[cardCt] = new Card(value, Suit.getSuit(suit));
				cardCt++;
			}
		}
		if (includeJokers) {
			this.deck[52] = new Card(1, Suit.JOKER);
			this.deck[53] = new Card(2, Suit.JOKER);
		}
		this.cardsUsed = 0;
	}

	/**
	 * Constructs a poker deck of playing cards, The deck contains
	 * the usual 52 cards and can optionally contain two Jokers
	 * in addition, for a total of 54 cards. Initially the cards
	 * are in a sorted order. The shuffle() method can be called to
	 * randomize the order.
	 *
	 * @param includeJokers
	 *            if true, two Jokers are included in the deck; if false,
	 *            there are no Jokers in the deck.
	 */
	public Deck(boolean includeJokers, Suit[] suits, FaceRank[] faceRanks) {
		if (includeJokers) {
			this.deck = new Card[54];
		} else {
			this.deck = new Card[52];
		}
		int cardCt = 0;
		for (final Suit suit : suits) {
			for (final FaceRank fRank : faceRanks) {
				this.deck[cardCt] = new Card(fRank.getRank(), suit);
				cardCt++;
			}
		}
		if (includeJokers) {
			this.deck[52] = new Card(1, Suit.JOKER);
			this.deck[53] = new Card(2, Suit.JOKER);
		}
		this.cardsUsed = 0;
	}

	/**
	 * Put all the used cards back into the deck (if any), and
	 * shuffle the deck into a random order.
	 */
	public void shuffle() {
		for (int i = this.deck.length - 1; i > 0; i--) {
			final int rand = (int) (Math.random() * (i + 1));
			final Card temp = this.deck[i];
			this.deck[i] = this.deck[rand];
			this.deck[rand] = temp;
		}
		this.cardsUsed = 0;
	}

	/**
	 * As cards are dealt from the deck, the number of cards left
	 * decreases. This function returns the number of cards that
	 * are still left in the deck. The return value would be
	 * 52 or 54 (depending on whether the deck includes Jokers)
	 * when the deck is first created or after the deck has been
	 * shuffled. It decreases by 1 each time the dealCard() method
	 * is called.
	 */
	public int cardsLeft() {
		return this.deck.length - this.cardsUsed;
	}

	/**
	 * Removes the next card from the deck and return it. It is illegal
	 * to call this method if there are no more cards in the deck. You can
	 * check the number of cards remaining by calling the cardsLeft() function.
	 *
	 * @return the card which is removed from the deck.
	 * @throws IllegalStateException
	 *             if there are no cards left in the deck
	 */
	public Card dealCard() {
		if (this.cardsUsed == this.deck.length) {
			throw new IllegalStateException("No cards are left in the deck.");
		}
		this.cardsUsed++;
		return this.deck[this.cardsUsed - 1];
	}

	/**
	 * Test whether the deck contains Jokers.
	 *
	 * @return true, if this is a 54-card deck containing two jokers, or false
	 *         if
	 *         this is a 52 card deck that contains no jokers.
	 */
	public boolean hasJokers() {
		return this.deck.length == 54;
	}

}
