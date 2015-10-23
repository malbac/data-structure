package data.order;

import data.Column;
import data.implementation.treap.TNode;

/**
 * Created by Malbac on 12.10.2015.
 */
public  abstract class Order {
    protected Column structure;
    protected TNode currentNode;



    protected Column getStructure() {
        return structure;
    }

    protected void setCurrentNode(TNode currentNode){
        this.currentNode = currentNode;
    }

    public Order(Column structure){
        setFirst();
        this.structure = structure;
    }


    abstract public void setFirst();
    abstract public TNode getCurrentNode();

    abstract public Object next();

    abstract public boolean hasNext();


}
