package implementation.treap;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.TreeMap;

/**
 * Created by Malbac on 19.10.2015.
 */
public class Treap {

    private TNode root;
    private TNode current;

    private void setRoot(TNode root) {
        this.root = root;
        this.root.setParent(null);
    }

    /**
     * A>B  >> 1
     * A<B  >>-1
     * A==B >> 0
     * @param A
     * @param B
     * @return
     */


    public boolean AisBiggerThanB(Object A,Object B){
        int a = ((Integer) A);
        int b = ((Integer) B);
        if(a>b)return true;
        else return false;
    }

    public boolean AisEqualToB(Object A,Object B){
        int a = ((Integer) A);
        int b = ((Integer) B);
        if(a==b)return true;
        else return false;
    }

    public TNode search(Object key) {
        current = root;
        if (root.getKey() == key) {
           // System.out.println("Found node with key: " + key + "  priority: " + current.getPriority());
            return current;
        }
        while (true) {
            //if (key < current.key) {//ak je sucasny kluc vacsi ako kluc co vkladam, chod do lava
            if (AisBiggerThanB(current.key,key)) {//ak je sucasny kluc vacsi ako kluc co vkladam, chod do lava
                //zisti ci je v volny lavy smernik, ak ano vloz, ak nie prestav ho na aktualny
                if (current.getLeft() != null) {
                    current = current.getLeft(); // ak nie prestav o na aktualny

                    if (current.getKey() == key) {
                       // System.out.println("Found node with key: " + key + "  priority: " + current.getPriority());
                        return current;
                    }

                    continue; // a pokracuj
                } else { //nasla sa slepa vetva vrat false
                    return null;
                }
            }
            if (AisBiggerThanB(key,current.key)) {//ak je sucasny kluc mensi ako kluc co vkladam, chod do prava
                //zisti ci je v volny pravy smernik, ak ano vloz, ak nie prestav ho na aktualny
                if (current.getRight() != null) {
                    current = current.getRight();

                    if (current.getKey() == key) {
                      //  System.out.println("Found node with key: " + key + "  priority: " + current.getPriority());
                        return current;
                    }

                    continue; // a ukonci
                } else { //nasla sa slepa vetva vrat false
                    return null;
                }
            }
            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            }
        }

    }

    public boolean delete(int key) {

        current = root;
        if(root==null) return false; //ak je list prazdny skonci

        if (AisEqualToB(root.getKey(), key)) {
           // System.out.println("Delete node with key: " + key + "  priority: " + current.getPriority());
            manageDeleteIntegrity(current);
            return true;
        }

        while (true) {
            if (AisBiggerThanB(current.key,key)) {//ak je sucasny kluc vacsi ako kluc co vkladam, chod do lava
                //zisti ci je v volny lavy smernik, ak ano vloz, ak nie prestav ho na aktualny
                if (current.getLeft() != null) {
                    current = current.getLeft(); // ak nie prestav o na aktualny

                    if (AisEqualToB(current.getKey(),key)) {
                        manageDeleteIntegrity(current);
                      //  System.out.println("Delete node with key: " + key + "  priority: " + current.getPriority());
                        return true;
                    }

                    continue; // a pokracuj
                } else {//neexistuj hladany kluc
                    return false;
                }
            }
            if (AisBiggerThanB(key,current.key)) {//ak je sucasny kluc mensi ako kluc co hladam, chod do prava
                //zisti ci je v volny pravy smernik, ak ano vloz, ak nie prestav ho na aktualny
                if (current.getRight() != null) {
                    current = current.getRight();

                    if (AisEqualToB(current.getKey(),key)) {
                        manageDeleteIntegrity(current);
                       // System.out.println("Delete node with key: " + key + "  priority: " + current.getPriority());
                        return true;
                    }

                    continue; // a ukonci
                } else {//neexistuj hladany kluc
                    return false;
                }
            }
            if (current.getLeft() == null && current.getRight() == null) {
                return false;
            }
        }

    }


    public boolean insert(int key) {
        if (root == null) {
            root = new TNode(key, null);
           // System.out.println("Root vlozeny: " + key + "  priority: " + root.getPriority());

            return true;
        }

        current = root;
        while (true) {
            if (AisBiggerThanB(current.key,key) ) {//ak je sucasny kluc vacsi ako kluc co vkladam, chod do lava
                //zisti ci je v volny lavy smernik, ak ano vloz, ak nie prestav ho na aktualny
                if (current.getLeft() == null) {
                    current.setLeft(new TNode(key, current));// ak ano vloz
                    current = current.getLeft();

                    handleIntegrity();


                  //  System.out.println("Node vlozeny left: " + key + "  priority: " + current.getPriority());
                    return true; // a ukonci
                } else {
                    current = current.getLeft(); // ak nie prestav o na aktualny
                  //  System.out.println("<< go LEFT " + current.key + "  priority: " + current.getPriority() + " << ");
                    continue; // a pokracuj
                }
            }
            if (AisBiggerThanB(key,current.key)) {//ak je sucasny kluc mensi ako kluc co vkladam, chod do prava
                //zisti ci je v volny pravy smernik, ak ano vloz, ak nie prestav ho na aktualny
                if (current.getRight() == null) {
                    current.setRight(new TNode(key, current));// ak ano vloz
                    current = current.getRight();

                    handleIntegrity();


                 //   System.out.println("Node vlozeny right: " + key + "  priority: " + current.getPriority());
                    return true; // a ukonci
                } else { // prestav ho na aktualny
                    current = current.getRight(); // ak nie prestav o na aktualny
                  //  System.out.println(">> go RIGHT " + current.key + "  priority: " + current.getPriority() + " >> ");
                    continue; // a pokracuj
                }
            }
            if (AisEqualToB(current.key,key)) {
                System.out.print("DANY VRCHOL UZ EXISTUJE");
                return false;
            }
        }
    }

    public boolean insertT(int key,int priority) {
        if (root == null) {
            root = new TNode(key, null,priority);
            System.out.println("Root vlozeny: " + key + "  priority: " + root.getPriority());

            return true;
        }

        current = root;
        while (true) {
            if (AisBiggerThanB(current.key,key)) {//ak je sucasny kluc vacsi ako kluc co vkladam, chod do lava
                //zisti ci je v volny lavy smernik, ak ano vloz, ak nie prestav ho na aktualny
                if (current.getLeft() == null) {
                    current.setLeft(new TNode(key, current,priority));// ak ano vloz
                    current = current.getLeft();

                    handleIntegrity();


                    System.out.println("Node vlozeny left: " + key + "  priority: " + current.getPriority());
                    return true; // a ukonci
                } else {
                    current = current.getLeft(); // ak nie prestav o na aktualny
                    System.out.println("<< go LEFT " + current.key + "  priority: " + current.getPriority() + " << ");
                    continue; // a pokracuj
                }
            }
            if (AisBiggerThanB(key,current.key)) {//ak je sucasny kluc mensi ako kluc co vkladam, chod do prava
                //zisti ci je v volny pravy smernik, ak ano vloz, ak nie prestav ho na aktualny
                if (current.getRight() == null) {
                    current.setRight(new TNode(key, current,priority));// ak ano vloz
                    current = current.getRight();

                    handleIntegrity();


                    System.out.println("Node vlozeny right: " + key + "  priority: " + current.getPriority());
                    return true; // a ukonci
                } else { // prestav ho na aktualny
                    current = current.getRight(); // ak nie prestav o na aktualny
                    System.out.println(">> go RIGHT " + current.key + "  priority: " + current.getPriority() + " >> ");
                    continue; // a pokracuj
                }
            }
            if (AisEqualToB(current.key,key)) {
                System.out.print("DANY VRCHOL UZ EXISTUJE");
                return false;
            }
        }
    }

    private void manageDeleteIntegrity(TNode current) {
        while (true) {
            //current nema ani pravy ani lavy syn
            if (current.getLeft() == null && current.getRight() == null) {
                deleteNode(current);
                return;
            }
            //current ma len len lavy a je to list
            if (current.getLeft() != null && current.getRight() == null && hasOnlyLeafsOnLeft(current)) {
                if (root == current) {//ak vymazavam koren
                    setRoot(current.getLeft());
                    return;
                }
                //if (current.getParent().getKey() >= current.getKey()) {
                if (AisBiggerThanB(current.getParent().getKey(),current.getKey()) ||
                        AisEqualToB(current.getParent().getKey(), current.getKey())) {
                    current.getParent().setLeft(current.getLeft());// delete node by seting left side
                    return;
                }
                //if (current.getParent().getKey() <= current.getKey()) {
                if (AisBiggerThanB(current.getKey(),current.getParent().getKey()) ||
                        AisEqualToB(current.getParent().getKey() , current.getKey())) {
                    current.getParent().setRight(current.getLeft());// delete node by seting right side
                    return;
                }
                return;
            }
            //current ma len len pravy a je to list
            if (current.getRight() != null && current.getLeft() == null && hasOnlyLeafsOnRight(current)) {
                if (root == current) {//ak vymazavam koren
                    setRoot(current.getRight());
                    return;
                }
                if (AisBiggerThanB(current.getParent().getKey(), current.getKey()) ||
                        AisEqualToB(current.getParent().getKey(), current.getKey())) {
                    current.getParent().setLeft(current.getRight());
                    return;
                }
                if (AisBiggerThanB(current.getKey(), current.getParent().getKey()) ||
                        AisEqualToB(current.getParent().getKey(), current.getKey())) {
                    current.getParent().setRight(current.getRight());
                    return;
                }
                return;
            }
            //current ma praveho aj laveho syna, oba su listy a vyberie toho najvacsieho
            if (current.getRight() != null && current.getLeft() != null && hasOnlyLeafs(current)) {
                //ak kluc laveho je mensi ako kluc praveho
                TNode higherPriorityNode;
                TNode left;
                TNode right;
                left = current.getLeft();
                right = current.getRight();

                if (left.getPriority() > right.getPriority()) {
                    higherPriorityNode = right;
                    //ak je vacsi na pravo tak nastav pravy OBR. 5
                    if (current == root) {
                        setRoot(higherPriorityNode);
                    }
                    higherPriorityNode.setLeft(left);

                } else {
                    higherPriorityNode = left;
                    //obr 6
                    if (current == root) {
                        setRoot(higherPriorityNode);
                    }
                    higherPriorityNode.setRight(right);
                }
                if (current.getParent() != null) {// case there si a parent
                    //LEFT LEFT
                    //if (current.getParent().getKey() >= current.getKey()) {
                    if (AisBiggerThanB(current.getParent().getKey(), current.getKey()) ||
                            AisEqualToB(current.getParent().getKey(), current.getKey())) {
                        current.getParent().setLeft(higherPriorityNode);
                        return;
                    }
                    //RIGHT RIGHT
                    //if (current.getParent().getKey() <= current.getKey()) {
                    if (AisBiggerThanB(current.getKey(),current.getParent().getKey()) ||
                            AisEqualToB(current.getParent().getKey() , current.getKey())) {
                        current.getParent().setRight(higherPriorityNode);
                        return;
                    }
                }
                return;
            }
            // current nema laveho syna, tak rotuj dolava.
            // Mysli na to ze potrebujes rotovat podla current.getRight pozri implementaciu
            if (current.getLeft() == null) {
                rotateLeft(current.getRight());
                continue;
            }
            if (current.getRight() == null) {
                rotateRight(current.getLeft());
                continue;
            }
            // inak rotuj podla priority
            if (current.getLeft().getPriority() < current.getRight().getPriority()) {
                rotateRight(current.getLeft());
                continue;
            } else {
                rotateLeft(current.getRight());
                continue;
            }
        }

    }

    private boolean hasOnlyLeafs(TNode current) {
        if (current.getLeft().getLeft() == null &&
                current.getLeft().getRight() == null &&
                current.getRight().getLeft() == null &&
                current.getRight().getRight() == null) return true;
        else return false;
    }

    private boolean hasOnlyLeafsOnLeft(TNode current) {
        if (current.getLeft().getLeft() == null &&
                current.getLeft().getRight() == null) return true;
        else return false;
    }

    private boolean hasOnlyLeafsOnRight(TNode current) {
        if (current.getRight().getLeft() == null &&
                current.getRight().getRight() == null) return true;
        else return false;
    }

    private void deleteNode(TNode current) {
        //zisti ci je z pravej alebo lavej strany
        if (current == root) {//vymazavanie korena
            root = null;
            return;
        }

        if (AisBiggerThanB(current.getKey(),current.getParent().getKey())||
                AisEqualToB(current.getKey(),current.getParent().getKey()) ) {//RIGHT RIGHT
            current.getParent().setRight(null);
            current.setParent(null);
            return;
        }

        if (AisBiggerThanB(current.getParent().getKey(),current.getKey())) {//LEFT LEFT
            current.getParent().setLeft(null);
            current.setParent(null);
            return;
        }
    }

    private void handleIntegrity() {
        while (priorityOfCurrentIsNotOkey()) {
            if (isRightRight()) {

                rotateLeft(current);

                continue;
            }
            if (isLeftLeft()) {

                rotateRight(current);

                continue;
            }
        }

    }

    private boolean isRightRight() {
        if (AisBiggerThanB(current.getKey(),current.getParent().getKey())) {
            return true;
        }
        return false;
    }

    private boolean isLeftLeft() {
        if (AisBiggerThanB(current.getParent().getKey(),current.getKey())) {
            return true;
        }
        return false;
    }

    private void rotateLeft(TNode current) {
        TNode parent;
        TNode a, b;
        //---------

        //-----------
        TNode u, v;

        parent = getGrandParent(current);

        u = current.getParent();
        v = current;
        //-----------
        a = u;
        b = v;
        //------ inicializacia ukoncena---
        //------ prehadzovanie smernikov--
        //------------
        u = b;//1 krok

        if (a != null) {
            a.setRight(b.getLeft());//prava vetva nodu A preberie lavy podstrom vrcholu B
        }


        // KROK 2 bacha na presmerovanie korana dolava

        if (a == root) {
            setRoot(u);
            u.setLeft(a);
        } else {
            u.setLeft(a);
        }


        // KROK 4 spojenie s rozpojenou vetvou, spojenie s rodicom
        if (parent != null) {
            if (AisBiggerThanB(u.getKey(),parent.getKey())||
                AisEqualToB(u.getKey(),parent.getKey()) ) {//RIGHT RIGHT
                parent.setRight(u);
            }
            if (AisBiggerThanB(parent.getKey(),u.getKey())) {//LEFT LEFT
                parent.setLeft(u);
            }
        }
        current = u;


    }


    private void rotateRight(TNode current) {
        {
            TNode parent;
            TNode a, b;
            //---------

            //-----------
            TNode u, v;

            parent = getGrandParent(current);

            u = current.getParent();
            v = current;
            //-----------
            a = v;
            b = u;
            //------ inicializacia ukoncena---
            //------ prehadzovanie smernikov--
            //------------
            u = v; // krok 1


            b.setLeft(a.getRight());//krok 2 prava vetva nodu A preberie lavy podstrom vrcholu B


            // bacha na presmerovanie korana dolava
            if (b == root) {
                setRoot(u);
                u.setRight(b);
            } else {
                u.setRight(b);
            }


            // KROK 4 spojenie s rozpojenou vetvou, spojenie s rodicom
            if (parent != null) {
                if (AisBiggerThanB(u.getKey(),parent.getKey())||AisEqualToB(u.getKey(),parent.getKey()) ) {//RIGHT RIGHT
                    parent.setRight(u);
                }
                if (AisBiggerThanB(parent.getKey(),u.getKey())) {//LEFT LEFT
                    parent.setLeft(u);
                }
            }
            current = u;

        }
    }

    private TNode getGrandGrandParent() {
        if (current.getParent() != null) {
            if (current.getParent().getParent() != null) {
                return current.getParent().getParent().getParent();
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    private TNode getGrandParent(TNode current) {
        if (current.getParent() != null) {
            return current.getParent().getParent();
        } else {
            return null;
        }
    }


    /**
     * ak je priorita sucasneho vacsia ako priorita rodica, tak je integrita v poriadku
     *
     * @return
     */
    private boolean priorityOfCurrentIsNotOkey() {

        if(current.getParent()==null){
            return false;
        }
        if (current.getPriority() < current.getParent().getPriority()) {
            return true;// ak ma sucasny mensiu prioritu ako rodic, tak to nie je v poriadku
        } else {
            return false;
        }
    }

    private void generalTestRotationLeft() {
        Treap treap = new Treap();
        TNode a = new TNode(1, 10);
        TNode b = new TNode(2, 20);
        TNode c = new TNode(3, 30);
        TNode d = new TNode(4, 40);
        TNode e = new TNode(5, 35);

        //-----------------------
        treap.setRoot(a);
        a.setRight(b);
        b.setRight(c);
        c.setRight(d);
        d.setRight(e);
        current = e;
        rotateLeft(current);
    }


    private void generalTestRotationRight() {
        Treap treap = new Treap();
        TNode a = new TNode(5, 50);
        TNode b = new TNode(4, 40);
        TNode c = new TNode(3, 30);
        TNode d = new TNode(2, 20);
        TNode e = new TNode(1, 25);


        //-----------------------
        treap.setRoot(a);
        a.setLeft(b);
        b.setLeft(c);
        c.setLeft(d);
        d.setLeft(e);
        current = e;
        rotateRight(current);
    }

    private void generalTestRotationLeft2() {
        TNode a = new TNode(1, 93);
        TNode b = new TNode(2, 75);

        //-----------------------
        setRoot(a);
        a.setRight(b);
        current = b;
        rotateLeft(current);
    }

    private void generalTestRotationRight2() {
        TNode a = new TNode(2, 93);
        TNode b = new TNode(1, 75);

        //-----------------------
        setRoot(a);
        a.setLeft(b);
        current = b;
        rotateRight(current);
    }

    // prints in level order
    public void levelOrderTraversal(TNode startNode) {
        if (root != null) {
            System.out.println("Root is : " + root.getKey());

            Queue<TNode> queue = new LinkedList<TNode>();
            queue.add(startNode);
            while (!queue.isEmpty()) {
                TNode tempNode = queue.poll();
                System.out.printf("%d ", tempNode.getKey());
                if (tempNode.getLeft() != null)
                    queue.add(tempNode.getLeft());
                if (tempNode.getRight() != null)
                    queue.add(tempNode.getRight());
            }
        }
    }

    // prints in level order
    public int levelOrderCount(TNode startNode) {
        int counter = 0;
        Queue<TNode> queue = new LinkedList<TNode>();
        queue.add(startNode);
        while (!queue.isEmpty()) {
            TNode tempNode = queue.poll();
            //System.out.printf("%d ",tempNode.getKey());
            counter++;
            if (tempNode.getLeft() != null)
                queue.add(tempNode.getLeft());
            if (tempNode.getRight() != null)
                queue.add(tempNode.getRight());
        }
        return counter;
    }

    public void testMethod(int limit, boolean writeDown) {
        LinkedList<TNode> list = new LinkedList<TNode>();
        for (int i = 1; i <= limit; i++) {
            insert(i);
            list.add(new TNode(i, i * 10));
        }
        int counter = levelOrderCount(root);
        System.out.println("Counter level order: " + counter);
        System.out.println("List size: " + list.size());

        if (writeDown) {
            System.out.println();
            System.out.println("List:");
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i).getKey() + ", ");
            }
            System.out.println();
            System.out.println("LevelOrder:");
            levelOrderTraversal(root);
        }

        System.out.println("\n\nSearch results");
        System.out.println("Kluc cislo 1 " + search(1).getKey());
        System.out.println("Kluc cislo 1 " + search(6).getKey());
        System.out.println("Kluc cislo 1 " + search(2).getKey());


    }

    public void testDeleteLeftLeft() {
        TNode a = new TNode(7, 10);
        TNode b = new TNode(6, 8);
        TNode c = new TNode(5, 7);

        setRoot(a);
        a.setLeft(b);
        b.setLeft(c);

        current = b;
        delete(6);

        levelOrderTraversal(root);

    }

    public void testDeleteRightRight() {
        TNode a = new TNode(5, 7);
        TNode b = new TNode(6, 8);
        TNode c = new TNode(7, 10);


        setRoot(a);
        a.setRight(b);
        b.setRight(c);

        current = c;
        delete(6);

        levelOrderTraversal(root);

    }

    public void testDeleteBothSide() {
        TNode a = new TNode(7, 10);
        TNode b = new TNode(6, 20);
        TNode c = new TNode(9, 30);


        setRoot(a);
        a.setLeft(b);
        a.setRight(c);

        current = c;
        delete(7);

        levelOrderTraversal(root);

    }

    public void testDeleteBothSideHigher() {
        TNode p = new TNode(15, 2);
        TNode a = new TNode(7, 10);
        TNode b = new TNode(6, 30);
        TNode c = new TNode(8, 60);


        setRoot(p);
        p.setLeft(a);
        a.setLeft(b);
        a.setRight(c);

        current = c;
        delete(7);


        levelOrderTraversal(root);

    }

    public void testDeleteRotateLeftLeft() {
        TNode a = new TNode(4, 10);
        TNode b = new TNode(3, 20);
        TNode c = new TNode(2, 30);
        TNode d = new TNode(1, 40);

        setRoot(a);
        a.setLeft(b);
        b.setLeft(c);
        c.setLeft(d);

        current = d;
        delete(4);

        levelOrderTraversal(root);

    }


    public void testInsertDelete(int rounds) {
        System.out.println("Insert part");
        for (int i = 1; i < rounds; i++) {
            insert(i);
            levelOrderTraversal(root);
            System.out.println();
        }
        System.out.println("Delete part");
        for (int i = 1; i < rounds; i++) {
            delete(i);
            levelOrderTraversal(root);
            System.out.println();
        }
    }

    public void insertTest(){
        insertT(1,61);
        insertT(2,68);
        insertT(3,29);
        insertT(4,29);
        insertT(5,99);
        insertT(6,79);
        insertT(7,52);
        insertT(8,19);
        insertT(9,25);

        delete(1);
        delete(2);
        delete(3);
        delete(4);
        delete(5);
        delete(6);
        delete(7);
        delete(8);
        delete(9);
    }
    public void seriousTestMethod(int rounds){
        TreeMap<Integer,String> helpStructure = new TreeMap<Integer, String>();
        int size;
        int sizeHelp;

        //INSERT PART
        for(int i=0;i<rounds;i++){
            insert(i);
            helpStructure.put(i,"");
        }
        if(levelOrderCount(root)==helpStructure.size()){
            System.out.println("Same size" + helpStructure.size());
        } else {
            System.out.println("PROBLEM different size");
        }
        //RANDOM DELELETE PART
        Random random = new Random();
        int randomIndex;
        TNode nodeFound;
        for (int i=0;i<rounds/2;i++){
            randomIndex = random.nextInt(rounds);
            helpStructure.remove(randomIndex);
            delete(randomIndex);
            nodeFound = search(randomIndex);
            if(nodeFound!=null){
                System.out.println("We found the node, which was deleted");
            }
            if(i==5){
                System.out.println("A mame ho junaka");
            }
        }
        System.out.println("Delete session completed");
        System.out.println();
        System.out.println("Compare size of structure");
        if(levelOrderCount(root)==helpStructure.size()){
            System.out.println("Same size" + helpStructure.size());
        } else {
            System.out.println("PROBLEM different size");
        }


    }


    public static void main(String[] args) {
        Treap treap = new Treap();

//
//        treap.insert(1);
//        treap.insert(2);
//        treap.insert(3);
//        treap.insert(4);
//        treap.insert(5);
//        treap.insert(6);
//        treap.insert(7);
//        treap.insert(8);
//
//        levelOrderTraversal(treap.root);
        //treap.testMethod(10, true);
        treap.seriousTestMethod(1000000);


    }
}
