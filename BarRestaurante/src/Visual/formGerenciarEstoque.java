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

public class formGerenciarEstoque extends javax.swing.JInternalFrame {
   
    //Conecta com o banco de dados
    Connection conecta;
    //Serve para a adição de parametros no Banco de Dados
    PreparedStatement pst;
    //Guarda os dados de uma pesquisa feita no Banco de Dados
    ResultSet rs;
    
    public formGerenciarEstoque() throws ClassNotFoundException {
        //Inicializa a janela
        initComponents();
        //Faz com que a janela inicialize num ponto pré-determinado na janela do formPrincipal
        this.setLocation(500,200);
        //Se conecta com o banco de dados
        conecta = ConexaoBD.conectaBD();
    }
    
    //Insere itens na tabela estoque do BD
    //Variaveis - id:serial (nao aparece aqui pq ele se auto-incrementa); item:String ; quantidade:inteiro.
    public void cadastrarItensEstoque(){
        //Variável para a modificação de itens no BD
        String sql;
        //Essa variável recebe um comando de inserção de valores no banco de dados, onde os parâmetros estão dentro do try abaixo
        sql = "Insert into estoque(item, quantidade) values (?, ?)";
        try{
            //Os parametros se conectam ao BD, assim pode inserir os valores no BD
            pst = conecta.prepareStatement(sql);
            //Aqui começa a zueira, o textoItem é a caixa de texto da janela GerenciarEstoque, qualquer coisa que o usuario digitar, vai ser inserida no pst.setString
            //Para fazer a condição dos if's e else's, seria bom pegar as variaveis textoAlgumaCoisa, pois elas que possuem os valores que o usuário digitou
            //O 1 dentro do setString significa que o item ta na coluna 1 da tabela
            pst.setString(1, textoItem.getText());
            //O textoQuantidade é a caixa de texto do item quantidade, tive que realizar conversao de String para int, porque a variavel quantidade é int
            //O 2 dentro do setString significa que a quantidade ta na coluna 2 da tabela
            pst.setInt(2, Integer.parseInt(textoQuantidade.getText()));
            //Vai tentar executar as inserções no banco de dados, se for bem sucedida, vai mostrar a mensagem Cadastro bem sucedido, se não, vai entrar no catch
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastro Bem-Sucedido!", "Cadastrado com sucesso!", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException error){
            JOptionPane.showMessageDialog(null, error);
        }
    }
    //Imprime na tela todos os itens da tabela estoque
    public void listarProdutos(){
        //Comando em sql para selecionar todos os itens da tabela estoque
        String sql = "Select * from estoque";
        try{
            //Mesmo esquema que do método cadastraItensEstoque
            pst = conecta.prepareStatement(sql);
            //Esse comando abaixo vai servir para percorrer todos os valores da tabela
            rs = pst.executeQuery();
            //O tabelaEstoque é a planilha que tem na janela, vai pegar o rs e vai jogar la bonitinho com todos os dados da tabela
            tabelaEstoque.setModel(DbUtils.resultSetToTableModel(rs));
        }
        
        catch(SQLException error){
            JOptionPane.showMessageDialog(null, error);
        }
    }
    
    /*Esse aqui serve para quando clicar em uma linha da planilha que possui um valor, os valores ficarem na caixa de texto (testem la pra ver que é melhor)
    Esse método é importante pois quando o usuário quiser deletar ou alterar um dado, é só clicar em cima que os dados vão estar populados nas caixas de texto
    Ai ou ele faz a alteração, ou a remoção daquele item que ele clicou */
    public void populaEstoque(){
        int seleciona = tabelaEstoque.getSelectedRow();
        //Campo ID
        textoID.setText(tabelaEstoque.getModel().getValueAt(seleciona, 0).toString());
        //Campo Item
        textoItem.setText(tabelaEstoque.getModel().getValueAt(seleciona, 1).toString());
        //Campo Quantidade
        textoQuantidade.setText(tabelaEstoque.getModel().getValueAt(seleciona, 2).toString());
        
    }
    
    //Vai deletar a linha que o usuário clicar no programa
    public void deletarEstoque(){
        //Comando em sql para fazer a remoção do item
        String sql = "Delete from estoque where item = ?";
        
        try{
            pst = conecta.prepareStatement(sql);
            pst.setString(1, textoItem.getText());
            pst.execute();
            listarProdutos();
            
        }
        catch(SQLException error){
            JOptionPane.showMessageDialog(null, error);
        }
    }
    //Esse método vai alterar os campos que o usuario quer modificar
    //Como funciona: Primeiro o usuário clica no que ele quer modificar, os dados serão populados nas caixas de texto
    //A partir dai, ele modifica diretamente na caixa de texto e clica no botão alterar
    //Depois de clicado, esse método vai chamar o método de imprimir na tabela e vai mostrar os itens ordenados pelo ID
    public void editarEstoque() {
        String sql  = "Update funcionarios set nome = ?, quantidade = ? where id = ?";
        
        try{
            pst = conecta.prepareStatement(sql);
            pst.setString(1, textoItem.getText());
            pst.setInt(2, Integer.parseInt(textoQuantidade.getText()));
            pst.setInt(3, Integer.parseInt(textoID.getText()));
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso!");
            listarProdutos();
        }
        catch(SQLException error){
            JOptionPane.showMessageDialog(null, error);
        }
    }
    
    //Daqui pra baixo é só coisas relacionadas às janelas e botões do programa
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaEstoque = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textoItem = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textoQuantidade = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        textoID = new javax.swing.JTextPane();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        tabelaEstoque.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaEstoque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaEstoqueMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaEstoque);

        jLabel1.setText("Item:");

        jScrollPane2.setViewportView(textoItem);

        jLabel2.setText("Quantidade:");

        jScrollPane3.setViewportView(textoQuantidade);

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

        jButton3.setText("Deletar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Listar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel3.setText("ID: ");

        textoID.setEnabled(false);
        jScrollPane4.setViewportView(textoID);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 33, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(43, 43, 43)
                        .addComponent(jButton2)
                        .addGap(56, 56, 56)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        editarEstoque();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       cadastrarItensEstoque();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabelaEstoqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaEstoqueMouseClicked
        populaEstoque();
    }//GEN-LAST:event_tabelaEstoqueMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        listarProdutos();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        deletarEstoque();
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tabelaEstoque;
    private javax.swing.JTextPane textoID;
    private javax.swing.JTextPane textoItem;
    private javax.swing.JTextPane textoQuantidade;
    // End of variables declaration//GEN-END:variables
}
