package br.com.fiap.contatos;

import br.com.fiap.contatos.model.Contato;
import br.com.fiap.dao.Conexao;
import br.com.fiap.dao.ContatoDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class ContatoApp {
    public static void main(String[] args) {
        Contato contato = new Contato();
        contato.setNome("Fabiana Oliveira");
        contato.setEmail("fabiana@email.com.br");
        contato.setDataNascimento(LocalDate.of(2000,10,15));


        // Criação do Entity Manager

        EntityManager em = Conexao.getEntityManager();

        //Criar uma Instancia do Dao
        ContatoDao contatoDao = new ContatoDao(em);

        em.getTransaction().begin();
        contatoDao.salvar(contato);
        em.getTransaction().commit();

    }

}
