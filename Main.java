import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();


        User carrentUser = getUserByLoginAndPassword(login, password);
        validateUser(carrentUser);

        System.out.println("Доступ предоставлен");

    }

    public static User[] getUser() {
        User user1 = new User ("Vasya", "12345", "meil@meil.ru", 32);
        User user2 = new User ("Vanya", "54321", "gmail@mail.ru", 17);
        User user3 = new User ("Venya", "12321", "abrec@gmail.com", 21);

        return new User[]{user1, user2, user3};
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUser();
        for (User user : users) {
            if (login.equals(user.login) && password.equals(user.password)) {
                return user;
            }
        }
        throw new UserNotFoundException("Пользователь не найден.");
    }


    public static void validateUser(User user) throws AccessDeniedException {

        if (user.age < 18) {
            throw new AccessDeniedException("Вам еще нет 18 лет, доступ запрещен.");
        }
    }
}