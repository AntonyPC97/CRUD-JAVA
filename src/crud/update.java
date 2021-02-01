package crud;

import entidades.Persona;
import models.PersonaModel;

public class update {
    public static void main(String[] args){
        PersonaModel personaModel = new PersonaModel();

        Persona persona = personaModel.read(2);
        persona.setNombre("Valeria");
        persona.setApellido("Coronado Rodríguez");

        boolean result = personaModel.update(persona);
        if(result){
            System.out.println("Persona actualizada correctamente.");
        }else{
            System.out.println("Error al acutalizar persona.");
        }
    }
}