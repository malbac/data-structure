package RBTreeImplementation;

import java.util.LinkedList;

/**
 * Created by Malbac on 14.10.2015.
 */
public class RBTree {
    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    private Node root;
    private Node current;

    public void insert(int key) {
        if (root == null) {
            root = new Node(key, null);
            root.setBlack();
            System.out.println("Root vlozeny: " + key + " " + printColor(root));

            return;
        }

        current = root;
        boolean inserted = false;
        while (!inserted) {
            if (key < current.key) {//ak je sucasny kluc vacsi ako kluc co hladam, chod do lava
                //zisti ci je v volny lavy smernik, ak ano vloz, ak nie prestav ho na aktualny
                if (current.getLeft() == null) {
                    current.setLeft(new Node(key, current));// ak ano vloz
                    current.getLeft().setRed();
                    if (isCaseOneLeft()) {

                    }
                    System.out.println("Node vlozeny left: " + key + " " + printColor(current.getLeft()));
                    break; // a ukonci
                } else {
                    current = current.getLeft(); // ak nie prestav o na aktualny
                    System.out.println("<< go LEFT " + current.key + printColor(current) + " << ");
                    continue; // a pokracuj
                }
            }
            if (current.key < key) {//ak je sucasny kluc mensi ako kluc co hladam, chod do prava
                //zisti ci je v volny pravy smernik, ak ano vloz, ak nie prestav ho na aktualny
                if (current.getRight() == null) {
                    current.setRight(new Node(key, current));// ak ano vloz
                    current.getRight().setRed();
                    current = current.getRight();
                    if (twoRedInTheRow()) {
                        if (isCaseOneRight()) {
                            rotateLeft();
                            //printSimpleOrder();
                        }
                    }
                    System.out.println("Node vlozeny right: " + key + " " + printColor(current));
                    break; // a ukonci
                } else { // prestav ho na aktualny
                    current = current.getRight(); // ak nie prestav o na aktualny
                    System.out.println(">> go RIGHT " + current.key + printColor(current) + " >> ");
                    continue; // a pokracuj
                }
            }
            if (current.key == key) {
                System.out.print("DANY VRCHOL UZ EXISTUJE");
                break;
            }
        }
    }

    private void printSimpleOrder() {
        LinkedList<Node> list1 = new LinkedList<Node>();
        LinkedList<Node> list2 = new LinkedList<Node>();

        Node current = root;

        System.out.println("SIMPLE ORDER PREHLIADKA");

        //System.out.print(root.getLeft().getKey() + "<<LEFT");
        System.out.print("::ROOT >>" + root.getKey() + "<<::ROOT::");
        //System.out.print("RIGHT >>" + root.getRight().getKey());
        System.out.println();

        if (current.getLeft() != null) {
            list1.addLast(current.getLeft());
        }
        if (current.getRight() != null) {
            list1.addLast(current.getRight());
        }


        int sizeList1 = list1.size();

        while (!list1.isEmpty()) {
            for (int i = 0; i < sizeList1; i++) {
                //
                try {
                    if (list1.get(i).getLeft() != null) {
                        System.out.print(list1.get(i).getLeft().getKey() + "<<LEFT");
                    }
                } catch (NullPointerException e) {
                    //System.out.print("NULL <<LEFT");
                }
                try {

                    if (list1.get(i).getKey() != -1) {
                        System.out.print(" ::" + list1.get(i).getKey() + ":: ");
                    }
                } catch (NullPointerException e) {
                }
                try {
                    if (list1.get(i).getRight() != null) {
                        System.out.print("RIGHT >>" + list1.get(i).getRight().getKey());
                    }
                } catch (NullPointerException e) {
                    //System.out.print("RIGHT >>NULL");
                }


            }
            System.out.println();
            //-----uloz si docaste sucasny list
            for (int i = 0; i < sizeList1; i++) {
                list2.add(list1.get(i));
            }
            //----vymaz list jedna
            list1.clear();
            //----vytvor dalsi level
            for (int i = 0; i < list2.size(); i++) {
                try {
                    if (list2.get(i).getLeft() != null) {
                        list1.addLast(list2.get(i).getLeft());
                    }
                } catch (NullPointerException e) {
                }
                try {
                    if (list2.get(i).getRight() != null) {
                        list1.addLast(list2.get(i).getRight());
                    }
                } catch (NullPointerException e) {
                }
            }
            //----list 1 je opat pripraveny, vymazeme list 2
            list2.clear();
        }
    }

