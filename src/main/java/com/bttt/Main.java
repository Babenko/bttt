package com.bttt;

import com.bttt.model.Mark;
import com.bttt.service.input.ConsoleInputMark;
import com.bttt.service.input.InputMark;

import java.util.stream.Stream;


/**
 * @author Sem Babenko.
 */
public class Main {


    public static void main(String[] args) {

        InputMark inputMark = new ConsoleInputMark();

        Mark mark = inputMark.next();
        Mark mark1 = inputMark.next();
        Mark mark2 = inputMark.next();
        Mark mark3 = inputMark.next();

        showField(7);
        drawField(8);
    }

    static void showField(int field) {
        Stream
                .iterate(31, i -> --i)
                .limit(32)
                .forEach(i -> System.out.print(i % 8 == 0 ? ((field & 1 << i) > 0 ? 1 : 0) + " " : (field & 1 << i) > 0 ? 1 : 0));

    }

    static void drawField(int field) {

        int position = 0;

        System.out.println("Current state of game board...");
        System.out.println("  1   2   3");
        for (int row = 0; row < 3; row++) {
            System.out.print(((char) (65 + row)) + " ");
            for(int column = 0; column < 3; column++) {
                char elem = '*';
                if(isPresentX(field, position)) {
                    elem = 'X';
                } else if (isPresentO(field, position)) {
                    elem = 'O';
                }
                System.out.print(elem);
                System.out.print(column < 2 ? " | " : "");
                position++;
            }
            System.out.println();
            System.out.println(row < 2 ? "  ----------" : "");
        }
    }

    static boolean isPresentX(int field, int position) {
        return (field & 1 << position) > 0;
    }

    static boolean isPresentO(int field, int position) {
        return (field & 1 << (31 - position)) > 0;
    }

}
