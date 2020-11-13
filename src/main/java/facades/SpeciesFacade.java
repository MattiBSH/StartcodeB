/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import DTOs.SpeciesDTO;
import static DTOs.SpeciesDTO.toDTO;
import entities.Species;
import static facades.FetchFacade.fetchSpecies;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import utils.EMF_Creator;


/**
 *
 * @author matti
 */
public class SpeciesFacade {
    private static EntityManagerFactory emf;
    private static SpeciesFacade instance;

    public SpeciesFacade() {
    }
    public static SpeciesFacade getUserFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new SpeciesFacade();
        }
        return instance;
    }
    public SpeciesDTO addHumanFromEndpoint() throws IOException{
        EntityManager em = emf.createEntityManager(); 
        SpeciesDTO sp= fetchSpecies();
           Species s= new Species(sp);
           try{
            em.getTransaction().begin();
            em.persist(s);
            em.getTransaction().commit();
        }finally {
            em.close();
           }
           return sp;
    }
    public SpeciesDTO addSpecies(SpeciesDTO s) throws IOException{
        EntityManager em = emf.createEntityManager(); 
        
           Species s1= new Species(s.getTitle(),s.getDescription());
           try{
            em.getTransaction().begin();
            em.persist(s1);
            em.getTransaction().commit();
        }finally {
            em.close();
           }
           return s;
    }
    public SpeciesDTO getSpeciesById(int id) throws IOException{
        
         EntityManager em = emf.createEntityManager();
        try{
            Species s = em.find(Species.class,id);
            
            return new SpeciesDTO(s);
        }finally {
            em.close();
        }}

    public List<SpeciesDTO> getAllSpecies(){
         EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Species> query = 
                       em.createQuery("Select s from Species s",Species.class);
            return toDTO(query.getResultList());
        }finally {
            em.close();}}


public static void main(String[] args) throws IOException {
        SpeciesFacade sf= new SpeciesFacade();
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        
        System.out.println(sf.getSpeciesById(1));
        System.out.println(sf.getAllSpecies());
    }    
}

