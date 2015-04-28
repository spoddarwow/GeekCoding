package topic.design.cardsDeck;

public enum Cards {

	Card_2("2"), Card_3("3"), Card_4("4"), Card_5("5"), Card_6("6"), Card_7("7"), Card_8(
			"8"), Card_9("9"), Card_10("10"), Card_A("A"), Card_J("J"), Card_Q(
			"Q"), Card_K("K");

	private String value;

	Cards(String value) {
		this.value = value;

	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
