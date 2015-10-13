package dataLogic.abstactTable;

import data.Column;
import structure.classes.KatastralnyUrad;
import data.RBTree.Node;
import data.RBTree.RBTree;
import data.order.LinearOrder;
import data.order.Order;
import log4j.Log4j;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


/**
 * Created by Malbac on 11.10.2015.
 */
public abstract class Table {
    private Class baseClass;
    Object mainIndexOn;
    //private RBTree id_tree;
    private HashMap<String, Column> indexArray; //there are RBtree inside, so indexes can be added dynamicaly
    private static final Logger log = Logger.getLogger(Log4j.class);

    public Table(Class baseNode, Object mainIndexOn) {
        indexArray = new HashMap<String, Column>();
        this.baseClass = baseNode;
        this.mainIndexOn = mainIndexOn;
        createMainIndexRecordIfDontExist();
//        if(objectIsInBaseStructure(mainIndexOn)){
//            id_tree = new Column((String)mainIndexOn, true, true, true);
//        } else {
//            log.trace("MAIN INDEX NOT CREATED");
//        }

    }

    public Column getColumn(Object nameOfColumn) {
        if (objectIsInBaseStructure(nameOfColumn)) {
            return indexArray.get(nameOfColumn);
        } else {
            return new Column("", false, false, false);//empty data
        }
    }


    /**
     * create record where are data and main id_key
     * id_key has to be part from data inside
     */
    public void insert(Node data, Column column) {
        Object keyData;
        if (areDataForThisTable(data)) {
            if (noDuplicityIndex()) {
                createMainIndexRecordIfDontExist();
                keyData = getKeyDataFromColumn(data, column);
                column.insert(keyData, data);
                //updateIndexIntegrity(data); oprav integritu

            }
        }
    }

    private boolean noDuplicityIndex() {
        return true;
    }

    public abstract boolean areDataForThisTable(Node data);


    /**
     * create rbtree __> column,
     * first, it checks if in data structure is variable with the same name
     * as columnName
     * if there is, it creates object column into indexArray with key of the variable,
     * which is in the dataStructure
     *
     * @param columnName
     */
    public void createIndexOn(Object columnName) {
        log.info("Creating index on column: " + columnName);
        Field[] fields = baseClass.getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            log.info("Values available for node: " + f.getName() + "  " + f.getType());
            if (columnName.getClass().getName().equals(f.getName())) {

                log.info(columnName + " Variable exist");
                log.info("key can be created");
                Column localColumn = new Column(f.getName(), false, false, false);
                indexArray.put(f.getName(), localColumn);
                createDataOnColumn(localColumn);
            }
        }

    }


    //==============================================================================
    //==============================================================================
    public Node search() {
        return new KatastralnyUrad(1);
    }


    private boolean objectIsInBaseStructure(Object indexOfColumn) {
        Field[] fields = baseClass.getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            log.info("Values available : " + f.getName() + "  " + f.getType());

            if ((indexOfColumn).equals(f.getName())) {
                return true;
            }
            log.fatal("Mapping error, indexOfColumn :" + indexOfColumn + " not found");
        }
        return false;
    }

    private void createDataOnColumn(Column localColumn) {
        Order order = new LinearOrder(indexArray.get(mainIndexOn));
        Node localNode;
        if (order.hasNext()) {
            localNode = (Node) order.next();
            localColumn.insert(getValueFromNode(localColumn.getMetaKeyName(), localNode), localNode);
        }
    }

    private Object getValueFromNode(String nameOfVariable, Node node) {
        try {
            Field field = node.getClass().getField(nameOfVariable);
            Object value = "";
            value = field.get(node);
            return value;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return "";
    }

    private Object getMetaKeyFromColumn(Column column) {
        return column.getMetaKeyName();
    }


    private void createMainIndexRecordIfDontExist() {
        if (indexArray.size() == 0) {
            indexArray.put((String) mainIndexOn, new Column((String) mainIndexOn, true, true, true));
            log.info("MAIN COLUMN CREATED");
        }

    }

    private Object getKeyDataFromColumn(Node data, Column column) {
        String localKey = column.getMetaKeyName();
        Field[] fields = data.getClass().getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            log.info("Values available : " + f.getName() + "  " + f.getType());
            if (localKey.equals(f.getName())) {

                log.info(localKey + " LOCAL KEY EXIST");
                Object value = "";

                try {
                    value = f.get(data);

                    log.info("VALUE to key: " + localKey + " is: " + value);
                    log.info("Data found, break");
                    return value;
                } catch (IllegalAccessException e) {
                    log.trace(localKey + " could not be assigned");
                    e.printStackTrace();
                }

            }
        }
        log.fatal("No value for key " + localKey + " found");
        return "";
    }

    /**
     * create index on all parts of node, where is not created
     * <p/>
     * go through indexArray and insert into every RBTree data, which were inserted to id_tree
     * depending on indexTree key method finds out, which column is judged as key column
     * can by like abstract method
     */
    private void updateIndexIntegrity(Node data) {
        String localRBTreeKey;
        RBTree localReference;
        Set<String> keySet = indexArray.keySet();

        Iterator<String> indexArrayIterator = keySet.iterator();
        //insert data reference to every index
        while (indexArrayIterator.hasNext()) {
            localRBTreeKey = indexArrayIterator.next();
            log.info("IndexTree loca key is : " + indexArray.get(localRBTreeKey));

            localReference = indexArray.get(localRBTreeKey);

            Object keyValue = getKeyValueForCurrentIndex(data, localRBTreeKey);
            localReference.insert(keyValue, data);//vlozenie prvku do stromu
        }

    }


    private Object getKeyValueForCurrentIndex(Node data, String localKey) {

        Field[] fields = data.getClass().getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            log.info("Values available : " + f.getName() + "  " + f.getType());
            if (localKey.equals(f.getName())) {

                log.info(localKey + " LOCAL KEY EXIST");
                Object value = "";

                try {
                    value = f.get(data);

                    log.info("VALUE to key: " + localKey + " is: " + value);
                    log.info("Data found, break");
                    return value;
                } catch (IllegalAccessException e) {
                    log.trace(localKey + " could not be assigned");
                    e.printStackTrace();
                }

            }
        }
        log.fatal("No value for key " + localKey + " found");
        return "";
    }

    private Object getRightKeyColumnForCurrentIndex(Node data) {

        return null;
    }

    private boolean isIdNodeKeyValid(Node data) {
        Class aClass = data.getClass();
        //Field id = id_node_key.get;
        //String variableName = String.valueOf(id_node_key);
        //Field field = aClass.getField(variableName);
        return true;
    }


    public static void main(String[] args) {

    }
}
