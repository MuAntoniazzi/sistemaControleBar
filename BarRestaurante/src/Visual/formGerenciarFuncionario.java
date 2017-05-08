package Visual;
/*O import DAL.ConexaoBD vai importar os dados de conexao do Banco de Dados com o programa, ou seja, todo valor que for inserido vai ser jogado
diretamente no BD*/
import DAL.ConexaoBD;
//java.sql.* vai importar os comandos necessários para inserir métodos que consigam fazer a interação entre a linguagem sql e o java
import java.sql.*;
//javax.swing.JOptionPane vai criar as janelas do programa
import javax.swing.JOptionPane;
//O import debaixo vai fazer com que os dados inseridos sejam listados na hora em que clicar o botão listar
import net.proteanit.sql.DbUtils;

public class formGerenciarFuncionario extends javax.swing.JInternalFrame {

    //Conecta com o banco de dados
    Connection conecta;
    //Serve para a adição de parametros no Banco de Dados
    PreparedStatement pst;
    //Guarda os dados de uma pesquisa feita no Banco de Dados
    ResultSet rs;
    
    public formGerenciarFuncionario() throws ClassNotFoundException {
        //Inicializa a janela
        initComponents();
        //Faz com que a janela inicialize num ponto pré-determinado na janela do formPrincipal
        this.setLocation(500,200);
        //Se conecta com o banco de dados
        conecta = ConexaoBD.conectaBD();
    }
    //Insere valores na tabela funcionario do BD
    //Variaveis - id:serial (nao aparece aqui pq ele se auto-incrementa); nome:String ; telefone:String ; endereco:String.
    public void cadastrarFuncionario(){
        //Variável para a modificação de itens no BD
        String sql;
        //Essa variável recebe um comando de inserção de valores no banco de dados, onde os parâmetros estão dentro do try abaixo
        sql = "Insert into funcionarios(nome, telefone, endereco) values (?, ?, ?)";
        try{
            //Os parametros se conectam ao BD, assim pode inserir os valores no BD
            pst = conecta.prepareStatement(sql);
            //Aqui começa a zueira, o textoNome é a caixa de texto da janela GerenciarFuncionario, qualquer coisa que o usuario digitar, vai ser inserida no pst.setString
            //Para fazer a condição dos if's e else's, seria bom pegar as variaveis textoAlgumaCoisa, pois elas que possuem os valores que o usuário digitou
            //O 1 dentro do setString significa que o item ta na coluna 1 da tabela
            pst.setString(1, textoNome.getText());
            //O textoTelefone é a caixa de texto do item telefone
            //O 2 dentro do setString significa que a quantidade ta na coluna 2 da tabela
            pst.setString(2, textoTelefone.getText());
            //O textoEndereco é a caixa de texto do item endereco
            //O 2 dentro do setString significa que a quantidade ta na coluna 3 da tabela
            pst.setString(3, textoEndereco.getText());
            //Vai tentar executar as inserções no banco de dados, se for bem sucedida, vai mostrar a mensagem Cadastro bem sucedido, se não, vai entrar no catch
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastro Bem-Sucedido!", "Cadastrado com sucesso!", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException error){
            JOptionPane.showMessageDialog(null, error);
        }
    }
    
    //Imprime na tela todos os dados da tabela funcionario
    public void listarFuncionarios(){
        //Comando em sql para selecionar todos os itens da tabela funcionario
        String sql = "Select * from funcionarios order by id Asc";
        try{
            //Mesmo esquema que do método cadastrarFuncionario
            pst = conecta.prepareStatement(sql);
            //Esse comando abaixo vai servir para percorrer todos os valores da tabela
            rs = pst.executeQuery();
             //O tabelaFuncionario é a planilha que tem na janela, vai pegar o rs e vai jogar la bonitinho com todos os dados da tabela
            tabelaFuncionario.setModel(DbUtils.resultSetToTableModel(rs));
        }
        
        catch(SQLException error){
            JOptionPane.showMessageDialog(null, error);
        }
    }
    
