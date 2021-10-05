import Classes.Aluno;
import Classes.Estado;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistencia");



        /*EntityManager entityManager = entityManagerFactory.createEntityManager();

        Estado estado1 = new Estado("Rio de Janeiro", "RJ");
        Aluno aluno1 = new Aluno("Carlos", 43, estado1);

        entityManager.getTransaction().begin();


        entityManager.persist(estado1);
        entityManager.persist(aluno1);

        entityManager.getTransaction().commit();






        entityManager.close();
        entityManagerFactory.close();*/











    }


}
