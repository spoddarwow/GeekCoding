package topic.design.cardsDeck;

public class Spade implements CardTypeInterface {

	private static Spade MY_INSTANCE = new Spade();
	private Cards[] cardsArray = Cards.values();

	private Spade() {
		// TODO Auto-generated constructor stub
	}

	public static Spade getInstance() {
		return MY_INSTANCE;
	}

	/**
	 * @return the cardsArray
	 */
	public Cards[] getCardsArray() {
		return cardsArray;
	}

	/**
	 * @param cardsArray
	 *            the cardsArray to set
	 */
	public void setCardsArray(Cards[] cardsArray) {
		this.cardsArray = cardsArray;
	}
}
