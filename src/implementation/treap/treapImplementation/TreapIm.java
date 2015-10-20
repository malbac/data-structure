package implementation.treap.treapImplementation;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Malbac on 19.10.2015.
 */
public class TreapIm {

    private TNode root;
    private TNode current;

    private void setRoot(TNode root) {
        this.root = root;
        this.root.setParent(null);
    }

    public TNode search(int key){
        current = root;
        if (root.getKey() == key) {
            System.out.println("Found node with key: " + key + "  priority: " + current.getPriority());
            return current;
        }

        while (true) {
            if (key < current.key) {//ak je sucasny kluc vacsi ako kluc co vkladam, chod do lava
                //zisti ci je v volny lavy smernik, ak ano vloz, ak nie prestav ho na aktualny
                if (current.getLeft() != null) {
                    current = current.getLeft(); // ak nie prestav o na aktualny

                    if (current.getKey() == key) {
                        System.out.println("Found node with key: " + key + "  priority: " + current.getPriority());
                        return current;
                    }

                    continue; // a pokracuj
                }
            }
            if (current.key < key) {//ak je sucasny kluc mensi ako kluc co vkladam, chod do prava
                //zisti ci je v volny pravy smernik, ak ano vloz, ak nie prestav ho na aktualny
                if (current.getRight() != null) {
                    current = current.getRight();

                    if (current.getKey() == key) {
                        System.out.println("Found node with key: " + key + "  priority: " + current.getPriority());
                        return current;
                    }

                    continue; // a ukonci
                }
            }
            if(current.getLeft()==null && current.getRight()==null){
                return null;
            }
        }

    }

    public boolean delete(int key) {
        current = root;
        if (root.getKey() == key) {
            System.out.println("Delete node with key: " + key + "  priority: " + current.getPriority());
            manageDeleteIntegrity(current);
            return true;
        }

        while (true) {
            if (key < current.key) {//ak je sucasny kluc vacsi ako kluc co vkladam, chod do lava
                //zisti ci je v volny lavy smernik, ak ano vloz, ak nie prestav ho na aktualny
                if (current.getLeft() != null) {
                    current = current.getLeft(); // ak nie prestav o na aktualny

                    if (current.getKey() == key) {
                        manageDeleteIntegrity(current);
                        System.out.println("Delete node with key: " + key + "  priority: " + current.getPriority());
                        return true;
                    }

                    continue; // a pokracuj
                }
            }
            if (current.key < key) {//ak je sucasny kluc mensi ako kluc co vkladam, chod do prava
                //zisti ci je v volny pravy smernik, ak ano vloz, ak nie prestav ho na aktualny
                if (current.getRight() == null) {
                    current = current.getRight();

                    if (current.getKey() == key) {
                        manageDeleteIntegrity(current);
                        System.out.println("Delete node with key: " + key + "  priority: " + current.getPriority());
                        return true;
                    }

                    continue; // a ukonci
                }
            }
            if(current.getLeft()==null && current.getRight()==null){
                return false;
            }
        }

    }


