package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println();
      }

      userService.add(new User("Ivan", "Ivanov", "Email1@gmail.com", new Car("Priora", 2112)));
      userService.add(new User("Petr", "Petrov", "Email2@gmail.com", new Car("RenoLogan", 254)));
      userService.add(new User("Sidor", "Sidorov", "Email3@gmail.com", new Car("BMW", 6)));
      userService.add(new User("Vlad", "Vladov", "Email1@gmail.com", new Car("Audi", 4)));


      List<User> users2 = userService.listUsers();
      for (User user : users2) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car = " + user.getUserCar());
         System.out.println();
      }

      System.out.println(userService.showUserByCar("Priora", 2112));

      context.close();
   }
}
