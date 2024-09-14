package controller;

import java.util.Scanner;

public class MainController {
    private static final Scanner input = new Scanner(System.in); //ler teclado

    public static void main(String[] args) {
        int option = 0;

        do {
            System.out.println("\n -*-*-*- Bem vindo a Doguito Petshop -*-*-*-");
            System.out.println("\n -*-*- Main Menu -*-*-");
            System.out.println("\n Digite um numero inteiro para selecionar um opção :) ");
            System.out.println("" +
                    "\n 1 - Manter Pet" +
                    "\n 2 - Manter Cliente" +
                    "\n 0 - Sair");
            option = input.nextInt();
            input.nextLine();
            switch (option) {
                case 1:
                    PetController.main(null);
                    break;
                case 2:
                    ClienteController.main(null);
                default:
                    if (option!=0) {
                        System.out.println("\n Opção invalida :( ");
                    }
            }
        }while(option!=0);

        System.out.println("\n -*-*- Fim! -*-*-");
        input.close(); //liberar
    }
}
