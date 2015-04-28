package topic.design.cardsDeck;

public class Diamond implements CardTypeInterface {

	private static Diamond MY_INSTANCE = new Diamond();
	private Cards[] cardsArray = Cards.values();

	private Diamond() {
		// TODO Auto-generated constructor stub
	}

	public static Diamond getInstance() {
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
