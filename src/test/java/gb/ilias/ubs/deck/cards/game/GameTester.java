/**
 *
 */
package gb.ilias.ubs.deck.cards.game;

import gb.ilias.ubs.deck.cards.game.internal.FaceRank;
import gb.ilias.ubs.deck.cards.game.internal.Suit;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tester class
 *
 * @author ilias
 * @since Oct 14, 2016
 */
public class GameTester {

	@Test
	public void gameHEARTSTest() {
		// Suits
		final Suit hearts = Suit.HEARTS;
		final Suit clubs = Suit.CLUBS;
		final Suit spades = Suit.SPADES;
		final Suit diamonds = Suit.DIAMONDS;
		// Ranks
		final FaceRank queen = FaceRank.Queen;
		final FaceRank king = FaceRank.King;
		final FaceRank jack = FaceRank.Jack;
		final FaceRank ace = FaceRank.Ace;
		// Possible Suits
		final Suit[] suits = { hearts, spades, clubs, diamonds };
		// Possible Ranks
		final FaceRank[] ranks = { ace, FaceRank.Ten, jack, queen, king, FaceRank.Deuce, FaceRank.Three,
				FaceRank.Four, FaceRank.Five, FaceRank.Six, FaceRank.Nine, FaceRank.Nine, FaceRank.Nine };
		//
		final Deck deck = new Deck(false, suits, ranks);
		final Card cardHearts = deck.dealCard();
		//
		Assert.assertTrue("Expecting Hearts: ", cardHearts.getSuit().equals(Suit.HEARTS));
	}

	@Test
	public void gameSPADESTest() {
		// Suits
		final Suit hearts = Suit.HEARTS;
		final Suit clubs = Suit.CLUBS;
		final Suit spades = Suit.SPADES;
		final Suit diamonds = Suit.DIAMONDS;
		// Ranks
		final FaceRank queen = FaceRank.Queen;
		final FaceRank king = FaceRank.King;
		final FaceRank jack = FaceRank.Jack;
		final FaceRank ace = FaceRank.Ace;
		// Possible Suits
		final Suit[] suits = { spades, hearts, clubs, diamonds };
		// Possible Ranks
		final FaceRank[] ranks = { ace, FaceRank.Ten, jack, queen, king, FaceRank.Deuce, FaceRank.Three,
				FaceRank.Four, FaceRank.Five, FaceRank.Six, FaceRank.Nine, FaceRank.Nine, FaceRank.Nine };
		//
		final Deck deck = new Deck(false, suits, ranks);
		final Card cardSpades = deck.dealCard();
		//
		Assert.assertTrue("Expecting Spades: ", cardSpades.getSuit().equals(Suit.SPADES));
	}

	@Test
	public void gameMultiTest() {
		// Suits
		final Suit hearts = Suit.HEARTS;
		final Suit clubs = Suit.CLUBS;
		final Suit spades = Suit.SPADES;
		final Suit diamonds = Suit.DIAMONDS;
		// Ranks
		final FaceRank queen = FaceRank.Queen;
		final FaceRank king = FaceRank.King;
		final FaceRank jack = FaceRank.Jack;
		final FaceRank ace = FaceRank.Ace;
		// Possible Suits
		final Suit[] suits = { diamonds, hearts, clubs, spades };
		// Possible Ranks
		final FaceRank[] ranks = { ace, FaceRank.Ten, jack, queen, king, FaceRank.Deuce, FaceRank.Three,
				FaceRank.Four, FaceRank.Five, FaceRank.Six, FaceRank.Nine, FaceRank.Nine, FaceRank.Nine };
		//
		final Deck deck = new Deck(false, suits, ranks);
		final Card card1 = deck.dealCard();
		//
		deck.shuffle();
		final Card card2 = deck.dealCard();
		//
		deck.shuffle();
		final Card card3 = deck.dealCard();
		//
		Assert.assertFalse("Expecting Different Cards: ", card1.getSuit().equals(card2.getSuit()));
		Assert.assertFalse("Expecting Different Cards: ", card1.getSuit().equals(card3.getSuit()));
	}
}
