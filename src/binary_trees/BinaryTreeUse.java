package binary_trees;

import java.util.*;

public class BinaryTreeUse {

    // MANUALLY CREATING TREE
    private static BinaryTree<Integer> getTree() {
        BinaryTree<Integer> root = new BinaryTree<>(10);
        BinaryTree<Integer> rootLeft = new BinaryTree<>(5);
        BinaryTree<Integer> rootRight = new BinaryTree<>(20);
        root.left = rootLeft;
        root.right = rootRight;
        BinaryTree<Integer> rootLeftLeft = new BinaryTree<>(3);
        BinaryTree<Integer> rootLeftRight = new BinaryTree<>(2);
        BinaryTree<Integer> rootRightRight = new BinaryTree<>(11);
        BinaryTree<Integer> rootRightLeft = new BinaryTree<>(1);
        rootLeft.left = rootLeftLeft;
        rootLeft.right = rootLeftRight;
        rootRight.right = rootRightRight;
        rootRight.left = rootRightLeft;
        return root;
    }


    // TAKING INPUT FROM USER

    // Takes input for creating a binary tree
    // Time Complexity: O(N), Space Complexity: O(N)
    public static BinaryTree<Integer> takeInput(int data, boolean isRoot, boolean isLeft) {
        Scanner s = new Scanner(System.in);
        if (isRoot) {
            System.out.println("Enter Root Data");
        } else {
            if (isLeft) {
                System.out.println("Enter Left Child of " + data);
            } else {
                System.out.println("Enter Right Child of " + data);
            }
        }
        System.out.println();
        int rootValue = s.nextInt();
        if (rootValue == -1) {
            return null;
        }
        BinaryTree<Integer> root = new BinaryTree<>(rootValue);
        BinaryTree<Integer> leftChild = takeInput(rootValue, false, true);
        BinaryTree<Integer> rightChild = takeInput(rootValue, false, false);

        root.left = leftChild;
        root.right = rightChild;

        return root;
    }

