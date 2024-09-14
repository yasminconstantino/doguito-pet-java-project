package dao;

import model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends BaseDAO{

    private static Cliente resultsetCliente(ResultSet rs) throws SQLException{
        Cliente cliente = new Cliente();
        cliente.setIdCliente(rs.getInt("id_cliente"));
        cliente.setNomeCliente(rs.getString("nm_cliente"));
        cliente.setCpf(rs.getString("cpf"));
        cliente.setTelefone(rs.getString("telefone"));
        cliente.setCep(rs.getString("cep"));
        cliente.setNrResidencia(rs.getString("nr_residencia"));
        cliente.setBairro(rs.getString("bairro"));
        cliente.setMunicipio(rs.getString("municipio"));
        cliente.setUf(rs.getString("uf"));

        return cliente;
    }

    public static boolean isertCliente (Cliente cliente){
        final String sql = "insert into clientes (nm_cliente, cpf, telefone, cep, nr_residencia, bairro, municipio, uf) values (?, ?, ?, ?,?,?, ?, ?)";;
        try(
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);) {
                stmt.setString(1,cliente.getNomeCliente());
                stmt.setString(2,cliente.getCpf());
                stmt.setString(3,cliente.getTelefone());
                stmt.setString(4,cliente.getCep());
                stmt.setString(5,cliente.getNrResidencia());
                stmt.setString(6, cliente.getBairro());
                stmt.setString(7,cliente.getMunicipio());
                stmt.setString(8,cliente.getUf());
                int count = stmt.executeUpdate();

                return count>0;
            } catch (SQLException e){
                e.printStackTrace();
                return false;
        }
    }

public static boolean alterarCliente(Cliente cliente) {
    final String sql = "UPDATE clientes SET nm_cliente=?, cpf=?, telefone=?, cep=?, nr_residencia=?, bairro=?, municipio=?, uf=? WHERE id_cliente=?";
    try (Connection conn = getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        // Definir os parâmetros da consulta
        stmt.setString(1, cliente.getNomeCliente());
        stmt.setString(2, cliente.getCpf());
        stmt.setString(3, cliente.getTelefone());
        stmt.setString(4, cliente.getCep());
        stmt.setString(5, cliente.getNrResidencia());
        stmt.setString(6, cliente.getBairro());
        stmt.setString(7, cliente.getMunicipio());
        stmt.setString(8, cliente.getUf());
        stmt.setInt(9, cliente.getIdCliente()); // Adicionar o ID do cliente para especificar qual registro atualizar

        int count = stmt.executeUpdate();
        return count > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    public static List<Cliente> selectClient(){
        final String sql = "select * from clientes";
        try (Connection conn = getConnection(); // conexao, que usamos em base
             PreparedStatement pstnt = conn.prepareStatement(sql); // pegao o objeto de conexao com o bd e dou um prepare statement
             ResultSet rs = pstnt.executeQuery(); // pego o statement que quero executar no banco e executo a query
        ) {
            List<Cliente> clientes = new ArrayList<>();
            while(rs.next()) {
                clientes.add(resultsetCliente(rs));
            }
            return clientes;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Cliente selectClientById(int idCliente){
        final String sql = "select * from clientes where id_cliente=?";
        try (Connection conn = getConnection(); // conexao, que usamos em base
             PreparedStatement pstnt = conn.prepareStatement(sql);) { // pegao o objeto de conexao com o bd e dou um prepare statement
            pstnt.setInt(1, idCliente);
            ResultSet rs = pstnt.executeQuery();
            Cliente cliente = null;
            if (rs.next()){
                cliente = resultsetCliente(rs);
            }
            rs.close();
            return cliente;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static List<Cliente> selectClientByNome(String nomeCliente){
        final String sql = "select * from clientes where nm_cliente like ? order by nm_cliente";
        try (Connection conn = getConnection(); // conexao, que usamos em base
             PreparedStatement pstnt = conn.prepareStatement(sql);) { // pegao o objeto de conexao com o bd e dou um prepare statement
            pstnt.setString(1, nomeCliente.toLowerCase()+"%");
            ResultSet rs = pstnt.executeQuery();
            List<Cliente> clientes = new ArrayList<>();
            while (rs.next()){
                clientes.add(resultsetCliente(rs));
            }
            return clientes;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }


}
