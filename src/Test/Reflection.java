package Test;

import data.Column;
import data.implementation.treap.TNode;
import structure.classes.Osoba;
import log4j.Log4j;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;

/**
 * Created by Malbac on 11.10.2015.
 */
public class Reflection {
    private static final Logger log = Logger.getLogger(Log4j.class);

    public Reflection() {
        Osoba osoba = new Osoba("1551", "Peter_Pavol", "Bytca");
        //getRightKeyValueForCurrentIndex(osoba, "rodneCislo");
        if(objectIsInBaseStructure("menoPriezisko")){
            System.out.println("true");
        } else {
            System.out.println("False");
        }

        //System.out.println(getKeyDataFromColumn(osoba,new Column("rodneCislo",false,false,false)));

    }

    public static void main(String[] args) {

        new Reflection();

    }
    private Object getKeyDataFromColumn(TNode data,Column column) {
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

    private boolean objectIsInBaseStructure(Object indexOfColumn) {
        Class baseClass = Osoba.class;
        Field[] fields = baseClass.getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            log.info("Values available : " + f.getName() + "  " + f.getType());

            if (indexOfColumn.equals(f.getName())) {
                return true;





            }
            log.fatal("Mapping error, indexOfColumn :" + indexOfColumn + " not found" );
        } return false;
    }

    private Object getRightKeyValueForCurrentIndex(TNode data, String localKey) {

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


}
