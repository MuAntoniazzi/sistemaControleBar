/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Visual.formGerenciarEstoque;
import Visual.formGerenciarFuncionario;
import Visual.formGerenciarMenu;

/**
 *
 * @author Igor Lima
 */
public class TesteClasses {
    
    public TesteClasses() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void gerenciarEstoque_ItemValido_QtdValida() throws ClassNotFoundException{
        formGerenciarEstoque test = new formGerenciarEstoque();
        assertTrue(test.cadastrarItensEstoque("Bolacha", 10));
    }
    @Test
    public void gerenciarEstoque_ItemValido_QtdInvalida() throws ClassNotFoundException{
        formGerenciarEstoque test = new formGerenciarEstoque();
        assertFalse(test.cadastrarItensEstoque("Bolacha", -1));
    }
    @Test
    public void gerenciarEstoque_ItemInvalido_QtdChar_Menor() throws ClassNotFoundException{
        formGerenciarEstoque test = new formGerenciarEstoque();
        assertFalse(test.cadastrarItensEstoque("B", 10));
    }
    @Test
    public void gerenciarEstoque_ItemInvalido_QtdChar_Vazio() throws ClassNotFoundException{
        formGerenciarEstoque test = new formGerenciarEstoque();
        assertFalse(test.cadastrarItensEstoque("", 10));
    }
    @Test
    public void gerenciarEstoque_ItemInvalido_QtdChar_igualLimiteInferior() throws ClassNotFoundException{
        formGerenciarEstoque test = new formGerenciarEstoque();
        assertTrue(test.cadastrarItensEstoque("Pao", 10));
    }
    @Test
    public void gerenciarEstoque_ItemInvalido_QtdChar_Maior() throws ClassNotFoundException{
        formGerenciarEstoque test = new formGerenciarEstoque();
        assertFalse(test.cadastrarItensEstoque("Suco de Laranja com Acerola e Goiaba e Tamarindo e Limão e Maca e Goiaba Double e Laranja Deluxe International", 10));
    }
    @Test
    public void gerenciarEstoque_ItemInvalido_QtdChar_igualLimiteSuperior() throws ClassNotFoundException{
        formGerenciarEstoque test = new formGerenciarEstoque();
        assertTrue(test.cadastrarItensEstoque("Suco de Laranja com Acerola e Goiaba e Tamarindo e", 10));
    }   
    @Test
    public void gerenciarEstoque_ItemInvalido_SimboloChar()throws ClassNotFoundException{
        formGerenciarEstoque test = new formGerenciarEstoque();
        assertFalse(test.cadastrarItensEstoque("Bol@ch@", 10));
    }
    @Test
    public void gerenciarEstoque_ItemInvalido_NumChar() throws ClassNotFoundException{
        formGerenciarEstoque test = new formGerenciarEstoque();
        assertFalse(test.cadastrarItensEstoque("B0L4CH4", 10));
    }
    @Test
    public void gerenciarEstoque_QtdValida_ItemInvalido() throws ClassNotFoundException{
        formGerenciarEstoque test = new formGerenciarEstoque();
        assertFalse(test.cadastrarItensEstoque("B", 10));
    }
    @Test
    public void gerenciarEstoque_QtdValida_Zero() throws ClassNotFoundException{
        formGerenciarEstoque test = new formGerenciarEstoque();
        assertTrue(test.cadastrarItensEstoque("Bolacha", 0));
    }
    @Test
    public void gerenciarEstoque_QtdInvalida_Menor() throws ClassNotFoundException{
        formGerenciarEstoque test = new formGerenciarEstoque();
        assertFalse(test.cadastrarItensEstoque("Bolacha", -1));
    }
    @Test
    public void gerenciarEstoque_QtdInvalida_Maior() throws ClassNotFoundException{
        formGerenciarEstoque test = new formGerenciarEstoque();
        assertFalse(test.cadastrarItensEstoque("Bolacha", 10000));
    }
    @Test
    public void gerenciarEstoque_QtdInvalida_MtMaior() throws ClassNotFoundException{
        formGerenciarEstoque test = new formGerenciarEstoque();
        assertFalse(test.cadastrarItensEstoque("Bolacha", 100000));
    }   
    @Test
    public void gerenciarEstoque() throws ClassNotFoundException{
        formGerenciarEstoque test = new formGerenciarEstoque();
        assertTrue(test.cadastrarItensEstoque("Bolacha", 10));
    }
    //MENU
    
