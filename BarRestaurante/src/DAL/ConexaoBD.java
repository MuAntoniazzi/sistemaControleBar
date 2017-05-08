package DAL;
import java.sql.*;
import javax.swing.JOptionPane;

//Essa classe serve apenas para fazer a conexao com o banco de dados

public class ConexaoBD {
    public static Connection conectaBD() throws ClassNotFoundException{
        //Try e Catch servem para tratar exceções
        try{
            /*Procura o driver do Postgresql, que foi o SGBD usado nesse programa
            Class.forName("org.postgresql.Driver");
            Esse connection debaixo serve para conectar ao banco de dados.
            Para criar um banco de dados desse programa no seu pc, tem que criar as tabelas diretamente no postgresql,
            e modificar os campos do getConnection(),
            onde getConnection("jdbc:sgbd que se quer usar://localhost:num_do_localost_postgresql/nomedoBD", "nome_usuario_postgresql", "senha_do_usuario")*/
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BarRestaurante","postgres", "root");
            return con;
        }
        
        catch(SQLException error){    
            JOptionPane.showMessageDialog(null, error);
            return null;
        }
    }
}
