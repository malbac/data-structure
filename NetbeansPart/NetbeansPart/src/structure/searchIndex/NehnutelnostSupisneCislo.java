package structure.searchIndex;

import data.implementation.treap.TNode;
import structure.classes.Nehnutelnost;

/**
 * Created by Malbac on 23.10.2015.
 */
public class NehnutelnostSupisneCislo extends TNode {

    private Nehnutelnost dataReference;

    public NehnutelnostSupisneCislo(Nehnutelnost nehnutelnost) {
        super();
        this.dataReference = nehnutelnost;
    }

    public Nehnutelnost getDataReference() {
        return dataReference;
    }

    public void setDataReference(Nehnutelnost dataReference) {
        this.dataReference = dataReference;
    }



    @Override
    public boolean isBiggerThan(TNode otherObject) {
        NehnutelnostSupisneCislo otherLocal = ((NehnutelnostSupisneCislo) otherObject);

        int dataReferenceId;
        int otherObjectId;
        dataReferenceId = dataReference.getIdSupisneCislo();
        otherObjectId = otherLocal.dataReference.getIdSupisneCislo();
        if (dataReferenceId > otherObjectId) return true;
        else
            return false;
    }

    @Override
    public boolean isEqualTo(TNode otherObject) {
        NehnutelnostSupisneCislo otherLocal = ((NehnutelnostSupisneCislo) otherObject);

        int dataReferenceId;
        int otherObjectId;
        dataReferenceId = dataReference.getIdSupisneCislo();
        otherObjectId = otherLocal.dataReference.getIdSupisneCislo();
        if (dataReferenceId == otherObjectId) return true;
        else
            return false;
    }
}
