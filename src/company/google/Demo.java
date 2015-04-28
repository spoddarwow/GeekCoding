package company.google;

public class Demo {

	public static void main(String[] args) {
		System.out.println(func("sumit", 'u', 'u'));

	}

	static int func(String s, char a, char b) {
		if (s.isEmpty())
			return -1;
		char[] strArray = s.toCharArray();
		int i = -1;
		int aIndex = 0;
		int bIndex = 0;
		while (aIndex == 0 && bIndex == 0 && i < strArray.length) {
			if (strArray[i] == a)
				aIndex = i;
			if (strArray[i] == b)
				bIndex = i;
			i++;

		}
		if (aIndex != 0) {
			if (bIndex == 0)
				return aIndex;
			else {
				if (bIndex != 0)
					return bIndex;
				else
					return -1;

			}

		}
		return -2;
	}

}
