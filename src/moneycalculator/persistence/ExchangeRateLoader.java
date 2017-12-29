package moneycalculator.persistence;

import moneycalculator.model.Currency;
import moneycalculator.model.ExchangeRate;

/**
 *
 * @author Héctor Déniz Álvarez (Heckutoru)
 */
public interface ExchangeRateLoader {
    
    ExchangeRate load(Currency from,Currency to);
    
}
