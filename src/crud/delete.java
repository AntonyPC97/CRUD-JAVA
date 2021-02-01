package crud;

import entidades.Persona;
import models.PersonaModel;

public class delete {
    public static void main(String[] args){
        PersonaModel personaModel = new PersonaModel();
        boolean result = personaModel.delete(4);
        if(result)
            System.out.println("Persona borrada correctamente.");
        else
            System.out.println("Error al borrar persona.");
    }
}