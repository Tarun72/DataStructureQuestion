package Trees;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeUse {
    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        TreeNode<Integer> root = takeInput(s);
        TreeNode<Integer> root = takeInputLevelWise();
        printLevelWise(root);
        TreeNode<Integer> secondNode =  findSecondLargest(root);
        System.out.println("second node "+secondNode.data);
      //  int numberOfNode = numNodeGreater(root,2);
      //  System.out.println("number of node "+numberOfNode);
       // System.out.println("next largest node");
//        int leavesNode = countLeafNodes(root);
//        System.out.println("leave node "+leavesNode);
       // printAtK(root,2);
        // 1,2,4,5,3,6,7
        // preOrderOfTree(root);
       // 40.50,20,30,40.10
       // postOrderOfTree(root);
//        TreeNode<Integer> nextLargestNode = findNextLargerNode(root,18);
//        System.out.println("next largest node "+nextLargestNode.data);
////        TreeNode<Integer> root = new TreeNode<>(4);
//        TreeNode<Integer>  node1 = new TreeNode<>(2);
//        TreeNode<Integer> node2 = new TreeNode<>(3);
//        TreeNode<Integer> node3 = new TreeNode<>(5);
//        TreeNode<Integer> node4 = new TreeNode<>(6);
//        root.children.add(node1);
//        root.children.add(node2);
//        root.children.add(node3);
//        node2.children.add(node4);
//        System.out.println(root);

    }

    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){
        if(root == null){
            return null;
        }
        TreeNode<Integer> largestNode = root;
        TreeNode<Integer> secondLargestNode = new TreeNode<Integer>(Integer.MIN_VALUE);
        if(!root.children.isEmpty()){
            TreeNode<Integer> childNode =  root.children.get(0);
            if(childNode.data > largestNode.data){
                largestNode = childNode;
                secondLargestNode = root;
            }else{
                secondLargestNode = childNode;
                largestNode = root;
            }
        }else{
            return  secondLargestNode;
        }

        Queue<TreeNode<Integer>> pendingNodeQueue =  new LinkedList<>();
        pendingNodeQueue.add(root);
        while (!pendingNodeQueue.isEmpty()){
           TreeNode<Integer> nodeToCompare =  pendingNodeQueue.poll();
            if (largestNode.data < nodeToCompare.data) {
                secondLargestNode = largestNode;
                largestNode = nodeToCompare;
            } else {
                secondLargestNode = nodeToCompare;
            }
            for (int i = 0; i < nodeToCompare.children.size(); i++) {
                pendingNodeQueue.add(nodeToCompare.children.get(i));
            }

        }
        return secondLargestNode;
    }


    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){
        // find the largest node
        if(root == null){
            return null;
        }
        TreeNode<Integer> largestNode = null;
        if(root.data > n){
            largestNode = root;
        }
        for (int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> returnedNode = findNextLargerNode(root.children.get(i),n);
            if(largestNode == null){
                    largestNode = returnedNode;
            }else if(returnedNode != null && largestNode.data > returnedNode.data){
                largestNode = returnedNode;
            }
        }
      //  System.out.println("largest node is "+largestNode.data);
        return largestNode;
    }


    public  static void postOrderOfTree(TreeNode<Integer> root){
        if(root == null){
            return;
        }
        for (int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> node = root.children.get(i);
            postOrderOfTree(node);
           // System.out.print(node.data + " ");
        }
        System.out.print(root.data +" ");
    }

    public static void preOrderOfTree(TreeNode<Integer> root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");

        for (int i = 0; i < root.children.size(); i++) {
            preOrderOfTree(root.children.get(i));
        }
    }

    public static void printAtK(TreeNode<Integer> root,int k){
        if(k<0){
            return;
        }
        if(k == 0){
            System.out.print(" "+ root.data);
        }

        for (int i = 0; i < root.children.size(); i++) {
            printAtK(root.children.get(i),k-1);
        }

    }

    public  static void printTree(TreeNode<Integer> root){
     String s = root.data + ":";
        for (int i = 0; i < root.children.size(); i++) {
            s = s + root.children.get(i).data + ",";
        }
        System.out.println(s);

        for (int i = 0; i < root.children.size(); i++) {
            printTree(root.children.get(i));
        }
    }

    public static TreeNode<Integer> takeInput(Scanner s){
        int n;
        System.out.println("Enter the next node");
        n = s.nextInt();
        TreeNode<Integer> root = new TreeNode<>(n);
       // System.out.println("Enter number of children node "+n);

        int childCount = s.nextInt();
        for (int i = 0; i < childCount; i++) {
            TreeNode<Integer> child = takeInput(s);
            root.children.add(child);
        }
        return root;
    }

    public static int largest(TreeNode<Integer> root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        int ans = root.data;
        for (int i = 0; i <root.children.size() ; i++) {
            int childrenLargest =  largest(root.children.get(i));
            if(childrenLargest> ans){
                ans = childrenLargest;
            }
        }
        return ans;
    }

    public static TreeNode<Integer> takeInputLevelWise(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the data ");
        int rootData = s.nextInt();
        Queue<TreeNode<Integer>> pendingNode = new LinkedList<>();
        TreeNode<Integer> root = new TreeNode<Integer>(rootData);
        pendingNode.add(root);
        while (!pendingNode.isEmpty()){
            TreeNode<Integer> frontNode = pendingNode.poll();
            System.out.println("Enter the number of children of "+frontNode.data);
            int numberOfChildren = s.nextInt();
            for (int i = 0; i < numberOfChildren; i++) {
                System.out.println("Enter"+(i+1)+"th children of "+frontNode.data);
                int child = s.nextInt();
                TreeNode<Integer> childNode = new TreeNode<Integer>(child);
                frontNode.children.add(childNode);
                pendingNode.add(childNode);
            }
        }
        return root;
    }

    public static void  printLevelWise(TreeNode<Integer> root){
        Queue<TreeNode<Integer>> pendingNode = new LinkedList<>();
        pendingNode.add(root);
        while (!pendingNode.isEmpty()){
            int size = pendingNode.size();
            for (int j = 0; j <size ; j++) {
             TreeNode<Integer> frontNode = pendingNode.poll();
                System.out.print(""+frontNode.data);
            for (int i = 0; i < frontNode.children.size(); i++) {
                pendingNode.add(frontNode.children.get(i));
            }
            }
            System.out.println("");
        }
    }

    public static int numNodeGreater(TreeNode<Integer> root,int x){
        int numberOfNode =0;
        if(root == null){
            return 0;
        }
        Queue<TreeNode<Integer>> pendingsNode =  new LinkedList<>();
        pendingsNode.add(root);
        while (!pendingsNode.isEmpty()){
           TreeNode<Integer> frontData =  pendingsNode.poll();
           int valueData = frontData.data;
           if(x < valueData){
               numberOfNode++;
           }
            for (int i = 0; i < frontData.children.size(); i++) {
                pendingsNode.add(frontData.children.get(i));
            }
        }
        return numberOfNode;
    }

    public static int getHeight(TreeNode<Integer> root){
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */

        if(root == null){
            return  0;
        }
        int ans = 0;
        for (int i = 0; i < root.children.size(); i++) {
            int childHeight =  getHeight(root.children.get(i));
            if(childHeight > ans){
                ans = childHeight;
            }
        }
        return  (ans +1);
    }

    public static int countLeafNodes(TreeNode<Integer> root){
        if(root == null){
            return -1;
        }else{
            int count =  0;

            if(root.children.isEmpty()){
                return count + 1;
            }
            for (int i = 0; i <root.children.size() ; i++) {
                count = count + countLeafNodes(root.children.get(i));
            }
            return count;
        }
    }


}
