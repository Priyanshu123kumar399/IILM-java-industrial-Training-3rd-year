class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1, map);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] postorder, int postStart, int postEnd,
                           Map<Integer, Integer> map) {

        if (preStart > preEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        if (preStart == preEnd) return root;

        int leftRoot = preorder[preStart + 1];
        int idx = map.get(leftRoot);
        int leftSize = idx - postStart + 1;

        root.left = build(preorder, preStart + 1, preStart + leftSize,
                          postorder, postStart, idx, map);

        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                           postorder, idx + 1, postEnd - 1, map);

        return root;
    }
}