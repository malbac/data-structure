package structure.classes;

import data.implementation.treap.Treap;
import structure.searchIndex.ListVlastnictvaId;
import structure.searchIndex.NehnutelnostSupisneCislo;

/**
 * Created by Malbac on 23.10.2015.
 */
public class KatastralneUzemie {
    private int idKatastralneUzemie;
    private KatastralnyUrad katastralnyUrad;
    private String nazovKatastralnehoUzemia;

   //==LISTS================================

    private Treap listNehnutelnost;
    private Treap listListovVlastnictva;

    public KatastralneUzemie(int idKatastralneUzemie, KatastralnyUrad katastralnyUrad, String nazovKatastralnehoUzemia) {
        this.idKatastralneUzemie = idKatastralneUzemie;
        this.katastralnyUrad = katastralnyUrad;
        this.nazovKatastralnehoUzemia = nazovKatastralnehoUzemia;
        //list inside
        listNehnutelnost = new Treap();
        listListovVlastnictva = new Treap();
    }

    public Treap getListListovVlastnictva() {
        return listListovVlastnictva;
    }

    public Treap getListNehnutelnost() {
        return listNehnutelnost;
    }

    public void addNehnutelnost(NehnutelnostSupisneCislo nehnutelnost){
        listNehnutelnost.insert(nehnutelnost);
    }

    public void removeNehnutelnost(NehnutelnostSupisneCislo nehnutelnost){
        listNehnutelnost.remove(nehnutelnost);
    }

    public void addListVlastnictva(ListVlastnictvaId listVlastnictvaId){
        listListovVlastnictva.insert(listVlastnictvaId);
    }

    public void removeListVlastnictva(ListVlastnictvaId listVlastnictvaId){
        listListovVlastnictva.remove(listVlastnictvaId);
    }

    public int getIdKatastralneUzemie() {
        return idKatastralneUzemie;
    }

    public void setIdKatastralneUzemie(int idKatastralneUzemie) {
        this.idKatastralneUzemie = idKatastralneUzemie;
    }

    public KatastralnyUrad getUrad() {
        return katastralnyUrad;
    }

    public void setIdUradu(KatastralnyUrad idUradu) {
        this.katastralnyUrad  = idUradu;
    }

    public String getNazovKatastralnehoUzemia() {
        return nazovKatastralnehoUzemia;
    }

    public void setNazovKatastralnehoUzemia(String nazovKatastralnehoUzemia) {
        this.nazovKatastralnehoUzemia = nazovKatastralnehoUzemia;
    }

    @Override
    public String toString() {
        return "KatastralneUzemie: \n" +
                "idKatastralneUzemie=" + idKatastralneUzemie +
                ", katastralnyUrad=" + katastralnyUrad +
                ", nazovKatastralnehoUzemia='" + nazovKatastralnehoUzemia;
    }
}
