/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.test;

import data.implementation.treap.TNode;
import data.implementation.treap.Treap;
import structure.classes.KatastralnyUrad;
import structure.searchIndex.KatastralnyUradId;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 *
 * @author Malbac
 */
public class TreapTest {
    LinkedList<TNode> helpStructure = new LinkedList<TNode>();
    Random random = new Random();
    Treap treap;

    public TreapTest(){
        treap = new Treap();



    }



    public String insertTest(int rounds){
        String result="==================================\nINSERT TEST ROUNDS " + rounds+"\n";
        int insertedCount = 0;
        int notInsertedCount = 0;
        //INSERT PART
        KatastralnyUradId katastralnyUradId;
        boolean inserted;
        for(int i=0;i<rounds;i++){
            katastralnyUradId = new KatastralnyUradId(new KatastralnyUrad(i));
            inserted = treap.insert(katastralnyUradId);
            helpStructure.add(katastralnyUradId);
            if(!inserted){
                result += katastralnyUradId.getDataReference().getId_uradu() + " kat. u. Not inserted, key exist already";
                notInsertedCount++;
            } else {
                insertedCount++;
            }

        }
        result += "Data inseted \nInseted: " + insertedCount + "\nNotInserted: " + notInsertedCount+"\n";
        return result;


    }

    public String randomInsertTest(int rounds){
        String result="==================================\nRANDOM INSERT TEST ROUNDS " + rounds+"\n";
        int insertedCount = 0;
        int notInsertedCount = 0;
        //INSERT PART
        KatastralnyUradId katastralnyUradId;
        boolean inserted;
        int randomIndex;
        for(int i=0;i<rounds;i++){
            randomIndex = getRandomValue();
            katastralnyUradId = new KatastralnyUradId(new KatastralnyUrad(randomIndex));
            //*************INSERTION******************
            inserted = treap.insert(katastralnyUradId);
            helpStructure.add(katastralnyUradId);
            if(!inserted){
                result += katastralnyUradId.getDataReference().getId_uradu() + " kat. u. Not inserted, key exist already";
                notInsertedCount++;
            } else {
                insertedCount++;
            }

        }
        result += "Data inseted \nInseted: " + insertedCount + "\nNotInserted: " + notInsertedCount+"\n";
        return result;


    }

    public String deleteAll(){
        String result = "==================================\nDELETE ALL\n";
        LinkedList<TNode> localList;
        localList = treap.inorderTraversal();
        KatastralnyUradId localNode;
        for (int i=0;!localList.isEmpty();i++){
            localNode = ((KatastralnyUradId)localList.getFirst());
            treap.remove(localNode);
            localList.removeFirst();
        }
        return result + "All Nodes deleted\n size: " + treap.size() + ", " + localList.size()+"\n";
    }

    public int getRandomValue(){
        int randomValue = random.nextInt();
        if (randomValue>0){
            return randomValue;
        } else {
            return randomValue*-1;
        }
    }

    public String deleteTest(int rounds){
        String result="==================================\nDELETE TEST ROUNDS " + rounds+"\n";
        int correctlyDeleted = 0;
        int uncorrectlyDeleted = 0;
        int keyToBeDeletedNotFound = 0;
        //RANDOM DELELETE PART

        Object nodeFound;
        TNode randomTNode;
        int size;
        for (int i=0;i<rounds;i++){
            try {
                randomTNode = helpStructure.getFirst();
            } catch (IndexOutOfBoundsException e){
                randomTNode = null;
            } catch (NoSuchElementException e){
                randomTNode = null;
            }
            if(randomTNode!=null){
                helpStructure.remove(randomTNode);
                treap.remove(randomTNode);
                try {
                    nodeFound = treap.search(randomTNode);
                } catch (NullPointerException e){
                    nodeFound = null;
                }
                if (nodeFound != null) {
                    //"We found the node, which was deleted\n";
                    uncorrectlyDeleted++;
                } else {
                    correctlyDeleted++;
                }
            }else {
                keyToBeDeletedNotFound++;
            }
        }


        result += "Nodes, which were already deleted count: " + uncorrectlyDeleted+"\n";
        result += "Correctly deleted: " + correctlyDeleted+"\n";
        result += "Key to be deleted not found: " + keyToBeDeletedNotFound+"\n";
        int treapCount = treap.levelOrderCount(treap.getRoot());
        int helpStructureSize = helpStructure.size();
        if(treapCount!=helpStructureSize){
            result+="FATAL PROBLEM, HELP STRUCTURE("+helpStructureSize+") AND TREAP("+treapCount+") COUNT ARE NOT SAME : ";
        } else {
            result+="HELP STRUCTURE("+helpStructureSize+") AND TREAP("+treapCount+") COUNT ARE SAME\n";
        }
        return result;
    }