        @Test
    public void gerenciarMenu_ItemValido_QtdValida() throws ClassNotFoundException{
        formGerenciarMenu test = new formGerenciarMenu();
        assertTrue(test.cadastraItensMenu("Bolacha", 10.0));
    }
    @Test
    public void gerenciarMenu_ItemValido_QtdInvalida() throws ClassNotFoundException{
        formGerenciarMenu test = new formGerenciarMenu();
        assertFalse(test.cadastraItensMenu("Bolacha", -1.0));
    }
    @Test
    public void gerenciarMenu_ItemInvalido_QtdChar_Menor() throws ClassNotFoundException{
        formGerenciarMenu test = new formGerenciarMenu();
        assertFalse(test.cadastraItensMenu("B", 10.0));
    }
    @Test
    public void gerenciarMenu_ItemInvalido_QtdChar_Vazio() throws ClassNotFoundException{
        formGerenciarMenu test = new formGerenciarMenu();
        assertFalse(test.cadastraItensMenu("", 10.0));
    }
    @Test
    public void gerenciarMenu_ItemInvalido_QtdChar_igualLimiteInferior() throws ClassNotFoundException{
        formGerenciarMenu test = new formGerenciarMenu();
        assertTrue(test.cadastraItensMenu("Pao", 10.0));
    }
    @Test
    public void gerenciarMenu_ItemInvalido_QtdChar_Maior() throws ClassNotFoundException{
        formGerenciarMenu test = new formGerenciarMenu();
        assertFalse(test.cadastraItensMenu("Suco de Laranja com Acerola e Goiaba e Tamarindo e Limão e Maca e Goiaba Double e Laranja Deluxe International", 10.0));
    }
    @Test
    public void gerenciarMenu_ItemInvalido_QtdChar_igualLimiteSuperior() throws ClassNotFoundException{
        formGerenciarMenu test = new formGerenciarMenu();
        assertTrue(test.cadastraItensMenu("Suco de Laranja com Acerola e Goiaba e Tamarindo e", 10.0));
    }   
    @Test
    public void gerenciarMenu_ItemInvalido_SimboloChar()throws ClassNotFoundException{
        formGerenciarMenu test = new formGerenciarMenu();
        assertFalse(test.cadastraItensMenu("Bol@ch@", 10.0));
    }
    @Test
    public void gerenciarMenu_ItemInvalido_NumChar() throws ClassNotFoundException{
        formGerenciarMenu test = new formGerenciarMenu();
        assertFalse(test.cadastraItensMenu("B0L4CH4", 10.0));
    }
    @Test
    public void gerenciarMenu_PrecoValido_ItemInvalido() throws ClassNotFoundException{
        formGerenciarMenu test = new formGerenciarMenu();
        assertFalse(test.cadastraItensMenu("B", 10.0));
    }
    @Test
    public void gerenciarMenu_PrecoInvalido_Zero() throws ClassNotFoundException{
        formGerenciarMenu test = new formGerenciarMenu();
        assertFalse(test.cadastraItensMenu("Bolacha", 0));
    }
    //Verificar esse
    @Test
    public void gerenciarMenu_PrecoInvalido_Menor() throws ClassNotFoundException{
        formGerenciarMenu test = new formGerenciarMenu();
        assertFalse(test.cadastraItensMenu("Bolacha", -1.0));
    }

    public void gerenciarMenu_PrecoInvalido_Maior() throws ClassNotFoundException{
        formGerenciarMenu test = new formGerenciarMenu();
        assertFalse(test.cadastraItensMenu("Bolacha", 10001.0));
    }
    @Test
    public void gerenciarMenu_PrecoInvalido_MtMaior() throws ClassNotFoundException{
        formGerenciarMenu test = new formGerenciarMenu();
        assertFalse(test.cadastraItensMenu("Bolacha", 100000.0));
    }   
    @Test
    public void gerenciarMenu() throws ClassNotFoundException{
        formGerenciarMenu test = new formGerenciarMenu();
        assertTrue(test.cadastraItensMenu("Bolacha", 10.0));
    }
    @Test
    public void gerenciarFuncionario_CadastroValido() throws ClassNotFoundException{
       formGerenciarFuncionario test = new formGerenciarFuncionario();
        assertTrue(test.cadastrarFuncionario("Antonio da Silva", "11-1234-1234", "Rua das Laranjeiras"));
    }
    
