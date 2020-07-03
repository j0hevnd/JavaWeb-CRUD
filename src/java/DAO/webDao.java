/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Conexion;
import Modelo.webV;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author jhone
 */
public class webDao {
    private static Connection con = null;

    // Guardar
    public boolean save(webV e) {
       int status = 0;
       boolean flat = false; // Creamos una respuesta de tipo boleano
       String sql = "INSERT INTO usuarios(usuario, nombre, apellido, correo, contrasena) VALUES (?,?,?,?,?) "; // Creamos la consulta
       try {
           con = Conexion.getDBConnection();  // Instanciamos un objeto de conexion
           PreparedStatement ps = con.prepareStatement(sql); // Creamos un preparedStatement y le enciamos la consulta
           ps.setString(1, e.getUsuario()); // Añadimos cada uno de los datos que estan con signo de pregunta en la consulta en su respectiva posision 
           ps.setString(2, e.getNombre());
           ps.setString(3, e.getApellido());
           ps.setString(4, e.getCorreo());
           ps.setString(5, e.getConstrasena());

           status = ps.executeUpdate(); // Ejecutamos la consulta y guardamos le resultado en status (aun no tengo muy claro porque es executeUpdate y no executeQuery)

           if(status == 1){
               flat = true; // si la ejecucion en la BD es verdadera cambia la respuesta a true
           }
           con.close();
       }catch(Exception ex) {
           ex.printStackTrace();
       }

       return flat; // Retona la respuesta de lo que haya acontesido aquí dentro
    }
    
    // Actualizar
    public JSONArray getUserEdit(int id) {
        JSONArray jsonArray = new JSONArray(); // instaciamos un objeto de tipo JSONArray 
        try {
            Connection con = Conexion.getDBConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM usuarios WHERE id_usuario=?"); // hacemos el preparedStatement
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery(); // Ejecutamos la consultas
            Integer i = 0;
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while (rs.next()) {
                JSONObject jsonObject = new JSONObject();  // Creamos un objeto de tipo jsonObject
                for (int ii = 1; ii < columnCount + 1; ii++) {
                    String colum = rsmd.getColumnLabel(ii); // guardamos el nombre de la columna en el String colum
                    jsonObject.put(colum, rs.getObject(colum)); // Lo agregamo al objeto de tipo jsonObject donde agrega el nombre de la columna y a este le agrega el dato que va en ella
                }
                jsonArray.put(i, jsonObject); // Al jsonArray le agregamos todo lo que este en la posision i del jsonObject
                i++;
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonArray; // Retornamos el jsonArray con lo que le hayan encontrado
    } 
     
    public boolean updateWeb(webV e) { // creamos el metodo de actualizar y resivimos parametros de tipo wevV
        int status = 0;
        boolean flat = false;
        try {
            con = Conexion.getDBConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE usuarios SET usuario=?, nombre=?, apellido=? WHERE id_usuario=" + e.getId()); // Preparamos la consulta
            ps.setString(1, e.getUsuario()); // Eniviamos los datos que resivimos como parametros
            ps.setString(2, e.getNombre());
            ps.setString(3, e.getApellido());
            status = ps.executeUpdate(); // ejecutamos la consulta
            if(status == 1){
                flat = true;
            }
            con.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return flat; //Retonamos el resultado de la consulta (true or false)
    }
    
    // Borrar
    public boolean deleteWeb(int id) { // resivimos un id como parametro
        int status = 0;
        boolean flat = false; 
        
        try {
            con = Conexion.getDBConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM usuarios WHERE id_Usuario=?");  // Preparamos la consulta
            ps.setInt(1, id); // le enviamos el id que resivimos
            status = ps.executeUpdate();  //  ejecutamos
            if(status == 1){
                flat = true;
            }
        }catch(Exception ex){
             ex.printStackTrace();
        }
        
        return flat; // Retornamos el resultado de la consulta
    }
    
    public JSONArray getView() { // Creamos un metodo de tipo JSONArray 
        JSONArray jsonArray = new JSONArray(); 
        try {
            Connection con = Conexion.getDBConnection();
            PreparedStatement ps = con.prepareStatement("SELECT id_usuario, usuario, CONCAT(nombre,' ', apellido) AS nombre, correo FROM usuarios"); // Preparamos la consulta a la base de datos
            ResultSet rs = ps.executeQuery(); // Ejecutamos la consulta y guardamos el resultado
            Integer i = 0;
            ResultSetMetaData rsmd = rs.getMetaData(); 
            int columnCount = rsmd.getColumnCount();
            while(rs.next()) {
                JSONObject jsonObject = new JSONObject();
                for(int j = 1; j < columnCount + 1; j++){
                    String colum = rsmd.getColumnLabel(j); // guardamos el nombre de la columna en el String colum
                    jsonObject.put(colum, rs.getObject(colum)); // Lo agregamo al objeto de tipo jsonObject donde agrega el nombre de la columna y a este le agrega el dato que va en ella
                }
                jsonArray.put(i, jsonObject); 
                i++;
            }  
            con.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return jsonArray; // Retornamos el jsonArray
    }
    
    /// CONSULTAS PARA EL LOGIN
    
    public boolean autenticacion(webV e) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean flat = false; 
        try {
            con = Conexion.getDBConnection();
            String consulta = "SELECT * FROM usuarios WHERE usuario=? AND correo=? AND contrasena=?";
            ps = con.prepareStatement(consulta);
            ps.setString(1, e.getUsuario());
            ps.setString(2, e.getCorreo());
            ps.setString(3, e.getConstrasena());
            rs = ps.executeQuery();
            
            if(rs.absolute(1)){ // Si tiene un registro retorneme true
                flat =  true;
            }
            ps.close();
            rs.close();
            con.close();
        } catch(Exception ex) {
            System.err.println("Error "+ex);
        }
        
        return flat;
    } 
}
