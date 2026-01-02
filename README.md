# sudoku-java

Jogo de Sudoku em Java

## Descrição

Este projeto é um jogo de Sudoku desenvolvido em Java, com interface gráfica utilizando JavaFX. O usuário pode jogar partidas em diferentes níveis de dificuldade, desfazer jogadas, resetar a partida e gerar novos desafios. Além disso, há um modo de design para criar e salvar novos tabuleiros personalizados.

## Funcionalidades

- Seleção de níveis de dificuldade (fácil, médio, difícil)
- Geração de novas partidas com tabuleiros aleatórios
- Desfazer o último palpite
- Resetar a partida (remover todos os palpites)
- Interface gráfica intuitiva com JavaFX
- **Modo Design**: Permite ao usuário criar um novo tabuleiro do zero, informando os valores iniciais e suas posições. O usuário pode escolher a dificuldade, que define a quantidade mínima de valores preenchidos. Ao finalizar, é possível salvar o tabuleiro criado em um arquivo JSON.

## Como funciona

Os valores iniciais do tabuleiro são carregados a partir de um arquivo JSON, que contém uma lista de objetos "partida". Cada objeto possui:
- `dificuldade`: string indicando o nível (ex: "fácil", "médio", "difícil")
- `tabuleiro`: matriz 9x9 de inteiros, onde casas vazias são representadas por zero

No modo design, todos os campos do tabuleiro são zerados e o usuário pode preencher os valores iniciais conforme a dificuldade selecionada (por padrão, dificuldade média). Após finalizar, basta clicar em salvar para gravar o novo tabuleiro no JSON.

## Requisitos

- Java 11 ou superior
- JavaFX
- (Opcional) IDE como IntelliJ IDEA ou Eclipse

## Como executar

1. Clone este repositório:
   ```bash
   git clone https://github.com/laisbastosbg/sudoku-java.git
   ```
2. Importe o projeto na sua IDE ou compile via terminal.
3. Certifique-se de que o JavaFX está configurado corretamente.
4. Execute a classe principal do projeto.

## Estrutura do Projeto

```md
sudoku-java/
├── .gitignore
├── pom.xml
├── README.md
└── src/
    ├── main/
    │   ├── java/
    │   │   └── com/lais/sudoku/
    │   │       ├── MainApplication.java
    │   │       │
    │   │       ├── model/             # Lógica de negócio e regras do jogo
    │   │       │   ├── Tabuleiro.java
    │   │       │   ├── Dificuldade.java   (Enum para fácil, médio, difícil)
    │   │       │   └── ResolvedorSudoku.java
    │   │       │
    │   │       ├── ui/                  # Classes relacionadas à interface (View e Controller)
    │   │       │   ├── GameController.java
    │   │       │   └── DesignController.java
    │   │       │
    │   │       └── persistence/       # Classes para leitura e escrita de dados
    │   │           ├── GerenciadorDePartidas.java
    │   │           └── PartidaDTO.java     # Classe para mapear o objeto JSON
    │   │
    │   └── resources/
    │       ├── com/lais/sudoku/ui/
    │       │   ├── game-view.fxml
    │       │   └── design-view.fxml
    │       │
    │       └── data/
    │           └── partidas.json      # O arquivo JSON com os tabuleiros
    │
    └── test/
        ├── java/
        │   └── com/lais/sudoku/
        │       ├── model/
        │       │   └── TabuleiroTest.java
        │       └── persistence/
        │           └── GerenciadorDePartidasTest.java
        │
        └── resources/
            └── data/
                └── partidas_teste.json # Um JSON específico para os testes
```

## Licença

Este projeto está licenciado sob a licença MIT.