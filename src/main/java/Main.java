import Classes.Aluno;
import Classes.Estado;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory;

        entityManagerFactory = Persistence.createEntityManagerFactory("persistente");



        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Estado estado1 = new Estado("Amazonas", "AM");
        Estado estado2 = new Estado("Sergipe", "SE");

        Aluno aluno1 = new Aluno("Carlos", 43, estado1);
        Aluno aluno2 = new Aluno("Andressa", 26, estado2);
        Aluno aluno3 = new Aluno("Marinalva", 36, estado1);


        entityManager.getTransaction().begin();


        entityManager.persist(estado1);
        entityManager.persist(estado2);

        entityManager.persist(aluno1);
        entityManager.persist(aluno2);
        entityManager.persist(aluno3);

        entityManager.getTransaction().commit();


        // RESGAGAR INSTANCIAS DO BANCO DE DADOS

        Estado estadoBusca = entityManager.find(Estado.class, 2);

        Aluno alunoBusca = entityManager.find(Aluno.class, 3);

        System.out.println(estadoBusca);
        System.out.println(alunoBusca);


        // ALTERAR UMA ENTIDADE

        entityManager.getTransaction().begin();

        alunoBusca.setNome("Joselito");
        alunoBusca.setIdade(20);

        entityManager.getTransaction().commit();


        //REMOVER UMA ENTIDADE

        entityManager.getTransaction().begin();
        entityManager.remove(alunoBusca);
        entityManager.getTransaction().commit();




        // ENCERRAR O GERENCIADOR DE ENTIDADES E ENCERRAR A FABRICA DE GERENCIADORES DE ENTIDADE
        entityManager.close();
        entityManagerFactory.close();











    }


}
