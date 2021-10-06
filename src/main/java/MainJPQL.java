import Classes.Aluno;
import Classes.Estado;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;



public class MainJPQL {
    public static void main(String[] args) {

        //Dados instanciados para serem utilizados como exemplo
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistente");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Estado estadoParaAdicionar = new Estado("Rio de Janeiro", "RJ");
        entityManager.persist(estadoParaAdicionar);
        entityManager.persist(new Estado("Sao Paulo", "SP"));
        entityManager.persist(new Aluno("Daniel", 29, estadoParaAdicionar));
        entityManager.persist(new Aluno("Joao", 20, estadoParaAdicionar));
        entityManager.persist(new Aluno("Pedro", 30, estadoParaAdicionar));
        entityManager.getTransaction().commit();


        //Consulta utilizando JPQL

        Aluno alunoJPQL = entityManager
                .createQuery("select a from Aluno a where a.nome = :nome", Aluno.class)
                .setParameter("nome", "Joao")
                .getSingleResult();

        System.out.println("Consulta JPQL: " + alunoJPQL);

        //Trazendo lista como resultado

        List<Aluno> alunoJPQLlist = entityManager
                .createQuery("select a from Aluno a where a.estado = :estado", Aluno.class)
                .setParameter("estado", estadoParaAdicionar)
                .getResultList();

        alunoJPQLlist.forEach(Aluno -> System.out.println("Lista de alunos: " + Aluno));






    }
}
