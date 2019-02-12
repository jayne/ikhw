package trees.test;

import trees.TreeNode;

/**
 * Created by jaynehsu on 2/7/19.
 */
public class BuildBSTFromArray {
    public static void main(String[] args) {

        int[] a = {1, 2, 4, 5, 6, 7};
        TreeNode result = build_balanced_bst(a);
        System.out.println(result.val);
    }

    static TreeNode build_balanced_bst(int[] a) {
        return buildTree(a, 0, a.length - 1);
    }

    private static TreeNode buildTree(int[] a, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (end - start) / 2 + start;
        TreeNode root = new TreeNode(a[mid]);
        root.left_ptr = buildTree(a, start, mid - 1);
        root.right_ptr = buildTree(a, mid + 1, end);
        return root;
    }
}
