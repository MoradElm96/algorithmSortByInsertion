/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SortByInsertionGUI;

/**
 *
 * @author Morad
 */import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortByInsertionGUI {

    private JTextField[] inputFields;
    private JButton sortButton;
    private JTextArea resultArea;

    public SortByInsertionGUI() {
        JFrame frame = new JFrame("Ordenamiento por Inserción");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel label = new JLabel("Ingrese el número de cadenas:");
        JTextField sizeField = new JTextField(5);
        inputPanel.add(label);
        inputPanel.add(sizeField);

        sortButton = new JButton("Ordenar");
        resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false);

        mainPanel.add(inputPanel, BorderLayout.NORTH);

        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int size = Integer.parseInt(sizeField.getText());
                    String[] lista = new String[size];

                    for (int i = 0; i < size; i++) {
                        String cadena = JOptionPane.showInputDialog(frame, "Ingrese la cadena " + (i + 1) + ":");
                        lista[i] = cadena;
                    }

                    insertionSort(lista);

                    StringBuilder sortedElements = new StringBuilder();
                    for (String cadena : lista) {
                        sortedElements.append(cadena).append("\n");
                    }

                    resultArea.setText("Lista ordenada alfabéticamente:\n" + sortedElements.toString());

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        mainPanel.add(sortButton, BorderLayout.CENTER);
        mainPanel.add(resultArea, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private static void insertionSort(String[] lista) {
        int n = lista.length;
        for (int i = 1; i < n; i++) {
            String elementoActual = lista[i];
            int j = i - 1;

          
            while (j >= 0 && lista[j].compareTo(elementoActual) > 0) {
                lista[j + 1] = lista[j];
                j--;
            }

            
            lista[j + 1] = elementoActual;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SortByInsertionGUI());
    }
}
