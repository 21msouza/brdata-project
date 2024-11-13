package com.mycompany.brdata;

import com.mycompany.brdataconnect.ConnectionFac; // Importado o package/classe da conexão com o banco de dados
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mathe
 */
public class SQL {
    public void insert(Jogador jogador) throws SQLException {
        String sql = "INSERT INTO stats (nome, clube, posicao, gols, assistencias, cartoes_amarelos, cartoes_vermelhos) VALUES (?,?,?,?,?,?,?)"; // feito o comando do insert SEM o ID, visto que é auto_increment na tabela.
        Connection conex = null; // Feito uma variável do tipo Connection (biblioteca)
        PreparedStatement state = null; // Feito uma variável do tipo PreparedStatement.

        try {
            conex = ConnectionFac.connectionDB(); //Conectando com o banco pela package que importei
            state = conex.prepareStatement(sql); // guardando o comando INSERT na variável
            state.setString(1, jogador.getNome());
            state.setString(2, jogador.getClube());
            state.setString(3, jogador.getPosicao());
            state.setInt(4, jogador.getGols());
            state.setInt(5, jogador.getAssistencias());
            state.setInt(6, jogador.getCartoesAmarelos());
            state.setInt(7, jogador.getCartoesVermelhos()); // Setando em ordem baseado no comando INSERT, ou seja, concatenando o getNome com a posição 1 que no comando está realmente nome, e assim sucessivamente
            state.executeUpdate(); // dado "commit" no comando.
            System.out.println("Insercao realizada com sucesso."); // Caso dê certo, retorna com essa mensagem.
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Ocorreu um erro ao acessar o banco de dados: " + ex.getMessage()); // Caso dê errado, retorna com essa mensagem.
        } finally {
            if (state != null) {
                state.close(); // Fechando o Statement para evitar dois comandos ao mesmo tempo.
            }
            if (conex != null) {
                conex.close(); // Fechando a conexão para evitar duas conexões ao mesmo tempo.
            }
        }
    }
    public void select() {
        String sql = "SELECT * FROM stats"; // Comando básico do SELECT, sem filtros.
        Connection conex = null;
        PreparedStatement state = null;
        ResultSet rs = null; // Resultset para mostrar no programa o resultado do select, ou seja, exportando do banco para o programa

        try {
            conex = ConnectionFac.connectionDB();
            state = conex.prepareStatement(sql);
            rs = state.executeQuery(); // executado a query pela variável do resultset

            while (rs.next()) { // Até o ultimo registro ele irá exportar, ou seja, tudo que tem no banco.
                
                System.out.println("Sequencia: " + rs.getInt("id"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Clube: " + rs.getString("clube"));
                System.out.println("Posicao: " + rs.getString("posicao"));
                System.out.println("Gols: " + rs.getInt("gols"));
                System.out.println("Assistencias: " + rs.getInt("assistencias"));
                System.out.println("Cartoes Amarelos: " + rs.getInt("cartoes_amarelos"));
                System.out.println("Cartoes Vermelhos: " + rs.getInt("cartoes_vermelhos")); // pego todas as colunas do banco e exportado para o programa
                System.out.println("-------------------");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Erro ao consultar: " + ex.getMessage());
        } finally {
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } // fechado resultset para evitar duas querys abertas ao mesmo tempo.
            }
            if (state != null) {
                try { state.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
            if (conex != null) {
                try { conex.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        }
    }
    public void selectUpdate(){
        String sql = "SELECT id, nome FROM stats"; // Adaptação do SELECT "full", onde só quero exportar as colunas ID e Nome
        Connection conex = null;
        PreparedStatement state = null;
        ResultSet rs = null;

        try {
            conex = ConnectionFac.connectionDB();
            state = conex.prepareStatement(sql);
            rs = state.executeQuery();

            while (rs.next()) {
                
                System.out.println("Sequencia: " + rs.getInt("id") + " | Nome: " + rs.getString("nome")); // Exportando somente o ID e Nome para facilitar a visualização do usuário.
                System.out.println("-------------------");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Erro ao consultar: " + ex.getMessage());
        } finally {
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) {}
            }
            if (state != null) {
                try { state.close(); } catch (SQLException e) {}
            }
            if (conex != null) {
                try { conex.close(); } catch (SQLException e) {}
            }
        }
    }
    public void update(Jogador jogador) throws SQLException{
        String sql = "UPDATE stats SET nome = ?, clube = ?, posicao = ?, gols = ?, assistencias = ?, cartoes_amarelos = ?, cartoes_vermelhos = ? "
                       + "Where id = ?"; // Feito o comando de UPDATE onde irá alterar tudo (exceto ID pois é primary key) filtrando pelo ID da linha.
        Connection conex = null;
        PreparedStatement state = null;
        
        try {
            conex = ConnectionFac.connectionDB();
            state = conex.prepareStatement(sql);
            state.setString(1, jogador.getNome());
            state.setString(2, jogador.getClube());
            state.setString(3, jogador.getPosicao());
            state.setInt(4, jogador.getGols());
            state.setInt(5, jogador.getAssistencias());
            state.setInt(6, jogador.getCartoesAmarelos());
            state.setInt(7, jogador.getCartoesVermelhos());
            state.setInt(8, jogador.getId());
            state.execute(); // Processo parecido do Insert para o JAVA, porém com um comando SQL diferente.
            System.out.println("Alteracao realizada com sucesso.");

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Erro ao consultar: " + ex.getMessage());
        } finally {
            if (state != null) {
                try { state.close(); } catch (SQLException e) {}
            }
            if (conex != null) {
                try { conex.close(); } catch (SQLException e) {}
            }
        }
    }
    public void delete(Jogador jogador){
        String sql = "DELETE FROM stats WHERE id = ?"; // Deletando linha do banco filtrando pelo ID.
        Connection conex = null;
        PreparedStatement state = null;
            try {
            conex = ConnectionFac.connectionDB();
            state = conex.prepareStatement(sql);
            state.setInt(1, jogador.getId()); // Filtrando o ID na MAIN para executar o comando.
            state.execute();
            System.out.println("Jogador excluido com sucesso.");
            } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Erro ao excluir: " + ex.getMessage());
            } finally {
                if (state != null) {
                    try { state.close(); } catch (SQLException ex) {}
            }
                if (conex != null) {
                    try { conex.close(); } catch (SQLException ex) {}
            }
        }
    }
}
