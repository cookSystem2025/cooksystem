//package org.cooksystem.helper;
//
//import java.io.*;
//
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//import io.cucumber.java.hu.De;
//
//import java.lang.reflect.Type;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//public class dataBase {
//
//
//    private static final Gson gson = new Gson();
//
//
//    public String statuspass;
//
//
//
//
//    public dataBase(){
//
//    }
//
//
//
//
//
//    public void saveDessertToFile(String filename, Dessert dessert) {
//        List<Dessert> allDessert = new ArrayList<>();
//
//        File file = new File(filename);
//        if (file.exists()) {
//            try (FileReader reader = new FileReader(filename)) {
//                Type dessertListType = new TypeToken<List<Dessert>>() {}.getType();
//                allDessert = gson.fromJson(reader, dessertListType);
//                if (allDessert == null) {
//                    allDessert = new ArrayList<>();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        allDessert.add(dessert);
//
//        try (FileWriter writer = new FileWriter(filename)) {
//            gson.toJson(allDessert, writer);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public List<message> loadmessageFromFile(String filename) {
//        List<message> allmessage = new ArrayList<>();
//        try (FileReader reader = new FileReader(filename)) {
//            Type messageListType = new TypeToken<List<message>>() {}.getType();
//            allmessage = gson.fromJson(reader, messageListType);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return allmessage;
//    }
//
//
//
//
//    public void savemessageToFile(String filename, message message) {
//        List<message> allmessage = new ArrayList<>();
//
//        File file = new File(filename);
//        if (file.exists()) {
//            try (FileReader reader = new FileReader(filename)) {
//                Type messageListType = new TypeToken<List<message>>() {}.getType();
//                allmessage = gson.fromJson(reader, messageListType);
//                if (allmessage == null) {
//                    allmessage = new ArrayList<>();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        allmessage.add(message);
//
//        try (FileWriter writer = new FileWriter(filename)) {
//            gson.toJson(allmessage, writer);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public List<Post> loadPostFromFile(String filename) {
//        List<Post> allPosts = new ArrayList<>();
//        try (FileReader reader = new FileReader(filename)) {
//            Type postListType = new TypeToken<List<Post>>() {}.getType();
//            allPosts = gson.fromJson(reader, postListType);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return allPosts;
//    }
//
//
//
//
//    public void savePostToFile(String filename, Post post) {
//        List<Post> allPost = new ArrayList<>();
//
//        File file = new File(filename);
//        if (file.exists()) {
//            try (FileReader reader = new FileReader(filename)) {
//                Type postListType = new TypeToken<List<Post>>() {}.getType();
//                allPost = gson.fromJson(reader, postListType);
//                if (allPost == null) {
//                    allPost = new ArrayList<>();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        allPost.add(post);
//
//        try (FileWriter writer = new FileWriter(filename)) {
//            gson.toJson(allPost, writer);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public List<Dessert> loadDessertFromFile(String filename) {
//        List<Dessert> allDessert = new ArrayList<>();
//        try (FileReader reader = new FileReader(filename)) {
//            Type dessertListType = new TypeToken<List<Dessert>>() {}.getType();
//            allDessert = gson.fromJson(reader, dessertListType);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return allDessert;
//    }
//
//
//
//    public void saveUserToFile(String filename, User newUser) {
//        List<User> allUsers = new ArrayList<>();
//
//        File file = new File(filename);
//        if (file.exists()) {
//            try (FileReader reader = new FileReader(filename)) {
//                Type userListType = new TypeToken<List<User>>() {}.getType();
//                allUsers = gson.fromJson(reader, userListType);
//                if (allUsers == null) {
//                    allUsers = new ArrayList<>();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        allUsers.add(newUser);
//
//        try (FileWriter writer = new FileWriter(filename)) {
//            gson.toJson(allUsers, writer);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public List<User> loadUsersFromFile(String filename) {
//        List<User> users = new ArrayList<>();
//        try (FileReader reader = new FileReader(filename)) {
//            Type userListType = new TypeToken<List<User>>() {}.getType();
//            users = gson.fromJson(reader, userListType);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return users;
//    }
//
//    public void clearJsonFile(String filePath) {
//        String emptyJsonContent = "";
//
//        try (FileWriter fileWriter = new FileWriter(filePath)) {
//            fileWriter.write(emptyJsonContent);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void Changepassword (String currentpass , String newpass , String username){
//        List<User> users = loadUsersFromFile("Users.json");
//        for(int i=0;i<users.size();i++)
//        {
//            if(Objects.equals(username, users.get(i).getUsername()))
//            {
//                if(Objects.equals(currentpass, users.get(i).getPassword()))
//                {
//                    statuspass = "Password change successfully";
//                    users.get(i).setPassword(newpass);
//                    clearJsonFile("C:\\Users\\User\\IdeaProjects\\sweet_project\\Users.json");
//                    for(int j=0 ; j<users.size();j++)
//                    {
//                        saveUserToFile("Users.json" , users.get(j));
//                    }
//                }
//            }
//        }
//
//    }
//
//}