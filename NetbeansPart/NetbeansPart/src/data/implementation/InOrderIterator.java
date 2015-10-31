package data.implementation;

import data.DataManager;
import data.implementation.treap.TNode;
import data.implementation.treap.Treap;
import structure.classes.Osoba;
import structure.searchIndex.OsobaTrvalyPobyt;

import java.util.NoSuchElementException;

public class InOrderIterator{
    private TNode next;

    public InOrderIterator(TNode root){
        next = root;
        if(next == null)
            return;
        while (next.getLeft() != null)
            next = next.getLeft();
    }

    public boolean hasNext(){
        return next != null;
    }

    public TNode next(){
        if(!hasNext()) throw new NoSuchElementException();
        TNode r = next;
        // if you can walk right, walk right, then fully left.
        // otherwise, walk up until you come from left.
        if(next.getRight() != null){
            next = next.getRight();
            while (next.getLeft() != null)
                next = next.getLeft();
            return r;
        }else while(true){
            if(next.getParent() == null){
                next = null;
                return r;
            }
            if(next.getParent().getLeft() == next){
                next = next.getParent();
                return r;
            }
            next = next.getParent();
        }
    }

    public static void main(String[] args){
        DataManager dataManager = new DataManager();
        dataManager.insertOsoba("1111","Martin","Bytca");//
        dataManager.insertOsoba("1112","Martin","Bytca");//
        dataManager.insertOsoba("1113","Martin","Bykkca");
        dataManager.insertOsoba("1114","Martin","Bykkca");
        dataManager.insertOsoba("1115","Martin","Bytca");//
        dataManager.insertOsoba("1116","Martin","Bytjjca");
        dataManager.insertOsoba("1117","Martin","Bytca");//
        dataManager.insertOsoba("1118","Martin","jj");
        dataManager.insertOsoba("1119","Martin","Bytca");//
        ////
        OsobaTrvalyPobyt osobaTrvalyPobyt = new OsobaTrvalyPobyt(new Osoba(null,null,"Bytca"));
        OsobaTrvalyPobyt localOsobaTrvalyPobyt;
        Treap treapOsobaPodlaTrvaleho = dataManager.getListOsobaPodlaTrvalyPobyt();
        localOsobaTrvalyPobyt = (OsobaTrvalyPobyt) treapOsobaPodlaTrvaleho.search(osobaTrvalyPobyt);
        InOrderIterator inOrderIterator = new InOrderIterator(localOsobaTrvalyPobyt);

        OsobaTrvalyPobyt osoba;
        while (inOrderIterator.hasNext()){
            osoba = (OsobaTrvalyPobyt) inOrderIterator.next();
            if(osoba.getDataReference().getTrvalyPobyt().compareToIgnoreCase("Bytca")==0){
                System.out.println(osoba);
            }

        }
    }
}