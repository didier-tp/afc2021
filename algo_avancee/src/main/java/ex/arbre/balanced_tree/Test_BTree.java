package ex.arbre.balanced_tree;

import java.util.Scanner;

public class Test_BTree {

    public static void main(String[] args)
    {

        //Scanner scan = new Scanner(System.in);

        SelfBalancingBinarySearchTrees sbbst = new SelfBalancingBinarySearchTrees();

        System.out.println("Self Balancing Tree\n");



        int N = 10;
        /*
        for (int i = 0; i < N; i++)

            sbbst.insert(scan.nextInt());
        */
        sbbst.insert(12);
        sbbst.insert(24);
        sbbst.insert(8);
        sbbst.insert(6);
        sbbst.insert(10);
        sbbst.insert(30);
        sbbst.insert(35);
        sbbst.insert(40);
        sbbst.insert(60);
        sbbst.insert(18);


        System.out.println("\nPre-order  :");

        sbbst.preorder();

        System.out.println("\nIn-order   :");

        sbbst.inorder();

        System.out.println("\nPost-order :");

        sbbst.postorder();

        //scan.close();

    }

}