package com.mycompany.Categoria;


import com.mycompany.productos.GestionCeldas;
import com.mycompany.productos.GestionEncabezadoTabla;
import java.awt.Component;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author usuario
 */
public class  Categoria {

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }
    
    int estado;
    String descripcion;
    int categoriaId;
    
    public void insertarCategoria(JTextField paramDescripcion, JTable paramMostrarProductos){
        
        setDescripcion(paramDescripcion.getText());
        
        Conexion conn = new Conexion();
        
        String consulta = "INSERT INTO categoria(id_categoria, nombre_categoria, estado) VALUES (?, ?, 1);";
        try {
            
            PreparedStatement ps = conn.establecerConexion().prepareStatement(consulta);
            ps.setInt(1, getCategoriaId());
            ps.setString(2,getDescripcion());
            
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se insertó correctamente la categoría");
                
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar la categoría: " + e.toString());
        }

        MostrarCategoria(paramMostrarProductos);
    }
    
   public void MostrarCategoria(JTable paramMostrarCategoria){
   Conexion conn = new Conexion();
    
    DefaultTableModel modelo = new DefaultTableModel();
    String sql = "";
    modelo.addColumn("ID");
    modelo.addColumn("Nombre");
    modelo.addColumn("Estado");
    
    
    
    sql = "SELECT c.id_categoria, c.nombre_categoria, c.estado FROM categoria c;";
    
    String[] datos = new String[3];
    try {
        PreparedStatement ps = conn.establecerConexion().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            datos[0] = rs.getString(1);
            datos[1] = rs.getString(2);
            String estado = rs.getString(3);
            datos[2] = (estado.equals("1")) ? "Activo" : "Desactivado";
            
            modelo.addRow(datos);
        }
        
        paramMostrarCategoria.setModel(modelo);
        
        JTableHeader th = paramMostrarCategoria.getTableHeader();
        th.setDefaultRenderer(new GestionEncabezadoTabla());
        
        for (int i = 0; i < paramMostrarCategoria.getColumnCount(); i++) {
                if (i == 0 || i == 4 || i == 5 || i == 8 || i == 9 || i == 10 || i == 13) { // columnas numericas
                    paramMostrarCategoria.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("numerico"));
                } else {
                    paramMostrarCategoria.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("texto"));
                }
            }
        
        String[] columnNames = {"ID_Categoria", "Nombre", "Estado"};
        
        TableColumnModel columnModel = paramMostrarCategoria.getColumnModel();
        for (int i = 0; i < columnNames.length; i++) {
            int maxWidth = 1500;
            for (int j = 0; j < modelo.getRowCount(); j++) {
                TableCellRenderer renderer = paramMostrarCategoria.getCellRenderer(j, i);
                Component comp = paramMostrarCategoria.prepareRenderer(renderer, j, i);
                int preferredWidth = comp.getPreferredSize().width;
                maxWidth = Math.max(maxWidth, preferredWidth);
            }
            columnModel.getColumn(i).setPreferredWidth(maxWidth);
        }
        paramMostrarCategoria.revalidate();
        paramMostrarCategoria.repaint();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "No se pudo mostrar los registros, error: " + e.toString());
    }}
    
    public void SeleccionarCategoria(JTable paramTablaProductos, JTextField paramId, JTextField paramDescripcion){
        try {
            int fila = paramTablaProductos.getSelectedRow();
            if (fila >= 0){
                paramId.setText(paramTablaProductos.getValueAt(fila,0).toString());
                paramDescripcion.setText(paramTablaProductos.getValueAt(fila,1).toString());
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Fila no seleccionada");
            }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error de seleccion: " + e.toString());
            
        }
    }
        
    public void EditarCategoria(JTextField paramId, JTextField paramDescripcion, JTable paramMostrarProductos){
        
        setCategoriaId(Integer.parseInt(paramId.getText()));
        setDescripcion(paramDescripcion.getText());
        
        Conexion conn = new Conexion();
        String consulta = "UPDATE categoria SET nombre_categoria = ? WHERE id_categoria = ?; ";
        
        try {
            PreparedStatement ps = conn.establecerConexion().prepareStatement(consulta);
            
            ps.setString(1, getDescripcion());
            ps.setInt(2, getCategoriaId());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Modificación exitosa");
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se modificó, error: " + e.toString());
            
        }

        MostrarCategoria(paramMostrarProductos);
    }
    
    public void EliminarCategoria(JTextField paramId, JTable paramMostrarProductos){
    setCategoriaId(Integer.parseInt(paramId.getText()));
    
    Conexion conn = new Conexion();
    String consulta = "UPDATE categoria SET estado = 0 WHERE id_categoria = ?;";
    
    try {
        PreparedStatement ps = conn.establecerConexion().prepareStatement(consulta);
        
        ps.setInt(1, getCategoriaId());
        
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Categoría desactivada exitosamente");

        MostrarCategoria(paramMostrarProductos);
   
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "No se pudo desactivar la categoría, error: " + e.toString());
    }
}

    
   public void ActivarCategoria(JTextField paramId, JTable paramMostrarProductos){
    setCategoriaId(Integer.parseInt(paramId.getText()));

    Conexion objetoConexion = new Conexion();
    String consulta = "UPDATE categoria SET estado = 1 WHERE id_categoria = ?";

    try {
        CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);

        cs.setInt(1, getCategoriaId()); 

        cs.execute();
        JOptionPane.showMessageDialog(null, "Activación exitosa");
        MostrarCategoria(paramMostrarProductos);
    }  catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al activar la categoría: " + e.toString());
    }
}

   public void LimpiarCampos(JTextField paramId, JTextField paramDescripcion){
    paramId.setText("");
    paramDescripcion.setText("");
    
}
}

    
                             