package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeUse {
    public static void main(String[] args) {
//        BinaryTree<Integer> root = new BinaryTree<Integer>(1);
//        BinaryTree<Integer> node1 = new BinaryTree<Integer>(2);
//        root.left = node1;
//        BinaryTree<Integer> node2 = new BinaryTree<Integer>(3);
//        root.right = node2;
//        Scanner scanner = new Scanner(System.in);
//        BinaryTree<Integer> root = takeInput(scanner);
         BinaryTreeNode<Integer> root = takeInputLevelWise();
        printLevelWise(root);
        System.out.println("count of a nodes "+countNodes(root));
        System.out.println("is Node present "+isNodePresent(root,100));
        System.out.println("height of binary tree "+height(root));


//        scanner.close();

    }
    public static int height(BinaryTreeNode<Integer> root){
    int count = 1;
    if(root == null){
        return 0;
    }
        int left =  count  +  height(root.left);
        int right = count + height(root.right);
        if(left > right){
           return left ;
        }else{
            return right;
        }
    }

    public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x){
        if(root == null){
            return false;
        }
        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<BinaryTreeNode<Integer>>();
        pendingNodes.add(root);

        while (!pendingNodes.isEmpty()){
            BinaryTreeNode<Integer> front = pendingNodes.poll();
            if(front.data == x){
                return  true;
            }
            if(front.left != null)
            pendingNodes.add(front.left);
            if(front.right != null)
                pendingNodes.add(front.right);
        }
        return  false;
    }

    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if(root == null){
            return;
        }

        //take queue
        Queue<BinaryTreeNode<Integer>> pendingQueue = new LinkedList<>();
        pendingQueue.add(root);
        while (!pendingQueue.isEmpty()){
            BinaryTreeNode<Integer> parentNode = pendingQueue.poll();
            StringBuilder builder = new StringBuilder();
            builder.append(parentNode.data+"");
            BinaryTreeNode<Integer> leftChildNode = parentNode.left;
            if(leftChildNode != null){
                builder.append("L"+leftChildNode.data);
                pendingQueue.add(leftChildNode);
            }
            BinaryTreeNode<Integer> rightNode = parentNode.right;
            if(rightNode != null){
                builder.append(",R"+rightNode.data);
                pendingQueue.add(rightNode);
            }
            System.out.print(builder.toString());
            builder.setLength(0);
        }
        System.out.println();

    }

    public static BinaryTreeNode<Integer> takeInputLevelWise() {
        Scanner s = new Scanner(System.in);
        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
        System.out.println("Enter root data");
        int rootData = s.nextInt();
        if (rootData == -1) {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        pendingNodes.add(root);

        while (!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> front;

                front = pendingNodes.poll();

            System.out.println("Enter left child of " + front.data);
            int leftChild = s.nextInt();
            if (leftChild != -1) {
                BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(leftChild);
                pendingNodes.add(child);
                front.left = child;
            }

            System.out.println("Enter right child of " + front.data);
            int rightChild = s.nextInt();
            if (rightChild != -1) {
                BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(rightChild);
                pendingNodes.add(child);
                front.right = child;
            }
        }
        return root;
    }

    public static BinaryTreeNode<Integer> takeInput(Scanner scanner){
        int rootData;
        System.out.println("Enter root data");
        rootData = scanner.nextInt();
        if(rootData == -1){
            return  null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        root.left = takeInput(scanner);
        root.right = takeInput(scanner);
        return root;
    }

    public static void printBST(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        String printing = root.data + " ";
        if(root.left != null){
            printing += "L:" +root.left.data + ",";
        }
        if(root.right != null){
            printing += "R:" +root.right.data;
        }
        System.out.println(printing);
        printBST(root.left);
        printBST(root.right);
    }

    public static  int countNodes(BinaryTreeNode<Integer> root){
        if(root == null){
            return 0;
        }

        int count = 1;
        count =  count + countNodes(root.left);
        count =  count + countNodes(root.right);
        return count;
    }

    public static LinkedListNode<Integer> constructLinkedList2(BinaryTreeNode<Integer> root) {
        if(root == null){
            return  null;
        }

        Queue<BinaryTreeNode<Integer>> pendingNotes = new LinkedList<>();
        pendingNotes.add(root);
        LinkedListNode<Integer>  headNode =  new LinkedListNode<>(root.data);
        LinkedListNode<Integer>  currentNode = headNode;
        while (!pendingNotes.isEmpty()){
            BinaryTreeNode<Integer> node  = pendingNotes.poll();
            BinaryTreeNode<Integer> nodeLeft = node.left;
            BinaryTreeNode<Integer> nodeRight = node.right;
            if(nodeLeft != null){
                pendingNotes.add(nodeLeft);
                LinkedListNode<Integer> nextNode = new LinkedListNode<>(nodeLeft.data);
                currentNode.next =  nextNode;
                currentNode = currentNode.next;
            }
            if(nodeRight != null){
                pendingNotes.add(nodeRight);
                LinkedListNode<Integer> nextNode = new LinkedListNode<>(nodeRight.data);
                currentNode.next =  nextNode;
                currentNode = currentNode.next;
            }

        }

        return headNode;
    }


//    public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
//        if(root == null){
//            return  null;
//        }
//        return new BinaryTreeNode<Integer>(2);
//    }

//    static LinkedListNode<Integer> helperFunction(BinaryTreeNode<Integer> root){
//        if(root == null){
//            return  null;
//        }
//        helperFunction(root.left);
//    }






















}
