# Campo Minado - Java

> Um jogo de Campo Minado em Java onde o jogador explora o tabuleiro com atenção, buscando evitar minas ocultas e vencendo ao revelar todas as casas seguras.

## 💻 Pré-requisitos

Antes de começar, verifique se você atendeu aos seguintes requisitos:

- Você instalou a versão mais recente do `Java`
- Você tem uma máquina `Windows, Linux ou Mac`.
- Você tem uma `IDE`.

## ☕ Overview

Estrutura:

```
.
├── src
│ └── campoMinado
│   ├── campoMinado.java //Classe com método main
│   ├── Jogo.java //Classe principal
│   ├── Ranking.java //Lida com ranking
│   ├── File.java //Lida com leitura e escrita de arquivos
│   ├── IFile.java
│   └── IRanking.java
│
├── data
│ └── ranking.txt //Guarda o ranking
│
└── README.md
```

Para entendermos o código, começamos aqui:

```java
/* campoMinado.java */

public static void main(String[] args) {
    Jogo jogo = new Jogo();
}
```

```java
/* Jogo.java */

public Jogo(){
    this.board = new Tabuleiro();
    this.jogada = new int[2];
    this.ranking = new Ranking();
    Menu();
}
```

No menu:

```java
/* Jogo.java */

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
```

Consultando o ranking:

```java
/* Ranking.java */

public void printRanking() {
    getScores(); //Faz a leitura do arquivo junto a classe File

    people.entrySet().stream() //Iteração sobre os jogadores
            .sorted(Map.Entry.comparingByValue())
            .forEach(person -> {
                System.out.println(
                        person.getKey() +
                                " ganhou em " + person.getValue() + " rodadas"
                );
            });
}
```

Iniciando o jogo:

```java
/* Jogo.java */

public void Jogar(Tabuleiro board){
    do{
        rodada++;
        System.out.println("Rodada "+rodada);
        board.exibe(); //Mostra o Tabuleiro
        terminar = board.setPosicao(); //Recebe a jogada do jogador

        if(!terminar){
            board.abrirVizinhas();
            terminar = board.ganhou();
        }
    }while(!terminar);
}
```

Recebendo a jogada e decidindo o resultado:

```java
/* Tabuleiro.java */
public boolean setPosicao(){
    do{
        System.out.print("\nLinha: ");
        linha = entrada.nextInt();
        System.out.print("Coluna: ");
        coluna = entrada.nextInt();

        if( (tabuleiro[linha][coluna] != '□') && ((linha < 9 && linha > 0) && (coluna < 9 && coluna > 0)))
            System.out.println("Esse campo já está sendo exibido");

        if( linha < 1 || linha > 8 || coluna < 1 || coluna > 8)
            System.out.println("Escolha números de 1 até 8");
    }while(tabuleiro[linha][coluna] != '□');

    if(getPosicao(linha, coluna)== -1) //Decide se a posição tem uma mina
        return true;
    else
        return false;

    }
```

Lidando com o resultado:

```java
/* Jogo.java */
if(!board.ganhou()){ //Quando perde
    System.out.println("Havia uma mina ! Você perdeu, " + playerName + "!");
    board.exibeMinas();
} else { //Quando ganha
    System.out.println("Parabéns, você deixou os 8 campos de minas livres em "+rodada+" rodadas");
    board.exibeMinas();
    ranking.addScore(playerName, rodada); //Salva no ranking
}
```

## 🤝 Colaboradores

Agradecemos às seguintes pessoas que contribuíram para este projeto:

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/brendomatias" title="link para o github de Brendon">
        <img src="https://avatars.githubusercontent.com/u/190748345?v=4" width="100px;" alt="Foto do Brendon Sobral no GitHub"/><br>
        <sub>
          <b>Brendon Sobral</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/GustavoBC2024" title="link para o github de Gustavo">
        <img src="https://avatars.githubusercontent.com/u/165310081?v=4" width="100px;" alt="Foto do Gustavo Benjamin no GitHub"/><br>
        <sub>
          <b>Gustavo Benjamin</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/thadeu-alves" title="link para o github de Thadeu">
        <img src="https://avatars.githubusercontent.com/u/78249846?v=4" width="100px;" alt="Foto do Thadeu Alves no GitHub"/><br>
        <sub>
          <b>Thadeu Alves</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="#" title="defina o título do link">
        <img src="https://miro.medium.com/max/360/0*1SkS3mSorArvY9kS.jpg" width="100px;" alt="Foto do Steve Jobs"/><br>
        <sub>
          <b>Steve Jobs</b>
        </sub>
      </a>
    </td>
  </tr>
</table>
