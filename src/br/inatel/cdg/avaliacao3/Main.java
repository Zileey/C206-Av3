package br.inatel.cdg.avaliacao3;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Arquivo a = new Arquivo();
        int opcao;

        System.out.println("Digite a opção que deseja realizar:");
        System.out.println("1 - para fazer um novo pedido");
        System.out.println("2 - para mostrar informalções de um pedido existente");
        System.out.println("0 - para sair");
        System.out.println("--------------------------------------------------------");
        opcao = sc.nextInt();

        do{
            switch (opcao){
                case 1:
                {
                    Pedido p1 = new Pedido();
                    System.out.println("Digite o numero do pedido:");
                    p1.id = sc.nextInt();
                    System.out.println("Digite o tipo de madeira:");
                    p1.tipoMadeira = sc.next();
                    System.out.println("Digite o preço de produção da madeira:");
                    p1.precoProducao = sc.nextDouble();
                    System.out.println("Digite o preço de venda da madeira:");
                    p1.precoVenda = sc.nextDouble();

                    a.escrever(p1);

                    break;
                }

                case 2:
                {
                    ArrayList<Pedido> ped = a.ler();

                    for(int i = 0; i < ped.size(); i++){
                        System.out.println("Pedido n: " + ped.get(i).id);
                        System.out.println("Tipo de madeira: " + ped.get(i).tipoMadeira);
                        System.out.println("Preço de produção: " + ped.get(i).precoProducao);
                        System.out.println("Preço de venda: " + ped.get(i).precoVenda);
                    }
                    break;
                }
                case 0:
                {
                    System.out.println("Obrigado por usar nosso sistema!");
                    break;
                }
                default:
                    System.out.println("Opção inválida!");
        }while(opcao != 0);




        sc.close();
    }
}
