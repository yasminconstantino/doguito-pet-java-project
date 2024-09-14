package dao;

import model.Pet;
import model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetDAO extends BaseDAO{

    private static Pet resultsetPet(ResultSet rs) throws SQLException {
        Pet pet = new Pet();
        pet.setIdPet(rs.getInt("id_pets"));
        pet.setNamePet(rs.getString("nm_pet"));
        pet.setTipoPet(rs.getString("tipo"));
        pet.setSexoPet(rs.getString("sexo"));
        pet.setRacaPet(rs.getString("raca"));
        pet.setCorPet(rs.getString("cor"));

        Cliente cliente = new Cliente();
        cliente.setIdCliente(rs.getInt("id_cliente"));
        pet.setCliente(cliente);

        return pet;
    }


    public static boolean insertPet(Pet pet) {
        final String sql = "INSERT INTO pets (nm_pet, tipo, sexo, raca, cor, id_cliente) VALUES (?, ?, ?, ?, ?, ?)";
        try (
                Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, pet.getNamePet());
            stmt.setString(2, pet.getTipoPet());
            stmt.setString(3, pet.getSexoPet());
            stmt.setString(4, pet.getRacaPet());
            stmt.setString(5, pet.getCorPet());  // Corrigido para o índice 5
            stmt.setInt(6, pet.getCliente().getIdCliente());  // Corrigido para o índice 6

            int count = stmt.executeUpdate();
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean alteraPet(Pet pet) {
        final String sql = "UPDATE pets SET nm_pet=?, tipo=?, sexo=?, raca=?, cor=?, id_cliente=? WHERE id_pets=?";
        try (
                Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, pet.getNamePet());
            stmt.setString(2, pet.getTipoPet());
            stmt.setString(3, pet.getSexoPet());
            stmt.setString(4, pet.getRacaPet());
            stmt.setString(5, pet.getCorPet());
            stmt.setInt(6, pet.getCliente().getIdCliente());
            stmt.setInt(7, pet.getIdPet());  // Adicionando a condição WHERE para o ID do pet

            int count = stmt.executeUpdate();
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



    public static List<Pet> selectPets(){
        final String sql = "SELECT * FROM pets";
        try (Connection conn = getConnection(); // conexao, que usamos em base
             PreparedStatement pstnt = conn.prepareStatement(sql); // pegao o objeto de conexao com o bd e dou um prepare statement
             ResultSet rs = pstnt.executeQuery(); // pego o statement que quero executar no banco e executo a query
        ) {
            List<Pet> pets = new ArrayList<>();
            while (rs.next()){
                pets.add(resultsetPet(rs));
            }
            return pets;
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Pet selectPetById(int idPet){
            final String sql = "select * from pets where id_pets=?";
            try (
                    Connection conn = getConnection();
                    PreparedStatement pstnt = conn.prepareStatement(sql);) {
                pstnt.setInt(1,idPet);
                ResultSet rs = pstnt.executeQuery();
                Pet pet = null;
                if (rs.next()){
                    pet=resultsetPet(rs);
                }
                rs.close();
                return pet;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }

        public static List<Pet> selectPetByNome(String nome){
            final String sql = "select * from pets where nm_pet like ? order by nm_pet";
            try (Connection conn = getConnection(); // conexao, que usamos em base
                 PreparedStatement pstnt = conn.prepareStatement(sql);) { // pegao o objeto de conexao com o bd e dou um prepare statement
                pstnt.setString(1, nome.toLowerCase()+"%");
                ResultSet rs = pstnt.executeQuery();
                List<Pet> pets = new ArrayList<>();
                while (rs.next()){
                    pets.add(resultsetPet(rs));
                }
                return pets;
            }catch (SQLException e){
                e.printStackTrace();
                return null;
            }
        }
}
