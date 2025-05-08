//package org.cooksystem.Authentication;
//
//
//
//import java.io.File;
//import java.sql.*;
//import java.util.List;
//import java.util.Objects;
//
//public class Register {
//    private String status;
//
//    //DataBase dataBase = new DataBase();
//
//
//    public Register() {
//
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public static boolean isFileEmpty(String filePath) {
//        File file = new File(filePath);
//
//        if (!file.exists()) {
//            System.err.println("File does not exist.");
//            return false;
//        }
//
//        try {
//            return file.length() == 0;
//        } catch (SecurityException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public boolean isTaken(String name)
//    {
//        if(isFileEmpty("C:\\Users\\User\\IdeaProjects\\sweet_project\\Users.json"))
//        {
//            return false;
//        }
//        List<User> users =  dataBase.loadUsersFromFile("Users.json");
//
//        for(int i = 0 ; i < users.size() ; i++)
//        {
//            if(Objects.equals(name, users.get(i).getUsername()))
//            {
//                return true;
//            }
//        }
//        return false;
//    }
//
//
//
//    public void registerUser(User user) throws SQLException {
//        String st = Validation.rollValidationTest(user);
//        setStatus(st);
//        if(getStatus().equals("Valid")){
//
//
//            if(isTaken(user.getUsername()))
//            {
//                setStatus("Username is already taken");
//                return;
//
//            }
//            else {
//
//                dataBase.saveUserToFile("Users.json" , user);
//                setStatus("User was registered successfully");
//
//            }
//        }
//    }
//}