public class Tree {

    Tree() {
        this.size = 0;
        this.root = null;
    }

    public boolean add(int key) {

        if (this.root == null) {
            this.root = new LeafNode(key);
            this.size++;
            return true;
        }

        if (this.root.left == null && this.root.right == null) {
            int rootKey = ((LeafNode) this.root).key;
            if (key == rootKey) {
                return false;
            }
            this.root = new Node();
            if (key > rootKey) {
                this.root.right = new LeafNode(key);
                this.root.left = new LeafNode(rootKey);
            } else {
                this.root.left = new LeafNode(key);
                this.root.right = new LeafNode(rootKey);
            }
            return true;
        }

        Node left = this.root.left;

        return false;
    }


    public void show() {
        showNode(this.root);
    }

    private void showNode(Node node) {
        if (node != null) {
            showNode(node.left);
            if (node instanceof LeafNode)
                System.out.println(((LeafNode) node).key);
            showNode(node.right);
        }

    }

    private int size;
    private Node root;

    private class Node {
        private Node right;
        private Node left;

        public Node() {
            this.right = null;
            this.left = null;
        }

    }


    private class LeafNode extends Node {

        public LeafNode(int key) {
            super();
            this.key = key;
        }

        private int key;
    }
}
