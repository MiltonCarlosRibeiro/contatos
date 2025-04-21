package br.com.fiap.dao;

import br.com.fiap.contatos.model.Contato;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ContatoDao {

    private EntityManager em;

    public ContatoDao(EntityManager em) {
        this.em = em;
    }

    /*SALVAR*/
    public void salvar(Contato contato) {
        em.persist(contato);
    }

    /*ATUALIZAR*/
    public void atualizar(Contato contato) {
        em.merge(contato);
    }

    /*EXCLUIR*/
    public void excluir(Contato contato) {
        Contato contatoExcluir = em.find(Contato.class, contato.getId());
        em.remove(contatoExcluir);
    }

    /*CONSULTAS*/
    public void consultaContatoPorId(Long id){
        Contato contatoConsulta = em.find(Contato.class, id);

        if(contatoConsulta == null){
            System.out.println("contato nao encontrado!!");
        }else {
            System.out.println("*********************************************************************************************************");
            System.out.println(contatoConsulta.toString());
            System.out.println("*********************************************************************************************************");
        }

    }

    public List<Contato> listarTodosOsContatos(){
        /*SQL ----> SELECT * FROM tbl_contatos ORDER BY nome ASC*/

        /*JPQL*/
        String consulta = "SELECT c FROM Contato c ORDER BY nome ASC";
        return em.createQuery(consulta).getResultList();
    }

    public List<Contato> listarContatosPorEmail(String emailProcurado){
        /*SQL ----> SELECT email FROM tbl_contatos ORDER BY nome ASC*/

        /*JPQL*/
        String consulta = "SELECT c FROM Contato c WHERE email = :email";

        return em.createQuery(consulta, Contato.class)
                .setParameter("email", emailProcurado)
                .getResultList();
    }


}
