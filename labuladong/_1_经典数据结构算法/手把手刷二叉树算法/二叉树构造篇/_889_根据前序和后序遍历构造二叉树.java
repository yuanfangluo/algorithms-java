package labuladong._1_经典数据结构算法.手把手刷二叉树算法.二叉树构造篇;

import java.util.HashMap;

import labuladong.Base.TreeNode;

public class _889_根据前序和后序遍历构造二叉树 {
    // 1、首先把前序遍历结果的第一个元素或者后序遍历结果的最后一个元素确定为根节点的值。
    // 2、然后把前序遍历结果的第二个元素作为左子树的根节点的值。
    // 3、在后序遍历结果中寻找左子树根节点的值，从而确定了左子树的索引边界，进而确定右子树的索引边界，递归构造左右子树即可。

    // 存储 postorder 中值到索引的映射
    HashMap<Integer, Integer> valToIndex = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            valToIndex.put(postorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    // 定义：根据 preorder[preStart..preEnd] 和 postorder[postStart..postEnd]
    // 构建二叉树，并返回根节点。
    TreeNode build(int[] preorder, int preStart, int preEnd,
            int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }
        // 数组中只有一个元素时，直接构建出这个节点。
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        // root 节点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preStart];

        // 我们假设前序遍历的第二个元素是左子树的根节点，但实际上左子树有可能是空指针，那么这个元素就应该是右子树的根节点。
        // 由于这里无法确切进行判断，所以导致了最终答案的不唯一。

        // root.left 的值是前序遍历第二个元素
        int leftRootVal = preorder[preStart + 1];

        // 通过前序和后序遍历构造二叉树的关键在于通过左子树的根节点

        // 确定 preorder 和 postorder 中左右子树的元素区间

        // leftRootVal 在后序遍历数组中的索引
        int index = valToIndex.get(leftRootVal);

        // 左子树的元素个数
        int leftSize = index - postStart + 1;

        // 先构造出当前根节点
        TreeNode root = new TreeNode(rootVal);

        // 递归构造左右子树
        // 根据左子树的根节点索引和元素个数推导左右子树的索引边界
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                postorder, postStart, index);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                postorder, index + 1, postEnd - 1);

        return root;
    }

    // 代码和前两道题非常类似，我们可以看着代码思考一下，为什么通过前序遍历和后序遍历结果还原的二叉树可能不唯一呢？
    // 关键在这一句：int leftRootVal = preorder[preStart + 1];
    // 我们假设前序遍历的第二个元素是左子树的根节点，但实际上左子树有可能是空指针，那么这个元素就应该是右子树的根节点。
    // 由于这里无法确切进行判断，所以导致了最终答案的不唯一。

}
