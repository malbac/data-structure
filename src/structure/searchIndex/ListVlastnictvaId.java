package structure.searchIndex;

import data.implementation.treap.TNode;
import structure.classes.KatastralnyUrad;
import structure.classes.ListVlastnictva;

/**
 * Created by Malbac on 24.10.2015.
 */
public class ListVlastnictvaId extends TNode {

    private ListVlastnictva dataReference;

    public ListVlastnictvaId(ListVlastnictva dataReference) {
        this.dataReference = dataReference;
    }

    public ListVlastnictva getDataReference() {
        return dataReference;
    }

    @Override
    public boolean isBiggerThan(TNode otherObject) {
        ListVlastnictvaId otherLocal = ((ListVlastnictvaId) otherObject);

        int dataReferenceId;
        int otherObjectId;
        dataReferenceId = dataReference.getIdListVlastnictva();
        otherObjectId = otherLocal.dataReference.getIdListVlastnictva();
        if (dataReferenceId > otherObjectId) return true;
        else
            return false;
    }

    @Override
    public boolean isEqualTo(TNode otherObject) {
        ListVlastnictvaId otherLocal = ((ListVlastnictvaId) otherObject);

        int dataReferenceId;
        int otherObjectId;
        dataReferenceId = dataReference.getIdListVlastnictva();
        otherObjectId = otherLocal.dataReference.getIdListVlastnictva();
        if (dataReferenceId == otherObjectId) return true;
        else
            return false;
    }
}
