package structure.searchIndex;

import data.implementation.treap.TNode;
import structure.classes.KatastralneUzemie;
import structure.classes.Osoba;

/**
 * Created by Malbac on 24.10.2015.
 */
public class OsobaRodCislo extends TNode {


    private Osoba dataReference;

    public Osoba getDataReference() {
        return dataReference;
    }

    public void setDataReference(Osoba dataReference) {

        this.dataReference = dataReference;
    }



    public OsobaRodCislo(Osoba katastralneUzemie) {
        super();
        this.dataReference = katastralneUzemie;
    }

    @Override
    public boolean isBiggerThan(TNode otherObject) {
        OsobaRodCislo osobaRodCislo = ((OsobaRodCislo) otherObject);
        if (dataReference.getRodneCislo().
                compareToIgnoreCase(osobaRodCislo.getDataReference().getRodneCislo()) > 0)
            return true;
        else return false;
    }

    @Override
    public boolean isEqualTo(TNode otherObject) {
        OsobaRodCislo osobaRodCislo = ((OsobaRodCislo) otherObject);
        if (dataReference.getRodneCislo().
                compareToIgnoreCase(osobaRodCislo.getDataReference().getRodneCislo()) == 0)
            return true;
        else return false;
    }

    public String toString(){
       return dataReference.toString();
    }
}
