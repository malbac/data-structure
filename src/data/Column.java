package data;

import data.RBTree.RBTree;

/**
 * Created by Malbac on 12.10.2015.
 */
public class Column extends RBTree {



    private String keyName;
    private boolean UNIQUE = false;
    private boolean PRIVATE_KEY = false;
    private boolean NOT_NULL = false;

    public String getMetaKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public Column(String keyName, boolean UNIQUE, boolean PRIVATE_KEY, boolean NOT_NULL) {
        this.keyName = keyName;
        this.UNIQUE = UNIQUE;
        this.PRIVATE_KEY = PRIVATE_KEY;
        this.NOT_NULL = NOT_NULL;
    }

    public boolean isUNIQUE() {
        return UNIQUE;
    }

    public void setUNIQUE(boolean UNIQUE) {
        this.UNIQUE = UNIQUE;
    }

    public boolean isPRIVATE_KEY() {
        return PRIVATE_KEY;
    }

    public void setPRIVATE_KEY(boolean PRIVATE_KEY) {
        this.PRIVATE_KEY = PRIVATE_KEY;
    }

    public boolean isNOT_NULL() {
        return NOT_NULL;
    }

    public void setNOT_NULL(boolean NOT_NULL) {
        this.NOT_NULL = NOT_NULL;
    }
}
