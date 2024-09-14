package controller;

import dao.ClienteDAO;
import dao.PetDAO;
import model.Pet;
import model.Cliente;

import java.util.Scanner;
import java.util.*;

public class PetController {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int option = 0;

        do {
            System.out.println("\n -*-*- Menu do Pet -*-*-");
            System.out.println("\n Digite um numero inteiro para selecionar um opção :) ");
            System.out.println(
                    "\n 1- Inserir novo pet"+
                    "\n 2- Alterar um pet"+
                    "\n 3- Listar os pets" +
                    "\n 4- Buscar um pet pelo id" +
                    "\n 5- Buscar pet pelo nome"+
                    "\n 0- Sair");
            option = input.nextInt();
            input.nextLine();

            switch (option) {
                case 1:
                    inserir();
                    break;
                case 2:
                    alterar();
                    break;
                case 3:
                    selectPets();
                    break;
                case 4:
                    selectPetsById();
                    break;
                case 5:
                    selectPetsByName();
                    break;
                default:
                    if (option!=0){
                        System.out.println("\n Opção invalida :(");
                    }
            }
        }while (option!=0);
    }


    private static void inserir() {
    Pet pet = new Pet();
    System.out.println("\n -*-*- Cadastrar um novo Pet -*-*-");

    System.out.println("\nDigite o nome do Pet:");
    pet.setNamePet(input.nextLine());

    System.out.println("\nDigite a espécie do Pet:");
    pet.setTipoPet(input.nextLine());

    System.out.println("\nDigite o sexo do Pet: (F ou M) ");
    pet.setSexoPet(input.nextLine());

    System.out.println("\nDigite a raça do Pet:");
    pet.setRacaPet(input.nextLine());

    System.out.println("\nDigite a cor do Pet:");
    pet.setCorPet(input.nextLine());

    // Solicitar o ID do cliente
    System.out.println("\nDigite o ID do cliente (dono do Pet):");
    int idCliente = input.nextInt();
    input.nextLine(); // Consumir a nova linha restante

    // Definir o cliente no objeto Pet
    Cliente cliente = new Cliente();
    cliente.setIdCliente(idCliente);
    pet.setCliente(cliente);

    // Inserir o Pet no banco de dados
    if (PetDAO.insertPet(pet)) {
        System.out.println("\nPet cadastrado com sucesso! :)");
    } else {
        System.out.println("\nOps, algo deu errado! :( \nProcure o suporte!");
    }
}

    private static void alterar() {
        System.out.println("\n -*-*- Alterar um Pet: -*-*- ");
        Pet pet = null;

        while (true) {
            System.out.println("\n Digite o id do Pet que deseja alterar (ou 0 para voltar ao menu): ");
            int id = input.nextInt();
            input.nextLine(); // Limpar o  scanner

            // Se o usuário digitar 0, sai do loop e retorna ao menu
            if (id == 0) {
                break;
            }

            pet = PetDAO.selectPetById(id);
            if (pet == null) {
                System.out.println("\n Ops, id inválido! :( ");
                continue; // Solicita um novo ID se o anterior for inválido
            }

            // Permite alterar os dados do pet
            System.out.println("\n Nome do Pet: " + pet.getNamePet());
            System.out.println("\n Deseja alterar? \n0- Sim \n1 - Não");
            if (input.nextInt() == 0) {
                input.nextLine();
                System.out.println("\n Digite o novo nome do pet: ");
                pet.setNamePet(input.nextLine());
            }

            System.out.println("\n Espécie do pet: " + pet.getTipoPet());
            System.out.println("\n Deseja alterar? \n0- Sim \n1 - Não");
            if (input.nextInt() == 0) {
                input.nextLine();
                System.out.println("\n Digite o tipo correto do pet: ");
                pet.setTipoPet(input.nextLine());
            }

            System.out.println("\n Sexo do pet (F ou M): " + pet.getSexoPet());
            System.out.println("\n Deseja alterar? \n0- Sim \n1 - Não");
            if (input.nextInt() == 0) {
                input.nextLine();
                System.out.println("\n Digite o sexo correto do pet: ");
                pet.setSexoPet(input.nextLine());
            }

            System.out.println("\n Raça do pet: " + pet.getRacaPet());
            System.out.println("\n Deseja alterar? \n0- Sim \n1 - Não");
            if (input.nextInt() == 0) {
                input.nextLine();
                System.out.println("\n Digite a raça correta do pet: ");
                pet.setRacaPet(input.nextLine());
            }

            System.out.println("\n Cor do pet: " + pet.getCorPet());
            System.out.println("\n Deseja alterar? \n0- Sim \n1 - Não");
            if (input.nextInt() == 0) {
                input.nextLine();
                System.out.println("\n Digite a cor do pet: ");
                pet.setCorPet(input.nextLine());
            }

            System.out.println("\n Id do cliente: " + pet.getCliente().getIdCliente());
            System.out.println("\n Deseja alterar o ID do cliente? \n0- Sim \n1 - Não");
            if (input.nextInt() == 0) {
                input.nextLine();
                System.out.println("\n Digite o novo ID do cliente: ");
                int idCliente = input.nextInt();
                input.nextLine(); // Consumir a nova linha pendente
                Cliente cliente = new Cliente();
                cliente.setIdCliente(idCliente);
                pet.setCliente(cliente);
            }

            // Atualiza o pet no banco de dados
            if (PetDAO.alteraPet(pet)) {
                System.out.println("\n Pet alterado com sucesso! :) ");
            } else {
                System.out.println("\n Algo deu errado! :( ");
            }

            // Sai do loop após a alteração ser concluída
            break;
        }
    }


    private static void selectPets(){
        System.out.println("\n Lista com os pets cadastrados: " + PetDAO.selectPets());
    }

    private static void selectPetsById(){
        System.out.println("\n Digite o id do pet: ");
        Pet pet = PetDAO.selectPetById(input.nextInt());
        input.nextLine();
        if (pet!=null){
            System.out.println(pet);
        } else {
            System.out.println("\n Id não foi localizado");
        }
    }

    private static void selectPetsByName(){
        System.out.println("\n Digite o nome do pet: ");
        String nome = input.next();
        System.out.println("\nChave de pesquisa: " + nome);
        List <Pet> pets = PetDAO.selectPetByNome(nome);
        if (pets.isEmpty()){
            System.out.println("\nNão existe nenhum pet com o nome " + nome);
        } else {
            System.out.println(pets);
        }
    }

}
