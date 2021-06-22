package leetcode;
/*
力扣836：矩形重叠
矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
给出两个矩形，判断它们是否重叠并返回结果。
并计算重叠矩阵的面积
 */
public class isRectangleOverlapTest836 {
    public static void main(String[] args) {
        isRectangleOverlapTest836 t1 = new isRectangleOverlapTest836();
        int[] rec1 = new int[]{0,0,1,1};
        int[] rec2 = new int[]{1,0,2,1};
        System.out.print(t1.isRectangleOverlap(rec1,rec2));
        System.out.print(t1.computerArea(-3,0,3,4,0,-1,9,2));
    }
    public boolean isRectangleOverlap(int[] rec1, int[] rec2)
    {
        if(rec2[2] <= rec1[0])
            return false;
        if(rec2[3] <= rec1[1])
            return false;
        if(rec2[1] >= rec1[3])
            return false;
        if(rec2[0] >= rec1[2])
            return false;
        return true;
    }
    public int computerArea(int A, int B, int C, int D, int E, int F, int G, int H)
    {
        int overLap = 0;
        if(G <= A || H <= B || F >= D || E >= C)
            overLap = 0;
        else
        {
            int x1 = Math.max(A, E);
            int y1 = Math.max(B, F);
            int x2 = Math.min(C, G);
            int y2 = Math.min(D, H);
            overLap = (x2-x1) * (y2-y1); //计算重叠面积
        }
        return (C-A) * (D-B) - overLap + (G-E) * (H-F);
    }
}