    public boolean insert(int key) {
        if (root == null) {
            root = new TNode(key, null);
            System.out.println("Root vlozeny: " + key + "  priority: " + root.getPriority());

            return true;
        }

        current = root;
        while (true) {
            if (key < current.key) {//ak je sucasny kluc vacsi ako kluc co vkladam, chod do lava
                //zisti ci je v volny lavy smernik, ak ano vloz, ak nie prestav ho na aktualny
                if (current.getLeft() == null) {
                    current.setLeft(new TNode(key, current));// ak ano vloz
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
            if (current.key < key) {//ak je sucasny kluc mensi ako kluc co vkladam, chod do prava
                //zisti ci je v volny pravy smernik, ak ano vloz, ak nie prestav ho na aktualny
                if (current.getRight() == null) {
                    current.setRight(new TNode(key, current));// ak ano vloz
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
            if (current.key == key) {
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
            if (current.getLeft() != null && current.getRight() == null && hasOnlyLeafs(current)) {
                if (current.getParent().getKey() >= current.getKey()) {
                    current.getParent().setLeft(current.getLeft());
                }
                if (current.getParent().getKey() <= current.getKey()) {
                    current.getParent().setRight(current.getLeft());
                }
                return;
            }
            //current ma len len pravy a je to list
            if (current.getRight() != null && current.getLeft() == null && hasOnlyLeafs(current)) {
                if (current.getParent().getKey() >= current.getKey()) {
                    current.getParent().setLeft(current.getRight());
                }
                if (current.getParent().getKey() <= current.getKey()) {
                    current.getParent().setRight(current.getRight());
                }
                return;
            }
            //current ma praveho aj laveho syna, oba su listy a vyberie toho najvacsieho
            if (current.getRight() != null && current.getLeft() != null && hasOnlyLeafs(current)) {
                //ak kluc laveho je mensi ako kluc praveho
                TNode biggerNode;
                TNode left;
                TNode right;
                left = current.getLeft();
                right = current.getRight();

                if (left.getPriority() < right.getPriority()) {
                    biggerNode = right;
                    //ak je vacsi na pravo tak nastav pravy OBR. 5
                    biggerNode.setLeft(left);
                } else {
                    biggerNode = left;
                    //obr 6
                    biggerNode.setRight(right);
                }
                //LEFT LEFT
                if (current.getParent().getKey() >= current.getKey()) {
                    current.getParent().setLeft(biggerNode);
                }
                //RIGHT RIGHT
                if (current.getParent().getKey() <= current.getKey()) {
                    current.getParent().setRight(biggerNode);
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
        if (current.getLeft().getLeft() != null) return true;
        if (current.getLeft().getRight() != null) return true;
        if (current.getRight().getLeft() != null) return true;
        if (current.getRight().getRight() != null) return true;
        else return false;
    }

    private void deleteNode(TNode current) {
        //zisti ci je z pravej alebo lavej strany
        if (current.getParent().getKey() <= current.getKey()) {//RIGHT RIGHT
            current.getParent().setRight(null);
            current.setParent(null);
        }
        if (current.getParent().getKey() > current.getKey()) {//LEFT LEFT
            current.getParent().setLeft(null);
            current.setParent(null);
        }
    }

    private void handleIntegrity() {
        while (priorityOfCurrentIsNotOkey()) {
            if (isRightRight()) {

                rotateLeft(current);

                return;
            }
            if (isLeftLeft()) {

                rotateRight(current);

                return;
            }
        }

    }

    private boolean isRightRight() {
        if (current.getKey() > current.getParent().getKey()) {
            return true;
        }
        return false;
    }

    private boolean isLeftLeft() {
        if (current.getKey() < current.getParent().getKey()) {
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

        parent = getGrandParent();

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
            if (parent.getKey() <= u.getKey()) {//RIGHT RIGHT
                parent.setRight(u);
            }
            if (parent.getKey() > u.getKey()) {//LEFT LEFT
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

            parent = getGrandParent();

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
                if (parent.getKey() <= u.getKey()) {//RIGHT RIGHT
                    parent.setRight(u);
                }
                if (parent.getKey() > u.getKey()) {//LEFT LEFT
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

    private TNode getGrandParent() {
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

        if (current.getPriority() < current.getParent().getPriority()) {
            return true;// ak ma sucasny mensiu prioritu ako rodic, tak to nie je v poriadku
        } else {
            return false;
        }
    }

    private void generalTestRotationLeft() {
        TreapIm treapIm = new TreapIm();
        TNode a = new TNode(1, 10);
        TNode b = new TNode(2, 20);
        TNode c = new TNode(3, 30);
        TNode d = new TNode(4, 40);
        TNode e = new TNode(5, 35);

        //-----------------------
        treapIm.setRoot(a);
        a.setRight(b);
        b.setRight(c);
        c.setRight(d);
        d.setRight(e);
        current = e;
        rotateLeft(current);
    }


    private void generalTestRotationRight() {
        TreapIm treapIm = new TreapIm();
        TNode a = new TNode(5, 50);
        TNode b = new TNode(4, 40);
        TNode c = new TNode(3, 30);
        TNode d = new TNode(2, 20);
        TNode e = new TNode(1, 25);


        //-----------------------
        treapIm.setRoot(a);
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
        Queue<TNode> queue=new LinkedList<TNode>();
        queue.add(startNode);
        while(!queue.isEmpty())
        {
            TNode tempNode=queue.poll();
            System.out.printf("%d ",tempNode.getKey());
            if(tempNode.getLeft()!=null)
                queue.add(tempNode.getLeft());
            if(tempNode.getRight()!=null)
                queue.add(tempNode.getRight());
        }
    }

    // prints in level order
    public int levelOrderCount(TNode startNode) {
        int counter = 0;
        Queue<TNode> queue=new LinkedList<TNode>();
        queue.add(startNode);
        while(!queue.isEmpty())
        {
            TNode tempNode=queue.poll();
            //System.out.printf("%d ",tempNode.getKey());
            counter++;
            if(tempNode.getLeft()!=null)
                queue.add(tempNode.getLeft());
            if(tempNode.getRight()!=null)
                queue.add(tempNode.getRight());
        }
        return counter;
    }

    public void testMethod(int limit,boolean writeDown){
        LinkedList<TNode> list = new LinkedList<TNode>();
        for (int i=1;i<=limit;i++){
        insert(i);
        list.add(new TNode(i,i*10));
        }
        int counter = levelOrderCount(root);
        System.out.println("Counter level order: " + counter);
        System.out.println("List size: " + list.size());

        if(writeDown) {
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


    public static void main(String[] args) {
        TreapIm treapIm = new TreapIm();

//
//        treapIm.insert(1);
//        treapIm.insert(2);
//        treapIm.insert(3);
//        treapIm.insert(4);
//        treapIm.insert(5);
//        treapIm.insert(6);
//        treapIm.insert(7);
//        treapIm.insert(8);
//
//        levelOrderTraversal(treapIm.root);
        treapIm.testMethod(10, true);


    }
}
