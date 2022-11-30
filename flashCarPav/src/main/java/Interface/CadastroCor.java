/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import br.unipar.flashcar.exception.DescricaoInvalidaException;
import br.unipar.flashcar.model.Cor;
import br.unipar.flashcar.service.CorService;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author tailon.prado
 */
public class CadastroCor extends javax.swing.JFrame {

    /**
     * Creates new form CadastroCor
     */
    public CadastroCor() {
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

        idCor = new javax.swing.JTextField();
        descricaoCor = new javax.swing.JTextField();
        excluiCor = new javax.swing.JButton();
        atualizaCor = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        idCor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                idCorFocusLost(evt);
            }
        });
        idCor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                idCorKeyReleased(evt);
            }
        });

        excluiCor.setText("Excluir");
        excluiCor.setEnabled(false);
        excluiCor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluiCorActionPerformed(evt);
            }
        });

        atualizaCor.setText("Cadastrar");
        atualizaCor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizaCorActionPerformed(evt);
            }
        });

        jLabel1.setText("Id");

        jLabel2.setText("Descrição");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(excluiCor, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(atualizaCor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(idCor, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(descricaoCor, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descricaoCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(excluiCor)
                    .addComponent(atualizaCor))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idCorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idCorFocusLost
        if(idCor.getText().equals("")){
            excluiCor.setEnabled(false);
            atualizaCor.setText("Cadastrar");
        }else{
            excluiCor.setEnabled(true);
            atualizaCor.setText("Atualizar");
            
            CorService corService = new CorService();
            Cor cor = new Cor();
            try {
                cor = corService.findById(Integer.parseInt(idCor.getText()));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao buscar a cor. Erro: "+ex.getMessage());
            }
            
            if(cor.getId() == null){
                JOptionPane.showMessageDialog(null, "Cor com id ("+idCor.getText()+") não encontrada.");
                excluiCor.setEnabled(false);
                atualizaCor.setText("Cadastrar");
                idCor.setText("");
            }else{
                descricaoCor.setText(cor.getDescricao());
            }
        }
    }//GEN-LAST:event_idCorFocusLost

    private void idCorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idCorKeyReleased
        idCor.setText(idCor.getText().replaceAll("[^0-9]+", ""));
    }//GEN-LAST:event_idCorKeyReleased

    private void atualizaCorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizaCorActionPerformed
        Cor cor = new Cor();
        if(!idCor.getText().equals(""))
            cor.setId(Integer.parseInt(idCor.getText()));
        cor.setDescricao(descricaoCor.getText());
        
        CorService corService = new CorService();
        if(idCor.getText().equals("")){
            try {   
                corService.insert(cor);
                cor.setId(corService.lastId());
                idCor.setText(cor.getId().toString());
                excluiCor.setEnabled(true);
                atualizaCor.setText("Atualizar");
                JOptionPane.showMessageDialog(null, "Cor ("+cor.getId()+") cadastrada com sucesso.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar cor. Erro: "+ex.getMessage());
            }
        }
        else{
            try {
                corService.update(cor);
                JOptionPane.showMessageDialog(null, "Cor ("+cor.getId()+") atualizada com sucesso.");
            } catch (DescricaoInvalidaException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar Cor. Erro: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_atualizaCorActionPerformed

    private void excluiCorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluiCorActionPerformed
        Cor cor = new Cor();
        cor.setId(Integer.parseInt(idCor.getText()));
        cor.setDescricao(descricaoCor.getText());
        
        CorService corService = new CorService();
        
        try {
            Object[] options = { "Sim", "Não" }; 
            int opcao = JOptionPane.showOptionDialog(null, "Deseja realmente excluir este registro?", "Exclusão de Registro", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]); 
            if (opcao == 0) {
                corService.delete(cor);
                JOptionPane.showMessageDialog(null, "Cor ("+cor.getId()+") excluida com sucesso");
                idCor.setText("");
                descricaoCor.setText("");
                
                excluiCor.setEnabled(false);
                atualizaCor.setText("Cadastrar");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao excluir Cor. Erro: " + ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir Cor. Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_excluiCorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroCor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroCor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroCor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroCor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroCor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atualizaCor;
    private javax.swing.JTextField descricaoCor;
    private javax.swing.JButton excluiCor;
    private javax.swing.JTextField idCor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}