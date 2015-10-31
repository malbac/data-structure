package structure.searchIndex;

import data.implementation.treap.TNode;
import structure.classes.Osoba;

/**
 * Created by Malbac on 24.10.2015.
 */
public class OsobaTrvalyPobyt extends TNode {


    private Osoba dataReference;

    public Osoba getDataReference() {
        return dataReference;
    }

    public void setDataReference(Osoba dataReference) {

        this.dataReference = dataReference;
    }



    public OsobaTrvalyPobyt(Osoba osoba) {
        super();
        this.dataReference = osoba;
    }

    @Override
    public boolean isBiggerThan(TNode otherObject) {
        OsobaTrvalyPobyt osobaTrvalyPobyt = ((OsobaTrvalyPobyt) otherObject);

        String dataReferenceAdresa;
        String otherObjectAdresa;
        dataReferenceAdresa = dataReference.getTrvalyPobyt();
        otherObjectAdresa = osobaTrvalyPobyt.dataReference.getTrvalyPobyt();
        //// comparison result
        int result = dataReferenceAdresa.compareToIgnoreCase(otherObjectAdresa);
        if(result!=0){
            if (result > 0) return true;
            else
                return false;
        } else {// adresy su rovnake a ideme preto porovnavat podla rodneho cisla
            String dataReferenceRodneCislo;
            String otherObjectRocneCislo;
            dataReferenceRodneCislo = dataReference.getRodneCislo();
            otherObjectRocneCislo = osobaTrvalyPobyt.dataReference.getRodneCislo();

            if (dataReferenceRodneCislo.compareToIgnoreCase(otherObjectRocneCislo) > 0)
                return true;
            else return false;
        }

    }

    @Override
    public boolean isEqualTo(TNode otherObject) {
        OsobaTrvalyPobyt osobaRodCislo = ((OsobaTrvalyPobyt) otherObject);

        String dataReferenceAdresa;
        String otherObjectAdresa;
        dataReferenceAdresa = dataReference.getTrvalyPobyt();
        otherObjectAdresa = osobaRodCislo.dataReference.getTrvalyPobyt();
        if (dataReferenceAdresa.compareToIgnoreCase(otherObjectAdresa) == 0) return true;
        else
            return false;
    }

    public String toString(){
       return dataReference.toString();
    }
}
