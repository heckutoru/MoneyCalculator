package moneycalculator;

import moneycalculator.control.CalculateCommnad;
import moneycalculator.persistence.CurrencyListLoader;
import moneycalculator.persistence.files.FileCurrencyListLoader;
import moneycalculator.persistence.rest.ResExchangeRateLoader;

/**
 *
 * @author Héctor Déniz Álvarez (Heckutoru)
 */
public class MoneyCalculator {

    public static void main(String[] args) {
        execute();
    }
    
    public static void execute(){
        CurrencyListLoader currencyLoader = new FileCurrencyListLoader("currencies");
        ResExchangeRateLoader exchangeRateLoader = new ResExchangeRateLoader();
        MainFrame mainFrame = new MainFrame(currencyLoader.currencies());
        mainFrame.add(new CalculateCommnad(mainFrame.getMoneyDialog(),mainFrame.getMoneyDisplay(),exchangeRateLoader));
    }
}
