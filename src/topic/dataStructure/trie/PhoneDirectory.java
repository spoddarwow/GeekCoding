package topic.dataStructure.trie;

public class PhoneDirectory {

	public static void main(String[] args) {
		NodeTrie[] trieObject = new NodeTrie[256];
		addDetails("SmattySamz",
				new PhoneBook("Sumit", "Poddar", "0468995395"), trieObject);

	}

	private static void addDetails(String nameToStore, PhoneBook phoneBook,
			NodeTrie[] trieObject) {
		NodeTrie nodeTrie = null;
		for (int i = 0; i < nameToStore.length(); i++) {
			if (i == 0) {
				if (trieObject[nameToStore.charAt(i)] == null) {
					nodeTrie = new NodeTrie();
					trieObject[nameToStore.charAt(i)] = nodeTrie;
				} else {
					nodeTrie = trieObject[nameToStore.charAt(i)];
				}
			} else {
				nodeTrie = nodeTrie.getMap().get(nameToStore.charAt(i));
				if (nodeTrie == null) {
					nodeTrie = new NodeTrie();
					nodeTrie.getMap().put(nameToStore.substring(i, i + 1),
							nodeTrie);
				}
			}

		}
System.out.println(trieObject);
	}
}
