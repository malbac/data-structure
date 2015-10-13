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
    public void setFirs() {
        setCurrentNode(super.getStructure().get(0));
    }



    @Override
    public Node getCurrentNode() {
        return super.currentNode;
    }

    @Override
    public void movePointerOfCurrentNodeToNext() {
        setCurrentNode(getStructure().get(getStructure().indexOf(getCurrentNode()) + 1));

    }

    @Override
    public boolean weCanMoveToNextPointer() {
        return (getStructure().size() > (getStructure().indexOf(getCurrentNode())) + 1);
    }
}
