package leetcode.Hash;

import java.util.HashMap;

/*
力扣1160：拼写单词
给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
注意：每次拼写时，chars 中的每个字母都只能用一次。
返回词汇表 words 中你掌握的所有单词的 长度之和。
 */
public class countCharactersTest1160 {
    public static void main(String[] args) {
        countCharactersTest1160 t1 = new countCharactersTest1160();
        String[] words = new String[]{"cat","bt","hat","tree"};
        String chars = "atach";
        System.out.print(t1.countCharacters(words,chars));
    }

    /**
     * HashMap的等于赋值是把两个值指向同一个地址空间，如果是要创建新的对象，使用对象.clone的方式。
     * @param words
     * @param chars
     * @return
     */
    public int countCharacters(String[] words, String chars) {
        HashMap<Character, Integer> hashMap = new HashMap();

        int count = 0;
        for (int i = 0; i < chars.length(); i++) {
            int index = 1;
            if(hashMap.containsKey(chars.charAt(i)))
            {
                int x = hashMap.get(chars.charAt(i));
                hashMap.put(chars.charAt(i), x+1);
                continue;
            }
            hashMap.put(chars.charAt(i), index);
        }

        for (int i = 0; i < words.length; i++)
        {
            HashMap<Character,Integer> hashTemp = (HashMap<Character, Integer>) hashMap.clone();
            String temp = words[i];
            int j = 0;
            for(; j < temp.length(); j++)
            {
                if(hashTemp.containsKey(temp.charAt(j)) && hashTemp.get(temp.charAt(j)) > 0)
                {
                    hashTemp.put(temp.charAt(j),hashTemp.get(temp.charAt(j))-1);
                    continue;
                }

                else
                    break;
            }
            if(j == temp.length())
                count = count + temp.length();
        }
        return count;
    }

    public int countCharacters1(String[] words, String chars)
    {
        int[] chars_count = count(chars);
        int res = 0;
        for(String word : words)
        {
            int [] word_count = count(word); //统计每个单词中字母的个数
            if(contains(chars_count,word_count))
            {
                res = res + word.length();
            }
        }
        return res;
    }

    //检查字母表中字母出现的次数是否覆盖单词字母出现的次数
    public boolean contains(int[] char_count, int[] word_count)
    {
        for(int i = 0; i < 26; i++)
        {
            if(char_count[i] < word_count[i])
                return false;
        }
        return true;
    }
    //统计26个字母出现的次数

    /**
     * 对于只有26个小写字母的，使用一个int[26]的数组，通过c-'a'来确定数组的下标。
     * 这个是字符串计数问题的常用技巧
     * @param word 传入的字符串
     * @return 统计字符串中字符个数的数组
     */
    public int[] count(String word) {
        int[] counter = new int[26]; //仅有小写字母，所以是26
        for (int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            counter[c-'a']++;
        }
        return counter;
    }

}
