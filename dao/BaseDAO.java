package dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
    public static Connection getConnection() {
        try {
            //a string com a url para o banco de dados sintaxe: protocolo:tecnologia://domínioDoServidor:porta/database
            final String url = "jdbc:sqlite:/home/yasmin/.local/share/DBeaverData/workspace6/.metadata/sample-database-sqlite-1/Chinook.db";
            //argumentos: url para o banco, usuário, senha.e retorna um objeto da classe Connection (do pacote java.sql -> que segue a especificação JDBC).
            return DriverManager.getConnection(url, "dbeaver", "");
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args){
        System.out.println(BaseDAO.getConnection()+ "yes, it workss");
    }
}