    private void rotateLeft() {
        Node a, b, c;
        //---------

        //-----------
        Node u, v, z;
        u = current.getParent().getParent();
        v = current.getParent();
        z = current;
        //-----------
        a = u;
        b = v;
        c = z;
        //------ inicializacia ukoncena---
        //------ prehadzovanie smernikov--
        //------------
        u = b;

        if (b.getLeft() != null) {
            a.setRight(b.getLeft());//prava vetva nodu A preberie lavy podstrom vrcholu B
        }

        // bacha na presmerovanie korana dolava
        if (a == root) {
            setRoot(u);
            u.setLeft(a);
        } else {
            u.setLeft(a);
        }

        // bacha na presmerovanie korana doprava
        if (c == root) {
            setRoot(u);
            u.setRight(c);
        } else {
            u.setRight(c);
        }


        //-----ZAFARBENIE------------------
        b.setBlack();
        a.setRed();
        c.setRed();
    }


    private boolean isCaseOneRight() {


        if (current.getParent().getKey() < current.getKey()) {//ak je rodic vacsi ako current, tak sa spytaj ci je lavy syn cierny,ak ja som cerveny
            System.out.println("rodic je vacsi ako current");
            if (current.isRed()) {//plati sucasny je cerveny a sucasne otec ukazuje na laveho syna ktory je null, alebo je cierny
                System.out.println("plati sucasny je cerveny");
                if (current.getParent().getLeft() == null) {
                    System.out.println("--CASE 1 SEARCH RIGHT--");
                    System.out.println("--CURRENT " + testCurrentKey());
                    System.out.println("--PARENT " + testGetParrentKey());
                    System.out.println("--PARENT RIGHT " + testGetParentRightKey());
                    System.out.println("--PARENT LEFT " + testGetParentLeftKey());
                    System.out.println("--END CASE 1 -----");

                    System.out.println("PARENT>>LEFT>>NULL");
                    return true;
                } else if (!current.getParent().getLeft().isRed()) {
                    System.out.println("--CASE 1 SEARCH RIGHT--");
                    System.out.println("--CURRENT " + testCurrentKey());
                    System.out.println("--PARENT " + testGetParrentKey());
                    System.out.println("--PARENT RIGHT " + testGetParentRightKey());
                    System.out.println("--PARENT LEFT " + testGetParentLeftKey());
                    System.out.println("--END CASE 1 -----");

                    System.out.println("PARENT>>LEFT>>black");
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isCaseOneLeft() {
        System.out.println("--CASE 1 LEFT SEARCH --");
        System.out.println("--CURRENT " + testCurrentKey());
        System.out.println("--PARENT " + testGetParrentKey());
        System.out.println("--PARENT RIGHT " + testGetParentRightKey());
        System.out.println("--PARENT LEFT " + testGetParentLeftKey());
        System.out.println("--END CASE 1 -----");
        if (current.getKey() < current.getParent().getKey()) {//ak je rodic vacsi ako current, tak sa spytaj ci je lavy syn cierny,ak ja som cerveny
            System.out.println("SUCASNY < PARENT");
            if (current.isRed()) {//plati sucasny je cerveny a sucasne otec ukazuje na laveho syna ktory je null, alebo je cierny
                if (current.getParent().getLeft() == null) {
                    System.out.println("PARENT>>RIGHT>>NULL");
                    return true;
                } else if (!current.getParent().getLeft().isRed()) {
                    System.out.println("PARENT>>RIGHT>>BLACK");
                    return true;
                }

            }
        }

        return false;
    }

    private String testCurrentKey() {
        if (current != null) return current.key + "";
        else return "";
    }

    private String testGetParrentKey() {
        if (current.getParent() != null) return current.getParent().getKey() + "";
        else return "";
    }

    private String testGetParentRightKey() {
        if (current.getParent().getRight() != null) return current.getParent().getRight().getKey() + "";
        else return "";
    }

    private String testGetParentLeftKey() {
        if (current.getParent().getLeft() != null) return current.getParent().getLeft().getKey() + "";
        else return "";
    }


    private void handleRedIntegrity() {

    }

    /**
     * current and parent are red
     *
     * @return
     */
    private boolean twoRedInTheRow() {
        if (current.isRed() && current.getParent().isRed()) {
            System.out.println("twoRedInTheRowRight\nCurrent and parent are red");
            return true;
        }
        return false;
    }

    private boolean twoRedInTheRowLeft() {
        if (current.isRed() && current.getLeft().isRed()) {
            System.out.println("twoRedInTheRowLeft");
            return true;
        }
        return false;
    }

    public String printColor(Node node) {
        if (node.isBlack) {
            return (" B ");
        } else {
            return (" R ");
        }
    }

    public static void main(String[] args) {
        RBTree rb = new RBTree();
        rb.insert(1);
        rb.insert(2);
        rb.insert(3);
        //rb.insert(4);
        //rb.insert(5);
        rb.printSimpleOrder();
        // rb.insert(4);
    }

}
