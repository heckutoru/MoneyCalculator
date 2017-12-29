package moneycalculator.control;

/**
 *
 * @author Héctor Déniz Álvarez (Heckutoru)
 */
public interface Command {
    String name();
    void execute();
}
