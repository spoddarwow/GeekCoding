package topic.design.cardsDeck;

public class CardDeck {
	private static CardDeck MY_INSTANCE = new CardDeck();
	private CardTypes[] cards = CardTypes.values();

	private CardDeck() {
		// TODO Auto-generated constructor stub
	}

	public static CardDeck getInstance() {
		return MY_INSTANCE;
	}

	/**
	 * @return the cards
	 */
	public CardTypes[] getCards() {
		return cards;
	}

	/**
	 * @param cards
	 *            the cards to set
	 */
	public void setCards(CardTypes[] cards) {
		this.cards = cards;
	}

}
