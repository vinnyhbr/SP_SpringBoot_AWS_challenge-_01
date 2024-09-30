package application;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import entities.Member;




//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //testing the connection with the database
        //replace the date again
        Member m1;
        m1 = new Member("vini", "rua 4 paralela", "82984372394", "vini@gmail.com");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Library");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(m1);

        em.getTransaction().commit();

        System.out.println("Ok!");

        }
    }
