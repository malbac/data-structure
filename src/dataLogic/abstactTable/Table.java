package dataLogic.abstactTable;

import data.KatastralnyUrad;
import data.Osoba;
import data.RBTree.Node;
import data.RBTree.RBTree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;


/**
 * Created by Malbac on 11.10.2015.
 */
public abstract class Table {
    private Node nodeStructure;
    private RBTree id_tree;
    private HashMap<String,RBTree> indexArray; //there are RBtree inside, so indexes can be added dynamicaly



    public Table(){
        id_tree = new RBTree();
        indexArray = new HashMap<String,RBTree>();
    }

    /**
     * create record where are data and main id_key
     * id_key has to be part from data inside
     */
    public void insert(int id_node_key, Node data)  {
        if(areDataForThisTable(data)) {
            createMainIndexRecordIfDontExist();
            id_tree.insert(id_node_key, data);
            updateIndexIntegrity(data);
        }
    }

    public abstract boolean areDataForThisTable(Node data) ;


    public Node search(){
        return new KatastralnyUrad(1);
    }

    public void createIndexOn(String variable){
       // id_tree
    }

    public void setIndexOn(Object index){

    }
//==============================================================================
//==============================================================================
    private void createMainIndexRecordIfDontExist() {
        //indexArray.add();
        if(id_tree==null){
            id_tree = new RBTree();
        }
    }

    /**
     * create index on all parts of node, where is not created
     */
    private void updateIndexIntegrity(Node data) {
        String localKey;
        RBTree localReference;
        Set<String> keySet= indexArray.keySet();

        Iterator<String> indexArrayIterator=keySet.iterator();
        //insert data reference to every index
        while(indexArrayIterator.hasNext()){
            localKey = indexArrayIterator.next();
            System.out.println(indexArray.get(localKey));

            localReference = indexArray.get(localKey);

            Object key = getRightKeyForCurrentIndex(data);
            localReference.insert(key,data);
        }

    }

    private Object getRightKeyForCurrentIndex(Node data) {

        return null;
    }

    private boolean isIdNodeKeyValid(Node data){
        Class aClass = data.getClass();
        //Field id = id_node_key.get;
        //String variableName = String.valueOf(id_node_key);
        //Field field = aClass.getField(variableName);
        return true;
    }



    public static void main(String[] args){

    }
}
