package crud;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import lombok.SneakyThrows;
import lombok.Data;

@Data

public class StartApp {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static String choose;

    @SneakyThrows
    public static void startApp() {
        int id;
        UserService userService = new UserService();
        String serviceMenu = "\n1. Create.\n" +
                "2. Read all users.\n" +
                "3. Read user by ID.\n" +
                "4. Update user by ID.\n" +
                "5. Delete user.\n" +
                "Please enter a number of an action that you want to do or type \"exit\" to quit";

        System.out.println("Hi! Welcome to the CRUD app! There are some options that you can do: \n" +
                "1. Create.\n" +
                "2. Read all users.\n" +
                "3. Read user by ID.\n" +
                "4. Update user by ID.\n" +
                "5. Delete user.\n" +
                "Please enter a number of an action that you want to do or type \"exit\" to quit");

        do {
            choose = reader.readLine();
            switch (choose) {
                case "1":
                    userService.createUser();
                    System.out.println(serviceMenu);
                    break;
                case "2":
                    userService.showAllUsers();
                    System.out.println(serviceMenu);
                    break;
                case "3":
                    System.out.println("Enter id: ");
                    id = Integer.parseInt(reader.readLine());
                    userService.readUserById(id);
                    System.out.println(serviceMenu);
                    break;
                case "4":
                    System.out.println("Enter id: ");
                    id = Integer.parseInt(reader.readLine());
                    userService.updateUserById(id);
                    System.out.println(serviceMenu);
                    break;
                case "5":
                    System.out.println("Enter id: ");
                    id = Integer.parseInt(reader.readLine());
                    userService.deleteUserById(id);
                    System.out.println(serviceMenu);
                    break;
                case "exit":
                    break;
                default:
                    System.out.println("There is no option like this " + "\"" + choose + "\"" + ". Try again: ");
                    System.out.println(serviceMenu);
                    break;
            }
        } while (!choose.equals("exit"));
        System.out.println("Thank you for using CRUD app! Have a good day!");
    }
}
