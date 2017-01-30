package jpl.ch13.ex03;

public class Example
{
    // すべての区切られた文字列を取り出すバージョン
    public static String[] improvedDelimitedString(String from, char start, char end)
    {
        int count = 0;
        String[] tmp= new String[100];  // とりあえず上限100
        String[] result;

        int startPos = 0;
        int endPos = 0;

        while(true)
        {
            startPos = from.indexOf(start, endPos);
            endPos = from.indexOf(end, startPos);

            if (startPos == -1) // 開始文字が見つからない
            {
                break;
            }
            else if (endPos == -1) // 終了文字が見つからない
            {
                tmp[count++] = from.substring(startPos);
            }
            else // 開示文字と終了文字が見つかった
            {
                tmp[count++] = from.substring(startPos, endPos + 1);
            }
        }

        // 区切られた文字列の数分の配列を作りなおして返す
        result = new String[count];
        int i = 0;
        while(null != tmp[i])
        {
            result[i] = tmp[i];
            i++;
        }

        return result;
    }

    public static void main(String[] args)
    {
        String[] test = improvedDelimitedString("aabaaabaaaaaab", 'a', 'b');
        for (int i = 0; i < test.length; i++)
        {
            System.out.println(test[i]);
        }
    }

}