package ohtu.data_access;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ohtu.domain.User;

public class FileUserDao implements UserDao {

    private List<User> users;
    private Scanner reader;

    public FileUserDao(String filePath) {
        this.users = new ArrayList<>();
        File file = new File(filePath);

        try {
            reader = new Scanner(file);
            readFile();
            reader.close();
        } catch (Exception e) {
            System.out.println("File not found.");
        }
    }

    private void readFile() {
        while (reader.hasNextLine()) {
            String row = reader.nextLine();
            String[] cells = row.split(",");
            User user = new User(cells[0], cells[1]);
            this.users.add(user);
        }
    }

    @Override
    public List<User> listAll() {
        return this.users;
    }

    @Override
    public User findByName(String name) {
        for (User user : users) {
            if (user.getUsername().equals(name)) {
                return user;
            }
        }

        return null;
    }

    @Override
    public void add(User user) {
        this.users.add(user);
    }

}
