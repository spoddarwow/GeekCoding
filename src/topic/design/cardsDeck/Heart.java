package topic.design.cardsDeck;

public class Heart implements CardTypeInterface {

	private static Heart MY_INSTANCE = new Heart();
	private Cards[] cardsArray = Cards.values();

	private Heart() {
		// TODO Auto-generated constructor stub
	}

	public static Heart getInstance() {
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
