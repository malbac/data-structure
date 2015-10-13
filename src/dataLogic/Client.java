package dataLogic;

import data.RBTree.Node;
import data.order.LinearOrder;
import data.order.Order;
import structure.classes.KatastralnyUrad;
import dataLogic.abstactTable.Table;
import ioLogic.IOHandler;
import structure.classes.Osoba;
import structure.tables.TableOsoba;

/**
 * Created by Malbac on 11.10.2015.
 */
public class Client {
    //oprav insert updateIndexIntegrity method
    public static void main(String[] args) {
        IOHandler ioHandler = new IOHandler();//not implemented
        ioHandler.load();//not implemented

        Table osobaT = new TableOsoba();

        //osobaT.insert(1, new KatastralnyUrad(1));
        osobaT.insert( new Osoba("1111","Fero","Bytca"),osobaT.getColumn("rodneCislo"));
        osobaT.insert( new Osoba("1112","Fero","Bytca"),osobaT.getColumn("rodneCislo"));


       // osobaT.createIndexOn();
        Order order = new LinearOrder(osobaT.getColumn("rodneCislo"));
        order.setFirs();
        while (order.hasNext()){
            Osoba next = (Osoba)order.next();

            System.out.println("Objekty: " + next.getMenoPriezvisko() + " ," + next.getRodneCislo());
        }
       // osobaT.createIndexOn(new KatastralnyUrad(1));


        ioHandler.save();
    }
}
