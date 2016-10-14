/**
 *
 */
package gb.ilias.ubs.deck.cards.game.internal;

/**
 * Card's faces
 *
 * @author ilias
 * @since Oct 14, 2016
 */
public enum FaceRank {

	Ace(1), Deuce(2), Nine(9), Eight(8), Seven(7), Six(6), Five(5), Four(4), Three(3), Ten(10), Jack(11), Queen(
			12), King(13);

	int	rank;

	FaceRank(int r) {
		this.rank = r;
	}

	int getRank() {
		return this.rank;
	}

	public static FaceRank getFaceRank(int fRank) {
		for (final FaceRank faceRank : values()) {
			if (faceRank.getRank() == fRank) {
				return faceRank;
			}
		}
		return FaceRank.King;
	}
}
