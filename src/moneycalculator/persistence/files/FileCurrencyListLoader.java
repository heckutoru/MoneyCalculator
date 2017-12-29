package moneycalculator.persistence.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import moneycalculator.model.Currency;
import moneycalculator.persistence.CurrencyListLoader;

/**
 *
 * @author Héctor Déniz Álvarez (Heckutoru)
 */
public class FileCurrencyListLoader implements CurrencyListLoader {

    private final String fileName;

    public FileCurrencyListLoader(String fileName) {
        this.fileName = fileName;
    }
    
    @Override
    public Currency[] currencies() {
        List<Currency> list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
            while(true){
                String line = reader.readLine();
                if(line == null) break;
                list.add(currencyOf(line));
            }
        } catch (IOException ex){}
        
        return list.toArray(new Currency[0]);
    }

    private Currency currencyOf(String line) {
        String[] split = line.split(",");
        Currency result = new Currency(split[0],split[1],split[2]);
        return result;
    }
    
}
