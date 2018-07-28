package TESTE;

import br.com.multcare.validator.ValidateCDA;
import java.awt.Color;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DemoCDA extends javax.swing.JFrame {
    public DemoCDA() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        telaPrincipal = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        XML = new javax.swing.JLabel();
        SelecionarXML = new javax.swing.JButton();
        Validar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        AreaDeAviso = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        telaPrincipal.setBackground(new java.awt.Color(254, 254, 254));
        telaPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                telaPrincipalMouseEntered(evt);
            }
        });
        telaPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(199, 236, 238));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(254, 254, 254));
        jLabel1.setFont(new java.awt.Font("Poiret One", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(69, 142, 150));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Validador HL7 CDA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 770, 50));

        telaPrincipal.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 770, 70));

        XML.setBackground(new java.awt.Color(254, 254, 254));
        XML.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        telaPrincipal.add(XML, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 510, 30));

        SelecionarXML.setBackground(new java.awt.Color(254, 254, 254));
        SelecionarXML.setFont(new java.awt.Font("Comfortaa", 1, 12)); // NOI18N
        SelecionarXML.setForeground(new java.awt.Color(0, 184, 148));
        SelecionarXML.setText("Selecionar arquivo XML");
        SelecionarXML.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        SelecionarXML.setBorderPainted(false);
        SelecionarXML.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SelecionarXML.setFocusPainted(false);
        SelecionarXML.setFocusable(false);
        SelecionarXML.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SelecionarXMLMouseEntered(evt);
            }
        });
        SelecionarXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelecionarXMLActionPerformed(evt);
            }
        });
        telaPrincipal.add(SelecionarXML, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 230, 30));

        Validar.setBackground(new java.awt.Color(254, 254, 254));
        Validar.setFont(new java.awt.Font("Comfortaa", 1, 12)); // NOI18N
        Validar.setForeground(new java.awt.Color(0, 184, 148));
        Validar.setText("Validar");
        Validar.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        Validar.setBorderPainted(false);
        Validar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Validar.setFocusPainted(false);
        Validar.setFocusable(false);
        Validar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ValidarMouseEntered(evt);
            }
        });
        Validar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValidarActionPerformed(evt);
            }
        });
        telaPrincipal.add(Validar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 230, 30));

        jScrollPane1.setBackground(new java.awt.Color(254, 254, 254));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jScrollPane1.setToolTipText("Resultado do teste de validação");

        AreaDeAviso.setEditable(false);
        AreaDeAviso.setColumns(20);
        AreaDeAviso.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        AreaDeAviso.setForeground(new java.awt.Color(1, 1, 1));
        AreaDeAviso.setLineWrap(true);
        AreaDeAviso.setRows(5);
        AreaDeAviso.setToolTipText("Resultado do teste de validação");
        AreaDeAviso.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jScrollPane1.setViewportView(AreaDeAviso);

        telaPrincipal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 750, 280));

        jSeparator1.setBackground(new java.awt.Color(199, 236, 238));
        jSeparator1.setForeground(new java.awt.Color(199, 236, 238));
        telaPrincipal.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 750, 10));

        jSeparator2.setBackground(new java.awt.Color(199, 236, 238));
        jSeparator2.setForeground(new java.awt.Color(199, 236, 238));
        telaPrincipal.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 750, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(telaPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(telaPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private File arquivoXml;
    
    public File getArquivoXml() {
        return arquivoXml;
    }

    public void setArquivoXml(File arquivo) {
        this.arquivoXml = arquivo;
    }
    
    public File selecionarArquivo(){
    JFileChooser filechooser = new JFileChooser();
    filechooser.setDialogTitle("Selecione uma arquivo");
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivo em XML","xml","XML");
    filechooser.addChoosableFileFilter(filter);
    filechooser.setAcceptAllFileFilterUsed(false);
    filechooser.setDialogType(JFileChooser.OPEN_DIALOG);
    
    File direct = new File(".");
    
    filechooser.setCurrentDirectory(new File(direct.getAbsolutePath()));
    
    filechooser.showOpenDialog(this);
    return filechooser.getSelectedFile();
    }
    
    private void ValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValidarActionPerformed
        ValidateCDA v = new ValidateCDA();
        
        if(getArquivoXml()!=null){
            if(v.validationCDAFile(getArquivoXml())){
                setColor(0);
                AreaDeAviso.setText(v.getNotificacao());
            }else{
                setColor(1);
                AreaDeAviso.setText(v.getNotificacao());
            }
        }
    }//GEN-LAST:event_ValidarActionPerformed
    
    void setColor(int op){
        if(op ==1)
            AreaDeAviso.setForeground(new Color(255,0,0));
        else
            AreaDeAviso.setForeground(new Color(5,138,5));
    }
    
    private void SelecionarXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelecionarXMLActionPerformed
        File xml = selecionarArquivo();
        setArquivoXml(xml);
        if(xml!=null)XML.setText(xml.getName());
    }//GEN-LAST:event_SelecionarXMLActionPerformed

    private void setButtonColor(JButton button){
        button.setBackground(new Color(34, 166, 179));
        button.setForeground(new Color(254,254,254));
    }
    private void getButtonColor(JButton button){
        button.setBackground(new Color(254,254,254));
        button.setForeground(new Color(0,184,148));
    }
    private void SelecionarXMLMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SelecionarXMLMouseEntered
        setButtonColor(SelecionarXML);
    }//GEN-LAST:event_SelecionarXMLMouseEntered

    private void ValidarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ValidarMouseEntered
        setButtonColor(Validar);
    }//GEN-LAST:event_ValidarMouseEntered

    private void telaPrincipalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_telaPrincipalMouseEntered
        getButtonColor(Validar);
        getButtonColor(SelecionarXML);
    }//GEN-LAST:event_telaPrincipalMouseEntered

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
            java.util.logging.Logger.getLogger(DemoCDA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DemoCDA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DemoCDA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DemoCDA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DemoCDA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AreaDeAviso;
    private javax.swing.JButton SelecionarXML;
    private javax.swing.JButton Validar;
    private javax.swing.JLabel XML;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel telaPrincipal;
    // End of variables declaration//GEN-END:variables
}
