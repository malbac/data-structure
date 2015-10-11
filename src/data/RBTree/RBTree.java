package data.RBTree;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Malbac on 11.10.2015.
 */
public class RBTree {
ArrayList<Node> main;

    public RBTree(){
        main = new ArrayList<Node>();
    }

    public void insert(Object key, Node data) {
        main.add(data);
    }

    public void search(Object key){

    }
}
