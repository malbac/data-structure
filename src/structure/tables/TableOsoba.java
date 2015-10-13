package structure.tables;

import structure.classes.Osoba;
import data.RBTree.Node;
import dataLogic.abstactTable.Table;

/**
 * Created by Malbac on 11.10.2015.
 */
public class TableOsoba extends Table {
    public TableOsoba() {
        super(Osoba.class,"rodneCislo");

    }

    @Override
    public boolean areDataForThisTable(Node data) {
        if (data instanceof Osoba) {
            return true;
        } else
            return false;
    }

    public void createIndexOnTrvalyPobyt() {
        // make index on the other column

    }
}
