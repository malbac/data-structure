package structure.classes;

import java.util.LinkedList;

/**
 * Created by Malbac on 23.10.2015.
 */
public class KatastralneUzemie {

    public int getIdKatastralneUzemie() {
        return idKatastralneUzemie;
    }

    public void setIdKatastralneUzemie(int idKatastralneUzemie) {
        this.idKatastralneUzemie = idKatastralneUzemie;
    }

    public int getIdUradu() {
        return idUradu;
    }

    public void setIdUradu(int idUradu) {
        this.idUradu = idUradu;
    }

    public String getNazovKatastralnehoUzemia() {
        return nazovKatastralnehoUzemia;
    }

    public void setNazovKatastralnehoUzemia(String nazovKatastralnehoUzemia) {
        this.nazovKatastralnehoUzemia = nazovKatastralnehoUzemia;
    }

    private int idKatastralneUzemie;
    private int idUradu;
    private String nazovKatastralnehoUzemia;

    private LinkedList<Nehnutelnost> listNehnutelnost;

    public KatastralneUzemie(int idKatastralneUzemie, int idUradu, String nazovKatastralnehoUzemia) {
        this.idKatastralneUzemie = idKatastralneUzemie;
        this.idUradu = idUradu;
        this.nazovKatastralnehoUzemia = nazovKatastralnehoUzemia;
    }

}
