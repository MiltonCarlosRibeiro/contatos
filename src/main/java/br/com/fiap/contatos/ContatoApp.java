package br.com.fiap.contatos;

import br.com.fiap.contatos.model.Contato;
import br.com.fiap.dao.Conexao;
import br.com.fiap.dao.ContatoDao;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;

public class ContatoApp {
    public static void main(String[] args) {

         /*Criação do Entity Manager*/
        EntityManager em = Conexao.getEntityManager();
        //cadastrar (em);
        //atualizar(em);
        //excluir(em);
        //consutarContatoPorId(em);
        //listarTodosOsContatos(em);
        listaContatoPorEmail(em);

    }
    /*CADASTRAR*/
    public static void cadastrar (EntityManager em){
        Contato contato = new Contato();
        contato.setNome("Hugo Correa Carlos");
        contato.setEmail("hugo@fiap.com.br");
        contato.setDataNascimento(LocalDate.of(1999,10,15));

        /*Criar uma Instancia do Dao*/
        ContatoDao contatoDao = new ContatoDao(em);

        em.getTransaction().begin();
        contatoDao.salvar(contato);
        em.getTransaction().commit();

    }
    /*ATUALIZAR*/
    public static void atualizar (EntityManager em){
        Contato contato = new Contato();
        contato.setId(2L);
        contato.setNome("Fabiana Rodrigues");
        contato.setEmail("victor@fiap.com.br");
        contato.setDataNascimento(LocalDate.of(2000,10,15));

        /*Criar uma Instancia do Dao*/
        ContatoDao contatoDao = new ContatoDao(em);

        em.getTransaction().begin();
        contatoDao.atualizar(contato);
        em.getTransaction().commit();

    }
    /*EXCLUIR*/
    public static void excluir (EntityManager em){
        Contato contato = new Contato();
        contato.setId(1L);;

        /*Criar uma Instancia do Dao*/
        ContatoDao contatoDao = new ContatoDao(em);

        em.getTransaction().begin();
        contatoDao.excluir(contato);
        em.getTransaction().commit();

    }

    /*CONSULTAS*/
    public static void consutarContatoPorId (EntityManager em){


        /*Criar uma Instancia do Dao*/
        ContatoDao contatoDao = new ContatoDao(em);

        em.getTransaction().begin();
        contatoDao.consultaContatoPorId(3L);
        em.getTransaction().commit();

    }

    public static void listarTodosOsContatos (EntityManager em){


        /*Criar uma Instancia do Dao*/
        ContatoDao contatoDao = new ContatoDao(em);

        List<Contato> contatos = contatoDao.listarTodosOsContatos();
        for (Contato contato : contatos) {
            System.out.println("********************************************************************************************************");
            System.out.println(contato.toString());
        }
        System.out.println("********************************************************************************************************");
        System.out.println("Fim dos registros...");

    }

    public static void listaContatoPorEmail (EntityManager em){


        /*Criar uma Instancia do Dao*/
        ContatoDao contatoDao = new ContatoDao(em);

        List<Contato> contatos = contatoDao.listarContatosPorEmail("victor@fiap.com.br");
        for (Contato contato : contatos) {
            System.out.println("********************************************************************************************************");
            System.out.println(contato.toString());
        }
        System.out.println("********************************************************************************************************");
        System.out.println("Fim dos registros...");

    }



}
