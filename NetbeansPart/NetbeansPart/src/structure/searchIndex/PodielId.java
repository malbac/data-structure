package structure.searchIndex;

import data.implementation.treap.TNode;
import structure.classes.KatastralnyUrad;
import structure.classes.Podiel;

/**
 * Created by Malbac on 28.10.2015.
 */
public class PodielId extends TNode {
    private Podiel dataReference;

    public Podiel getDataReference() {
        return dataReference;
    }

    public PodielId(Podiel dataReference){
        super();
        this.dataReference =dataReference;
    }

    @Override
    public boolean isBiggerThan(TNode otherObject) {
        PodielId idOtherObject;
        idOtherObject = ((PodielId)otherObject);
        if(otherObject==null)return false;

        int dataRefId = dataReference.getId_podiel();
        int otherObjectId = idOtherObject.dataReference.getId_podiel();


        if(dataRefId> otherObjectId)
            return true;
        else return false;
    }

    @Override
    public boolean isEqualTo(TNode otherObject) {
        PodielId idOtherObject;
        idOtherObject = ((PodielId)otherObject);
        if(otherObject==null)return false;

        int dataRefId = dataReference.getId_podiel();
        int otherObjectId = idOtherObject.dataReference.getId_podiel();


        if(dataRefId== otherObjectId)
            return true;
        else return false;
    }
}
