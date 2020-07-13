package main.java.com.leetcode;

public class SameTree {

    public static void main(String[] args) {
        /**
         * Creation of tree not implemented.
         */
        SameTree obj = new SameTree();
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(5);
        t1.right = new TreeNode(7);
        t2.right = new TreeNode(7);
        t1.left = new TreeNode(4);
        t2.left = new TreeNode(4);
        System.out.println(obj.isSameTree(t1,t2));
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)
            return true;
        else if(p==null || q==null)
            return false;
        else{
            if(p.val==q.val)
                return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
            else
                return false;
        }
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {

    }
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
    }
}
