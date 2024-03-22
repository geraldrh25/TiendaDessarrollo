/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javasqlserver;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable; 
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class CUsuario {
    public void mostrarUsuario(JTable paramTablaUsuario){
        
        CConexion objetoConexion = new CConexion();
        
        DefaultTableModel modelo = new DefaultTableModel(); 
        
        String sql="";
        
        modelo.addColumn("idUsuario");
        modelo.addColumn("nombre");
        modelo.addColumn("apellidos");
        modelo.addColumn("correoUsuario");
        modelo.addColumn("telefonoUsuario");
        
        paramTablaUsuario.setModel (modelo);
        
        sql="select * from Usuario;";  
        
        String [] datos = new String[5];
        
        Statement st;
        
        try {
            
            st = objetoConexion.establecerConexion().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                
                modelo.addRow(datos);
            }
            
            paramTablaUsuario.setModel(modelo);
            
                
            } catch (Exception e) {
                
                JOptionPane.showMessageDialog(null,"No se mostraron los registros, error:"+e.toString());
            }
        
      
    }
    
    public void SeleccionarUsuario(JTable paramTablaUsuario, JTextField paramId, JTextField paramNombre, JTextField paramApellido, JTextField paramCorreoUsuario, JTextField paramTelefonoUsuario){
        
        try {
            int fila = paramTablaUsuario.getSelectedRow();
            
            if (fila>=0){
                paramId.setText(paramTablaUsuario.getValueAt(fila, 0).toString());
                paramNombre.setText(paramTablaUsuario.getValueAt(fila, 1).toString());
                paramApellido.setText(paramTablaUsuario.getValueAt(fila, 2).toString());
                paramCorreoUsuario.setText(paramTablaUsuario.getValueAt(fila, 3).toString());
                paramTelefonoUsuario.setText(paramTablaUsuario.getValueAt(fila, 4 ).toString());
            }
            else{
                JOptionPane.showMessageDialog(null,"No se seleciono registros, error:");
            }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"error de seleccion:"+e.toString());
            }
        
    }
    
    public void InsertarUsuario(JTable paramTablaUsuario, JTextField paramId, JTextField paramNombre, JTextField paramApellido, JTextField paramCorreoUsuario, JTextField paramTelefonoUsuario){
        CConexion objetoConexion = new CConexion();
        
        String consulta = "INSERT INTO usuarios (Nombre, Apellidos, CorreoUsuario, TelefonoUsuario) VALUES (?,?,?,?);";
        
        try {
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            
            
            cs.setString(1, paramId.getText());
            cs.setString(2, paramNombre.getText());
            cs.setString(3, paramApellido.getText());
            cs.setString(4, paramCorreoUsuario.getText());
            cs.setString(5, paramTelefonoUsuario.getText());
            
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null,"Se inserto correctamente");
                
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al insetar");    
            }
    }
    
    public void ModificarUsuario(JTextField paramIdUsuario, JTextField paramId, JTextField paramNombre, JTextField paramApellido, JTextField paramCorreoUsuario, JTextField paramTelefonoUsuario){
        
        CConexion objetoConexion = new CConexion();
        
        String consulta = "UPDATE usuarios SET usuarios.Nombre = ?, usuarios.Apellidos = ?, usuarios.CorreoUsuario = ?,  usuarios.TelefonoUsuario =? WHERE usuarios.IdUsuario=?;";
        
        try {
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta); 
            
            cs.setString(1, paramNombre.getText());
            cs.setString(2, paramApellido.getText());
            cs.setString(3, paramCorreoUsuario.getText());
            cs.setString(4, paramTelefonoUsuario.getText());
            cs.setInt(5, Integer.parseInt(paramIdUsuario.getText()));
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null,"Se modificó correctamente");
            
               
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Error al modificar:"+e.toString( ));
            }
        
        
    }
    
    public void EliminarUsuario(JTextField paramIdUsuario){
        
        CConexion objetoConexion = new CConexion();
        
        String consulta = "DELETE FROM usuarios WHERE usuarios.IdUsuario=?;";
        
        try {
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setInt(1, Integer.parseInt(paramIdUsuario.getText()));
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null,"Se elimino correctamente");
            
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Error al eliminar:"+e.toString( ));
            }
}

    void mostrarUsuarios(JTable tableusuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void InsertarUsuario(JTextField txtid, JTextField txtnombre, JTextField txtapellidos, JTextField txtcorreo, JTextField txttelefono) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void ModificarUsuario(JTextField txtid, JTextField txtnombre, JTextField txtapellidos, JTextField txtcorreo, JTextField txttelefono) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}    



