import Classes.Aluno;
import Classes.Estado;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class MainSQL {

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




        //Consulta utilizando SQL nativo
        String sql = "SELECT * FROM Aluno WHERE nome = :nome";
        Aluno alunoSQL = (Aluno) entityManager
                .createNativeQuery(sql, Aluno.class)
                .setParameter("nome", "Daniel")
                .getSingleResult();

        System.out.println("Resultado da consulta SQL: " + alunoSQL);


        //Trazendo uma lista como resultado
        sql = "SELECT * FROM aluno";
        List<Aluno> alunoSQLlist = entityManager
                .createNativeQuery(sql, Aluno.class)
                .getResultList();

        alunoSQLlist.forEach(Aluno-> System.out.println("Lista de alunos: " + Aluno));





    }


}
