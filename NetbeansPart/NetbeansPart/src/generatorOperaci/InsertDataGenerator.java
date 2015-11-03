package generatorOperaci;

import data.DataManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Malbac on 02.11.2015.
 */
public class InsertDataGenerator {
    DataManager dataManager;
    Random random = new Random();
    //
    LinkedList<String> listRodneCisla = new LinkedList();
    LinkedList<String> listAdresy     = new LinkedList();
    LinkedList<String> listTowns = new LinkedList();
    LinkedList<String> listNames = new LinkedList();
    LinkedList<Integer> listSupisneCislo = new LinkedList();
    //
    int katUradCount;
    int katUzemieCount;
    int listVlastnictvaCount;
    int nehnutelnostCount;
    int podielCount;
    int osobaCount;

    public InsertDataGenerator (DataManager dataManager){
        this.dataManager = dataManager;
        initListMena();
        initListMesta();
    }

    /**
     * udava pocet prvkov ktore maju byt vytvorene
     * @param katUrad
     * @param katUzemie
     * @param listVlastnictva
     * @param nehnutelnost
     * @param podiel
     * @param osoba
     */
    public void naplnData(int katUrad, int katUzemie, int listVlastnictva, int nehnutelnost, int podiel, int osoba){
        this.katUradCount = katUrad ;
        this.katUzemieCount = katUzemie ;
        this.listVlastnictvaCount = listVlastnictva ;
        this.nehnutelnostCount = nehnutelnost ;
        this.podielCount = podiel ;
        this.osobaCount = osoba ;

        naplnKatastralnyUrad(katUrad);
        naplnKatastralneUzemie(katUzemie);
        naplnListVlastnictva(listVlastnictva);
        naplnNehnutelnost(nehnutelnost);
        naplnOsoba(osoba);
        naplnPodiel(podiel);
    }

    private void naplnKatastralnyUrad(int rounds){
        for(int i=0;i<rounds;i++) {
            dataManager.insertKatastralnyUrad(i);
        }
    }

    private void naplnKatastralneUzemie(int rounds){
        int listKatastraneUzemiaSizeBeforeInserting ;
        for(int i=0;i< katUradCount;i++){//napln vsetky kat uzemia v ramci kat uradu
            listKatastraneUzemiaSizeBeforeInserting = dataManager.getListKatastralneUzemiePodlaId().size();
            String nazovKatastralnehoUzemia;
            int idKatastralenehoUzemia;
            for(int j=0;j<rounds;j++){//napln vsetky kat uzemia konkretnymi datami
                nazovKatastralnehoUzemia = getRandomNazovKatUzemia();
                idKatastralenehoUzemia = listKatastraneUzemiaSizeBeforeInserting + j;
                dataManager.insertKatastralneUzemie(i, idKatastralenehoUzemia, nazovKatastralnehoUzemia);
            }
        }
    }



    private void naplnListVlastnictva(int rounds){
        int listVlastnictvaSizeBeforeInserting;
        int pocetKatastralnychUzemi = dataManager.getListKatastralneUzemiePodlaId().size();
        for(int idKatUzemia=0;idKatUzemia< pocetKatastralnychUzemi;idKatUzemia++){//napln vsetky LISTY VLASTNCTVA v ramci KAT UZEMIA, i
            listVlastnictvaSizeBeforeInserting = dataManager.getListListVlastnictva().size();
            int idListVlastnictva;
            for(int j=0;j<rounds;j++){//napln vsetky kat uzemia konkretnymi datami
                idListVlastnictva = listVlastnictvaSizeBeforeInserting + j;
                dataManager.insertListVlastnictva(idListVlastnictva, idKatUzemia);
            }
        }
    }

    private void naplnNehnutelnost(int rounds){
        int listNehnutelnostiSizeBeforeInserting ;
        int pocetListovVlastnictva = dataManager.getListListVlastnictva().size();
        for(int idListVlastnictva=0;idListVlastnictva< pocetListovVlastnictva;idListVlastnictva++){//napln vsetky NEHNUTELNOSTI v ramci LISTOV VLASTNICTVA, i
            listNehnutelnostiSizeBeforeInserting = dataManager.getListNehnutelnostPodlaSupC().size();
            int idSupisneCislo;
            String adresa;
            for(int j=0;j<rounds;j++){//napln vsetky kat uzemia konkretnymi datami
                idSupisneCislo = listNehnutelnostiSizeBeforeInserting + j;
                listSupisneCislo.add(idSupisneCislo);
                adresa = getRandomAdresa();
                dataManager.insertNehnutelnost(idSupisneCislo, idListVlastnictva, adresa);
            }
        }
    }



