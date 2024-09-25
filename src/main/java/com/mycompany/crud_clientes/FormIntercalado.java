/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud_clientes;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class FormIntercalado extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table,
                                                   Object value,
                                                   boolean isSelected,
                                                   boolean hasFocus,
                                                   int row,
                                                   int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Verifica si la fila está seleccionada
        if (isSelected) {
            this.setBackground(new Color(140, 140, 140)); // Color de fondo para la selección
        } else {
            // Si la fila es par, establece el color blanco
            if (evaluarPar(row)) {
                this.setBackground(Color.WHITE);
            } else {
                // Si la fila es impar, establece un color personalizado
                this.setBackground(Color.decode("#94D7F2"));
            }
        }

        return this;
    }

    // Método para evaluar si una fila es par
    private boolean evaluarPar(int row) {
        return row % 2 == 0;
    }
}