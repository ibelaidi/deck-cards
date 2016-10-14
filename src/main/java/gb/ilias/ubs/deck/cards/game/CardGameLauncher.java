/**
 *
 */
package gb.ilias.ubs.deck.cards.game;

import gb.ilias.ubs.deck.cards.game.utils.InputIOUtils;

/**
 * Main launcher for this game
 *
 * @author ilias
 * @since Oct 14, 2016
 */
public class CardGameLauncher {

	public static void main(String[] args) {

		System.out.println("Game HighLow. A card is dealt from a deck of cards.");
		System.out.println("You have to predict whether the next card will be");
		System.out.println("higher or lower.");
		System.out.println();

		int gamesPlayed = 0;
		int sumOfScores = 0;
		double averageScore;
		boolean playAgain;

		do {
			int scoreThisGame;
			scoreThisGame = play();
			sumOfScores += scoreThisGame;
			gamesPlayed++;
			System.out.print("Play again? ");
			playAgain = InputIOUtils.getlineBoolean();
		}
		while (playAgain);

		averageScore = (double) sumOfScores / gamesPlayed;

		System.out.println();
		System.out.println("You played " + gamesPlayed + " games.");
		System.out.printf("Your average score was %1.3f.\n", averageScore);

	}

	/**
	 * Lets the user play one game of HighLow,
	 */
	private static int play() {

		final Deck deck = new Deck();
		Card currentCard;
		Card nextCard;
		int correctGuesses;
		char guess; // The user's guess. 'H' if the user predicts that
		// the next card will be higher, 'L' if the user
		// predicts that it will be lower.

		deck.shuffle(); // Shuffle the deck into a random order before
		// starting the game.

		correctGuesses = 0;
		currentCard = deck.dealCard();
		System.out.println("The first card is the " + currentCard);

		while (true) {
			/* Get the user's prediction, 'H' or 'L' (or 'h' or 'l'). */
			System.out.print("Will the next card be higher (H) or lower (L)?  ");
			do {
				guess = InputIOUtils.getlineChar();
				guess = Character.toUpperCase(guess);
				if (guess != 'H' && guess != 'L') {
					System.out.print("Please respond with H or L:  ");
				}
			}
			while (guess != 'H' && guess != 'L');
			nextCard = deck.dealCard();
			System.out.println("The next card is " + nextCard);

			if (nextCard.getValue() == currentCard.getValue()) {
				System.out.println("The value is the same as the previous card.");
				System.out.println("You lose on ties.  Sorry!");
				break;
			} else if (nextCard.getValue() > currentCard.getValue()) {
				if (guess == 'H') {
					System.out.println("Your prediction was correct.");
					correctGuesses++;
				} else {
					System.out.println("Your prediction was incorrect.");
					break; // End the game.
				}
			} else { // nextCard is lower
				if (guess == 'L') {
					System.out.println("Your prediction was correct.");
					correctGuesses++;
				} else {
					System.out.println("Your prediction was incorrect.");
					break; // End the game.
				}
			}

			/*
			 * To set up for the next iteration of the loop, the nextCard
			 * becomes the currentCard, since the currentCard has to be
			 * the card that the user sees, and the nextCard will be
			 * set to the next card in the deck after the user makes
			 * his prediction.
			 */
			currentCard = nextCard;
			System.out.println();
			System.out.println("The card is " + currentCard);

		}

		System.out.println();
		System.out.println("The game is over.");
		System.out.println("You made " + correctGuesses + " correct predictions.");
		System.out.println();

		return correctGuesses;

	}
}
