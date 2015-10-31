package structure.searchIndex;

import data.implementation.treap.TNode;
import structure.classes.Nehnutelnost;

/**
 * Created by Malbac on 23.10.2015.
 */
public class NehnutelnostAdresa extends TNode {

    private Nehnutelnost dataReference;

    public NehnutelnostAdresa(Nehnutelnost nehnutelnost) {
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
        NehnutelnostAdresa otherLocal = ((NehnutelnostAdresa) otherObject);

        String dataReferenceAdresa;
        String otherObjectAdresa;
        dataReferenceAdresa = dataReference.getAdresa();
        otherObjectAdresa = otherLocal.dataReference.getAdresa();
        if (dataReferenceAdresa.compareToIgnoreCase(otherObjectAdresa) > 0) return true;
        else
            return false;
    }

    @Override
    public boolean isEqualTo(TNode otherObject) {
        NehnutelnostAdresa otherLocal = ((NehnutelnostAdresa) otherObject);

        String dataReferenceAdresa;
        String otherObjectAdresa;
        dataReferenceAdresa = dataReference.getAdresa();
        otherObjectAdresa = otherLocal.dataReference.getAdresa();
        if (dataReferenceAdresa.compareToIgnoreCase(otherObjectAdresa) == 0) return true;
        else
            return false;
    }
}
