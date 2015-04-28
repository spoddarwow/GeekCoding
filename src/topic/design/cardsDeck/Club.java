package topic.design.cardsDeck;

public class Club implements CardTypeInterface {

	private static Club MY_INSTANCE = new Club();
	private Cards[] cardsArray = Cards.values();

	private Club() {

	}

	public static Club getInstance() {
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
