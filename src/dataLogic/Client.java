package dataLogic;

import data.KatastralnyUrad;
import data.Osoba;
import dataLogic.abstactTable.Table;
import ioLogic.IOHandler;

/**
 * Created by Malbac on 11.10.2015.
 */
public class Client {
    public static void main(String[] args) {
        IOHandler ioHandler = new IOHandler();
        ioHandler.load();

        Table osobaT = new TableOsoba();

        osobaT.insert(1, new KatastralnyUrad(1));
        osobaT.insert(1, new KatastralnyUrad(2));
        osobaT.insert(1, new KatastralnyUrad(3));

       // osobaT.createIndexOn();

        osobaT.search();
       // osobaT.createIndexOn(new KatastralnyUrad(1));


        ioHandler.save();
    }
}