    public String randomDeleteTest(int rounds){
        int correctlyDeleted = 0;
        int uncorrectlyDeleted = 0;
        int keyToBeDeletedNotFound = 0;
        String result="==================================\n" +
                "RANDOM DELETE TEST " + rounds +"\n";
        //RANDOM DELELETE PART

        Object nodeFound;
        TNode randomTNode;
        //***************
        int size;
        int randomIndex;
        for (int i=0;i<rounds;i++){
            size = helpStructure.size();
            randomIndex = random.nextInt(rounds);
            if(size>randomIndex) {
                randomTNode = helpStructure.get(randomIndex);
                //-------------DELETING
                helpStructure.remove(randomTNode);
                treap.remove(randomTNode);
                nodeFound = treap.search(randomTNode);
                if(nodeFound!=null){
                    //"We found the node, which was deleted\n";
                    uncorrectlyDeleted++;
                } else {
                    correctlyDeleted++;
                }
            } else {
                keyToBeDeletedNotFound++;
            }
        }

        result += "Nodes, which were already deleted count: " + uncorrectlyDeleted+"\n";
        result += "Correctly deleted: " + correctlyDeleted+"\n";
        result += "Key to be deleted not found: " + keyToBeDeletedNotFound+"\n";
        int treapCount = treap.levelOrderCount(treap.getRoot());
        int helpStructureSize = helpStructure.size();
        if(treapCount!=helpStructureSize){
            result+="FATAL PROBLEM, HELP STRUCTURE("+helpStructureSize+") AND TREAP("+treapCount+") COUNT ARE NOT SAME : ";
        } else {
            result+="HELP STRUCTURE("+helpStructureSize+") AND TREAP("+treapCount+") COUNT ARE SAME\n";
        }
        return result;
    }

    public String randomDeleteTestWithoutControl(int rounds){
        int correctlyDeleted = 0;
        int uncorrectlyDeleted = 0;
        int keyToBeDeletedNotFound = 0;
        String result="==================================\n" +
                "RANDOM DELETE TEST " + rounds +"\n";
        //RANDOM DELELETE PART

        Object nodeFound;
        TNode randomTNode;
        //***************
        int randomIndex;
        boolean deleted;
        for (int i=0;i<rounds;i++){
            randomIndex = random.nextInt(rounds);

                //-------------DELETING
                deleted =treap.remove(new KatastralnyUradId(new KatastralnyUrad(randomIndex)));
                if(deleted){
                    correctlyDeleted++;
                } else {
                    uncorrectlyDeleted++;
                }

        }

        result += "Nodes, which were already deleted count: " + uncorrectlyDeleted+"\n";
        result += "Correctly deleted: " + correctlyDeleted+"\n";
        result += "Key to be deleted not found: " + keyToBeDeletedNotFound+"\n";
        int treapCount = treap.levelOrderCount(treap.getRoot());


            result+="TREAP("+treapCount+") COUNT\n ";

        return result;
    }

    public String getSize(){
        return "The current size of treap is : " + treap.size();
    }

    public int getSizeInt(){
        int treapSize = treap.size();
        System.out.println(treapSize);
        return treapSize;
    }

    public static void main(String[] args){
        TreapTest treap = new TreapTest();
        //seriousTestMethod(100);
        System.out.println(treap.insertTest(1000));
        //System.out.println(deleteTest(50000));
        //System.out.println(randomDeleteTest(50000));
        System.out.println(treap.randomDeleteTestWithoutControl(50000));
        treap.randomInsertTest(10);
        System.out.println(treap.getSize());
        System.out.println(treap.deleteAll());
        System.out.println(treap.getSize());
    }
    
}
