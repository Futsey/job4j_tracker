package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user : users) {
            if (login.equals(user.getUserName())) {
                System.out.println("Welcome " + user.getUserName());
                return user;
            }
        }
        throw new UserNotFoundException("Can`t find user in the list");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUserName().length() < 3) {
            throw new UserInvalidException("User is not valid or length of your name"
                    + " less then three chars");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true),
                new User("Igor Arsentev", false),
                new User("Andrew Petrushin", false),
                new User("PA", true),
        };
        try {
            User user = findUser(users, "Andrew Petrushin");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ev) {
            ev.printStackTrace();
        } catch (UserNotFoundException ef) {
            ef.printStackTrace();
        }
    }
}
