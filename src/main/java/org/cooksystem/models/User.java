//package org.cooksystem.models;
//
//
//
//import javax.xml.crypto.Data;
//import java.io.Serial;
//import java.io.Serializable;
//import java.util.List;
//
//public class User  {
//    @Serial
//
//    private String status;
//    private String username;
//    private String firstName;
//    private String lastName;
//    private String phoneNumber;
//    private String password;
//    private String email;
//    private String imagePath;
//    private String userType;
//    private String preferences_dietary;
//    private String allergies;
//
//    public User() {
//        this.username = "";
//        this.firstName = "";
//        this.lastName = "";
//        this.phoneNumber = "";
//        this.password = "";
//        this.email = "";
//        this.imagePath = "";
//        this.userType = "";
//    }
//
//    public User(String username, String firstName, String lastName,
//                String phoneNumber, String password, String email,
//                String imagePath, String userType) {
//        setUsername(username);
//        setFirstName(firstName);
//        setLastName(lastName);
//        setPhoneNumber(phoneNumber);
//        setPassword(password);
//        setEmail(email);
//        setImagePath(imagePath);
//        setUserType(userType);
//    }
//
//    public User(User user) {
//        this(user.getUsername(), user.getFirstName(), user.getLastName(),
//                user.getPhoneNumber(), user.getPassword(), user.getEmail(),
//                user.getImagePath(), user.getUserType());
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username.toLowerCase();
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getImagePath() {
//        return (imagePath.isEmpty() ? "C:\\Users\\User\\IdeaProjects\\software_project\\src\\main\\resources\\nouser.png" : imagePath);
//    }
//
//    public void setImagePath(String imagePath) {
//        this.imagePath = imagePath;
//    }
//
//
//    public void deleteuser(String username){
//        DataBase dataBase = new DataBase();
//        List<User> allusers = dataBase.loadUsersFromFile("Users.json");
//        for(int i=0;i< allusers.size();i++)
//        {
//            if(username == allusers.get(i).getUsername())
//            {
//                setStatus("User deleted successfully");
//                allusers.remove(i);
//                dataBase.clearJsonFile("C:\\Users\\User\\IdeaProjects\\sweet_project\\Users.json");
//                for(int j=0 ; j<allusers.size();j++)
//                {
//                    dataBase.saveUserToFile("Users.json" , allusers.get(j));
//                }
//            }
//        }
//    }
//
//    public String getUserType() {
//        return userType;
//    }
//
//    public void setUserType(String userType) {
//        this.userType = userType;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "username='" + username + '\'' +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", phoneNumber='" + phoneNumber + '\'' +
//                ", password='" + password + '\'' +
//                ", email='" + email + '\'' +
//                ", imagePath='" + imagePath + '\'' +
//                '}';
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
//    public String getPreferences_dietary() {
//        return preferences_dietary;
//    }
//
//    public void setPreferences_dietary(String preferences_dietary) {
//        this.preferences_dietary = preferences_dietary;
//    }
//
//    public String getAllergies() {
//        return allergies;
//    }
//
//    public void setAllergies(String allergies) {
//        this.allergies = allergies;
//    }
//}