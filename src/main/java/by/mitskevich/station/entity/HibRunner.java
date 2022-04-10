package by.mitskevich.station.entity;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibRunner {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Role.class);
        configuration.addAnnotatedClass(User.class);

        Role role = new Role();
        role.setName("super_admin");

        User user = User.builder()
                .firstName("John")
                .lastName("Test")
                .email("test@gmail.com")
                .password("qwer122")
                .login("log").build();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(role);
            user.setRole(role);
            session.save(user);
//            session.delete(String.valueOf(Role.class),2L);
            session.getTransaction().commit();
            session.close();

        }
    }
}
