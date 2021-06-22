package leetcode.Tree;

public class isSubStructure {
    public static boolean isSubStructure(TreeNode A, TreeNode B)
    {
        if(A == null || B == null)
            return false;
        if(!isPartSame(A, B))
        {
            return isSubStructure(A.left,B) || isSubStructure(A.right, B);
        }
        return true;
    }
    public static boolean isPartSame(TreeNode A, TreeNode B)
    {
        if(B == null)
            return true;
        if(A == null)
            return false;
        if(A.val == B.val)
        {
            return isPartSame(A.left,B.left) && isPartSame(A.right, B.right);
        }
        return false;
    }
}
