/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud_clientes;

import com.mycompany.crud_clientes.GestionEncabezadoTabla;

import com.mycompany.productos.Conexion;
import java.awt.Color;
import java.awt.Component;

import java.awt.Color;

import java.sql.CallableStatement;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;


import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


/**
 *
 * @author SENA
 */
public class CCliente {

    int idCliente;
    String correoCliente; 
    int tipoIdentificacionId; 
    int numeroIdentificacionCliente;
    String nombreCliente;
    String apellidoCliente;
    String clave_cliente;
    String telefonoCliente;
    String direccionEntregaCliente;
    String fechaNacimientoCliente;
    int ciudadId;
    int estado;
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public int getTipoIdentificacionId() {
        return tipoIdentificacionId;
    }

    public void setTipoIdentificacionId(int tipoIdentificacionId) {
        this.tipoIdentificacionId = tipoIdentificacionId;
    }

    public int getNumeroIdentificacionCliente() {
        return numeroIdentificacionCliente;
    }

    public void setNumeroIdentificacionCliente(int numeroIdentificacionCliente) {
        this.numeroIdentificacionCliente = numeroIdentificacionCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getClave_cliente() {
        return clave_cliente;
    }

    public void setClave_cliente(String clave_cliente) {
        this.clave_cliente = clave_cliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getDireccionEntregaCliente() {
        return direccionEntregaCliente;
    }

    public void setDireccionEntregaCliente(String direccionEntregaCliente) {
        this.direccionEntregaCliente = direccionEntregaCliente;
    }

    public String getFechaNacimientoCliente() {
        return fechaNacimientoCliente;
    }

    public void setFechaNacimientoCliente(String fechaNacimientoCliente) {
        this.fechaNacimientoCliente = fechaNacimientoCliente;
    }

    public int getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(int ciudadId) {
        this.ciudadId = ciudadId;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    //P de Parametro
    public void InsertarCliente(JTextField pCorreo, JComboBox pTipoIdentificacion, JTextField pNumIdentificacionCliente, JTextField pNombreCliente, JTextField pApellidoCliente, JTextField pClaveCliente, JTextField pTelefonoCliente, JTextField pDirreccionCliente, JTextField pFechaNacimiento, JComboBox pCiudadId){
        
        setCorreoCliente(pCorreo.getText());
        setTipoIdentificacionId(pTipoIdentificacion.getSelectedIndex() +1);
        setNumeroIdentificacionCliente(Integer.parseInt(pNumIdentificacionCliente.getText()));
        setNombreCliente(pNombreCliente.getText());
        setApellidoCliente(pApellidoCliente.getText());
        setClave_cliente(pClaveCliente.getText());
        setTelefonoCliente(pTelefonoCliente.getText());
        setDireccionEntregaCliente(pDirreccionCliente.getText());
        setFechaNacimientoCliente(pFechaNacimiento.getText());
        setCiudadId(pCiudadId.getSelectedIndex() +1);
        
        CConexion objetoConexion = new CConexion();

        String consulta = "INSERT INTO `cliente` (`correo_cliente`, `tipo_identificacion_id`, `numero_identificacion_cliente`, `nombre_cliente`, `apellido_cliente`, `clave_cliente`, `telefono_cliente`, `direccion_entrega_cliente`, `fecha_nacimiento_cliente`, `ciudad_id`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            // Crear un PreparedStatement en lugar de un CallableStatement
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            
            // Setear los parámetros en el PreparedStatement
            cs.setString(1, getCorreoCliente());
            cs.setInt(2, getTipoIdentificacionId());
            cs.setInt(3, getNumeroIdentificacionCliente());
            cs.setString(4, getNombreCliente());
            cs.setString(5, getApellidoCliente());
            cs.setString(6, getClave_cliente());
            cs.setString(7, getTelefonoCliente());
            cs.setString(8, getDireccionEntregaCliente());
            cs.setString(9, getFechaNacimientoCliente());
            cs.setInt(10, getCiudadId());
            
            // Ejecutar la consulta
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se inserto correctamente el cliente");
        } catch (Exception e) {
            // Manejo de excepciones
           JOptionPane.showMessageDialog(null, "No se inserto correctamente el cliente, error: "+e.toString());
        }
    }

    //P de Parametro
    public void MostrarClientes(JTable pTablaClientesTotales){
        CConexion objetoConexion = new CConexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        Object[] columnNames = {"ID Cliente", "Correo Cliente","Tipo Identificacion ID","Num Identificacion Cliente","Nombre Cliente","Apellido Cliente","Clave Cliente","Telefono Cliente","Dirreccion Cliente","Fecha Nacimiento Cliente","Ciudad ID","Estado"};
        
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel>(modelo);
        pTablaClientesTotales.setRowSorter(OrdenarTabla);
        
        String sql = "";
        
        modelo.addColumn("ID Cliente");
        modelo.addColumn("Correo Cliente");
        modelo.addColumn("Tipo Identificacion ID");
        modelo.addColumn("Num Identificacion Cliente");
        modelo.addColumn("Nombre Cliente");
        modelo.addColumn("Apellido Cliente");
        modelo.addColumn("Clave Cliente");
        modelo.addColumn("Telefono Cliente");
        modelo.addColumn("Direccion Cliente");
        modelo.addColumn("Fecha Nacimiento Cliente");
        modelo.addColumn("Ciudad ID");
        modelo.addColumn("Estado");
        
        pTablaClientesTotales.setModel(modelo);
        
        sql = "select * from cliente;";
        
        String[] datos = new String[12];
        Statement st;
        
        try {
            st= objetoConexion.estableceConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                datos[8] = rs.getString(9);
                datos[9] = rs.getString(10);
                datos[10] = rs.getString(11);

                
                String estado = rs.getString(12);
                datos[11] = (estado.equals("1")) ? "Activo" : "Desactivado";

                datos[11] = rs.getString(12);

                
                modelo.addRow(datos);
            }
            
            pTablaClientesTotales.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar los registros, error: "+e.toString());
        }
        
        FormIntercalado c = new FormIntercalado();
        
        
        //Funciones adiciones:
        //Cambiar color de la cabecera
        JTableHeader Theader = pTablaClientesTotales.getTableHeader();

        Theader.setDefaultRenderer(new GestionEncabezadoTabla());

        Theader.setBackground(Color.decode("#94D7F2"));

        
        //Desabilitar mover las cl¿olumnas
        pTablaClientesTotales.getTableHeader().setReorderingAllowed(false);
        
        //No poder editar
        pTablaClientesTotales.setDefaultEditor(Object.class, null);
        
        //El tamaño de lo header al hacer slide creo xdd
        

        TableColumnModel columnModel = pTablaClientesTotales.getColumnModel();
            for (int i = 0; i < columnNames.length; i++) {
                int maxWidth = 1500;
                for (int j = 0; j < modelo.getRowCount(); j++) {
                    TableCellRenderer renderer = pTablaClientesTotales.getCellRenderer(j, i);
                    Component comp = pTablaClientesTotales.prepareRenderer(renderer, j, i);
                    int preferredWidth = comp.getPreferredSize().width;
                    maxWidth = Math.max(maxWidth, preferredWidth);
                }
                columnModel.getColumn(i).setPreferredWidth(maxWidth);
            }
            pTablaClientesTotales.revalidate();
            pTablaClientesTotales.repaint();

            Theader.setDefaultRenderer(new GestionEncabezadoTabla());

        
        //
        for(int i = 0; i< pTablaClientesTotales.getColumnCount(); i++){
        pTablaClientesTotales.getColumnModel().getColumn(i).setCellRenderer(c);
        
        }
    }
    
    public void SeleccionarCliente(JTable pTablaClientes, JTextField pIdCliente, JTextField pCorreo, JComboBox pTipoIdentificacion, JTextField pNumIdentificacionCliente, JTextField pNombreCliente, JTextField pApellidoCliente, JTextField pClaveCliente, JTextField pTelefonoCliente, JTextField pDirreccionCliente, JTextField pFechaNacimiento, JComboBox pCiudadId, JTextField pEstado) {
    try {
        int fila = pTablaClientes.getSelectedRow();

        if (fila >= 0) {
            pIdCliente.setText(pTablaClientes.getValueAt(fila, 0).toString());
            pCorreo.setText(pTablaClientes.getValueAt(fila, 1).toString());
            pTipoIdentificacion.setSelectedIndex(Integer.parseInt(pTablaClientes.getValueAt(fila, 2).toString()) - 1); // Resta 1 para ajustar el índice
            pNumIdentificacionCliente.setText(pTablaClientes.getValueAt(fila, 3).toString());
            pNombreCliente.setText(pTablaClientes.getValueAt(fila, 4).toString());
            pApellidoCliente.setText(pTablaClientes.getValueAt(fila, 5).toString());
            pClaveCliente.setText(pTablaClientes.getValueAt(fila, 6).toString());
            pTelefonoCliente.setText(pTablaClientes.getValueAt(fila, 7).toString());
            pDirreccionCliente.setText(pTablaClientes.getValueAt(fila, 8).toString());
            pFechaNacimiento.setText(pTablaClientes.getValueAt(fila, 9).toString());
            pCiudadId.setSelectedIndex(Integer.parseInt(pTablaClientes.getValueAt(fila, 10).toString()) - 1); // Resta 1 para ajustar el índice
            String estado = pTablaClientes.getValueAt(fila, 11).toString();
            pEstado.setText(estado); // Busca el estado en el combo box por su valor
        } else {
            JOptionPane.showMessageDialog(null, "Fila no seleccionada");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error de seleccion, error: " + e.toString());
    }
}

    
    public void ModificarCliente(JTextField pIdCliente , JTextField pCorreo, JComboBox pTipoIdentificacion, JTextField pNumIdentificacionCliente, JTextField pNombreCliente, JTextField pApellidoCliente, JTextField pClaveCliente, JTextField pTelefonoCliente, JTextField pDirreccionCliente, JTextField pFechaNacimiento, JComboBox pCiudadId) {
    // Establecer los valores del cliente con los campos de entrada
    System.out.println("Valores recibidos para modificación:");
        System.out.println("ID Cliente: " + pIdCliente.getText());
        System.out.println("Correo: " + pCorreo.getText());
        System.out.println("Tipo Identificación: " + pTipoIdentificacion.getSelectedIndex());
        System.out.println("Número de Identificación: " + pNumIdentificacionCliente.getText());
        System.out.println("Nombre: " + pNombreCliente.getText());
        System.out.println("Apellido: " + pApellidoCliente.getText());
        System.out.println("Clave: " + pClaveCliente.getText());
        System.out.println("Teléfono: " + pTelefonoCliente.getText());
        System.out.println("Dirección: " + pDirreccionCliente.getText());
        System.out.println("Fecha Nacimiento: " + pFechaNacimiento.getText());
        System.out.println("Ciudad: " + pCiudadId.getSelectedIndex());
    
    setIdCliente(Integer.parseInt(pIdCliente.getText()));
    setCorreoCliente(pCorreo.getText());
    setTipoIdentificacionId(pTipoIdentificacion.getSelectedIndex() +1);
    setNumeroIdentificacionCliente(Integer.parseInt(pNumIdentificacionCliente.getText()));
    setNombreCliente(pNombreCliente.getText());
    setApellidoCliente(pApellidoCliente.getText());
    setClave_cliente(pClaveCliente.getText());
    setTelefonoCliente(pTelefonoCliente.getText());
    setDireccionEntregaCliente(pDirreccionCliente.getText());
    setFechaNacimientoCliente(pFechaNacimiento.getText());
    setCiudadId(pCiudadId.getSelectedIndex() +1);

    CConexion objetoConexion = new CConexion();
    String consulta = "UPDATE cliente SET correo_cliente = ?, tipo_identificacion_id = ?, numero_identificacion_cliente = ?, nombre_cliente = ?, apellido_cliente = ?, clave_cliente = ?, telefono_cliente = ?, direccion_entrega_cliente = ?, fecha_nacimiento_cliente = ?, ciudad_id = ? WHERE id_cliente = ?";

    try {
        CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);

        // Setear los parámetros en el PreparedStatement con los valores del cliente
        cs.setString(1, getCorreoCliente());
        cs.setInt(2, getTipoIdentificacionId());
        cs.setInt(3, getNumeroIdentificacionCliente());
        cs.setString(4, getNombreCliente());
        cs.setString(5, getApellidoCliente());
        cs.setString(6, getClave_cliente());
        cs.setString(7, getTelefonoCliente());
        cs.setString(8, getDireccionEntregaCliente());
        cs.setString(9, getFechaNacimientoCliente());
        cs.setInt(10, getCiudadId());
        cs.setInt(11, getIdCliente()); // Agregar el ID del cliente en el último parámetro

        cs.execute();
        JOptionPane.showMessageDialog(null, "Modificación exitosa");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Modificación fallida, error: " + e.toString());
        System.out.println(e.toString());
    }
}

    public void DesactivarCliente(JTextField pIdCliente) {
    // Establecer los valores del cliente con los campos de entrada
    setIdCliente(Integer.parseInt(pIdCliente.getText()));

    CConexion objetoConexion = new CConexion();
    String consulta = "UPDATE cliente SET estado = 0 WHERE id_cliente = ?";

    try {
        CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);

        cs.setInt(1, getIdCliente()); // Agregar el ID del cliente en el segundo parámetro

        cs.execute();
        JOptionPane.showMessageDialog(null, "Desactivación exitosa");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Desactivación fallida, error: " + e.toString());
    }
}
    
