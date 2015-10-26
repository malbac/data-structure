package dataLogic;

import dataLogic.operations.*;

/**
 * Created by Malbac on 25.10.2015.
 */
public class OperationManager {

    private Operation7 operation7;
    private Operation8 operation8;

    private Operation15 operation15;
    private Operation16 operation16;
    private Operation17 operation17;
    private Operation21 operation21;
    private OperationKatastralnyUrad operationKatastralnyUrad;

    public OperationKatastralnyUrad getOperationKatastralnyUrad() {
        return operationKatastralnyUrad;
    }




    public Operation15 getOperation15() {
        return operation15;
    }

    public Operation16 getOperation16() {
        return operation16;
    }

    public Operation17 getOperation17() {
        return operation17;
    }

    public Operation21 getOperation21() {
        return operation21;
    }

    public Operation8 getOperation8() {
        return operation8;
    }

    public Operation7 getOperation7() {
        return operation7;
    }


    public OperationManager() {
        operation7 = new Operation7();
        operation8 = new Operation8();
        operation15 = new Operation15();
        operation16 = new Operation16();
        operation17 = new Operation17();
        operation21 = new Operation21();
        operationKatastralnyUrad= new OperationKatastralnyUrad();
    }

}
