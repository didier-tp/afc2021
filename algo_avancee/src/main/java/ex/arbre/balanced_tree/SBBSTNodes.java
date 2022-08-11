package ex.arbre.balanced_tree;

// self balancing binary tree node
class SBBSTNodes {

    SBBSTNodes left, right;

    int data; //or String data , or T data , or KeyValue data

    int height;


    public SBBSTNodes() {

        left = null;

        right = null;

        data = 0;

        height = 0;

    }


    public SBBSTNodes(int n) {


        left = null;

        right = null;

        data = n;

        height = 0;

    }

}

