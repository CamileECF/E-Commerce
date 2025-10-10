package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL implements ConexaoBD {

    private static final String URL = "jdbc:mysql://localhost:3306/ecommerce";
    private static final String USUARIO = "root";
    private static final String SENHA = "1234";

    @Override
    public Connection obterConexao() throws Exception {
        try {
            // Carrega o driver JDBC (opcional no Java 8+)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Retorna uma conexão ativa
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException e) {
            throw new Exception("Driver JDBC não encontrado!", e);
        } catch (SQLException e) {
            throw new Exception("Erro ao conectar ao banco de dados!", e);
        }
    }

    @Override
    public void fechaConexao(Connection conexao) {
        if (conexao != null) {
            try {
                conexao.close();
                System.out.println("✅ Conexão fechada com sucesso!");
            } catch (SQLException e) {
                System.out.println("⚠️ Erro ao fechar a conexão!");
                e.printStackTrace();
            }
        }
    }
}