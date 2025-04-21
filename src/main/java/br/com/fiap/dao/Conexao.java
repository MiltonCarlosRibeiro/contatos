package br.com.fiap.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Conexao {

    /*Estamos transformado uma variavel em constante por isso o nome e maiúsculo(EMF)*/
    public static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("contatos");

    public static EntityManager getEntityManager(){
        return EMF.createEntityManager();
    }
}
