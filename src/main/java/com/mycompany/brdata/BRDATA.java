package com.mycompany.brdata;

import java.sql.SQLException;
import java.util.Scanner;

public class BRDATA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SQL query = new SQL(); // Fiz uma variável query da classe SQL visto que os comandos estão dentro dessa classe

        while (true) { // Fiz um menu em Switch Case para que o usuário faça as operações basicas do sistema (Insert, Update, Select, Delete);
            System.out.println("Menu:");
            System.out.println("1 - Cadastrar jogador");
            System.out.println("2 - Alterar jogador");
            System.out.println("3 - Consultar jogador");
            System.out.println("4 - Excluir jogador");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opcao: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    Jogador novoJogador = new Jogador();
                    
                    System.out.println("Digite o nome do jogador:");
                    novoJogador.setNome(scanner.nextLine());
                    
                    System.out.println("Digite o clube do jogador:");
                    novoJogador.setClube(scanner.nextLine());
                    
                    System.out.println("Digite a posicao do jogador:");
                    novoJogador.setPosicao(scanner.nextLine());
                    
                    System.out.println("Digite o numero de gols do jogador:");
                    novoJogador.setGols(scanner.nextInt());
                    
                    System.out.println("Digite o numero de assistencias do jogador:");
                    novoJogador.setAssistencias(scanner.nextInt());
                    
                    System.out.println("Digite o numero de cartoes amarelos do jogador:");
                    novoJogador.setCartoesAmarelos(scanner.nextInt());
                    
                    System.out.println("Digite o numero de cartoes vermelhos do jogador:");
                    novoJogador.setCartoesVermelhos(scanner.nextInt()); // Peguei todas as variáveis da tabela, EXCETO o ID que é auto_increment

                    try {
                        query.insert(novoJogador);  // executado o comando insert (Dentro da classe SQL)
                    } catch (SQLException e) {
                        System.out.println("Erro ao inserir jogador: " + e.getMessage());
                    }
                    break;
                }

                case 2 ->{ 
                    Jogador mudaJogador = new Jogador();
                    System.out.println ("Qual jogador voce deseja alterar?");
                    query.selectUpdate(); // executado um "mini" select que traz as informações de ID e Nome para o usuário selecionar QUAL dado ele quer alterar
                    System.out.println("Selecione pela sequencia: ");
                    mudaJogador.setId(scanner.nextInt()); // pego o ID para ser alterado pelo id (filtro no update)
                    scanner.nextLine(); // este scanner foi só para que consiga processar o nome do jogador após, visto que o scanner next int pula uma linha.
                    
                    System.out.println("Digite o nome do jogador:");
                    mudaJogador.setNome(scanner.nextLine());
                    
                    System.out.println("Digite o clube do jogador:");
                    mudaJogador.setClube(scanner.nextLine());
                    
                    System.out.println("Digite a posicao do jogador:");
                    mudaJogador.setPosicao(scanner.nextLine());
                    
                    System.out.println("Digite o numero de gols do jogador:");
                    mudaJogador.setGols(scanner.nextInt());
                    
                    System.out.println("Digite o numero de assistencias do jogador:");
                    mudaJogador.setAssistencias(scanner.nextInt());
                    
                    System.out.println("Digite o numero de cartoes amarelos do jogador:");
                    mudaJogador.setCartoesAmarelos(scanner.nextInt());
                    
                    System.out.println("Digite o numero de cartoes vermelhos do jogador:");
                    mudaJogador.setCartoesVermelhos(scanner.nextInt()); // Peguei todas as variáveis da tabela, EXCETO o ID que é auto_increment
                    
                    try {
                        query.update(mudaJogador); // executado o comando update do banco por essa função
                    } catch (SQLException e) {
                        System.out.println("Erro ao alterar jogador: " + e.getMessage());
                    }  
                    break;
                }
                case 3 ->{ 
                    query.select(); // Apenas um select * /sem filtro.
                }
                case 4 -> {
                    Jogador excluiJogador = new Jogador();
                    System.out.println("Qual jogador voce deseja excluir?");
                    query.selectUpdate(); // colocado o mesmo "mini" select do update para que o usuário consiga verificar 
                    System.out.println("Selecione pela sequencia: ");
                    excluiJogador.setId(scanner.nextInt()); // pego o ID para que seja deletado pelo ID filtrado.
                    query.delete(excluiJogador); // executado o comando de DELETE.

                }

                case 5 -> {
                    System.out.println("Saindo do programa...");
                    scanner.close();
                    return; // Caso a opção do menu seja 5 o programa finaliza.
                }

                default -> System.out.println("Opcao invalida. Tente novamente."); // tentando outra opção o programa retorna com esse texto, que retorna ao menu
            }
        }
    }

    
     

    
    
}

    
   


    