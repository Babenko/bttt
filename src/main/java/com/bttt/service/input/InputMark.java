package com.bttt.service.input;

import com.bttt.model.Mark;

import java.io.Closeable;

/**
 * @author Sem Babenko.
 */
public interface InputMark extends AutoCloseable {

    Mark next();

    boolean hasNext();
}
