package structure.classes;


import data.implementation.treap.Treap;
import structure.searchIndex.KatastralneUzemieNazov;

/**
 * Created by Malbac on 11.10.2015.
 */
public class KatastralnyUrad  {

    int id_uradu;

    //==LISTS================================

    Treap listKatastralneUzemia = new Treap();

    public void addKatastralneUzemie(KatastralneUzemieNazov katastralneUzemieNazov){
        listKatastralneUzemia.insert(katastralneUzemieNazov);
    }

    public void removeKatastralneUzemie(KatastralneUzemieNazov katastralneUzemieNazov){
        listKatastralneUzemia.remove(katastralneUzemieNazov);
    }
    public int getId_uradu() {
        return id_uradu;
    }

    public void setId_uradu(int id_uradu) {
        this.id_uradu = id_uradu;
    }



    public KatastralnyUrad(int id_uradu) {
        this.id_uradu = id_uradu;
    }
}
