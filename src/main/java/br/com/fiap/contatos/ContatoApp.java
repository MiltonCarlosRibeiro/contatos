package br.com.fiap.contatos;

import br.com.fiap.contatos.model.Contato;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class ContatoApp {
    public static void main(String[] args) {
        Contato contato = new Contato();
        contato.setNome("Pedro Oliveira");
        contato.setEmail("pedro@email.com.br");
        contato.setDataNascimento(LocalDate.of(1999,5,10));


        // Criação do Entity Manager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contatos");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(contato);
        em.getTransaction().commit();

    }

}
