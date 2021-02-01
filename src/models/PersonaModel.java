package models;

import entidades.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonaModel {
    public List<Persona> listar(){
        List<Persona> personas = new ArrayList<Persona>();
        try{
            PreparedStatement ps = connectToDB.getConnection()
                    .prepareStatement("SELECT * FROM PERSONA WHERE activo =?");
            ps.setInt(1,1);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Persona persona = new Persona();
                persona.setId(rs.getInt("id"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setDni(rs.getString("dni"));
                persona.setEdad(rs.getInt("edad"));
                persona.setActivo(rs.getBoolean("activo"));
                personas.add(persona);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            personas = null;
        }
        return personas;
    }

    public boolean create(Persona persona){
        boolean result = true;
        if (persona.getEdad()<0)
            return false;

        try{
            int dni = Integer.parseInt(persona.getDni());
        }catch (NumberFormatException nfe){
            return false;
        }

        try{
            PreparedStatement ps = connectToDB.getConnection()
                    .prepareStatement("INSERT INTO PERSONA(nombre,apellido,dni,edad,activo) VALUES (?,?,?,?,?)");
            ps.setString(1,persona.getNombre());
            ps.setString(2,persona.getApellido());
            ps.setString(3,persona.getDni());
            ps.setInt(4,persona.getEdad());
            ps.setBoolean(5,persona.isActivo());
            ps.executeUpdate();
        }catch (Exception e){
            result = false ;
        }
        return result;
    }

    public Persona read(int id){
        Persona persona = null;
        try{
            PreparedStatement ps = connectToDB.getConnection()
                    .prepareStatement("SELECT * FROM PERSONA WHERE id=?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                persona = new Persona();
                persona.setId(rs.getInt("id"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setEdad(rs.getInt("edad"));
                persona.setDni(rs.getString("dni"));
                persona.setActivo(rs.getBoolean("activo"));

            }
        }catch (Exception e){
            persona = null ;
        }
        return persona;
    }

    public boolean update(Persona persona){
        boolean result = true;
        try{
            PreparedStatement ps = connectToDB.getConnection()
                    .prepareStatement("UPDATE PERSONA SET nombre=?, apellido=?, dni=?, edad=? WHERE id=?");
            ps.setString(1,persona.getNombre());
            ps.setString(2,persona.getApellido());
            ps.setString(3,persona.getDni());
            ps.setInt(4,persona.getEdad());
            ps.setInt(5,persona.getId());
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
            result = false ;
        }
        return result;
    }

    public boolean delete(int id){
        boolean result = true;
        try{
            PreparedStatement ps = connectToDB.getConnection()
                    .prepareStatement("DELETE FROM PERSONA WHERE id=?");
            ps.setInt(1,id);
            result = ps.executeUpdate() > 0;
        }catch (Exception e){
            System.out.println(e.getMessage());
            result = false ;
        }
        return result;
    }
}
