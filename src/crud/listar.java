package crud;

import entidades.Persona;
import models.PersonaModel;
import java.util.List;

public class listar {
    public static void main(String[] args){
        PersonaModel personaModel = new PersonaModel();
        List<Persona> personas = personaModel.listar();
        if(personas == null){
            System.out.println("Cantidad de Personas: " + 0);
        }else{
            System.out.println("Cantidad de Personas: " + personas.size());
            for(Persona persona: personas){
                System.out.println(persona.getNombre() + ' ' +persona.getApellido());
            }
        }

    }
}
