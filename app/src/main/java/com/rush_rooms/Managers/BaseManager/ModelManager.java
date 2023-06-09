package com.rush_rooms.Managers.BaseManager;

import com.rush_rooms.Constants.MyConstants;


public class ModelManager extends com.rush_rooms.Managers.BaseManager.BaseManager implements MyConstants {

    private static final String TAG = ModelManager.class.getSimpleName();
    //Static properties
    private static ModelManager _ModelManger;
    private static String mGenericAuthToken = "";
   /// Instance Properties
    /*private static LoginResponse mCurrentUser = null;*/
//    private DispatchQueue dispatchQueue =
//            new DispatchQueue("com.queue.serial.modelmanager", DispatchQueue.QoS.userInitiated);

    /**
     * private constructor
     */
    private ModelManager() {

    }

    /**
     * method to create a threadsafe singleton class instance
     */
   /* public static synchronized ModelManager modelManager() {
        if (_ModelManger == null) {
            _ModelManger = new ModelManager();
            mCurrentUser = getDataFromPreferences(kCurrentUser, LoginResponse.class);
            Log.i(TAG, "Current User : " + ((mCurrentUser == null) ? null : mCurrentUser.toString()));
        }
       return _ModelManger;
    }*/

    /**
     * to initialize the singleton object
     */
    public void initializeModelManager() {
        System.out.print("ModelManager object initialized.");
    }

    /**
     * Stores {@link } to the share preferences and synchronize sharedpreferece
     */
    /*public synchronized void archiveCurrentUser() {
        saveDataIntoPreferences(mCurrentUser, kCurrentUser);
    }*/

    /**
     * getter method for genericAuthToken
     */
    public synchronized String getGenericAuthToken() {
        return mGenericAuthToken;
    }

//
//    public DispatchQueue getDispatchQueue() {
//        return dispatchQueue;
//    }
//
//
    /*public synchronized LoginResponse getCurrentUser() {
        return mCurrentUser;
    }
//
    public synchronized void setCurrentUser(LoginResponse o) {
        mCurrentUser = o;
        archiveCurrentUser();
    }*/

}

