/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Categoria;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author valmanu
 */
public class modeloTabla extends DefaultTableModel{
    public modeloTabla(Object[] columnNames, int rowCount) {
        super(columnNames, rowCount);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false; 
    }
}
