package implementation.treap;

/**
 * Created by Malbac on 19.10.2015.
 */

import java.util.Scanner;

/** Class TreapTest **/
public class TreapTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /** Creating object of Treap **/
        TreapTree trpt = new TreapTree();
        System.out.println("Treap Test\n");
        char ch;
        /**  Perform tree operations  **/
        do {
            System.out.println("\nTreap Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. search");
            System.out.println("3. count nodes");
            System.out.println("4. check empty");
            System.out.println("5. clear");

            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter integer element to insert");
                    trpt.insert(scan.nextInt());
                    break;
                case 2:
                    System.out.println("Enter integer element to search");
                    System.out.println("Search result : " + trpt.search(scan.nextInt()));
                    break;
                case 3:
                    System.out.println("Nodes = " + trpt.countNodes());
                    break;
                case 4:
                    System.out.println("Empty status = " + trpt.isEmpty());
                    break;
                case 5:
                    System.out.println("\nTreap Cleared");
                    trpt.makeEmpty();
                    break;
                default:
                    System.out.println("Wrong Entry \n ");
                    break;
            }
            /**  Display tree  **/
            System.out.print("\nPost order : ");
            trpt.postorder();
            System.out.print("\nPre order : ");
            trpt.preorder();
            System.out.print("\nIn order : ");
            trpt.inorder();

            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');
    }
}