    @Test
    public void gerenciarFuncionario_nomeUnderLimite1() throws ClassNotFoundException{
       formGerenciarFuncionario test = new formGerenciarFuncionario();
        assertFalse(test.cadastrarFuncionario("Ton", "11-1234-1234", "Rua das Laranjeiras"));
    }
    
    @Test
    public void gerenciarFuncionario_nomeUnderLimite2() throws ClassNotFoundException{
       formGerenciarFuncionario test = new formGerenciarFuncionario();
        assertFalse(test.cadastrarFuncionario("T", "11-1234-1234", "Rua das Laranjeiras"));
    }
    
    @Test
    public void gerenciarFuncionario_nomeLimiteInferior() throws ClassNotFoundException{
       formGerenciarFuncionario test = new formGerenciarFuncionario();
        assertTrue(test.cadastrarFuncionario("Tonhao", "11-1234-1234", "Rua das Laranjeiras"));
    }
    
    @Test
    public void gerenciarFuncionario_nomeOverLimite1() throws ClassNotFoundException{
       formGerenciarFuncionario test = new formGerenciarFuncionario();
        assertFalse(test.cadastrarFuncionario("Antonio da Silva Jose Dos Santos Pascoale Souza Watchatcha ", "11-1234-1234", "Rua das Laranjeiras"));
    }
    
    @Test
    public void gerenciarFuncionario_nomeOverLimite2() throws ClassNotFoundException{
       formGerenciarFuncionario test = new formGerenciarFuncionario();
        assertFalse(test.cadastrarFuncionario("Antonio da Silva Jose Dos Santos Pascoale Souza Wat", "11-1234-1234", "Rua das Laranjeiras"));
    }
    
    @Test
    public void gerenciarFuncionario_nomeLimiteSuperior() throws ClassNotFoundException{
       formGerenciarFuncionario test = new formGerenciarFuncionario();
        assertTrue(test.cadastrarFuncionario("Antonio da Silva Jose Dos Santos Pascoale Souza W", "11-1234-1234", "Rua das Laranjeiras"));
    }
    
    @Test
    public void gerenciarFuncionario_nomeVazio() throws ClassNotFoundException{
       formGerenciarFuncionario test = new formGerenciarFuncionario();
        assertFalse(test.cadastrarFuncionario("", "11-1234-1234", "Rua das Laranjeiras"));
    }
    
    @Test
    public void gerenciarFuncionario_nomeSimbolo() throws ClassNotFoundException{
       formGerenciarFuncionario test = new formGerenciarFuncionario();
        assertFalse(test.cadastrarFuncionario("Antonio da $ilva", "11-1234-1234", "Rua das Laranjeiras"));
    }
    
    @Test
    public void gerenciarFuncionario_nomeNumero() throws ClassNotFoundException{
       formGerenciarFuncionario test = new formGerenciarFuncionario();
        assertFalse(test.cadastrarFuncionario("Antonio da Silva 123", "11-1234-1234", "Rua das Laranjeiras"));
    }
    
    @Test
    public void gerenciarFuncionario_enderecoUnderLimite1() throws ClassNotFoundException{
       formGerenciarFuncionario test = new formGerenciarFuncionario();
        assertFalse(test.cadastrarFuncionario("Antonio da Silva", "11-1234-1234", "R"));
    }
    
    @Test
    public void gerenciarFuncionario_enderecoUnderLimite2() throws ClassNotFoundException{
       formGerenciarFuncionario test = new formGerenciarFuncionario();
        assertFalse(test.cadastrarFuncionario("Antonio da Silva", "11-1234-1234", "Rua"));
    }
    
    @Test
    public void gerenciarFuncionario_enderecoLimiteInferior() throws ClassNotFoundException{
       formGerenciarFuncionario test = new formGerenciarFuncionario();
        assertTrue(test.cadastrarFuncionario("Antonio da Silva", "11-1234-1234", "Rua XV"));
    }
    
