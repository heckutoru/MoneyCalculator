package moneycalculator.persistence;

import moneycalculator.model.Currency;

/**
 *
 * @author Héctor Déniz Álvarez (Heckutoru)
 */
public interface CurrencyListLoader {
    
    Currency[] currencies();
}
