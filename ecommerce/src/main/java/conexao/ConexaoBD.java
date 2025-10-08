
package conexao;

import java.sql.Connection;


public interface ConexaoBD {
    
    
    //obtem uma conexao com o banco de dados
    Connection obterConexao() throws Exception;
    
    
    
    //fecha uma conexao com o vanco de dados
    void fechaConexao(Connection conexao);
        
        
    
}
