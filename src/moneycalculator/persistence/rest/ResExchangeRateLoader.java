package moneycalculator.persistence.rest;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import moneycalculator.model.Currency;
import moneycalculator.model.ExchangeRate;
import moneycalculator.persistence.ExchangeRateLoader;

/**
 *
 * @author Héctor Déniz Álvarez (Heckutoru)
 */
public class ResExchangeRateLoader implements ExchangeRateLoader{

    @Override
    public ExchangeRate load(Currency from, Currency to) {
        try {
            return new ExchangeRate(from,to, read(from.getCode(), to.getCode()));
        } catch (IOException ex) {
            return null;
        }
    }

    private double read(String fromCode, String toCode) throws IOException {
        String line = read(new URL("http://api.fixer.io/latest?base="+fromCode+"&symbols="+toCode));
        double parseDouble = Double.parseDouble(line.substring(line.indexOf(toCode)+5,line.indexOf("}")));
        return parseDouble;
    }

    private String read(URL url) throws IOException {
        InputStream is = url.openStream();
        byte[] buffer = new byte[1024];
        int length = is.read(buffer);
        return new String (buffer,0,length);
    }
    
}