    public static BinaryTree<Integer> takeInputOptimized() {
        Scanner s = new Scanner(System.in);
        Queue<BinaryTree<Integer>> queue = new LinkedList<>();
        System.out.println("Enter Root Data");
        int rootData = s.nextInt();
        if (rootData == -1) {
            return null;
        }
        BinaryTree<Integer> root = new BinaryTree<>(rootData);
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTree<Integer> node = queue.poll();
            System.out.println("Enter Left Child of " + node.value);
            int left = s.nextInt();
            if (left != -1) {
                BinaryTree<Integer> leftChild = new BinaryTree<>(left);
                node.left = leftChild;
                queue.offer(leftChild);
            }

            System.out.println("Enter Right Child of " + node.value);
            int right = s.nextInt();
            if (right != -1) {
                BinaryTree<Integer> rightChild = new BinaryTree<>(right);
                node.right = rightChild;
                queue.offer(rightChild);
            }
        }
        return root;
    }


    // TREE PRINTING METHODS

    // Preorder Traversal
    // Time Complexity: O(N), Space Complexity: O(N)
    public static void printPreOrder(BinaryTree<Integer> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + ": ");
        if (root.left != null) {
            System.out.print("L:" + root.left.value + ",");
        }
        if (root.right != null) {
            System.out.print("R:" + root.right.value + ",");
        }
        System.out.println();
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    // Postorder Traversal
    // Time Complexity: O(N), Space Complexity: O(N)
    public static void printPostOrder(BinaryTree<Integer> root) {
        if (root == null) {
            return;
        }
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.value + ": ");
        if (root.left != null) {
            System.out.print("L:" + root.left.value + ",");
        }
        if (root.right != null) {
            System.out.print("R:" + root.right.value + ",");
        }
        System.out.println();
    }

    // inorder Traversal
    // Time Complexity: O(N), Space Complexity: O(N)
    public static void printInOrder(BinaryTree<Integer> root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.print(root.value + ": ");
        if (root.left != null) {
            System.out.print("L:" + root.left.value + ",");
        }
        if (root.right != null) {
            System.out.print("R:" + root.right.value + ",");
        }
        System.out.println();
        printInOrder(root.right);
    }

    // Level Order Traversal
    // Time Complexity: O(N), Space Complexity: O(N)
    public static void printLevelOrder(BinaryTree<Integer> root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTree<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                BinaryTree<Integer> node = queue.poll();
                assert node != null;
                System.out.print(node.value + ": ");
                if (node.left != null) {
                    queue.offer(node.left);
                    System.out.print("L:" + node.left.value + " ");
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    System.out.print("R:" + node.right.value);
                }
                System.out.println();
            }
        }
    }


    /* QUESTIONS */

    // Returns the number of nodes in the binary tree
    // Time Complexity: O(N), Space Complexity: O(H), where H is the height of the tree
    public static int numOfNodes(BinaryTree<Integer> root) {
        if (root == null) {
            return 0;
        }

        int left = numOfNodes(root.left);
        int right = numOfNodes(root.right);

        return 1 + left + right;
    }

    // Returns a list containing the nodes of the binary tree in preorder traversal
    // Time Complexity: O(N), Space Complexity: O(N)
    public static List<Integer> preorderTraversal(BinaryTree<Integer> root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Stack<BinaryTree<Integer>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTree<Integer> node = stack.pop();
            ans.add(node.value);

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return ans;
    }

    // Returns a list containing the nodes of the binary tree in postorder traversal
    // Time Complexity: O(N), Space Complexity: O(N)
    public static List<Integer> postorderTraversal(BinaryTree<Integer> root) {
        if (root == null) {
            return new ArrayList<>();
        }

        ArrayList<Integer> ans = new ArrayList<>();
        Stack<BinaryTree<Integer>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTree<Integer> node = stack.pop();
            ans.add(0, node.value);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return ans;
    }

    // Returns a list containing the nodes of the binary tree in level order traversal
    // Time Complexity: O(N), Space Complexity: O(N)
    public static List<List<Integer>> levelOrder(BinaryTree<Integer> root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<BinaryTree<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> ans = new ArrayList<>();

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> individualLevels = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                BinaryTree<Integer> node = queue.poll();
                assert node != null;
                individualLevels.add(node.value);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.add(individualLevels);
        }

        return ans;
    }

    // Returns a list containing the nodes of the binary tree in inorder traversal
    // Time Complexity: O(N), Space Complexity: O(N)
    public static List<Integer> inorderTraversal(BinaryTree<Integer> root) {
        if (root == null) {
            return new ArrayList<>();
        }

        ArrayList<Integer> ans = new ArrayList<>();
        Stack<BinaryTree<Integer>> stack = new Stack<>();
        BinaryTree<Integer> current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            ans.add(current.value);
            current = current.right;
        }
        return ans;
    }

    // Returns the maximum depth of the binary tree
    // Time Complexity: O(N), Space Complexity: O(H), where H is the height of the tree
    public static int maxDepth(BinaryTree<Integer> root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    // Returns the number of leaf nodes in the binary tree
    // Time Complexity: O(N), Space Complexity: O(H), where H is the height of the tree
    public static int noOfLeafNodes(BinaryTree<Integer> root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        return noOfLeafNodes(root.left) + noOfLeafNodes(root.right);
    }

    // Prints the nodes at depth k in the binary tree
    // Time Complexity: O(N), Space Complexity: O(H), where H is the height of the tree
    public static void printNodesAtDepthK(BinaryTree<Integer> root, int k) {
        if (root == null) {
            return;
        }

        if (k == 0) {
            System.out.print(root.value + " ");
            return;
        }

        printNodesAtDepthK(root.left, k - 1);
        printNodesAtDepthK(root.right, k - 1);
    }

    // Replaces nodes at depth k with depth d in the binary tree
    // Time Complexity: O(N), Space Complexity: O(H), where H is the height of the tree
    public static void replaceNodesAtDepthKWithDepth(BinaryTree<Integer> root, int k, int depth) {
        if (root == null) {
            return;
        }

        if (k == 0) {
            root.value = depth;
            return;
        }

        replaceNodesAtDepthKWithDepth(root.left, k - 1, depth);
        replaceNodesAtDepthKWithDepth(root.right, k - 1, depth);
    }

    // Checks if a node with value x is present in the binary tree
    // Time Complexity: O(N), Space Complexity: O(H), where H is the height of the tree
    private static boolean isNodePresent(BinaryTree<Integer> root, int x) {
        if (root == null) {
            return false;
        }

        if (root.value == x) {
            return true;
        }

        boolean left = isNodePresent(root.left, x);
        if (left) {
            return true;
        }
        return isNodePresent(root.right, x);
    }

    // Prints the nodes without a sibling in the binary tree
    // Time Complexity: O(N), Space Complexity: O(H), where H is the height of the tree
    public static void printNodesWithoutSibling(BinaryTree<Integer> root) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.right == null) {
            System.out.print(root.left.value + " ");
        }
        if (root.right != null && root.left == null) {
            System.out.print(root.right.value + " ");
        }
        printNodesWithoutSibling(root.left);
        printNodesWithoutSibling(root.right);
    }

    public static void removeLeafNodes(BinaryTree<Integer> root) {
        if (root == null) {
            return;
        }


        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                root.left = null;
//                return;
            }
        }
        if (root.right != null) {
            if (root.right.left == null && root.right.right == null) {
                root.right = null;
//                return;
            }
        }

        removeLeafNodes(root.left);
        removeLeafNodes(root.right);

    }

    public static BinaryTree<Integer> removeLeafNodes1(BinaryTree<Integer> root) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return null;
        }
        root.left = removeLeafNodes1(root.left);
        root.right = removeLeafNodes1(root.right);
        return root;
    }

    public static BinaryTree<Integer> mirrorBinaryTree(BinaryTree<Integer> root) {
        if (root == null) {
            return null;
        }
        BinaryTree<Integer> left = mirrorBinaryTree(root.left);
        BinaryTree<Integer> right = mirrorBinaryTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    //    O(n2)
    public static boolean isTreeBalanced(BinaryTree<Integer> root) {
        if (root == null) {
            return true;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        }
        boolean isLeftBalanced = isTreeBalanced(root.left);
        boolean isRightBalanced = isTreeBalanced(root.right);

        return isLeftBalanced && isRightBalanced;
    }

    public static int diameterOfBinaryTree(BinaryTree<Integer> root) {
        //Your code goes here
        if (root == null) {
            return 0;
        }
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);
        int curr = height(root.left) + height(root.right) + 1;
        return Math.max(curr, Math.max(leftDiameter, rightDiameter));
    }

    public static int height(BinaryTree<Integer> root) {
        if (root == null) return 0;
        int leftHeight = 1 + height(root.left);
        int rightHeight = 1 + height(root.right);
        return Math.max(leftHeight, rightHeight);
    }

    private static void duplicateBinaryTreeLeft(BinaryTree<Integer> root) {
        if (root == null) {
            return;
        }
        duplicateBinaryTreeLeft(root.left);
        duplicateBinaryTreeLeft(root.right);

        BinaryTree<Integer> oldLeft = root.left;
        BinaryTree<Integer> newNode = new BinaryTree<>(root.value);
        root.left = newNode;
        newNode.left = oldLeft;
    }

    private static int[] findMinAndMax(BinaryTree<Integer> root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        }

        int[] left = findMinAndMax(root.left);
        int[] right = findMinAndMax(root.right);

        return new int[]{Math.min(root.value, Math.min(left[0], right[0])), Math.max(root.value, Math.max(left[1], right[1]))};
    }

    /* Time complexity: O(N) Space complexity: O(H) where N is the number of nodes in the input tree and H is the height of the input tree */
    /*Given a binary tree where each node contains an integer value, implement a function rootToLeafPathsSumToK to find all paths from the
    root to the leaf nodes such that the sum of values along the path equals a given integer k. The function should print these paths.
     */

    public static void rootToLeafPathsSumToK(BinaryTree<Integer> root, int k) {
        rootToLeafPathsSumToKHelper(root, k, "", 0);
    }

    private static void rootToLeafPathsSumToKHelper(BinaryTree<Integer> root, int k, String path, int currSum) {
        if (root == null) {
            return;
        }
        if (root.value + currSum > k) {
            return;
        }
        if (root.left == null && root.right == null) {
            currSum += root.value;
            if (currSum == k) {
                System.out.println(path + root.value);
            }
            return;
        }
        rootToLeafPathsSumToKHelper(root.left, k, path + root.value + " ", currSum + root.value);
        rootToLeafPathsSumToKHelper(root.right, k, path + root.value + " ", currSum + root.value);
    }


