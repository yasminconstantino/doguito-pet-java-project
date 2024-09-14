package controller;

import dao.ClienteDAO;
import model.Cliente;

import java.util.List;
import java.util.Scanner;

public class ClienteController {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int option = 0;

        do {
            System.out.println("\n -*-*- Menu do Tutor -*-*-");
            System.out.println("\n Digite um numero inteiro para selecionar um opção :) ");
            System.out.println(
                    "\n 1- Inserir novo Tutor"+
                            "\n 2- Alterar um Tutor"+
                            "\n 3- Listar os Tutores" +
                            "\n 4- Buscar um tutor pelo id" +
                            "\n 5- Buscar tutor pelo nome"+
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
                    selectCliente();
                    break;
                case 4:
                    selectClienteById();
                    break;
                case 5:
                    selectClienteByName();
                    break;
                default:
                    if (option!=0){
                        System.out.println("\n Opção invalida :(");
                    }
            }
        }while (option!=0);
    }
    private static void inserir(){
        Cliente client = new Cliente();
        System.out.println("\n -*-*- Cadastrar um novo Tutor -*-*-");
        System.out.println("\n Digite o nome do Tutor");
        client.setNomeCliente(input.nextLine());
        System.out.println("\n Digite o CPF do Tutor");
        client.setCpf(input.nextLine());
        System.out.println("\n Digite o telefone do Tutor");
        client.setTelefone(input.nextLine());
        System.out.println("\n Digite o cep do Tutor");
        client.setCep(input.nextLine());
        System.out.println("\n Digite o numero da residencia do Tutor");
        client.setNrResidencia(input.nextLine());
        System.out.println("\n Digite o bairro do Tutor");
        client.setBairro(input.nextLine());
        System.out.println("\n Digite a cidade do Tutor");
        client.setMunicipio(input.nextLine());
        System.out.println("\n Digite o estado do Tutor");
        client.setUf(input.nextLine());

        if (ClienteDAO.isertCliente(client)){
            System.out.println("\n Cliente cadastrado com sucesso! :) ");
        } else {
            System.out.println("\n Ops, algo deu errado! :( \n Procure o suporte! ");
        }
    }

    private static void alterar() {
        System.out.println("\n -*-*- Alterar um Cliente: -*-*- ");
        Cliente client = null;

        // Loop para tentar encontrar e alterar o cliente
        while (true) {
            System.out.println("\n Digite o id do cliente que deseja alterar (ou 0 para voltar ao menu):");
            int id = input.nextInt();
            input.nextLine(); // Limpar o scanner

            // Se o usuário digitar 0, sai do loop e retorna ao menu
            if (id == 0) {
                break;
            }

            client = ClienteDAO.selectClientById(id);
            if (client == null) {
                System.out.println("\n Ops, id inválido! :( ");
                continue; // Solicita um novo ID se o anterior for inválido
            }

            // Se o cliente for encontrado, permite alterar os dados
            System.out.println("\n Nome: " + client.getNomeCliente());
            System.out.println("\n Deseja alterar? \n0- Sim \n1 - Não");
            if (input.nextInt() == 0) {
                input.nextLine();
                System.out.println("\n Digite o novo nome do Tutor:");
                client.setNomeCliente(input.nextLine());
            }

            System.out.println("\n CPF: " + client.getCpf());
            System.out.println("\n Deseja alterar? \n0- Sim \n1 - Não");
            if (input.nextInt() == 0) {
                input.nextLine();
                System.out.println("\n Digite o novo CPF do Tutor:");
                client.setCpf(input.nextLine());
            }

            System.out.println("\n Telefone: " + client.getTelefone());
            System.out.println("\n Deseja alterar? \n0- Sim \n1 - Não");
            if (input.nextInt() == 0) {
                input.nextLine();
                System.out.println("\n Digite o novo telefone do Tutor:");
                client.setTelefone(input.nextLine());
            }

            System.out.println("\n CEP do Tutor: " + client.getCep());
            System.out.println("\n Deseja alterar? \n0- Sim \n1 - Não");
            if (input.nextInt() == 0) {
                input.nextLine();
                System.out.println("\n Digite o novo CEP do Tutor:");
                client.setCep(input.nextLine());
            }

            System.out.println("\n Número da residência: " + client.getNrResidencia());
            System.out.println("\n Deseja alterar? \n0- Sim \n1 - Não");
            if (input.nextInt() == 0) {
                input.nextLine();
                System.out.println("\n Digite o novo número de residência do Tutor:");
                client.setNrResidencia(input.nextLine());
            }

            System.out.println("\n Bairro: " + client.getBairro());
            System.out.println("\n Deseja alterar? \n0- Sim \n1 - Não");
            if (input.nextInt() == 0) {
                input.nextLine();
                System.out.println("\n Digite o novo bairro do Tutor:");
                client.setBairro(input.nextLine());
            }

            System.out.println("\n Município: " + client.getMunicipio());
            System.out.println("\n Deseja alterar? \n0- Sim \n1 - Não");
            if (input.nextInt() == 0) {
                input.nextLine();
                System.out.println("\n Digite o novo município do Tutor:");
                client.setMunicipio(input.nextLine());
            }

            System.out.println("\n UF: " + client.getUf());
            System.out.println("\n Deseja alterar? \n0- Sim \n1 - Não");
            if (input.nextInt() == 0) {
                input.nextLine();
                System.out.println("\n Digite a nova UF do Tutor:");
                client.setUf(input.nextLine());
            }

            // Atualiza o cliente no banco de dados
            if (ClienteDAO.alterarCliente(client)) {
                System.out.println("\n Cliente alterado com sucesso! :) ");
            } else {
                System.out.println("\n Algo deu errado! :( ");
            }

            // Sai do loop após a alteração ser concluída
            break;
        }
    }

    private static void selectCliente(){
        System.out.println("\n -*-*- Lista dos clientes cadastrados --*-*\n"+ ClienteDAO.selectClient());
    }

    private static void selectClienteById(){
        System.out.println("\n Digite o id do cliente ");
        Cliente client = ClienteDAO.selectClientById(input.nextInt());
        input.nextLine();
        if (client != null){
            System.out.println(client);
        } else {
            System.out.println("\n Ops! Id não localizado :( ");
        }
    }


    private static void selectClienteByName(){
        System.out.println("\n Digite o nome do cliente ");
        String nome = input.next();
        System.out.println("\n Chave para pesquisa: " + nome);
        List<Cliente> clientes = ClienteDAO.selectClientByNome(nome);
        if (clientes.isEmpty()){
            System.out.println("\n Não existe clientes com esse nome: " + nome);
        } else {
            System.out.println(clientes);
        }
    }
}
