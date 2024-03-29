/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.event.ListSelectionEvent;
import model.bean.Livro;
import model.bean.Vendedor;

/**
 *
 * @author biaad
 */
public class TelaRelatório extends javax.swing.JInternalFrame {
    
   private javax.swing.table.DefaultTableModel tabelaModelo;
   private Object tabelaRelatorio;
   private Livro lSelecionado = new Livro();
        
    public TelaRelatório(){
        
        CriarTabelaModelo();
        
        initComponents();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Nome do Livro", "ISBN", "Páginas"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    public void CriarTabelaModelo(){
    tabelaModelo = new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null}
                },
                new String[]{
                    "Nome do livro", "ISBN", "Páginas"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            boolean[] canEdit = new boolean[]{
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }

        };
    }

 public void preencherRelatorio(ListSelectionEvent e) {
        int linha = jTable1.getSelectedRow();
        try {
            
            String titulo = tabelaModelo.getValueAt(linha, 1).toString();
            String ISBN = tabelaModelo.getValueAt(linha, 2).toString();
            String paginas = tabelaModelo.getValueAt(linha, 3).toString();

            this.preencherTabela(lSelecionado, titulo, ISBN, paginas);

        } catch (Exception erro) {
        }
    }

    public void preencherTabela(Livro l, String titulo, String ISBN, String paginas) {
        if (titulo != null && ISBN != null && paginas != null) {
          l.setTitulo(titulo);
          l.setISBN(Integer.parseInt(ISBN));
          l.setPaginas(Integer.parseInt(paginas));
        } 
    }
}