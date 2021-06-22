package leetcode.Offer;

public class isSubStructure_26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null){
            return false;
        }
        if(!isParam(A, B)){
            return isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }
        return true;
    }

    public boolean isParam(TreeNode A, TreeNode B){
        if(B == null){
            return true;
        }
        if(A == null){
            return false;
        }
        if(A.val == B.val){
            return isParam(A.left, B.left) && isParam(A.right, B.right);
        }
        return  false;
    }
}
