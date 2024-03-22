/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javasqlserver;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class CConexion {
    
    Connection conectar = null;
    
    String usuario ="root2";
    String contrasenia = "root2";
    String bd = "turismoBD";
    String ip = "localhost";
    String puerto = "1433";
    
    
    public Connection establecerConexion(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            String cadena = "jdbc:sqlserver://"+ip+":"+puerto+";"+"databaseName="+bd+";"+
                            "encrypt=true;trustServerCertifiate=true";
            conectar = DriverManager.getConnection(cadena,usuario,contrasenia);
            
            JOptionPane.showMessageDialog(null,"Se concectó satisfactoriamente a la base de datos");
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No Se concectó satisfactoriamente a la base de datos"); 
        }
        
        return conectar;
            
            
        }
    }
    

