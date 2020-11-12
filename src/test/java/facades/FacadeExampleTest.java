package facades;

import DTOs.SpeciesDTO;
import utils.EMF_Creator;
import entities.RenameMe;
import entities.Species;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class FacadeExampleTest {

    private static EntityManagerFactory emf;
    private static FacadeExample facade;
    private static SpeciesFacade facade2;
    private Species s1;
    private Species s2;
    private Species s3;
    public FacadeExampleTest() {
    }

    @BeforeAll
    public static void setUpClass() {
       emf = EMF_Creator.createEntityManagerFactoryForTest();
       facade = FacadeExample.getFacadeExample(emf);
       facade2=SpeciesFacade.getUserFacade(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the code below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() throws IOException {
        
        EntityManager em = emf.createEntityManager();
        try {
            s1=new Species("a", "b");
            em.getTransaction().begin();
            em.createNamedQuery("RenameMe.deleteAllRows").executeUpdate();
            em.createNamedQuery("Species.deleteAllRows").executeUpdate();
            em.persist(new RenameMe("Some txt", "More text"));
            em.persist(new RenameMe("aaa", "bbb"));
            em.persist(s1);
            
            
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    // TODO: Delete or change this method 
    @Test
    public void testAFacadeMethod() {
        System.out.println("Skabelonens test virker ikke hvis du ser det her i consolen");
        assertEquals(2, facade.getRenameMeCount(), "Expects two rows in the database");
    }
    @Test
    public void testGetByid() throws IOException {
        System.out.println("Id test virker ikke hvis du ser det her i consolen");
        SpeciesDTO speciesById = facade2.getSpeciesById(s1.getId());
        SpeciesDTO ex= new SpeciesDTO(new Species("a", "b"));
        
        assertEquals(speciesById,ex);
    }
    @Test
    public void testGetAll() throws IOException {
        System.out.println("All test virker ikke hvis du ser denne i consolen");
        List<SpeciesDTO> species = facade2.getAllSpecies();  
        SpeciesDTO ex= new SpeciesDTO(new Species("a", "b"));
        System.out.println(species);
        assertTrue(species.size()==1);
    }
    @Test
    public void testAdd() throws IOException {
        SpeciesDTO s=new SpeciesDTO("Matti","et menneske agtig væsen");
        facade2.addSpecies(s);
        
        assertTrue(facade2.getAllSpecies().size()==2);
        
    }
    
}
