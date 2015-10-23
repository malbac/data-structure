package structure.searchIndex;

import data.implementation.treap.TNode;
import structure.classes.KatastralneUzemie;

/**
 * Created by Malbac on 23.10.2015.
 */
public class KatastralneUzemieNazov extends TNode {

    private KatastralneUzemie dataReference;

    public KatastralneUzemieNazov(KatastralneUzemie katastralneUzemie) {
        this.dataReference = katastralneUzemie;
    }

    @Override
    public boolean isBiggerThan(TNode otherObject) {
        KatastralneUzemieNazov katastralneUzemie = ((KatastralneUzemieNazov) otherObject);
        if (dataReference.getNazovKatastralnehoUzemia().
                compareToIgnoreCase(katastralneUzemie.dataReference.getNazovKatastralnehoUzemia()) > 0)
            return true;
        else return false;
    }

    @Override
    public boolean isEqualTo(TNode otherObject) {
        KatastralneUzemieNazov katastralneUzemie = ((KatastralneUzemieNazov) otherObject);
        if (dataReference.getNazovKatastralnehoUzemia().
                compareToIgnoreCase(katastralneUzemie.dataReference.getNazovKatastralnehoUzemia()) == 0)
            return true;
        else return false;
    }


    public static void main(String[] args){
        KatastralneUzemieNazov ku = new KatastralneUzemieNazov(new KatastralneUzemie(1,1,"lolo"));
        String a = "A";
        String b = "Z";
        if(a.compareTo(b)>0){
            System.out.println("A is bigger");
        } else {
            System.out.println("B is bigger");
        }

    }
}
