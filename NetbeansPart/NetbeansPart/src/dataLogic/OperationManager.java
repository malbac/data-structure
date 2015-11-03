package dataLogic;

import data.DataManager;
import dataLogic.operations.*;

/**
 * Created by Malbac on 25.10.2015.
 */
public class OperationManager {



    private Operation1 operation1;
    private Operation2 operation2;
    private Operation3 operation3;
    private Operation4 operation4;
    private Operation5 operation5;
    private Operation6 operation6;
    private Operation7 operation7;
    private Operation8 operation8;
    private Operation9 operation9;
    private Operation14 operation14;

    //insert operations
    private Operation15 operation15;
    private Operation16 operation16;
    private Operation17 operation17;
    private Operation21 operation21;

    private Operation12 operation12;
    //delete operations
    private Operation13 operation13;
    private Operation18 operation18;
    private Operation19 operation19;
    private Operation20 operation20;
    private Operation22 operation22;


    //change operations
    private Operation10 operation10;
    private Operation11 operation11;

    private OperationKatastralnyUrad operationKatastralnyUrad;

    public OperationKatastralnyUrad getOperationKatastralnyUrad() {
        return operationKatastralnyUrad;
    }






    public OperationManager(DataManager dataManager) {
       operation1 = new  Operation1(dataManager);
       operation2 = new  Operation2(dataManager);
       operation3 = new  Operation3(dataManager);
       operation4 = new  Operation4(dataManager);
       operation5 = new  Operation5(dataManager);
       operation6 = new  Operation6(dataManager);
       operation7 = new  Operation7(dataManager);
       operation8 = new  Operation8(dataManager);
       operation9 = new  Operation9(dataManager);
        operation14 = new Operation14(dataManager);

        //insert operations
        operation15 = new Operation15(dataManager);
        operation16 = new Operation16(dataManager);
        operation17 = new Operation17(dataManager);
        operation21 = new Operation21(dataManager);

        operation12 = new Operation12(dataManager);
        //delete operations
        operation13 = new Operation13(dataManager);
        operation18 = new Operation18(dataManager);
        operation19 = new Operation19(dataManager);
        operation20 = new Operation20(dataManager);
        operation22 = new Operation22(dataManager);


        //change operations
        operation10 = new Operation10(dataManager);
        operation11 = new Operation11(dataManager);
        operationKatastralnyUrad= new OperationKatastralnyUrad();
    }
//GETTERS

    public Operation1 getOperation1() {
        return operation1;
    }

    public Operation2 getOperation2() {
        return operation2;
    }

    public Operation3 getOperation3() {
        return operation3;
    }

    public Operation4 getOperation4() {
        return operation4;
    }

    public Operation5 getOperation5() {
        return operation5;
    }

    public Operation6 getOperation6() {
        return operation6;
    }

    public Operation7 getOperation7() {
        return operation7;
    }

    public Operation8 getOperation8() {
        return operation8;
    }

    public Operation9 getOperation9() {
        return operation9;
    }

    public Operation14 getOperation14() {
        return operation14;
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

    public Operation12 getOperation12() {
        return operation12;
    }

    public Operation13 getOperation13() {
        return operation13;
    }

    public Operation18 getOperation18() {
        return operation18;
    }

    public Operation19 getOperation19() {
        return operation19;
    }

    public Operation20 getOperation20() {
        return operation20;
    }

    public Operation22 getOperation22() {
        return operation22;
    }

    public Operation10 getOperation10() {
        return operation10;
    }

    public Operation11 getOperation11() {
        return operation11;
    }
}
