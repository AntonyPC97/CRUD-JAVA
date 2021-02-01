package crud;

import entidades.Persona;
import models.PersonaModel;

public class create {
    public static void main(String[] args){
        PersonaModel personaModel = new PersonaModel();
        Persona persona = new Persona();
        persona.setNombre("Juan");
        persona.setApellido("Martínez Ocasio");
        persona.setDni("75869544");
        persona.setEdad(27);
        persona.setActivo(true);

        boolean result = personaModel.create(persona);
        if(result){
            System.out.println(persona.getNombre() + " creado correctamente.");
        }else{
            System.out.println("Error al crear persona.");
        }

    }
}
