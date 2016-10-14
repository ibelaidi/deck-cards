/**
 *
 */
package gb.ilias.ubs.deck.cards.game;

import gb.ilias.ubs.deck.cards.game.internal.FaceRank;
import gb.ilias.ubs.deck.cards.game.internal.Suit;

/**
 * Card represents a playing card from a
 * standard Poker deck, including Jokers.
 *
 * @author ilias
 * @since Oct 14, 2016
 */
public class Card {

	/**
	 */
	private final Suit	suit;

	/**
	 * The card's value. For a normal card, this is one of the values
	 * 1 through 13, with 1 representing ACE. For a JOKER, the value
	 * can be anything. The value cannot be changed after the card
	 * is constructed.
	 */
	private final int	value;

	/**
	 * Creates a Joker, with 1 as the associated value.
	 */
	public Card() {
		this.suit = Suit.JOKER;
		this.value = 1;
	}

	/**
	 * Creates a card with a specified suit and value.
	 *
	 * @param theValue
	 *            the value of the new card.
	 * @param theSuit
	 *            the suit of the new card. This must be one of the values
	 *            Suit.SPADES, Suit.HEARTS, Suit.DIAMONDS, Suit.CLUBS, or
	 *            Suit.JOKER.
	 * @throws IllegalArgumentException
	 *             if the parameter values are not in the
	 *             permissible ranges
	 */
	public Card(int theValue, Suit theSuit) {
		if (theSuit != Suit.SPADES && theSuit != Suit.HEARTS && theSuit != Suit.DIAMONDS
				&& theSuit != Suit.CLUBS && theSuit != Suit.JOKER) {
			throw new IllegalArgumentException("Illegal playing card suit");
		}
		if (theSuit != Suit.JOKER && (theValue < 1 || theValue > 13)) {
			throw new IllegalArgumentException("Illegal playing card value");
		}
		this.value = theValue;
		this.suit = theSuit;
	}

	/**
	 * Returns the suit of this card.
	 *
	 * @returns the suit, which is one of the constants Suit.SPADES,
	 *          Suit.HEARTS, Suit.DIAMONDS, Suit.CLUBS, or Suit.JOKER
	 */
	public Suit getSuit() {
		return this.suit;
	}

	/**
	 * Returns the value of this card.
	 *
	 * @return the value, which is one of the numbers 1 through 13, inclusive
	 *         for
	 *         a regular card, and which can be any value for a Joker.
	 */
	public int getValue() {
		return this.value;
	}

	/**
	 * Returns a String representation of the card's suit.
	 *
	 * @return one of the strings "Spades", "Hearts", "Diamonds", "Clubs"
	 *         or "Joker".
	 */
	public String getSuitAsString() {
		switch (this.suit) {
			case SPADES:
				return Suit.SPADES.name();
			case HEARTS:
				return Suit.HEARTS.name();
			case DIAMONDS:
				return Suit.DIAMONDS.name();
			case CLUBS:
				return Suit.CLUBS.name();
			default:
				return Suit.JOKER.name();
		}
	}

	/**
	 * Returns a String representation of the card's value.
	 *
	 * @return for a regular card, one of the strings "Ace", "2",
	 *         "3", ..., "10", "Jack", "Queen", or "King". For a Joker, the
	 *         string is always numerical.
	 */
	public String getValueAsString() {
		if (this.suit.equals(Suit.JOKER)) {
			return "" + this.value;
		}
		return FaceRank.getFaceRank(this.value).name();
	}

	/**
	 * Returns a string representation of this card, including both
	 * its suit and its value (except that for a Joker with value 1,
	 * the return value is just "Joker").
	 */
	@Override
	public String toString() {
		if (this.suit.equals(Suit.JOKER)) {
			if (this.value == 1) {
				return Suit.JOKER.name();
			} else {
				return Suit.JOKER.name() + " #" + this.value;
			}
		} else {
			return this.getValueAsString() + " of " + this.getSuitAsString();
		}
	}

}
