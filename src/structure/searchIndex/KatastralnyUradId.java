package structure.searchIndex;

import data.implementation.treap.TNode;
import structure.classes.KatastralnyUrad;

/**
 * Created by Malbac on 23.10.2015.
 */
public class KatastralnyUradId extends TNode {

    private KatastralnyUrad dataReference;

    public KatastralnyUradId(KatastralnyUrad dataReference){
        this.dataReference =dataReference;
    }

    @Override
    public boolean isBiggerThan(TNode otherObject) {
        KatastralnyUradId idOtherObject;
        idOtherObject = ((KatastralnyUradId)otherObject);

        int dataRefId = dataReference.getId_uradu();
        int otherObjectId = idOtherObject.dataReference.getId_uradu();


        if(dataRefId> otherObjectId)
            return true;
        else return false;
    }

    @Override
    public boolean isEqualTo(TNode otherObject) {
        KatastralnyUradId idOtherObject;
        idOtherObject = ((KatastralnyUradId)otherObject);

        int dataRefId = dataReference.getId_uradu();
        int otherObjectId = idOtherObject.dataReference.getId_uradu();


        if(dataRefId == otherObjectId)
            return true;
        else return false;
    }
}
