package moneycalculator.ui.swing;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JPanel;
import moneycalculator.model.Money;
import moneycalculator.ui.MoneyDisplay;

/**
 *
 * @author Héctor Déniz Álvarez (Heckutoru)
 */
public class SwingMoneyDisplay extends JPanel implements MoneyDisplay {

    private Money money;

    @Override
    public void display(Money money) {
        this.money = money;
        this.removeAll();
        this.add(amount());
        this.add(currency());
        this.updateUI();
    }

    private Component amount() {
        JLabel label = new JLabel(String.valueOf(money.getAmount()));
        return label;
    }

    private Component currency() {
        JLabel label = new JLabel(money.getCurrency().getCode());
        return label;
    }
    
}