    private void naplnOsoba(int rounds) {
        int sizeListOsoba = dataManager.getListOsobaPodlaRodneCislo().size();
        String rodneCislo;
        String menoPriezvisko;
        String trvalyPobyt;
        for (int i = 0; i < rounds; i++) {//napln vsetky NEHNUTELNOSTI v ramci LISTOV VLASTNICTVA, i

            rodneCislo = (i + sizeListOsoba + 1000) + "";
            listRodneCisla.add(rodneCislo);
            menoPriezvisko = getRandomName();
            trvalyPobyt = getAdresaFromAlreadyGeneratedAdresses();
            dataManager.insertOsoba(rodneCislo, menoPriezvisko, trvalyPobyt);
        }
    }



    private void naplnPodiel(int rounds){

        int sizeListPodiel = dataManager.getListPodiel().size();
        int idPodiel;
        String rodneCisloPodielnika;
        int supisneCisloNehnutelnosti;
        int velkostPodiel;
        for (int i = 0; i < rounds; i++) {//napln vsetky NEHNUTELNOSTI v ramci LISTOV VLASTNICTVA, i

            idPodiel = (i + sizeListPodiel);
            rodneCisloPodielnika = getRodneCisloFromGeneratedOnes();
            supisneCisloNehnutelnosti = getSupisneCisloNehnutelnostiFromAlreadyGenerated();
            velkostPodiel = random.nextInt(100);
            dataManager.insertPodiel(idPodiel, rodneCisloPodielnika, supisneCisloNehnutelnosti, velkostPodiel);
        }
    }


    //====================RANDOM GENERATORS
    private String getRandomNazovKatUzemia() {
        int randomCity = random.nextInt(listTowns.size());

        return listTowns.get(randomCity);
    }

    private String getAdresaFromAlreadyGeneratedAdresses() {
        int randomAdresa = random.nextInt(listAdresy.size());
        return listAdresy.get(randomAdresa);
    }

    private String getRandomName() {
        int randomName = random.nextInt(listNames.size());
        return listNames.get(randomName);
    }

    private String getRandomAdresa() {
        int randomCity = random.nextInt(listTowns.size());
        String adresa;
        String town;
        int adressNumber;
        //***
        adressNumber = random.nextInt(100);
        town = listTowns.get(randomCity);
        adresa = town +" " + adressNumber;
        listAdresy.add(adresa);
        return adresa;
    }


    private int getSupisneCisloNehnutelnostiFromAlreadyGenerated() {
        int randomSupisneCislo = random.nextInt(listSupisneCislo.size());
        return listSupisneCislo.get(randomSupisneCislo);
    }

    private String getRodneCisloFromGeneratedOnes() {
        int listSize = listRodneCisla.size();
        int randomIndex = random.nextInt(listSize);
        return listRodneCisla.get(randomIndex);
    }

    //
    private void initListMesta(){
        String fileName = "filesSimulatedData\\towns.txt";
        try{
            //Create object of FileReader
            FileReader inputFile = new FileReader(fileName);
            //Instantiate the BufferedReader Class
            BufferedReader bufferReader = new BufferedReader(inputFile);
            //Variable to hold the one line data
            String line;
            String[] variablesToSave;
            // Read file line by line and print on the console
            while ((line = bufferReader.readLine()) != null)   {
                listTowns.add(line);
                System.out.println(line);
            }
            //Close the buffer reader
            bufferReader.close();
        }catch(Exception e){
            System.out.println("Error while reading file line by line:" + e.getMessage());
        }
    }

    private void initListMena(){
        String fileName = "filesSimulatedData\\names.txt";
        try{
            //Create object of FileReader
            FileReader inputFile = new FileReader(fileName);
            //Instantiate the BufferedReader Class
            BufferedReader bufferReader = new BufferedReader(inputFile);
            //Variable to hold the one line data
            String line;
            String[] variablesToSave;
            // Read file line by line and print on the console
            while ((line = bufferReader.readLine()) != null)   {
                listNames.add(line);
                System.out.println(line);
            }
            //Close the buffer reader
            bufferReader.close();
        }catch(Exception e){
            System.out.println("Error while reading file line by line:" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        InsertDataGenerator insertDataGenerator = new InsertDataGenerator(new DataManager());
        insertDataGenerator.initListMena();
        insertDataGenerator.initListMesta();
    }

}
