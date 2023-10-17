package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BishopBlackTest {

    @Test
    void whenCreateBishopBlackThenPositionIsSet() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Cell position = bishopBlack.position();
        assertEquals(Cell.C8, position);
    }

    @Test
    void whenCopyBishopBlackThenNewPositionIsSet() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        BishopBlack newBishopBlack = (BishopBlack) bishopBlack.copy(Cell.E6);
        Cell newPosition = newBishopBlack.position();
        assertEquals(Cell.E6, newPosition);
    }

    @Test
    void whenWayBishopIsDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] way = bishopBlack.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertArrayEquals(expected, way);
    }

    @Test
    void whenWayBishopIsNotDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> bishopBlack.way(Cell.E2)
        );
        String expected = "Could not way by diagonal from C1 to E2";
        assertThat(exception.getMessage()).isEqualTo(expected);
    }
}