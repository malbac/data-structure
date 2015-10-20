package implementation.RBTreeImplementation;

/**
 * Created by Malbac on 14.10.2015.
 */
public class Node {
    public Node getParent() {
        if (parent == null)
            return new Node(-1, parent);
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeft() {
        return left;
    }

    /**
     * it sets parent automatically
     *
     * @param left
     */
    public void setLeft(Node left) {
        this.left = left;
        if (left != null) {
            this.left.setParent(this);
        }

    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
        if(right!=null){
            this.right.setParent(this);
        }

    }

    private Node parent;
    private Node left;
    private Node right;

    boolean isBlack;

    public int getKey() {
        if (this == null) {
            return -1;
        }
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    int key;

    public Node(int key, Node parent) {
        this.key = key;
        this.parent = parent;
        setRed();
    }

    public Node(Node left, Node right, Node parent, boolean isBlack, int key) {
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.isBlack = isBlack;
        this.key = key;
    }

    public void setBlack() {
        isBlack = true;
        System.out.println(key + " was set black");
    }

    public void setRed() {
        isBlack = false;
        System.out.println(key + " was set red");
    }

    public boolean isRed() {
        if (isBlack == false)
            return true;
        else return false;
    }

    public static void main(String[] args) {
        Node a;
        a = new Node(2, null);
        Node b;
        b = new Node(3, null);
        //-----------
        a.setRight(b);
        a.getRight();
        b.getParent();
    }


}
