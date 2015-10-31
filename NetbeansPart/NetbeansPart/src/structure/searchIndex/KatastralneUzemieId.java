package structure.searchIndex;

import data.implementation.treap.TNode;
import structure.classes.KatastralneUzemie;

/**
 * Created by Malbac on 23.10.2015.
 */
public class KatastralneUzemieId extends TNode {

    private KatastralneUzemie dataReference;

    public KatastralneUzemie getDataReference() {
        return dataReference;
    }

    public void setDataReference(KatastralneUzemie dataReference) {

        this.dataReference = dataReference;
    }



    public KatastralneUzemieId(KatastralneUzemie katastralneUzemie) {
        super();
        this.dataReference = katastralneUzemie;
    }



    @Override
    public boolean isBiggerThan(TNode otherObject) {
        KatastralneUzemieId katastralneUzemie = ((KatastralneUzemieId) otherObject);

        int dataReferenceId;
        int otherObjectId;
        dataReferenceId = dataReference.getIdKatastralneUzemie();
        otherObjectId = katastralneUzemie.getDataReference().getIdKatastralneUzemie();

        if (dataReferenceId > otherObjectId)
            return true;
        else return false;
    }

    @Override
    public boolean isEqualTo(TNode otherObject) {
        KatastralneUzemieId katastralneUzemie = ((KatastralneUzemieId) otherObject);

        int dataReferenceId;
        int otherObjectId;
        dataReferenceId = dataReference.getIdKatastralneUzemie();
        otherObjectId = katastralneUzemie.getDataReference().getIdKatastralneUzemie();

        if (dataReferenceId == otherObjectId)
            return true;
        else return false;
    }


    public static void main(String[] args){
        KatastralneUzemieId ku = new KatastralneUzemieId(new KatastralneUzemie(1,null,"mala bytca"));
        String a = "A";
        String b = "Z";
        if(a.compareTo(b)>0){
            System.out.println("A is bigger");
        } else {
            System.out.println("B is bigger");
        }

    }
}
