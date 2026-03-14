import java.util.Scanner;
class BST {
    int data;
    BST lchild = null;
    BST rchild = null;
}
public class BinarySearchTree {
    static BST insert(BST root,BST new1) {
        if(root == null) {
            return new1;
        }
        else if(root.data == new1.data) {
            System.out.println("\n" + new1.data + " already exists in the Binary Tree");
        } 
        else if(root.data > new1.data) {
            root.lchild = insert(root.lchild,new1);
        }
        else {
            root.rchild = insert(root.rchild,new1);
        }
        return root;
    }
    static void inOrder(BST root) {
        if(root == null) {
            return;
        }
        inOrder(root.lchild);
        System.out.print(root.data + " ");
        inOrder(root.rchild);
    }
    static void preOrder(BST root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        inOrder(root.lchild);
        inOrder(root.rchild);
    }
    static void postOrder(BST root) {
        if(root == null) {
            return;
        }
        inOrder(root.lchild);
        inOrder(root.rchild);
        System.out.print(root.data + " ");
    }
    static int search(BST root,int x) {
        if(root == null) {
            return 1;
        }
        else if(root.data == x) {
            return 0;
        }
        else if(root.data > x) {
            return search(root.lchild,x);
        }
        else {
            return search(root.rchild,x);
        }
    }
    public static void main(String[] args) {
        BST root = null,new1;
        int choice,f,x;
        Scanner scanf = new Scanner(System.in);
        while(true) {
            System.out.println("\nMENU\n1.Insert\n2.Inorder Traversal\n3.Preorder Traversal\n4.Postorder Traversal\n5.Search\n6.Exit\n");
            System.out.print("Enter your choice : ");
            choice = scanf.nextInt();
            switch(choice) {
                case 1: new1 = new BST();
                        System.out.print("\nEnter the data : ");
                        new1.data = scanf.nextInt();
                        root = insert(root,new1);
                        break;
                case 2: if(root == null) {
                            System.out.println("\nNo Binary tree has been created");
                        }
                        else {
                            System.out.print("\nThe Inorder Traversal of the binary tree is : ");
                            inOrder(root);
                            System.out.println();
                        }
                        break;
                case 3: if(root == null) {
                            System.out.println("\nNo Binary tree has been created");
                        }
                        else {
                            System.out.print("\nThe Preorder Traversal of the binary tree is : ");
                            preOrder(root);
                            System.out.println();
                        }
                        break;
                case 4: if(root == null) {
                            System.out.println("\nNo Binary tree has been created");
                        }
                        else {
                            System.out.print("\nThe Postoder Traversal of the binary tree is : ");
                            postOrder(root);
                            System.out.println();
                        }
                        break;
                 case 5: if(root == null) {
                            System.out.println("\nNo Binary tree has been created");
                        }
                        else {
                            System.out.print("\nEnter the searching data : ");
                            x = scanf.nextInt();
                            f = search(root,x);
                            if(f == 0) {
                                System.out.println("\n" + x + " exists in the binary tree");
                            }
                            else {
                                System.out.println("\n" + x + " doesn't exists in the binary tree");
                            }
                        }
                        break;
                case 6: System.out.println("\nExiting");
                        System.exit(0);
                default:System.out.println("\nInvalid choice");
            }
        }
    }
}