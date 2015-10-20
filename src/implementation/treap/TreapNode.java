package implementation.treap;

import java.util.Random;

/**
 * Created by Malbac on 19.10.2015.
 */
public class TreapNode {
    TreapNode left, right;
    int priority, element;

    /** Constructor **/
    public TreapNode()
    {
        this.element = 0;
        this.left = this;
        this.right = this;
        this.priority = Integer.MAX_VALUE;
    }

    /** Constructor **/
    public TreapNode(int ele)
    {
        this(ele, null, null);
    }

    /** Constructor **/
    public TreapNode(int ele, TreapNode left, TreapNode right)
    {
        this.element = ele;
        this.left = left;
        this.right = right;
        this.priority = new Random().nextInt( );
    }


}
