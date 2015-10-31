package ioLogic;

import data.DataManager;
import data.InsertDataObject;
import data.implementation.treap.TNode;

import java.util.LinkedList;

/**
 * Created by Malbac on 11.10.2015.
 */
public class IOHandler {
    DataManager dataManager;
    //Format
    private String saveFormat = ".txt";
    // path
    private File saveFile;
    private String filePath = "files\\";
    // save files
    private String fileKatastralnyUrad = filePath +  "KatastralnyUrad" + saveFormat;
    private String fileKatastralneUzemie = filePath + "KatastralneUzemie" + saveFormat;
    private String fileListVlastnictva = filePath + "ListVlastnictva" + saveFormat;
    private String fileNehnutelnost = filePath + "Nehnutelnost" + saveFormat;
    private String fileOsoba = filePath + "Osoba" + saveFormat;
    private String filePodiel = filePath + "Podiel" + saveFormat;
    // save
    private PrintWriter outKatastralnyUrad;
    private PrintWriter outKatastralneUzemie;
    private PrintWriter outListVlastnictva;
    private PrintWriter outNehnutelnost;
    private PrintWriter outOsoba;
    private PrintWriter outPodiel;

    public IOHandler(DataManager dataManager){
        createFile();
        this.dataManager = dataManager;

    }

    private void createFile() {
        File file = new File(filePath);
        if(!file.exists()){
            file.mkdir();
        }
    }


    public boolean save(){
        initializePrintWriters();
        saveKatastralnyUrad();
        saveKatastralneUzemie();
        saveListVlastnictva();
        saveNehnutelnost();
        saveOsoba();
        savePodiel();

        return true;
    }

    private void initializePrintWriters() {
        try {

            outKatastralnyUrad = new PrintWriter(fileKatastralnyUrad);
            outKatastralneUzemie = new PrintWriter(fileKatastralneUzemie);
            outListVlastnictva = new PrintWriter(fileListVlastnictva);
            outNehnutelnost = new PrintWriter(fileNehnutelnost);
            outOsoba = new PrintWriter(fileOsoba);
            outPodiel = new PrintWriter(filePodiel);

        } catch (FileNotFoundException e) {


        }
    }

    public boolean load(){
        loadKatastralnyUrad();
        loadKatastralneUzemie();
        loadListVlastnictva();
        loadNehnutelnost();
        loadOsoba();
        loadPodiel();
        return true;
    }

    //SAVE PART

    private void saveKatastralnyUrad() {
        LinkedList<TNode> localKatastralnyUrad = dataManager.getListKatastralnyUrad().inorderTraversal();
        KatastralnyUrad localVar;
        for (int i=0;i<localKatastralnyUrad.size();i++){
            localVar = ((KatastralnyUradId)localKatastralnyUrad.get(i)).getDataReference();
            outKatastralnyUrad.println(localVar.getId_uradu());
        }

        outKatastralnyUrad.close();
    }

    private void saveKatastralneUzemie() {
        LinkedList<TNode> localKatastralneUzemie = dataManager.getListKatastralneUzemiePodlaNazov().inorderTraversal();
        KatastralneUzemie localVar;
        for (int i=0;i<localKatastralneUzemie.size();i++){
            localVar = ((KatastralneUzemieNazov)localKatastralneUzemie.get(i)).getDataReference();
            outKatastralneUzemie.println(localVar.getUrad().getId_uradu()+","
                                        +localVar.getIdKatastralneUzemie()+","
                                        +localVar.getNazovKatastralnehoUzemia());
        }

        outKatastralneUzemie.close();
    }

    private void saveListVlastnictva() {
        LinkedList<TNode> localListVlastnictva = dataManager.getListListVlastnictva().inorderTraversal();
        ListVlastnictva localVar;
        for (int i=0;i<localListVlastnictva.size();i++){
            localVar = ((ListVlastnictvaId)localListVlastnictva.get(i)).getDataReference();
            outListVlastnictva.println(localVar.getIdListVlastnictva()+","
                                        +localVar.getKatastralneUzemie().getNazovKatastralnehoUzemia());
        }

        outListVlastnictva.close();
    }

    private void saveNehnutelnost() {
        LinkedList<TNode> localListNehnutelnosti = dataManager.getListNehnutelnostPodlaSupC().inorderTraversal();
        Nehnutelnost localVar;
        for (int i=0;i<localListNehnutelnosti.size();i++){
            localVar = ((NehnutelnostSupisneCislo)localListNehnutelnosti.get(i)).getDataReference();
            outNehnutelnost.println(localVar.getIdSupisneCislo()+","
                    +localVar.getListVlastnictva().getIdListVlastnictva()+","
                    +localVar.getAdresa());
        }

        outNehnutelnost.close();
    }

    private void saveOsoba() {
        LinkedList<TNode> localListOsoba = dataManager.getListOsobaPodlaRodneCislo().inorderTraversal();
        Osoba localVar;
        for (int i=0;i<localListOsoba.size();i++){
            localVar = ((OsobaRodCislo)localListOsoba.get(i)).getDataReference();
            outOsoba.println(localVar.getRodneCislo()+","
                    +localVar.getMenoPriezvisko()+","
                    +localVar.getTrvalyPobyt());
        }

        outOsoba.close();
    }

    private void savePodiel() {
        LinkedList<TNode> localListPodiel = dataManager.getListPodiel().inorderTraversal();
        Podiel localVar;
        for (int i=0;i<localListPodiel.size();i++){
            localVar = ((PodielId)localListPodiel.get(i)).getDataReference();
            outPodiel.println(localVar.getId_podiel()+","
                    +localVar.getMajitel().getRodneCislo()+","
                    +localVar.getNehnutelnost().getIdSupisneCislo()+","
                    +localVar.getPodiel());
        }

        outPodiel.close();
    }




    //LOAD PART



    private void loadKatastralnyUrad() {
        new LoadKatastralnyUrad().readFile(fileKatastralnyUrad,dataManager);
    }

    private void loadKatastralneUzemie() {
        new LoadKatastralneUzemie().readFile(fileKatastralneUzemie,dataManager);
    }

    private void loadListVlastnictva() {
        new LoadListVlastnictva().readFile(fileListVlastnictva,dataManager);
    }

    private void loadNehnutelnost() {
        new LoadNehnutelnost().readFile(fileNehnutelnost, dataManager);
    }

    private void loadOsoba() {
        new LoadOsoba().readFile(fileOsoba, dataManager);

    }

    private void loadPodiel() {
        new LoadPodiel().readFile(filePodiel,dataManager);
    }

    //HELP LOAD METHOD

    private  void loadOsoba(String fileName,DataManager dataManager){

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
                variablesToSave = line.split(",");
                //*************
                if(variablesToSave.length==3){//mnozstvo premennych pri katastralnom urade
                    dataManager.insertOsoba(variablesToSave[0],variablesToSave[1],variablesToSave[2]);
                    System.out.println("Osoba LOADED");
                }
            }
            //Close the buffer reader
            bufferReader.close();
        }catch(Exception e){
            System.out.println("Error while reading file line by line:" + e.getMessage());
        }
    }






    public static void main(String[] args){
        DataManager dataManager = new DataManager();
       IOHandler ioHandler = new IOHandler(dataManager);
        new InsertDataObject(dataManager);
        ioHandler.save();
        ioHandler.load();
    }





}
