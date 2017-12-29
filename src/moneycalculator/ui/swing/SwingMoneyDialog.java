package moneycalculator.ui.swing;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import moneycalculator.model.Currency;
import moneycalculator.model.Money;
import moneycalculator.ui.MoneyDialog;

/**
 *
 * @author Héctor Déniz Álvarez (Heckutoru)
 */
public class SwingMoneyDialog extends JPanel implements MoneyDialog {

    private Currency currency;
    private String amountS;
    private final Currency[] currencies;

    
    public SwingMoneyDialog(Currency[] currencies) {
        this.currencies = currencies;
        this.add(amount());
        this.add(currency());
    }

    @Override
    public Money get() {
        Money money = new Money(Double.parseDouble(amountS),currency);
        return money;
    }

    private Component amount() {
        JTextField amount = new JTextField("100");
        amount.setColumns(10);
        amount.getDocument().addDocumentListener(amountChanged());
        amountS = amount.getText();
        return amount;
    }

    private Component currency() {
        JComboBox combo = new JComboBox(currencies);
        combo.addItemListener(currencyChanged());
        currency = (Currency) combo.getSelectedItem();
        return combo;
    }

    private ItemListener currencyChanged() {
        return new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.DESELECTED){
                    return;
                }
                currency = (Currency) e.getItem();
            }
        };
    }

    private DocumentListener amountChanged() {
        return new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                amountChanged(e.getDocument());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                amountChanged(e.getDocument());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                amountChanged(e.getDocument());
            }

            private void amountChanged(Document document) {
                try {
                    amountS = document.getText(0, document.getLength());
                } catch (BadLocationException ex) {
                }
            }
        };
    }

}
