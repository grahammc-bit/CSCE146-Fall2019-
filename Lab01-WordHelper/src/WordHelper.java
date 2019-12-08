//Written by Matthew Graham
public class WordHelper {


    public static String[] sortByVowels(String [] words)
    {
        String [] temp = new String [words.length];
            for (int i=0;i<words.length;i++)
            {
                temp [i] = words [i];
            }
            return temp;

    }

    public static String[] sortByConsonants(String [] words)
    {
        String [] temp = new String [words.length];
        for (int i=0;i<words.length-1;i++)
        {
            temp [i] = words[i];
        }

        for (int i=0;i<words.length-1;i++)
        {
            for (int j=0;j<words.length;j++)
            {

            }
        }

        return temp;
    }


    public static String[] sortByLength(String [] words)
    {

        String [] temp = new String [words.length];
        for (int i=0;i<words.length;i++)
        {
            temp [i] = words [i];
        }
        for(int i = 0;i<temp.length-1;i++)
        {
            for(int j=0;j<temp.length-1;j++) {
               
                if (temp[j].length() > temp[j + 1].length()) {
                    String ret = temp[j];
                    temp[j] = temp[j + 1];
                    temp[j + 1] = ret;

                }
            }
        }
        return temp;
    }

}
