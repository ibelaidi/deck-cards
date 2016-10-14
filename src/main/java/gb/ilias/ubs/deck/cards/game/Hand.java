/**
 *
 */
package gb.ilias.ubs.deck.cards.game;

import java.util.ArrayList;
import java.util.List;

/**
 * Hand represents a hand of cards. The
 * cards belong to the class Card. A hand is empty when it
 * is created, and any number of cards can be added to it.
 *
 * @author ilias
 * @since Oct 14, 2016
 */
public class Hand {

	private List<Card>	hand;

	/**
	 * Create a hand that is initially empty.
	 */
	public Hand() {
		this.hand = new ArrayList<Card>();
	}

	/**
	 * Remove all cards from the hand, leaving it empty.
	 */
	public void clear() {
		this.hand.clear();
	}

	/**
	 * Add a card to the hand. It is added at the end of the current hand.
	 *
	 * @param c
	 *            the non-null card to be added.
	 * @throws NullPointerException
	 *             if the parameter c is null.
	 */
	public void addCard(Card c) {
		if (c == null) {
			throw new NullPointerException("Can't add a null card to a hand.");
		}
		this.hand.add(c);
	}

	/**
	 * Remove a card from the hand, if present.
	 *
	 * @param c
	 *            the card to be removed. If c is null or if the card is not in
	 *            the hand, then nothing is done.
	 */
	public void removeCard(Card c) {
		this.hand.remove(c);
	}

	/**
	 * Remove the card in a specified position from the hand.
	 *
	 * @param position
	 *            the position of the card that is to be removed, where
	 *            positions are starting from zero.
	 * @throws IllegalArgumentException
	 *             if the position does not exist in
	 *             the hand, that is if the position is less than 0 or greater
	 *             than
	 *             or equal to the number of cards in the hand.
	 */
	public void removeCard(int position) {
		if (position < 0 || position >= this.hand.size()) {
			throw new IllegalArgumentException("Position does not exist in hand: " + position);
		}
		this.hand.remove(position);
	}

	/**
	 * Returns the number of cards in the hand.
	 */
	public int getCardCount() {
		return this.hand.size();
	}

	/**
	 * Gets the card in a specified position in the hand. (Note that this card
	 * is not removed from the hand!)
	 *
	 * @param position
	 *            the position of the card that is to be returned
	 * @throws IllegalArgumentException
	 *             if position does not exist in the hand
	 */
	public Card getCard(int position) {
		if (position < 0 || position >= this.hand.size()) {
			throw new IllegalArgumentException("Position does not exist in hand: " + position);
		}
		return this.hand.get(position);
	}

	/**
	 * Sorts the cards in the hand so that cards of the same suit are
	 * grouped together, and within a suit the cards are sorted by value.
	 * Note that aces are considered to have the lowest value, 1.
	 */
	public void sortBySuit() {
		final ArrayList<Card> newHand = new ArrayList<Card>();
		while (this.hand.size() > 0) {
			int pos = 0;
			Card c = this.hand.get(0);
			for (int i = 1; i < this.hand.size(); i++) {
				final Card c1 = this.hand.get(i);
				if (c1.getSuit().getOrder() < c.getSuit().getOrder() || c1.getSuit() == c.getSuit()
						&& c1.getValue() < c.getValue()) {
					pos = i;
					c = c1;
				}
			}
			this.hand.remove(pos);
			newHand.add(c);
		}
		this.hand = newHand;
	}

	/**
	 * Sorts the cards in the hand so that cards of the same value are
	 * grouped together. Cards with the same value are sorted by suit.
	 * Note that aces are considered to have the lowest value, 1.
	 */
	public void sortByValue() {
		final ArrayList<Card> newHand = new ArrayList<Card>();
		while (this.hand.size() > 0) {
			int pos = 0;
			Card c = this.hand.get(0);
			for (int i = 1; i < this.hand.size(); i++) {
				final Card c1 = this.hand.get(i);
				if (c1.getValue() < c.getValue() || c1.getValue() == c.getValue()
						&& c1.getSuit().getOrder() < c.getSuit().getOrder()) {
					pos = i;
					c = c1;
				}
			}
			this.hand.remove(pos);
			newHand.add(c);
		}
		this.hand = newHand;
	}

}