    @Test
    public void gerenciarFuncionario_enderecoOverLimite1() throws ClassNotFoundException{
       formGerenciarFuncionario test = new formGerenciarFuncionario();
        assertFalse(test.cadastrarFuncionario("Antonio da Silva", "11-1234-1234", "Rua das Laranjeiras das Catacumbas de Haraharagaraganaeaeae"));
    }
    
    @Test
    public void gerenciarFuncionario_enderecoOverLimite2() throws ClassNotFoundException{
       formGerenciarFuncionario test = new formGerenciarFuncionario();
        assertFalse(test.cadastrarFuncionario("Antonio da Silva", "11-1234-1234", "Rua das Laranjeiras das Catacumbas de Harahaganahae"));
    }
    
    @Test
    public void gerenciarFuncionario_enderecoLimiteSuperior() throws ClassNotFoundException{
       formGerenciarFuncionario test = new formGerenciarFuncionario();
        assertTrue(test.cadastrarFuncionario("Antonio da Silva", "11-1234-1234", "Rua das Laranjeiras das Catacumbas de Harahaganaha"));
    }
    
    @Test
    public void gerenciarFuncionario_enderecoVazio() throws ClassNotFoundException{
       formGerenciarFuncionario test = new formGerenciarFuncionario();
        assertFalse(test.cadastrarFuncionario("Antonio da Silva", "11-1234-1234", ""));
    }
    
    @Test
    public void gerenciarFuncionario_enderecoSimbolo() throws ClassNotFoundException{
       formGerenciarFuncionario test = new formGerenciarFuncionario();
        assertFalse(test.cadastrarFuncionario("Antonio da Silva", "11-1234-1234", "Rua das Laranjeira$"));
    }
    public void gerenciarFuncionario_telefone5Digitos() throws ClassNotFoundException{
       formGerenciarFuncionario test = new formGerenciarFuncionario();
        assertFalse(test.cadastrarFuncionario("Antonio da Silva", "11-12345-1234", "Rua das Laranjeiras"));
    }
    @Test
    public void gerenciarFuncionario_telefone_DDD3Digitos() throws ClassNotFoundException{
       formGerenciarFuncionario test = new formGerenciarFuncionario();
        assertTrue(test.cadastrarFuncionario("Antonio da Silva", "011-1234-1234", "Rua das Laranjeiras"));
    }
    @Test
    public void gerenciarFuncionario_telefoneLimiteSuperior1() throws ClassNotFoundException{
       formGerenciarFuncionario test = new formGerenciarFuncionario();
        assertFalse(test.cadastrarFuncionario("Antonio da Silva", "11-1234-12345123", "Rua das Laranjeiras"));
    }
        @Test
    public void gerenciarFuncionario_telefone_DDDInvalido1() throws ClassNotFoundException{
       formGerenciarFuncionario test = new formGerenciarFuncionario();
        assertFalse(test.cadastrarFuncionario("Antonio da Silva", "0111-1234-1234", "Rua das Laranjeiras"));
    }
    @Test
    public void gerenciarFuncionario_telefone_DDDInvalido2() throws ClassNotFoundException{
       formGerenciarFuncionario test = new formGerenciarFuncionario();
        assertFalse(test.cadastrarFuncionario("Antonio da Silva", "1234-1234", "Rua das Laranjeiras"));
    }
    public void gerenciarFuncionario_telefone_DDDSimbolo() throws ClassNotFoundException{
       formGerenciarFuncionario test = new formGerenciarFuncionario();
        assertFalse(test.cadastrarFuncionario("Antonio da Silva", "@@-1234-1234", "Rua das Laranjeiras"));
    }
    public void gerenciarFuncionario_telefone_Simbolo() throws ClassNotFoundException{
       formGerenciarFuncionario test = new formGerenciarFuncionario();
        assertFalse(test.cadastrarFuncionario("Antonio da Silva", "11-123*-1234", "Rua das Laranjeiras"));
    }
    public void gerenciarFuncionario_telefoneLetra() throws ClassNotFoundException{
       formGerenciarFuncionario test = new formGerenciarFuncionario();
        assertFalse(test.cadastrarFuncionario("Antonio da Silva", "11-123a-1a34", "Rua das Laranjeiras"));
    }
}
