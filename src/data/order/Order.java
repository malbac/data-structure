package data.order;

import data.Column;
import data.RBTree.Node;

/**
 * Created by Malbac on 12.10.2015.
 */
public  abstract class Order {
    protected Column structure;
    protected Node currentNode;

    protected Column getStructure() {
        return structure;
    }

    protected void setCurrentNode(Node currentNode){
        this.currentNode = currentNode;
    }

    public Order(Column structure){
        this.structure = structure;
    }


    abstract public void setFirs();
    abstract public Node getCurrentNode();
    abstract public void movePointerOfCurrentNodeToNext();
    abstract public boolean weCanMoveToNextPointer();

    public Object next(){
        Object resultNode = getCurrentNode();
        movePointerOfCurrentNodeToNext();
        return resultNode;
    }

    public boolean hasNext(){
        if(weCanMoveToNextPointer()){
            return true;
        } else {
            return false;
        }
    }

}
