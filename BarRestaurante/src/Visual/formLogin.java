package Visual;
import java.sql.*;
import DAL.ConexaoBD;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

//Essa classe é a classe de login do programa
//Não precisa modificar nada, os usuarios e senhas são cadastradas diretamente no postgresql

public class formLogin extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public formLogin() throws ClassNotFoundException{
        initComponents();
        //Vai abrir a janela no centro da tela
        setLocationRelativeTo(null);
        con = ConexaoBD.conectaBD();
    }
    
    public void Logar(){
        
        String sql = "Select * from login where usuario = ? and senha = ?";
        
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1, textoUsuario.getText());
            pst.setString(2, textoSenha.getText());
            
            rs = pst.executeQuery();
            
            if(rs.next()){
                formPrincipal frm = new formPrincipal();
                frm.setVisible(true);
                dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "Usuario e/ou senha invalidos");
            }
        }
        
        catch(SQLException error){
            JOptionPane.showMessageDialog(null, error);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textoUsuario = new javax.swing.JTextField();
        textoSenha = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        LOGIN = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login de usuário");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Usuário:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jLabel1, gridBagConstraints);

        jLabel2.setText("Senha:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 300;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(textoUsuario, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 300;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(textoSenha, gridBagConstraints);

        jButton1.setText("Entrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jButton1, gridBagConstraints);

        LOGIN.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        LOGIN.setName(""); // NOI18N
        LOGIN.setText("LOGIN");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(LOGIN, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       Logar();
    }//GEN-LAST:event_jButton1ActionPerformed
                                      

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new formLogin().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(formLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label LOGIN;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField textoSenha;
    private javax.swing.JTextField textoUsuario;
    // End of variables declaration//GEN-END:variables
}
                     


            
