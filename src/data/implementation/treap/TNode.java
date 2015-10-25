package data.implementation.treap;

import java.util.Random;

/**
 * Created by Malbac on 19.10.2015.
 */
public abstract class TNode {

    private TNode parent;
    private TNode left;
    private TNode right;

    //Object key;
    //private Object value;
    int priority;



    /**
     * A>B  >> 1
     * A<B  >>-1
     * A==B >> 0
     * @param otherObject
     * @return
     */
    public abstract boolean isBiggerThan(TNode otherObject);

    public abstract boolean isEqualTo(TNode otherObject);

//    public void setValue(Object value) {
//        this.value = value;
//    }
    public TNode(){
        priority = createPriority();
    }





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



//    public Object getKey() {
//        if (this == null) {
//            return -1;
//        }
//        return key;
//    }
//
//    public void setKey(Object key) {
//        this.key = key;
//    }
//
//
//
//    public TNode(Object key, TNode parent,Object value) {
//        this.key = key;
//        this.parent = parent;
//        this.value = value;
//        this.priority = createPriority();
//    }
//
//    public TNode(Object key, TNode parent,int priority) {
//        this.key = key;
//        this.parent = parent;
//        this.priority = priority;
//    }
//
//    public TNode(Object key, int priority) {
//        this.key = key;
//        this.priority = priority;
//    }
//
//    public TNode(TNode left, TNode right, TNode parent, int key) {
//        this.left = left;
//        this.right = right;
//        this.parent = parent;
//        this.key = key;
//        this.priority = createPriority();
//    }

    private int createPriority(){
        Random random = new Random();
        int result = random.nextInt(100);
        if(result>0) return result;
        else return result*-1;
    }




}
