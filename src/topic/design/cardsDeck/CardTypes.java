package topic.design.cardsDeck;

public enum CardTypes {

	SPADE(13, Spade.getInstance()), HEART(13, Heart.getInstance()), DIAMOND(13,
			Diamond.getInstance()), CLUB(13, Club.getInstance());

	private int count;
	private CardTypeInterface type;

	CardTypes(int count, CardTypeInterface type) {
		this.count = count;
		this.type = type;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return the type
	 */
	public CardTypeInterface getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(CardTypeInterface type) {
		this.type = type;
	}

}
