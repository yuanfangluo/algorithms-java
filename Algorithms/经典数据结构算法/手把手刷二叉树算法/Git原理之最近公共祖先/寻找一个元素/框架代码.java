package Algorithms.经典数据结构算法.手把手刷二叉树算法.Git原理之最近公共祖先.寻找一个元素;

import Algorithms.Base.TreeNode;

public class 框架代码 {
    // 定义：在以 root 为根的二叉树中寻找值为 val 的节点
    TreeNode find1(TreeNode root, int val) {
        // base case
        if (root == null) {
            return null;
        }
        // 看看 root.val 是不是要找的
        if (root.val == val) {
            return root;
        }

        // root 不是目标节点，那就去左子树找
        TreeNode left = find1(root.left, val);
        if (left != null) {
            return left;
        }
        // 左子树找不着，那就去右子树找
        TreeNode right = find1(root.right, val);
        if (right != null) {
            return right;
        }
        // 实在找不到了
        return null;
    }

    // 这段代码也可以达到目的，但是实际运行的效率会低一些，
    // 原因也很简单，如果你能够在左子树找到目标节点，还有没有必要去右子树找了？
    // 没有必要。但这段代码还是会去右子树找一圈，所以效率相对差一些。
    TreeNode find2(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        // 前序位置
        if (root.val == val) {
            return root;
        }
        // root 不是目标节点，去左右子树寻找
        TreeNode left = find2(root.left, val);
        TreeNode right = find2(root.right, val);
        // 看看哪边找到了
        return left != null ? left : right;
    }

    // 把对 root.val 的判断从前序位置移动到后序位置：
    // 这段代码相当于你先去左右子树找，然后才检查 root，依然可以到达目的，但是效率会进一步下降。
    // 因为这种写法必然会遍历二叉树的每一个节点。
    TreeNode find3(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        // 先去左右子树寻找
        TreeNode left = find3(root.left, val);
        TreeNode right = find3(root.right, val);
        // 后序位置，看看 root 是不是目标节点
        if (root.val == val) {
            return root;
        }
        // root 不是目标节点，再去看看哪边的子树找到了
        return left != null ? left : right;
    }

    // 定义：在以 root 为根的二叉树中寻找值为 val1 或 val2 的节点
    TreeNode find(TreeNode root, int val1, int val2) {
        // base case
        if (root == null) {
            return null;
        }
        // 前序位置，看看 root 是不是目标值
        if (root.val == val1 || root.val == val2) {
            return root;
        }
        // 去左右子树寻找
        TreeNode left = find(root.left, val1, val2);
        TreeNode right = find(root.right, val1, val2);
        // 后序位置，已经知道左右子树是否存在目标值
        
        return left != null ? left : right;
    }
}
