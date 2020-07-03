/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author jhone
 */
public class Conexion {
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver"; // Esta es la libreria de el motor de BD que usaremos 
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/webv"; // El servidor al que nos conectaremos y puerto de conexion
    private static final String DB_USER = "root"; // El nombre de usuario de la base de datos
    private static final String DB_PASSWORD = ""; // La contraseña de la base de datos
    private static Connection dbConnection = null; // Atributo de tipo connection que de momento no resive ningun dato

    public static Connection getDBConnection(){ // Creamos el metodo getDBConnection de tipo Connection
       try{
            Class.forName(DB_DRIVER); //Esto debe de ser para saber el motor que usaremos
        } catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD); // Esto hace la conexion a nuestra base de datos
            // System.out.println(dbConnection);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

     return dbConnection; // Retorna la conexion
   }
    public static void main(String[] args) {
        Conexion conn = new Conexion();
        
        System.out.print(conn);
    }
    
}



