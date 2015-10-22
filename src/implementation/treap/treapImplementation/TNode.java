package implementation.treap.treapImplementation;

import java.util.Random;

/**
 * Created by Malbac on 19.10.2015.
 */
public class TNode {

    private TNode parent;
    private TNode left;
    private TNode right;

    int key;
    int priority;

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }



    public TNode getParent() {
        return parent;
    }

    public void setParent(TNode parent) {
        this.parent = parent;
    }

    public TNode getLeft() {
        if (left==null)
            return null;
        return left;
    }

    /**
     * it sets parent automatically
     *
     * @param left
     */
    public void setLeft(TNode left) {
        this.left = left;
        if (left != null) {
            this.left.setParent(this);
        }

    }

    public TNode getRight() {
        return right;
    }

    public void setRight(TNode right) {
        this.right = right;
        if(right!=null){
            this.right.setParent(this);
        }

    }



    public int getKey() {
        if (this == null) {
            return -1;
        }
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }



    public TNode(int key, TNode parent) {
        this.key = key;
        this.parent = parent;
        this.priority = createPriority();
    }

    public TNode(int key, TNode parent,int priority) {
        this.key = key;
        this.parent = parent;
        this.priority = priority;
    }

    public TNode(int key, int priority) {
        this.key = key;
        this.priority = priority;
    }

    public TNode(TNode left, TNode right, TNode parent, int key) {
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.key = key;
        this.priority = createPriority();
    }

    private int createPriority(){
        Random random = new Random();
        int result = random.nextInt();
        if(result>0) return result;
        else return result*-1;
    }



    public static void main(String[] args) {
        TNode a;
        a = new TNode(2, null);
        TNode b;
        b = new TNode(3, null);
        //-----------
        a.setRight(b);
        a.getRight();
        b.getParent();
    }



}
