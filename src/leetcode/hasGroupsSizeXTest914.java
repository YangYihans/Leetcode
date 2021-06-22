package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
914.卡牌分组
给定一副牌，每张牌上都写着一个整数。
此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
每组都有 X 张牌。
组内所有的牌上都写着相同的整数。
仅当你可选的 X >= 2 时返回 true。
 */
public class hasGroupsSizeXTest914 {
    public static void main(String[] args) {
        hasGroupsSizeXTest914 t1 = new hasGroupsSizeXTest914();
        int[] deck = new int[]{1,1,2,2,2,2};
        System.out.println(t1.hasGroupsSizeX(deck));
    }
    public boolean hasGroupsSizeX(int[] deck)
    {
        int len = deck.length;
        if(len <= 1)
            return false;
        int [] nums = new int[10000];
        int max = 0;
        for(int i = 0; i < len; i++)
        {
            nums[deck[i]]++;
            max = Math.max(max,nums[deck[i]]);
        }
        int times = 2;
        while(times <= max)
        {
            int loopTimes = 0;
            for(int i = 0; i < nums.length; i++)
            {
                if(nums[i] % times != 0)
                    break;
                loopTimes++;
            }
            if(loopTimes == nums.length)
                return true;
            times++;
        }
        return false;

    }
}
