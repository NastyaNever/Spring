package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {

    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        System.out.println("Таблица создана");
        userService.saveUser("Алексей", "Серов", (byte) 25);
        System.out.println("User с именем - Алексей добавлен в базу данных");
        userService.saveUser("Олег", "Самойлов", (byte) 34);
        System.out.println("User с именем - Олег добавлен в базу данных");
        userService.saveUser("Ольга", "Лебедева", (byte) 48);
        System.out.println("User с именем - Ольга добавлен в базу данных");
        userService.saveUser("Дмитрий", "Шарапов", (byte) 32);
        System.out.println("User с именем - Дмитрий добавлен в базу данных");
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        System.out.println("Таблица очищена");
        userService.dropUsersTable();
        System.out.println("Таблица удалена");

    }
}
