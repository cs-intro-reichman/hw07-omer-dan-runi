

public class HashTagTokenizer {
	public static void main(String[] args) {

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);

	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);
		for (int i = 0; i < dictionary.length; i++)
		{
			dictionary[i] = in.readString();
		}

		return dictionary;
	}

	public static boolean existInDictionary(String word, String []dictionary)
	{
		for (int i = 0; i < dictionary.length; i++)
		{
			if (i == 1312)
			{

			}
			if (dictionary[i].equals(word))
			{
				return true;
			}
		}
		
		return false;
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {
		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) {
            return;
        }
		
		// Convert the hashtag to lowercase for consistent comparison
		hashtag = hashtag.toLowerCase();

        int N = hashtag.length();
		String subHash = "";
		String nextHash = "";

        for (int i = 1; i <=  N; i++)
		{
			if (existInDictionary(hashtag.substring(0, i), dictionary))
			{
				subHash = hashtag.substring(0, i);
				nextHash = hashtag.substring(i, N);
				i = N + 1;

				System.out.println(subHash);
				breakHashTag(nextHash, dictionary);
			}
			else if (hashtag.substring(0, i).equals(hashtag))
			{
				System.out.println(hashtag);
			}
        }
	}			

}
