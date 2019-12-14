package com.simple.test;

import org.junit.jupiter.api.Test;

public class DiamondWriterTest {

/*  Inheritance "diamond" diagram

  Poet         Writer
    \            /
     Multitalented

*/

    public interface Poet {
        default void write() {
            System.out.println("Poet's default method");
        }
    }

    public interface Writer {
        default void write() {
            System.out.println("Writer's default method");
        }
    }

    public class Multitalented implements Poet, Writer {
        @Override // without override write() - compile time error: class Multitalented inherits unrelated defaults for write() from types Poet and Writer
        public void write() {
            System.out.println("Writing stories and poems");
        }
    }

    @Test
    public void testMultitalented() {
        Multitalented john = new Multitalented();
        john.write();
    }

}
