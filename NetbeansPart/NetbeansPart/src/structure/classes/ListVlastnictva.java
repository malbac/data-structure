package structure.classes;

import data.implementation.treap.TNode;
import data.implementation.treap.Treap;
import structure.searchIndex.NehnutelnostSupisneCislo;

import java.util.LinkedList;

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

    @Override
    public String toString() {
        String result = "ListVlastnictva: \n" +
                "idListVlastnictva=" + idListVlastnictva +
                ", katastralneUzemie=" + katastralneUzemie.getNazovKatastralnehoUzemia() +"\n\n";

        if(listNehnutelnost!=null){
            result+="\n";
            LinkedList<TNode> localListNehnutelnost = listNehnutelnost.inorderTraversal();
            LinkedList<Podiel> localListPodiely;

            Podiel localPodiel;
            Nehnutelnost localNehnutelnost;
            for (int i = 0;i<localListNehnutelnost.size();i++){
                localNehnutelnost = ((NehnutelnostSupisneCislo)localListNehnutelnost.get(i)).getDataReference();
                result+= "Supisne Cislo: " + localNehnutelnost.getIdSupisneCislo() + ", Adresa: " + localNehnutelnost.getAdresa() + "\n";
            }

            result  += "\nSupis vsetkych vlastnikov\n";
            for (int i = 0;i<localListNehnutelnost.size();i++){
                localNehnutelnost = ((NehnutelnostSupisneCislo)localListNehnutelnost.get(i)).getDataReference();
                localListPodiely = localNehnutelnost.getListPodiely();
                for(int j=0;j<localListPodiely.size();j++){
                    localPodiel = localListPodiely.get(j);
                    result+= "Majitel : " + localPodiel.getMajitel().getMenoPriezvisko() + ",  Majetkovy podiel: " + localPodiel.getPodiel()+ " na nehnutelnosti :" + localPodiel.getNehnutelnost().getAdresa() + "\n";
                }

            }
        }

        return result;
    }
}
