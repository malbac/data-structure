package structure.classes;

/**
 * Created by Malbac on 24.10.2015.
 */
public class Podiel {

    private int id_podiel;
    private Osoba majitel;
    private Nehnutelnost nehnutelnost;
    private int podiel;

    public Podiel(int id_podiel, Osoba majitel, Nehnutelnost nehnutelnost, int podiel) {

        this.id_podiel = id_podiel;
        this.majitel = majitel;
        this.nehnutelnost = nehnutelnost;
        this.podiel = podiel;
    }

    public int getId_podiel() {
        return id_podiel;
    }

    public void setId_podiel(int id_podiel) {
        this.id_podiel = id_podiel;
    }

    public Osoba getMajitel() {
        return majitel;
    }

    public void setMajitel(Osoba majitel) {
        this.majitel = majitel;
    }

    public Nehnutelnost getNehnutelnost() {
        return nehnutelnost;
    }

    public void setNehnutelnost(Nehnutelnost nehnutelnost) {
        this.nehnutelnost = nehnutelnost;
    }

    public int getPodiel() {
        return podiel;
    }

    public void setPodiel(int podiel) {
        this.podiel = podiel;
    }


}