    public void ActivarCliente(JTextField pIdCliente) {
    // Establecer los valores del cliente con los campos de entrada
    setIdCliente(Integer.parseInt(pIdCliente.getText()));

    CConexion objetoConexion = new CConexion();
    String consulta = "UPDATE cliente SET estado = 1 WHERE id_cliente = ?";

    try {
        CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);

        cs.setInt(1, getIdCliente()); // Agregar el ID del cliente en el segundo parámetro

        cs.execute();
        JOptionPane.showMessageDialog(null, "Activación exitosa");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Activación fallida, error: " + e.toString());
    }
}
    
    public void LimpiarCamposCliente(JTextField pIdCliente, JTextField pCorreo, JComboBox pTipoIdentificacion, 
                                 JTextField pNumIdentificacionCliente, JTextField pNombreCliente, JTextField pApellidoCliente, 
                                 JTextField pClaveCliente, JTextField pTelefonoCliente, JTextField pDirreccionCliente, 
                                 JTextField pFechaNacimiento, JComboBox pCiudadId, JTextField pEstado) {

    pIdCliente.setText("");
    pCorreo.setText("");
    pNumIdentificacionCliente.setText("");
    pNombreCliente.setText("");
    pApellidoCliente.setText("");
    pClaveCliente.setText("");
    pTelefonoCliente.setText("");
    pDirreccionCliente.setText("");
    pFechaNacimiento.setText("");

    pTipoIdentificacion.setSelectedIndex(0);
    pCiudadId.setSelectedIndex(0);
    pEstado.setText("");
}
    
    public void CargarComboBox(String table,String campoId, String campoNombre, JComboBox paramCombo) {
        Conexion conn = new Conexion();
        String consulta = "SELECT " + campoId + "," + campoNombre + " FROM " + table ;
        Statement st;
        try  {
            st = conn.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while (rs.next()) {
                paramCombo.addItem(rs.getString(campoNombre));
            }
        } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.toString() );
        }
    }


    
    
}