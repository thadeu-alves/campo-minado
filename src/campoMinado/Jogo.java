package campoMinado;

import java.util.Scanner;

public class Jogo {
    private Ranking ranking;
    private Tabuleiro board;
    boolean terminar = false;
    boolean ganhou = false;
    int[] jogada;
    int rodada=0;
    private Scanner read = new Scanner(System.in);
    private String playerName;
    
    public Jogo(){
        this.board = new Tabuleiro();
        this.jogada = new int[2];
        this.ranking = new Ranking();
        Menu();
    }

    public void Menu(){
        System.out.print("Digite seu nome: ");
        playerName = read.nextLine();

        int op;
        do{
            System.out.println("Escolha uma opção: ");
            System.out.println("[1] - Iniciar Jogo");
            System.out.println("[2] - Consultar Ranking");
            System.out.println("[0] - Sair");
            op = read.nextInt();

            switch(op){
                case 1: Jogar(board); break;
                case 2: ranking.printRanking(); break;
                case 0: System.out.println("Encerrando o jogo"); break;
                default: System.out.println("Opção inválida");
            }
        }while(op != 0);
    }
    
    public void Jogar(Tabuleiro board){
        do{
            rodada++;
            System.out.println("Rodada "+rodada);
            board.exibe();
            terminar = board.setPosicao();
            
            if(!terminar){
                board.abrirVizinhas();
                terminar = board.ganhou();
            }
            
        }while(!terminar);
        
        if(!board.ganhou()){
            System.out.println("Havia uma mina ! Você perdeu, " + playerName + "!");
            board.exibeMinas();
        } else {
            System.out.println("Parabéns, você deixou os 8 campos de minas livres em "+rodada+" rodadas");
            board.exibeMinas();
            ranking.addScore(playerName, rodada);
        }
    }
}