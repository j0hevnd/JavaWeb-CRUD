/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author jhone
 */
public class webV {
    // Creamos los atributos de nuestra clase
    private int id;
    private String usuario;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;

    // para editar
    public webV(int id, String usuario, String nombre, String apellido){ // Resivimos parametros
        this.id = id; // Enviamos los parametros resividos a sus respectivos atributos de la clase
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    // Autenticacion
    public webV(String usuario, String correo, String contrasena){
        this.usuario = usuario;
        this.correo = correo;
        this.contrasena = contrasena;
    }
    
    public webV(){
        
    }
    
    // Para añadir
    public webV(String usuario, String nombre, String apellido, String correo, String contrasena){ // Resivimos parametros
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
    }
     
    // Estos son los metodos que retornan la informacion que nos piden(GET) y que envian la informacion que resivimos a los atributos de la clse(SET) 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getConstrasena() {
        return contrasena;
    }

    public void setConstrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
}
