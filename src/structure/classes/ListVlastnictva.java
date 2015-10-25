package structure.classes;

import data.implementation.treap.Treap;
import structure.searchIndex.NehnutelnostSupisneCislo;

/**
 * Created by Malbac on 24.10.2015.
 */
public class ListVlastnictva {
    private int idListVlastnictva;
    private KatastralneUzemie katastralneUzemie;

    private Treap listNehnutelnost = new Treap();
    private Treap listPodielnici = new Treap();

    public ListVlastnictva(int idListVlastnictva, KatastralneUzemie katastralneUzemie) {
        this.idListVlastnictva = idListVlastnictva;
        this.katastralneUzemie = katastralneUzemie;
    }

    public void addNehnutelnostToListNehnutelnost(Nehnutelnost nehnutelnost){
        listNehnutelnost.insert(new NehnutelnostSupisneCislo(nehnutelnost));
    }

    public void removeNehnutelnostToListNehnutelnost(Nehnutelnost nehnutelnost) {
        listNehnutelnost.remove(new NehnutelnostSupisneCislo(nehnutelnost));
    }

//    public void addPodielnikToListPodielnici(Podielnik podielnik){
//        listPodielnici.insert(new (nehnutelnost));
//    }
//
//    public void removePodielnikToListPodielnici(Podielnik podielnik){
//        listPodielnici.remove(new NehnutelnostSupisneCislo(nehnutelnost));
//    }

    public int getIdListVlastnictva() {
        return idListVlastnictva;
    }

    public void setIdListVlastnictva(int idListVlastnictva) {
        this.idListVlastnictva = idListVlastnictva;
    }

    public KatastralneUzemie getKatastralneUzemie() {
        return katastralneUzemie;
    }

    public void setKatastralneUzemie(KatastralneUzemie katastralneUzemie) {
        this.katastralneUzemie = katastralneUzemie;
    }
}
