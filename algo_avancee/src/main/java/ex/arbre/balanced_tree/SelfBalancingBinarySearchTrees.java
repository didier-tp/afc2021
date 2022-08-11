package ex.arbre.balanced_tree;


class SelfBalancingBinarySearchTrees {

    private SBBSTNodes root;


    public SelfBalancingBinarySearchTrees() {

        root = null;

    }


    public boolean isEmpty() {

        return root == null;

    }


    public void clear() {

        root = null;

    }


    public void insert(int data) {

        root = insert(data, root);

    }


    private int height(SBBSTNodes t) {


        return t == null ? -1 : t.height;

    }


    private int max(int lhs, int rhs) {

        return lhs > rhs ? lhs : rhs;

    }


    private SBBSTNodes insert(int x, SBBSTNodes t) {

        if (t == null)

            t = new SBBSTNodes(x);

        else if (x < t.data) {

            t.left = insert(x, t.left);

            if (height(t.left) - height(t.right) == 2)

                if (x < t.left.data)

                    t = rotateWithLeftChild(t);

                else

                    t = doubleWithLeftChild(t);

        } else if (x > t.data) {

            t.right = insert(x, t.right);

            if (height(t.right) - height(t.left) == 2)

                if (x > t.right.data)

                    t = rotateWithRightChild(t);

                else

                    t = doubleWithRightChild(t);

        } else

            ;

        t.height = max(height(t.left), height(t.right)) + 1;

        return t;

    }

    private SBBSTNodes rotateWithLeftChild(SBBSTNodes k2) {

        SBBSTNodes k1 = k2.left;

        k2.left = k1.right;

        k1.right = k2;

        k2.height = max(height(k2.left), height(k2.right)) + 1;

        k1.height = max(height(k1.left), k2.height) + 1;

        return k1;

    }


    private SBBSTNodes rotateWithRightChild(SBBSTNodes k1) {

        SBBSTNodes k2 = k1.right;

        k1.right = k2.left;

        k2.left = k1;

        k1.height = max(height(k1.left), height(k1.right)) + 1;

        k2.height = max(height(k2.right), k1.height) + 1;

        return k2;

    }


    private SBBSTNodes doubleWithLeftChild(SBBSTNodes k3) {

        k3.left = rotateWithRightChild(k3.left);

        return rotateWithLeftChild(k3);

    }


    private SBBSTNodes doubleWithRightChild(SBBSTNodes k1) {

        k1.right = rotateWithLeftChild(k1.right);

        return rotateWithRightChild(k1);

    }


    public int countNodes() {

        return countNodes(root);

    }


    private int countNodes(SBBSTNodes r) {

        if (r == null)

            return 0;

        else {

            int l = 1;

            l += countNodes(r.left);

            l += countNodes(r.right);

            return l;

        }

    }


    public boolean search(int val) {

        return search(root, val);

    }


    private boolean search(SBBSTNodes r, int val) {

        boolean found = false;

        while ((r != null) && !found) {

            int rval = r.data;

            if (val < rval)

                r = r.left;

            else if (val > rval)

                r = r.right;

            else {

                found = true;

                break;

            }

            found = search(r, val);

        }

        return found;

    }


    public void inorder() {

        inorder(root);

    }


    private void inorder(SBBSTNodes r) {

        if (r != null) {

            inorder(r.left);

            System.out.print(r.data + " ");

            inorder(r.right);

        }

    }


    public void preorder() {


        preorder(root);

    }


    private void preorder(SBBSTNodes r) {

        if (r != null) {

            System.out.print(r.data + " ");

            preorder(r.left);

            preorder(r.right);

        }

    }


    public void postorder() {

        postorder(root);

    }


    private void postorder(SBBSTNodes r) {

        if (r != null) {

            postorder(r.left);

            postorder(r.right);

            System.out.print(r.data + " ");

        }

    }

}