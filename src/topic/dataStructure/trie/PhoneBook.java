package topic.dataStructure.trie;

public class PhoneBook {

	private String firstName;
	private String lastName;
	private String phoneNo;

	/**
	 * @param firstName
	 * @param lastName
	 * @param phoneNo
	 */
	public PhoneBook(String firstName, String lastName, String phoneNo) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}

	/**
	 * @param phoneNo
	 *            the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

}
