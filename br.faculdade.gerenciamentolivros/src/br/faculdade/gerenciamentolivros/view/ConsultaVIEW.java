/*
 * Aulas professor Maromo.
 */
package br.faculdade.gerenciamentolivros.view;

import br.faculdade.gerenciamentolivros.entities.Editora;
import br.faculdade.gerenciamentolivros.entities.Livro;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author maromo
 */
public class ConsultaVIEW extends javax.swing.JFrame {

    private List<Livro> listaLivro;
    private List<Editora> listaEditora;
    DefaultTableModel modelo;

    /**
     * Creates new form ConsultaVIEW
     */
    public ConsultaVIEW() {
        initComponents();
        lookAndFeel();
    }

    private void lookAndFeel() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsultaVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public ConsultaVIEW(List<Livro> listaLivro, List<Editora> listaEditora) {
        initComponents();
        lookAndFeel();
        apresentarTabelaDefault(listaLivro, listaEditora);
    }

    private void apresentarTabelaDefault(List<Livro> listaLivro, List<Editora> listaEditora) {
        this.listaLivro = listaLivro;
        this.listaEditora = listaEditora;
        modelo = new DefaultTableModel();
        prepararCabecalho(modelo);
        //Apresentar os dados na tabela. Temos livros e editora (por nome)
        String nomeEditora = null;
        for (Livro livro : listaLivro) {
            for (Editora editora : listaEditora) {
                if (livro.editora.idEditora == editora.idEditora) {
                    nomeEditora = editora.nomeEditora;
                }
            }
            modelo.addRow(new Object[]{livro.idLivro, livro.tituloLivro, nomeEditora, livro.autor});
        }
    }

    private void prepararCabecalho(DefaultTableModel modelo) {
        tblDados.removeAll();
        tblDados.setModel(modelo);
        modelo.setColumnCount(4);
        modelo.setColumnIdentifiers(new Object[]{"Código ", "Título do Livro", "Nome da Editora", "Autor do Livro"});
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnFiltar = new javax.swing.JButton();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblTexto = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDados = new javax.swing.JTable();
        btnLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNome.setText("Nome:");
        getContentPane().add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 41, -1));

        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomeKeyTyped(evt);
            }
        });
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 420, -1));

        btnFiltar.setText("Filtrar");
        btnFiltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFiltarMouseClicked(evt);
            }
        });
        getContentPane().add(btnFiltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, 79, -1));

        lblCodigo.setText("Código:");
        getContentPane().add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, -1, -1));
        getContentPane().add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 80, -1));

        lblTexto.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblTexto.setText("Realize a busca por código ou nome");
        getContentPane().add(lblTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 460, -1));

        tblDados.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblDados.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblDados);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 870, -1));

        btnLimpar.setText("Limpar Filtros");
        btnLimpar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimparMouseClicked(evt);
            }
        });
        getContentPane().add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(759, 40, 140, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txtNomeKeyTyped

    private void txtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyReleased
        // TODO add your handling code here:
        StringBuffer sb = new StringBuffer();
        sb.append(txtNome.getText());
        modelo = new DefaultTableModel();
        prepararCabecalho(modelo);
        List<Livro>listaFiltrada = new ArrayList<>();
        Stream<Livro> filter = listaLivro.stream().filter(u -> u.tituloLivro.contains(sb.toString()));
        filter.forEach(listaFiltrada::add);
        String nomeEditora = null;
        for (Livro livro : listaFiltrada) {
            for (Editora editora : listaEditora) {
                if (livro.editora.idEditora == editora.idEditora) {
                    nomeEditora = editora.nomeEditora;
                }
            }
            modelo.addRow(new Object[]{livro.idLivro, livro.tituloLivro, nomeEditora, livro.autor});
        }
    }//GEN-LAST:event_txtNomeKeyReleased

    private void btnFiltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFiltarMouseClicked
        // TODO add your handling code here:
        int codigo = Integer.parseInt(txtCodigo.getText());
        modelo = new DefaultTableModel();
        prepararCabecalho(modelo);
        List<Livro>listaFiltrada = new ArrayList<>();
        Stream<Livro> filter = listaLivro.stream().filter(u -> u.idLivro==codigo);
        filter.forEach(listaFiltrada::add);
        String nomeEditora = null;
        for (Livro livro : listaFiltrada) {
            for (Editora editora : listaEditora) {
                if (livro.editora.idEditora == editora.idEditora) {
                    nomeEditora = editora.nomeEditora;
                }
            }
            modelo.addRow(new Object[]{livro.idLivro, livro.tituloLivro, nomeEditora, livro.autor});
        }
    }//GEN-LAST:event_btnFiltarMouseClicked

    private void btnLimparMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimparMouseClicked
        // TODO add your handling code here:
        apresentarTabelaDefault(listaLivro, listaEditora);
    }//GEN-LAST:event_btnLimparMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTexto;
    private javax.swing.JTable tblDados;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}