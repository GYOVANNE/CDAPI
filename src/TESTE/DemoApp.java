package TESTE;

import br.com.multcare.ClinicalDocument;
import br.com.multcare.validator.ValidateCDA;
import java.awt.CardLayout;
import java.awt.Color;
import java.io.File;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author android
 */
public class DemoApp extends javax.swing.JFrame {
    public DemoApp() {
        initComponents();
    }
    private File arquivoXml;
    
    public File getArquivoXml() {
        return arquivoXml;
    }
    void setColor(int op){
        if(op ==1)
            AreaDeAviso.setForeground(new Color(255,0,0));
        else
            AreaDeAviso.setForeground(new Color(5,138,5));
    }

    public void setArquivoXml(File arquivo) {
        this.arquivoXml = arquivo;
    }
    
    private void setButtonColor(JLabel button){
        button.setBackground(new Color(72, 84, 96));
        button.setForeground(new Color(210, 218, 226));
    }
    private void getButtonColor(JLabel button){
        button.setBackground(new Color(30,39,46));
        button.setForeground(new Color(254,254,254));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelSistema = new javax.swing.JPanel();
        panelGerar = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        panelLer = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        XML1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        AreaDeLeitura = new javax.swing.JTextArea();
        LerArquivo = new javax.swing.JLabel();
        selecionar1 = new javax.swing.JLabel();
        panelValidacao = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AreaDeAviso = new javax.swing.JTextArea();
        XML = new javax.swing.JLabel();
        selecionar = new javax.swing.JLabel();
        Validar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lerCDA = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Validacao = new javax.swing.JLabel();
        gerarCDA = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(1, 1, 1));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPrincipal.setBackground(new java.awt.Color(30, 39, 46));
        panelPrincipal.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panelPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelPrincipalMouseEntered(evt);
            }
        });
        panelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelSistema.setBackground(new java.awt.Color(254, 254, 254));
        panelSistema.setLayout(new java.awt.CardLayout());

        panelGerar.setBackground(new java.awt.Color(240, 240, 240));
        panelGerar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Comfortaa", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(115, 115, 115));
        jLabel3.setText("Selecione um arquivo para iniciar a validação");
        panelGerar.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 370, 30));

        panelSistema.add(panelGerar, "panelGerar");

        panelLer.setBackground(new java.awt.Color(240, 240, 240));
        panelLer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Comfortaa", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(115, 115, 115));
        jLabel4.setText("Selecione um arquivo para iniciar a leitura");
        panelLer.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 370, 30));

        XML1.setBackground(new java.awt.Color(254, 254, 254));
        XML1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panelLer.add(XML1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 350, 40));

        jScrollPane2.setBackground(new java.awt.Color(254, 254, 254));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jScrollPane2.setToolTipText("Resultado do teste de validação");

        AreaDeLeitura.setEditable(false);
        AreaDeLeitura.setColumns(20);
        AreaDeLeitura.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        AreaDeLeitura.setForeground(new java.awt.Color(1, 1, 1));
        AreaDeLeitura.setLineWrap(true);
        AreaDeLeitura.setRows(5);
        AreaDeLeitura.setToolTipText("Resultado do teste de validação");
        AreaDeLeitura.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jScrollPane2.setViewportView(AreaDeLeitura);

        panelLer.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 760, 440));

        LerArquivo.setBackground(new java.awt.Color(241, 242, 246));
        LerArquivo.setFont(new java.awt.Font("Comfortaa", 0, 13)); // NOI18N
        LerArquivo.setForeground(new java.awt.Color(74, 74, 74));
        LerArquivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LerArquivo.setText("Ler");
        LerArquivo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LerArquivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LerArquivo.setOpaque(true);
        LerArquivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LerArquivoMouseClicked(evt);
            }
        });
        panelLer.add(LerArquivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 190, 40));

        selecionar1.setBackground(new java.awt.Color(241, 242, 246));
        selecionar1.setFont(new java.awt.Font("Comfortaa", 0, 13)); // NOI18N
        selecionar1.setForeground(new java.awt.Color(74, 74, 74));
        selecionar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        selecionar1.setText("Escolher arquivo");
        selecionar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        selecionar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        selecionar1.setOpaque(true);
        selecionar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selecionar1MouseClicked(evt);
            }
        });
        panelLer.add(selecionar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 190, 40));

        panelSistema.add(panelLer, "panelLer");

        panelValidacao.setBackground(new java.awt.Color(241, 242, 246));
        panelValidacao.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panelValidacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelValidacaoMouseEntered(evt);
            }
        });
        panelValidacao.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        panelValidacao.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 760, 290));

        XML.setBackground(new java.awt.Color(254, 254, 254));
        XML.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panelValidacao.add(XML, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 560, 40));

        selecionar.setBackground(new java.awt.Color(241, 242, 246));
        selecionar.setFont(new java.awt.Font("Comfortaa", 0, 13)); // NOI18N
        selecionar.setForeground(new java.awt.Color(74, 74, 74));
        selecionar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        selecionar.setText("Escolher arquivo");
        selecionar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        selecionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        selecionar.setOpaque(true);
        selecionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selecionarMouseClicked(evt);
            }
        });
        panelValidacao.add(selecionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 190, 40));

        Validar.setBackground(new java.awt.Color(241, 242, 246));
        Validar.setFont(new java.awt.Font("Comfortaa", 0, 13)); // NOI18N
        Validar.setForeground(new java.awt.Color(74, 74, 74));
        Validar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Validar.setText("Validar");
        Validar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Validar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Validar.setOpaque(true);
        Validar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ValidarMouseClicked(evt);
            }
        });
        panelValidacao.add(Validar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 190, 40));

        jLabel1.setFont(new java.awt.Font("Comfortaa", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(115, 115, 115));
        jLabel1.setText("Faça upload do arquivo XML que você deseja validar.");
        panelValidacao.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 510, 30));

        jLabel5.setBackground(new java.awt.Color(254, 254, 254));
        jLabel5.setFont(new java.awt.Font("Poiret One", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(154, 154, 154));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Validador CDA");
        panelValidacao.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 290, 50));

        panelSistema.add(panelValidacao, "panelValidacao");

        panelPrincipal.add(panelSistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 780, 550));

        lerCDA.setBackground(new java.awt.Color(30, 39, 46));
        lerCDA.setFont(new java.awt.Font("Comfortaa", 0, 13)); // NOI18N
        lerCDA.setForeground(new java.awt.Color(254, 254, 254));
        lerCDA.setText("                  ler CDA");
        lerCDA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lerCDA.setOpaque(true);
        lerCDA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lerCDAMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lerCDAMouseEntered(evt);
            }
        });
        panelPrincipal.add(lerCDA, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 220, 40));

        jLabel2.setBackground(new java.awt.Color(254, 254, 254));
        jLabel2.setFont(new java.awt.Font("Poiret One", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("HL7 CDA");
        panelPrincipal.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 70));

        Validacao.setBackground(new java.awt.Color(30, 39, 46));
        Validacao.setFont(new java.awt.Font("Comfortaa", 0, 13)); // NOI18N
        Validacao.setForeground(new java.awt.Color(254, 254, 254));
        Validacao.setText("                  Validação");
        Validacao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Validacao.setOpaque(true);
        Validacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ValidacaoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ValidacaoMouseEntered(evt);
            }
        });
        panelPrincipal.add(Validacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 220, 40));

        gerarCDA.setBackground(new java.awt.Color(30, 39, 46));
        gerarCDA.setFont(new java.awt.Font("Comfortaa", 0, 13)); // NOI18N
        gerarCDA.setForeground(new java.awt.Color(254, 254, 254));
        gerarCDA.setText("                  Gerar CDA");
        gerarCDA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gerarCDA.setOpaque(true);
        gerarCDA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gerarCDAMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gerarCDAMouseEntered(evt);
            }
        });
        panelPrincipal.add(gerarCDA, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 220, 40));

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelPrincipal.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 780, 70));

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, 1000, 620));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public File selecionarArquivo(){
        JFileChooser filechooser = new JFileChooser();
        filechooser.setDialogTitle("Selecione um arquivo");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivo XML","xml","XML");
        filechooser.addChoosableFileFilter(filter);
        filechooser.setAcceptAllFileFilterUsed(false);
        filechooser.setDialogType(JFileChooser.OPEN_DIALOG);

        File direct = new File(".");

        filechooser.setCurrentDirectory(new File(direct.getAbsolutePath()));

        filechooser.showOpenDialog(this);
        return filechooser.getSelectedFile();
    }
    private void lerCDAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lerCDAMouseClicked
        CardLayout card = (CardLayout) panelSistema.getLayout();
        card.show(panelSistema, "panelLer");                
    }//GEN-LAST:event_lerCDAMouseClicked

    private void panelValidacaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelValidacaoMouseEntered
        getButtonColor(lerCDA);
        getButtonColor(gerarCDA);
        setButtonColor(Validacao);
    }//GEN-LAST:event_panelValidacaoMouseEntered

    private void selecionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selecionarMouseClicked
        File xml = selecionarArquivo();
        setArquivoXml(xml);
        if(xml!=null)XML.setText(xml.getName());
    }//GEN-LAST:event_selecionarMouseClicked

    private void ValidarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ValidarMouseClicked
        ValidateCDA v = new ValidateCDA();

        if(getArquivoXml()!=null){
            if(v.validationCDAFile(getArquivoXml())){
                setColor(0);
                AreaDeAviso.setText(v.getNotification());
            }else{
                setColor(1);
                AreaDeAviso.setText(v.getNotification());
            }
        }
    }//GEN-LAST:event_ValidarMouseClicked

    private void lerCDAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lerCDAMouseEntered
        setButtonColor(lerCDA);
        getButtonColor(gerarCDA);
        getButtonColor(Validacao);
    }//GEN-LAST:event_lerCDAMouseEntered

    private void ValidacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ValidacaoMouseClicked
        CardLayout card = (CardLayout) panelSistema.getLayout();
        card.show(panelSistema, "panelValidacao");  
    }//GEN-LAST:event_ValidacaoMouseClicked

    private void ValidacaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ValidacaoMouseEntered
         setButtonColor(Validacao);
         getButtonColor(gerarCDA);
         getButtonColor(lerCDA);
    }//GEN-LAST:event_ValidacaoMouseEntered

    private void gerarCDAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gerarCDAMouseClicked
        CardLayout card = (CardLayout) panelSistema.getLayout();
        card.show(panelSistema, "panelGerar");
    }//GEN-LAST:event_gerarCDAMouseClicked

    private void gerarCDAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gerarCDAMouseEntered
         setButtonColor(gerarCDA);
         getButtonColor(Validacao);
         getButtonColor(lerCDA);
    }//GEN-LAST:event_gerarCDAMouseEntered

    private void panelPrincipalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelPrincipalMouseEntered
        getButtonColor(lerCDA);
        getButtonColor(gerarCDA);
        getButtonColor(Validacao);
    }//GEN-LAST:event_panelPrincipalMouseEntered

    private void selecionar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selecionar1MouseClicked
        File xml = selecionarArquivo();
        setArquivoXml(xml);
        if(xml!=null)XML1.setText(xml.getName());
    }//GEN-LAST:event_selecionar1MouseClicked

    private void LerArquivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LerArquivoMouseClicked
        if(getArquivoXml()!=null){
            String conteudo;
            try {
                ClinicalDocument cda = new ClinicalDocument(getArquivoXml());

                conteudo= "Nome: "+cda.getPatient().getName();
                conteudo += "\nSobrenome: "+cda.getPatient().getFamily();
                conteudo += "\nEndereço: "+cda.getPatient().getAddr();
                conteudo += "\nLocal de nascimento: "+cda.getPatient().getAddrBirthPlace();
                conteudo += "\nAniversario: "+cda.getPatient().getBirth();
                conteudo += "\nCodigo Sistema: "+cda.getPatient().getCodeSystem();
                conteudo += "\nEtinia: "+cda.getPatient().getEthnicGroup();
                conteudo += "\nId de extensao: "+cda.getPatient().getIdExtension();
                conteudo += "\nEstado civil: "+cda.getPatient().getMaritalStatus();
                conteudo += "\nTelefone: "+cda.getPatient().getPhone();
                conteudo += "\nRaça: "+cda.getPatient().getRace();
                conteudo += "\nReligiao: "+cda.getPatient().getReligious();
                conteudo += "\nId: "+cda.getPatient().getId();                
                
                AreaDeLeitura.setText(conteudo);
            } catch (Exception ex) {
                Logger.getLogger(DemoApp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_LerArquivoMouseClicked
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
            java.util.logging.Logger.getLogger(DemoApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DemoApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DemoApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DemoApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new DemoApp().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AreaDeAviso;
    private javax.swing.JTextArea AreaDeLeitura;
    private javax.swing.JLabel LerArquivo;
    private javax.swing.JLabel Validacao;
    private javax.swing.JLabel Validar;
    private javax.swing.JLabel XML;
    private javax.swing.JLabel XML1;
    private javax.swing.JLabel gerarCDA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lerCDA;
    private javax.swing.JPanel panelGerar;
    private javax.swing.JPanel panelLer;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelSistema;
    private javax.swing.JPanel panelValidacao;
    private javax.swing.JLabel selecionar;
    private javax.swing.JLabel selecionar1;
    // End of variables declaration//GEN-END:variables
}
