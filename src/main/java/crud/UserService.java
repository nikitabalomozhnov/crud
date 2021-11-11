package crud;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import lombok.Data;
import lombok.SneakyThrows;

@Data

public class UserService {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    ArrayList<User> users = new ArrayList<>();

    @SneakyThrows
    protected ArrayList<User> createUser() {
        System.out.println("Enter username: ");
        String username = reader.readLine();
        if (username.isEmpty()) {
            System.out.println("You have written empty username, try again: ");
            createUser();
        } else {
            User user = new User(username);
            users.add(user);
        }
        return users;
    }

    protected void showAllUsers() {
        if (users.isEmpty()) {
            System.out.println("There is no users yet.");
        } else {
            for (User user : users) {
                System.out.println("ID: " + user.getId() + " - Username: " + user.getName() + ".");
            }
        }
    }

    @SneakyThrows
    protected void readUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                System.out.println("\nUsername: " + users.get(id).getName());
                return;
            }
        }
        System.out.println("There is no user with this id " + id + ".\n" +
                "Would you like to try again? Y / N: ");
        String choose = reader.readLine();
        if (choose.equalsIgnoreCase("y")) {
            System.out.println("Enter id: ");
            int idNew = 0;
            readUserById(idNew = Integer.parseInt(reader.readLine()));
        } else {
            return;
        }
    }

    @SneakyThrows
    protected ArrayList<User> updateUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                System.out.println("Enter new name: ");
                String newName = reader.readLine();
                user.getName().delete(0, user.getName().length());
                user.getName().append(newName);
                System.out.println("Name successfully  updated to: " + newName);
                return users;
            } else if (users.toArray().length > 1) {
                continue;
            }
            System.out.println("There is no user with this id " + id + ".\n" +
                    "Would you like to try again? Y / N: ");
            String choose = reader.readLine();
            if (choose.equalsIgnoreCase("y")) {
                System.out.println("Enter id: ");
                int idNew = 0;
                updateUserById(idNew = Integer.parseInt(reader.readLine()));
            } else {
                return users;
            }
        }
        return users;
    }

    @SneakyThrows
    protected ArrayList<User> deleteUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                System.out.println("Are you sure? Y / N");
                String choose = reader.readLine();
                if (choose.equalsIgnoreCase("y")) {
                    users.remove(user);
                    System.out.println("User successfully deleted.");
                } else {
                    break;
                }
                return users;
            } else if (users.toArray().length > 1) {
                continue;
            }
        }
        System.out.println("There is no user with this id " + id + ".\n" +
                "Would you like to try again? Y / N: ");
        String choose = reader.readLine();
        if (choose.equalsIgnoreCase("y")) {
            System.out.println("Enter id: ");
            int idNew = 0;
            updateUserById(idNew = Integer.parseInt(reader.readLine()));
        } else {
            return users;
        }
        return users;
    }

}


