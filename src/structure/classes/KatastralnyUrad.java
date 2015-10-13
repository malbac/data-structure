package structure.classes;

import data.RBTree.Node;

/**
 * Created by Malbac on 11.10.2015.
 */
public class KatastralnyUrad extends Node {
    public int getId_uradu() {
        return id_uradu;
    }

    public void setId_uradu(int id_uradu) {
        this.id_uradu = id_uradu;
    }

    int id_uradu;

    public KatastralnyUrad(int id_uradu) {
        this.id_uradu = id_uradu;
    }
}
