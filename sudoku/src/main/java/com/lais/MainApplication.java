package com.lais;

import java.util.Scanner;

import java.util.stream.Stream;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lais.model.Board;
import com.lais.model.Space;

public class MainApplication {

    private final static Scanner scanner = new Scanner(System.in);

    private static Board board;

    private final static int BOARD_LIMIT = 9;

    public static void main(String[] args) {
        final var positions = Stream.of(args)
            .collect(toMap(
                k -> k.split(";")[0],
                v -> v.split(";")[1]
            ));

        var option = -1;

        while(true) {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Iniciar novo jogo");
            System.out.println("2 - Colocar novo número");
            System.out.println("3 - Remover número");
            System.out.println("4 - Visualizar jogo atual");
            System.out.println("5 - Verificar status do jogo");
            System.out.println("6 - Limpar jogo");
            System.out.println("7 - Finalizar jogo");
            System.out.println("8 - Sair");


            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1 -> startGame(positions);
                case 2 -> inputNumber();
                case 3 -> removeNumber();
                case 4 -> showCurrentGame();
                case 5 -> showGameStatus();
                case 6 -> clearGame();
                case 7 -> finishGame();
                case 8 -> System.exit(0);
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void startGame(Map<String,String> positions) {
        if (nonNull(board)) {
            System.out.println("Jogo já iniciado.");
            return;
        }

        List<List<Space>> spaces = new ArrayList<>();

        for (int i = 0; i < BOARD_LIMIT; i++) {
            spaces.add(new ArrayList<>());
            for (int j = 0; j < BOARD_LIMIT; j++) {
                var positionConfig = positions.get("%s,%s".formatted(i, j));
                var expected = Integer.parseInt(positionConfig.split("'")[0]);
                var fixed = Boolean.parseBoolean(positionConfig.split("'")[1]);
                var currentSpace = new Space(expected, fixed);
                spaces.get(i).add(currentSpace);
            }
        }

        board = new Board(spaces);
        System.out.println("Jogo pronto para começar :)");
    }

    private static void inputNumber() {
        if (isNull(board)) {
            System.out.println("Jogo ainda não iniciado.");
            return;
        }

        System.out.println("Informe a coluna (0-8):");
        var col = runUntilNumberIsValid(0, 8);
        System.out.println("Informe a linha (0-8):");
        var row = runUntilNumberIsValid(0, 8);
        System.out.println("Informe o número (1-9):");
        var value = runUntilNumberIsValid(1, 9);

        if (!board.changeValue(col, row, value)) {
            System.out.println("Não foi possível alterar o valor. Espaço fixo.");
            return;
        } else {
            System.out.println("Valor alterado com sucesso.");
        }
    }

    private static void removeNumber() {
        if (isNull(board)) {
            System.out.println("Jogo ainda não iniciado.");
            return;
        }

        System.out.println("Informe a coluna (0-8):");
        var col = runUntilNumberIsValid(0, 8);
        System.out.println("Informe a linha (0-8):");
        var row = runUntilNumberIsValid(0, 8);
        if (!board.clearValue(col, row)) {
            System.out.println("Não foi possível limpar o valor. Espaço fixo.");
            return;
        } else {
            System.out.println("Valor limpo com sucesso.");
        }
    }

    private static void showCurrentGame() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showCurrentGame'");
    }

    private static void showGameStatus() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showGameStatus'");
    }

    private static void clearGame() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clearGame'");
    }

    private static void finishGame() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'finishGame'");
    }

    private static int runUntilNumberIsValid(final int min, final int max) {
        var current = scanner.nextInt();

        while (current < min || current > max) {
            System.out.printf("Número inválido. Informe um valor entre %s e %s: ", min, max);
            current = scanner.nextInt();
        }

        return current;
    }
}