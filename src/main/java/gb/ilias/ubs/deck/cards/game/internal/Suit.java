/**
 *
 */
package gb.ilias.ubs.deck.cards.game.internal;

/**
 * Enum Codes for the 4 suits, plus JOKER.
 *
 * @author ilias
 * @since Oct 14, 2016
 */
public enum Suit {
	SPADES(0), HEARTS(1), DIAMONDS(2), CLUBS(3), JOKER(4), NONE(5);

	int	order;

	Suit(int o) {
		this.order = o;
	}

	public int getOrder() {
		return this.order;
	}

	public static Suit getSuit(int order) {
		for (final Suit suit : values()) {
			if (suit.getOrder() == order) {
				return suit;
			}
		}
		return Suit.NONE;
	}
}
