package com.bttt.service.input;

import com.bttt.config.Constant;
import com.bttt.model.Mark;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author Sem Babenko.
 */
public class ConsoleInputMark implements InputMark {

    private static final Integer SYMBOL_INDEX = 0;
    private static final Integer LOCATION_INDEX = 1;

    private Scanner scanner = new Scanner(System.in);

    @Override
    public Mark next() {
        String line = scanner.nextLine();
        String[] parts = line.split("\\s");
        validateInput(parts);
        return new Mark(Mark.Symbol.getEnum(parts[SYMBOL_INDEX]), Constant.getLocation(parts[LOCATION_INDEX]));
    }

    @Override
    public boolean hasNext() {
        return scanner.hasNext();
    }

    @Override
    public void close() throws IOException {
        scanner.close();
    }


    private void validateInput(String[] args) {
        if(args.length != 2) {
            throw new IllegalArgumentException("Missed all or all of arguments - location and(or) symbol");
        }
        Objects.requireNonNull(args[SYMBOL_INDEX]);
        Objects.requireNonNull(args[LOCATION_INDEX]);
        if(args[SYMBOL_INDEX].length() > 1) {

            throw new IllegalArgumentException("Symbol should be x or o");
        }
        Mark.Symbol.getEnum(args[SYMBOL_INDEX]);
        if(args[LOCATION_INDEX].length() != 2) {
            throw new IllegalArgumentException("Location has wrong value");
        }
    }
}