    /*Esse aqui serve para quando clicar em uma linha da planilha que possui um valor, os valores ficarem na caixa de texto (testem la pra ver que é melhor)
    Esse método é importante pois quando o usuário quiser deletar ou alterar um dado, é só clicar em cima que os dados vão estar populados nas caixas de texto
    Ai ou ele faz a alteração, ou a remoção daquele item que ele clicou */
    public void populaFuncionario(){
        int seleciona = tabelaFuncionario.getSelectedRow();
        //Campo ID
        textoID.setText(tabelaFuncionario.getModel().getValueAt(seleciona, 0).toString());
        //Campo Nome
        textoNome.setText(tabelaFuncionario.getModel().getValueAt(seleciona, 1).toString());
        //Campo Telefone
        textoTelefone.setText(tabelaFuncionario.getModel().getValueAt(seleciona, 2).toString());
        //Campo Endereço
        textoEndereco.setText(tabelaFuncionario.getModel().getValueAt(seleciona, 3).toString());
    }
    
    //Vai deletar a linha que o usuário clicar na tabela
    public void deletarFuncionario(){
        //Comando em sql para fazer a remoção do item
        String sql = "Delete from funcionarios where nome = ?";
        
        try{
            pst = conecta.prepareStatement(sql);
            pst.setString(1, textoNome.getText());
            pst.execute();
            listarFuncionarios();        
        }
        
        catch(SQLException error){
            JOptionPane.showMessageDialog(null, error);
        }
    }
    
    //Esse método vai alterar os campos que o usuario quer modificar
    //Como funciona: Primeiro o usuário clica no que ele quer modificar, os dados serão populados nas caixas de texto
    //A partir dai, ele modifica diretamente na caixa de texto e clica no botão alterar
    //Depois de clicado, esse método vai chamar o método de imprimir na tabela e vai mostrar os itens ordenados pelo ID
    public void editarFuncionario(){
        String sql  = "Update funcionarios set nome = ?, telefone = ?, endereco = ? where id = ?";
        
        try{
            pst = conecta.prepareStatement(sql);
            pst.setString(1, textoNome.getText());
            pst.setString(2, textoTelefone.getText());
            pst.setString(3, textoEndereco.getText());
            pst.setInt(4, Integer.parseInt(textoID.getText()));
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso!");
            listarFuncionarios();
        }
        catch(SQLException error){
            JOptionPane.showMessageDialog(null, error);
        }
    }
    
    //Daqui pra baixo é só coisas relacionadas às janelas e botões do programa
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaFuncionario = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textoNome = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        textoTelefone = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        textoEndereco = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        textoID = new javax.swing.JTextPane();

        jButton3.setText("jButton3");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        tabelaFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelaFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaFuncionarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaFuncionario);

        jLabel1.setText("Nome");

        jLabel2.setText("Telefone");

        jLabel3.setText("Endereço");

        jScrollPane2.setViewportView(textoNome);

        jScrollPane3.setViewportView(textoTelefone);

        jScrollPane4.setViewportView(textoEndereco);

        jButton1.setText("Inserir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Alterar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Deletar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Consultar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel4.setText("ID:");

        jScrollPane5.setViewportView(jTextPane1);

        jScrollPane6.setViewportView(jTextPane2);

        textoID.setEnabled(false);
        jScrollPane7.setViewportView(textoID);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(43, 43, 43)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(33, 33, 33)
                        .addComponent(jButton5))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane4)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cadastrarFuncionario();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        listarFuncionarios();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tabelaFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaFuncionarioMouseClicked
        populaFuncionario();
    }//GEN-LAST:event_tabelaFuncionarioMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        deletarFuncionario();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        editarFuncionario();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTable tabelaFuncionario;
    private javax.swing.JTextPane textoEndereco;
    private javax.swing.JTextPane textoID;
    private javax.swing.JTextPane textoNome;
    private javax.swing.JTextPane textoTelefone;
    // End of variables declaration//GEN-END:variables
}
