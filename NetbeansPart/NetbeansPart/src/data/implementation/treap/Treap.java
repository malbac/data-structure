package data.implementation.treap;

import structure.classes.KatastralnyUrad;
import structure.searchIndex.KatastralnyUradId;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

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


    public int size(){
        return levelOrderCount(root);
    }

    public TNode search(TNode key) {
        current = root;
        //if (root.getKey() == key) {
        if (root.isEqualTo(key)) {
           // System.out.println("Found node with key: " + key + "  priority: " + current.getPriority());
            return current;
        }
        while (true) {
            //if (key < current.key) {//ak je sucasny kluc vacsi ako kluc co vkladam, chod do lava
            if (current.isBiggerThan(key)) {//ak je sucasny kluc vacsi ako kluc co vkladam, chod do lava
                //zisti ci je v volny lavy smernik, ak ano vloz, ak nie prestav ho na aktualny
                if (current.getLeft() != null) {
                    current = current.getLeft(); // ak nie prestav o na aktualny

                    if (current.isEqualTo(key)) {
                       // System.out.println("Found node with key: " + key + "  priority: " + current.getPriority());
                        return current;
                    }

                    continue; // a pokracuj
                } else { //nasla sa slepa vetva vrat false
                    return null;
                }
            }
            if (key.isBiggerThan(current)) {//ak je sucasny kluc mensi ako kluc co vkladam, chod do prava
                //zisti ci je v volny pravy smernik, ak ano vloz, ak nie prestav ho na aktualny
                if (current.getRight() != null) {
                    current = current.getRight();

                    if (current.isEqualTo(key)) {
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

    public boolean remove(TNode key) {

        current = root;
        if(root==null) return false; //ak je list prazdny skonci

        if (root.isEqualTo(key)) {
           // System.out.println("Delete node with key: " + key + "  priority: " + current.getPriority());
            manageDeleteIntegrity(current);
            return true;
        }

        while (true) {
            if (current.isBiggerThan(key)) {//ak je sucasny kluc vacsi ako kluc co vkladam, chod do lava
                //zisti ci je v volny lavy smernik, ak ano vloz, ak nie prestav ho na aktualny
                if (current.getLeft() != null) {
                    current = current.getLeft(); // ak nie prestav o na aktualny

                    if (current.isEqualTo(key)) {
                        manageDeleteIntegrity(current);
                      //  System.out.println("Delete node with key: " + key + "  priority: " + current.getPriority());
                        return true;
                    }

                    continue; // a pokracuj
                } else {//neexistuj hladany kluc
                    return false;
                }
            }
            if (key.isBiggerThan(current))
            {//ak je sucasny kluc mensi ako kluc co hladam, chod do prava
                //zisti ci je v volny pravy smernik, ak ano vloz, ak nie prestav ho na aktualny
                if (current.getRight() != null) {
                    current = current.getRight();

                    if (current.isEqualTo(key)) {
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


    public boolean insert(TNode newNode) {
        if (root == null) {
            root = newNode;
           // System.out.println("Root vlozeny: " + newNode + "  priority: " + root.getPriority());

            return true;
        }

        current = root;
        while (true) {
            if (current.isBiggerThan(newNode) ) {//ak je sucasny kluc vacsi ako kluc co vkladam, chod do lava
                //zisti ci je v volny lavy smernik, ak ano vloz, ak nie prestav ho na aktualny
                if (current.getLeft() == null) {
                    current.setLeft(newNode);// ak ano vloz
                    current = current.getLeft();

                    handleIntegrity();


                  //  System.out.println("Node vlozeny left: " + newNode + "  priority: " + current.getPriority());
                    return true; // a ukonci
                } else {
                    current = current.getLeft(); // ak nie prestav o na aktualny
                  //  System.out.println("<< go LEFT " + current.newNode + "  priority: " + current.getPriority() + " << ");
                    continue; // a pokracuj
                }
            }
            if (newNode.isBiggerThan(current)) {//ak je sucasny kluc mensi ako kluc co vkladam, chod do prava
                //zisti ci je v volny pravy smernik, ak ano vloz, ak nie prestav ho na aktualny
                if (current.getRight() == null) {
                    current.setRight(newNode);// ak ano vloz
                    current = current.getRight();

                    handleIntegrity();


                 //   System.out.println("Node vlozeny right: " + newNode + "  priority: " + current.getPriority());
                    return true; // a ukonci
                } else { // prestav ho na aktualny
                    current = current.getRight(); // ak nie prestav o na aktualny
                  //  System.out.println(">> go RIGHT " + current.newNode + "  priority: " + current.getPriority() + " >> ");
                    continue; // a pokracuj
                }
            }
            if (current.isEqualTo(newNode)) {
                //System.out.print("DANY VRCHOL UZ EXISTUJE");
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
                if (current.getParent().isBiggerThan(current) ||
                        current.getParent().isEqualTo(current)) {
                    current.getParent().setLeft(current.getLeft());// remove node by seting left side
                    return;
                }
                //if (current.getParent().getKey() <= current.getKey()) {
                if (current.isBiggerThan(current.getParent()) ||
                        current.getParent().isEqualTo(current)) {
                    current.getParent().setRight(current.getLeft());// remove node by seting right side
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
                if (current.getParent().isBiggerThan(current) ||
                        current.getParent().isEqualTo(current)) {
                    current.getParent().setLeft(current.getRight());
                    return;
                }
                if (current.isBiggerThan(current.getParent()) ||
                        current.getParent().isEqualTo(current)) {
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
                    if (current.getParent().isBiggerThan( current) ||
                            current.getParent().isEqualTo(current)) {
                        current.getParent().setLeft(higherPriorityNode);
                        return;
                    }
                    //RIGHT RIGHT
                    //if (current.getParent().getKey() <= current.getKey()) {
                    if (current.isBiggerThan(current.getParent()) ||
                            current.getParent().isEqualTo(current)) {
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
            } else {
                rotateLeft(current.getRight());
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

        if (current.isBiggerThan(current.getParent())||
                current.isEqualTo(current.getParent()) ) {//RIGHT RIGHT
            current.getParent().setRight(null);
            current.setParent(null);
            return;
        }

        if (current.getParent().isBiggerThan(current)) {//LEFT LEFT
            current.getParent().setLeft(null);
            current.setParent(null);
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
            }
        }

    }

    private boolean isRightRight() {
        if (current.isBiggerThan(current.getParent())) {
            return true;
        }
        return false;
    }

    private boolean isLeftLeft() {
        if (current.getParent().isBiggerThan(current)) {
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
            if (u.isBiggerThan(parent)||
                u.isEqualTo(parent) ) {//RIGHT RIGHT
                parent.setRight(u);
            }
            if (parent.isBiggerThan(u)) {//LEFT LEFT
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
                if (u.isBiggerThan(parent)|| u.isEqualTo(parent) ) {//RIGHT RIGHT
                    parent.setRight(u);
                }
                if (parent.isBiggerThan( u)) {//LEFT LEFT
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








    // prints in level order
    public void levelOrder(TNode startNode) {
        if (root != null) {
            System.out.println("Root is : " + root);

            Queue<TNode> queue = new LinkedList<TNode>();
            queue.add(startNode);
            while (!queue.isEmpty()) {
                TNode tempNode = queue.poll();
                KatastralnyUradId katastralnyUradId = ((KatastralnyUradId)tempNode);
                System.out.printf("%d ", katastralnyUradId.getDataReference().getId_uradu());
                if (tempNode.getLeft() != null)
                    queue.add(tempNode.getLeft());
                if (tempNode.getRight() != null)
                    queue.add(tempNode.getRight());
            }
        }
    }

    // prints in level order
    public void levelOrder() {
        levelOrder(root);
    }

    // prints in level order
    public int levelOrderCount(TNode startNode) {
        if(startNode==null)return 0;
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

    void inOrder (TNode root)
    {

        if(root == null) return;

        inOrder(root.getLeft());
        KatastralnyUradId katastralnyUradId = ((KatastralnyUradId)root);
        System.out.printf("%d ", katastralnyUradId.getDataReference().getId_uradu());
        inOrder( root.getRight() );

    }

    public LinkedList<TNode> inorderTraversal(TNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        LinkedList<TNode> lst = new LinkedList<TNode>();

        if(root == null)
            return lst;

        Stack<TNode> stack = new Stack<TNode>();
        //define a pointer to track nodes
        TNode p = root;

        while(!stack.empty() || p != null){

            // if it is not null, push to stack
            //and go down the tree to left
            if(p != null){
                stack.push(p);
                p = p.getLeft();

                // if no left child
                // pop stack, process the node
                // then let p point to the right
            }else{
                TNode t = stack.pop();
                lst.add(t);
                p = t.getRight();
            }
        }

        return lst;
    }

    public LinkedList<TNode> inorderTraversal() {
        return inorderTraversal(root);
    }




    public void seriousTestMethod(int rounds){
        LinkedList<TNode> helpStructure = new LinkedList<TNode>();

        //INSERT PART
        KatastralnyUradId katastralnyUradId;
        for(int i=0;i<rounds;i++){
            katastralnyUradId = new KatastralnyUradId(new KatastralnyUrad(i));
            insert(katastralnyUradId);
            helpStructure.add(katastralnyUradId);
        }
        if(levelOrderCount(root)==helpStructure.size()){
            System.out.println("Same size" + helpStructure.size());
        } else {
            System.out.println("PROBLEM different size");
        }
        //RANDOM DELELETE PART
        Random random = new Random();
        TNode randomTNode;
        Object nodeFound;
        for (int i=0;i<rounds/2;i++){
            randomTNode = helpStructure.get(random.nextInt(rounds/2));
            helpStructure.remove(randomTNode);
            remove(randomTNode);
            nodeFound = search(randomTNode);
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

    public void insertTest(int rounds){

        //INSERT PART
        KatastralnyUradId katastralnyUradId;
        for(int i=0;i<rounds;i++){
            katastralnyUradId = new KatastralnyUradId(new KatastralnyUrad(1));
            insert(katastralnyUradId);
        }
        System.out.println("Data inserted");


    }

    public static void main(String[] args){
        Treap treap = new Treap();
        treap.insertTest(5);
        //treap.levelOrder();
        treap.inOrder(treap.root);
        //treap.insertTest(100000);
    }


    public TNode getRoot() {
        return root;
    }
}
