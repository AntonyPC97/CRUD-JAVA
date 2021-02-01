package crud;

import entidades.Persona;
import models.PersonaModel;

public class read {
    public static void main(String[] args){
        PersonaModel personaModel = new PersonaModel();
        Persona persona = personaModel.read(1);
        if(persona!= null){
            System.out.println("Persona encontrada:");
            System.out.println("Nombres: "+ persona.getNombre());
            System.out.println("Apellidos: "+ persona.getApellido());
            System.out.println("Dni: "+ persona.getDni());
            System.out.println("Edad: "+ persona.getEdad());
            System.out.println("Activo: "+ persona.isActivo());
        }else{
            System.out.println("No existe esta persona en el sistema.");
        }

    }
}