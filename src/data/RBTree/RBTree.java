package data.RBTree;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Malbac on 11.10.2015.
 */
public class RBTree {
    ArrayList<Node> main;
    Node root;
    Node right;
    Node left;

    public RBTree(){
        main = new ArrayList<Node>();
    }

    public void insert(Object key, Node data) {
        main.add(data);
    }

    public void search(Object key){
        main.get((Integer) key);
    }

    public void remove(Object key){
        main.remove(key);
    }

    public int size(){
        return main.size();
    }

    public Node get(Integer i){
        return main.get(i);
    }

    public Integer indexOf(Object o){
        return main.indexOf(o);
    }

    //=============================

}
