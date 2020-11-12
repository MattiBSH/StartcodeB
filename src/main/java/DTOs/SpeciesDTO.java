/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOs;


import entities.Species;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import javax.persistence.Id;


public class SpeciesDTO {   
    private String title;
    private String description;

    public SpeciesDTO() {
    }

    public SpeciesDTO(String title, String description) {
       
        this.title = title;
        this.description = description;
        
    }

    public SpeciesDTO(Species s1) {
         this.title = s1.getTitle();
        this.description = s1.getDescription();
    }
  public static List<SpeciesDTO> toDTO(List<Species> list){
        List<SpeciesDTO> listDTO = new ArrayList();
        for (Species s : list) {
                listDTO.add(new SpeciesDTO(s));
        } //Måske lambda expression?
        return listDTO;
    } 
   

    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SpeciesDTO{ title=" + title + ", description=" + description + '}';
    }
    private static final Logger LOG = Logger.getLogger(SpeciesDTO.class.getName());

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.title);
        hash = 23 * hash + Objects.hashCode(this.description);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SpeciesDTO other = (SpeciesDTO) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }

    

}
