package br.com.fiap.dao;

import br.com.fiap.contatos.model.Contato;
import jakarta.persistence.EntityManager;

public class ContatoDao {

    private EntityManager em;

    public ContatoDao(EntityManager em) {
        this.em = em;
    }

    /*SALVAR*/
    public void salvar(Contato contato) {
        em.persist(contato);
    }


}
