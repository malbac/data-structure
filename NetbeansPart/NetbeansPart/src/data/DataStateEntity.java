package data;

/**
 * Created by Malbac on 25.10.2015.
 */
public class DataStateEntity {
    private static DataStateEntity dataStateEntity;
    private static DataManager dataManager;

    private DataStateEntity(){}

    public static DataManager getDataManager(){
        if(dataStateEntity==null){
            dataStateEntity = new DataStateEntity();
            initialize();
            return dataManager;
        } else {
            return dataManager;
        }

    }

    public static void removeDataManager(){
        dataStateEntity = null;
    }

    private static void initialize(){
        dataManager = new DataManager();
    }


}
