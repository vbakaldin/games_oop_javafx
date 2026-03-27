package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BishopBlackTest {

    @Test
    void whenPosition() {
        Cell cell = Cell.C8;
        BishopBlack bishopBlack = new BishopBlack(cell);
        assertEquals(cell, bishopBlack.position());
    }

    @Test
    void whenCopy() {
        Cell cell = Cell.C8;
        BishopBlack bishopBlack = new BishopBlack(cell);
        Cell newCell = Cell.B7;
        assertEquals(newCell, bishopBlack.copy(newCell).position());
    }

    @Test
    void whenWayG5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = bishopBlack.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(result).containsExactly(expected);
    }

    @Test
    void whenWayA3() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        Cell[] result = bishopBlack.way(Cell.A3);
        Cell[] expected = {Cell.E7, Cell.D6, Cell.C5, Cell.B4, Cell.A3};
        assertThat(result).containsExactly(expected);
    }

    @Test
    void wayWayException() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        Cell newCell = Cell.A4;
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    Cell[] result = bishopBlack.way(newCell);;
                });
        assertThat(exception.getMessage()).isEqualTo(String.format("Could not move by diagonal from %s to %s", bishopBlack.position(), newCell));
    }
}