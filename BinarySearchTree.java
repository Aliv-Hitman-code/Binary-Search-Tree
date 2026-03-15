import java.util.Scanner;
class BST {
    int data;
    BST lchild = null;
    BST rchild = null;
}
public class BinarySearchTree {
    static BST insertNode(BST root,BST newnode) {
        if(root == null) {
            return newnode;
        }
        else if(root.data == newnode.data) {
            System.out.println("\n" + newnode.data + " already exists in the Binary Tree");
        } 
        else if(root.data > newnode.data) {
            root.lchild = insertNode(root.lchild,newnode);
        }
        else {
            root.rchild = insertNode(root.rchild,newnode);
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
        preOrder(root.lchild);
        preOrder(root.rchild);
    }
    static void postOrder(BST root) {
        if(root == null) {
            return;
        }
        postOrder(root.lchild);
        postOrder(root.rchild);
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
    static BST deleteNode(BST root,int x) {
        if(root.data > x) {
            root.lchild = deleteNode(root.lchild,x);
        }
        else if(root.data < x) {
            root.rchild = deleteNode(root.rchild,x);
        } 
        else {
            if(root.lchild == null && root.rchild == null) {
                root = null;
            }
            else if(root.lchild != null && root.rchild != null) {
                BST t = inorderSuccessor(root.rchild);
                root.data = t.data;
                root.rchild = deleteNode(root.rchild,t.data);
            }
            else if(root.lchild == null) {
                BST t = root;
                root = root.rchild;
                t = null;
            }
            else {
                BST t = root;
                root = root.lchild;
                t = null;
            }
        }
        return root;
    }
    static BST inorderSuccessor(BST root) {
        if(root.lchild == null) {
            return root;
        }
        return inorderSuccessor(root.lchild);
    }
    public static void main(String[] args) {
        BST root = null,newnode;
        int choice,f,x;
        Scanner scanf = new Scanner(System.in);
        while(true) {
            System.out.println("\nMENU\n1.Insert\n2.Inorder Traversal\n3.Preorder Traversal\n4.Postorder Traversal\n5.Search\n6.Delete a node\n7.Exit\n");
            System.out.print("Enter your choice : ");
            choice = scanf.nextInt();
            switch(choice) {
                case 1: newnode = new BST();
                        System.out.print("\nEnter the data : ");
                        newnode.data = scanf.nextInt();
                        root = insertNode(root,newnode);
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
                 case 6: if(root == null) {
                            System.out.println("\nNo Binary tree has been created");
                        }
                        else {
                            System.out.print("\nEnter the deleting data : ");
                            x = scanf.nextInt();
                            f = search(root,x);
                            if(f == 0) {
                                System.out.println("\n" + x + " is deleted from the binary tree");
                                root = deleteNode(root,x);
                            }
                            else {
                                System.out.println("\n" + x + " doesn't exists in the binary tree");
                            }
                        }
                        break;
                case 7: System.out.println("\nExiting");
                        System.exit(0);
                default:System.out.println("\nInvalid choice");
            }
        }
    }
}