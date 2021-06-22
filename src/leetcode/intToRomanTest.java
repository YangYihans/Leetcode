package leetcode;
/*
12.整数转罗马数字
 */
public class intToRomanTest {
    public static void main(String[] args) {
        intToRomanTest t1 = new intToRomanTest();
        System.out.println(t1.intTORoman(10));
    }
    public String intTORoman(int num)
    {
        String res = "";
        int thousand = 0;
        int hundred = 0;
        int ten = 0;
        int single = 0;
        if(num/1000>0)
        {
            thousand = num/1000;
            for(int i = 0; i < thousand; i++)
            {
                res = res + "M";
            }
        }
       if((num-thousand*1000)/100>0)
       {
           hundred = (num-thousand*1000)/100;
           if(hundred <= 3)
           {
               for(int i = 0 ; i < hundred; i++)
               {
                   res = res +"C";
               }
           }
           if(hundred == 4)
               res = res + "CD";
           if(hundred == 5)
               res = res + "D";
           if(hundred>5 && hundred<9)
           {
               res = res + "D";
               for(int i = 6; i <= hundred; i++)
               {
                   res = res + "C";
               }
           }
           if(hundred == 9)
               res = res + "CM";
       }
       if((num - thousand*1000 -hundred*100)>=10)
       {
           ten = (num-thousand*1000-hundred*100)/10;
           if(ten <= 3)
           {
               for(int i = 0; i < ten; i++)
               {
                   res = res + "X";
               }
           }
           if(ten == 4)
               res = res + "XL";
           if(ten == 5)
               res = res + "L";
           if(ten > 5 && ten < 9)
           {
               res = res + "L";
               for(int i = 6; i <= ten; i++)
               {
                   res = res + "X";
               }
           }
           if(ten == 9)
           {
               res = res + "XC";
           }
       }
        int single1 = num - thousand * 1000 - hundred * 100 - ten * 10;
        if(single1 >0)
       {
           single = single1;
           if(single <= 3)
           {
               for(int i = 0; i < single; i++)
               {
                   res = res + "I";
               }
           }
           if(single == 4)
               res = res + "IV";
           if(single == 5)
               res = res + "V";
           if(single>5 && single<9)
           {
               res = res + "V";
               for(int i = 6; i <= single; i++)
               {
                   res = res + "I" ;
               }
           }
           if(single == 9)
               res = res + "IX";
       }
        return res;
    }
}
