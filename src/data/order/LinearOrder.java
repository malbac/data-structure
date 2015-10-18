package data.order;

import data.Column;
import data.RBTree.Node;

/**
 * Created by Malbac on 12.10.2015.
 */
public class LinearOrder extends Order {


    public LinearOrder(Column structure) {
        super(structure);
    }

    @Override
    public void setFirst() {
        setCurrentNode(null);
    }


    @Override
    public Node getCurrentNode() {
        return super.currentNode;
    }

    @Override
    public Object next() {
        Object resultNode;
        if (super.currentNode == null) {
            resultNode = getStructure().get(0);
        } else {
            resultNode = getCurrentNode();
        }
        movePointerOfCurrentNodeToNext();
        return resultNode;
    }

    @Override
    public boolean hasNext() {
        if(weCanMoveToNextPointer()){
            return true;
        } else {
            return false;
        }
    }


    public void movePointerOfCurrentNodeToNext() {
        if(super.currentNode==null){
            setCurrentNode(getStructure().get(1));
        } else {
            setCurrentNode(getStructure().get(getStructure().indexOf(getCurrentNode()) + 1));
        }

    }


    public boolean weCanMoveToNextPointer() {
        if (super.currentNode==null){
            return (getStructure().size() >  1);
        }
        return (getStructure().size() > (getStructure().indexOf(getCurrentNode())) + 1);
    }
}
