package Bai1;

public class Main {
    public static void main(String[] args) {
        try {
            DatabaseConnection.initializeDatabase();
            new RegisterForm();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
