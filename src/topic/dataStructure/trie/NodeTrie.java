package topic.dataStructure.trie;

import java.util.HashMap;

public class NodeTrie {

	private PhoneBook phoneBook;
	private HashMap<String, NodeTrie> map = new HashMap<String, NodeTrie>();

	/**
	 * @return the phoneBook
	 */
	public PhoneBook getPhoneBook() {
		return phoneBook;
	}

	/**
	 * @param phoneBook
	 *            the phoneBook to set
	 */
	public void setPhoneBook(PhoneBook phoneBook) {
		this.phoneBook = phoneBook;
	}

	/**
	 * @return the map
	 */
	public HashMap<String, NodeTrie> getMap() {
		return map;
	}

	/**
	 * @param map
	 *            the map to set
	 */
	public void setMap(HashMap<String, NodeTrie> map) {
		this.map = map;
	}

}
