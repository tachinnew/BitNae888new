package com.example.demo.data;

import java.util.ArrayList;

public class Password {
    private static ArrayList<String> pCollecter = new ArrayList<String>();
    private static ArrayList<String> iCollecter = new ArrayList<String>();
    private static ArrayList<String> adminICollecter = new ArrayList<String>();

    private static boolean iAlreadyCheck = false;
    private static boolean pAlreadyCheck = false;
    private static boolean isAdmin = false;

    private static String userName;

    public static void startPassword(){
        addPassword("TachinTheAdmin1","qazwsxedc123");
        addPassword("TachinTheAdmin2","qazwsxedc123");
        addPassword("TachinTheAdmin3","qazwsxedc123");
        addPassword("TachinTheAdmin4","qazwsxedc123");
        addAdmin("TachinTheAdmin1");
    }

    private static void setUserName(String name){
        userName = name;
    }

    public static String getUserName(){
        return userName;
    }

    private static void setIA(boolean status){
        iAlreadyCheck = status;
    }

    private static void setPA(boolean status){
        pAlreadyCheck = status;
    }

    public static boolean getIA(){
        return iAlreadyCheck;
    }

    public static boolean getPA(){
        return pAlreadyCheck;
    }

    public static boolean getIAD(){
        return isAdmin;
    }

    protected static void addPassword(String ID,String Password){
        iCollecter.add(ID);
        pCollecter.add(Password);
    }

    protected static void addAdmin(String IDa){
        adminICollecter.add(IDa);
    }

    public static void checkRole(String IDw){
        for(int i = 0 ; i < adminICollecter.size() ; i++){
            if(IDw.equals(adminICollecter.get(i))){
                isAdmin = true;
            }
        }
    }

    public static void checkUserIDP(String IDw,String Passwordw){
        for(int i = 0 ; i < iCollecter.size() ;i++){
            if(IDw.equals(iCollecter.get(i))){
                setIA(true);
                if(Passwordw.equals(pCollecter.get(i))){
                    setUserName(IDw);
                    setPA(true);
                    return;
                }
                setIA(false);
            }
        }
    }

    protected static void getPassword(){
        return;
    }


}