//
    public static void nodesAtDistanceK(BinaryTree<Integer> root, int node, int k) {
        nodesAtDistanceKHelper(root,node,k);
    }
    private static int nodesAtDistanceKHelper(BinaryTree<Integer> root, int node, int k) {
        if(root==null){
            return -1;
        }
        if(root.value==node){
            printNodesAtDepthK(root,k);
            return 0;
        }

        int leftResult = nodesAtDistanceKHelper(root.left,node,k);
        if(leftResult!=-1){
            if(leftResult+1==k){
                System.out.println(root.value);
            }
            else {
                printNodesAtDepthK(root.right,k-2);
            }
            return leftResult+1;
        }

        int rightResult = nodesAtDistanceKHelper(root.right,node,k);
        if(rightResult!=-1){
            if(rightResult+1==k){
                System.out.println(root.value);
            }
            else {
               printNodesAtDepthK(root.left,k-rightResult-2);
            }
            return rightResult+1;
        }

        return -1;
    }


    public static void main(String[] args) {

        BinaryTree<Integer> root = getTree();

//        BinaryTree<Integer> root = takeInputOptimized();
        printLevelOrder(root);
        System.out.println("---------------------------------");
        nodesAtDistanceK(root,20,1);

        System.out.println(1-0-2);
    }
}
