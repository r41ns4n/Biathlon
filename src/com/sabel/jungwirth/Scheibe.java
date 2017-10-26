package com.sabel.jungwirth;
/**
 * @author jungwirth
 */

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Scheibe extends JPanel {

    // DATAFIELD
    private JRadioButton[] jRadioButtons;

    // CONSTRUCTOR
    public Scheibe(String artDesSchiessens) {
        this.setBorder(new TitledBorder(artDesSchiessens));
        jRadioButtons = new JRadioButton[5];
        for (int i = 0; i < 5; i++) {
            jRadioButtons[i] = new JRadioButton();
            jRadioButtons[i].setSelected(true);
            this.add(jRadioButtons[i]);
        } // END FOR
    } // END Scheibe(String artDesSchiessens)

    // METHOD
    public int anzahlDerFehler() {
        int result = 0;
        for (int i = 0; i < 5; i++) {
            if (jRadioButtons[i].isSelected()) {
                result++;
            } // END IF
            jRadioButtons[i].setEnabled(false);
        } // END FOR
        return result;
    } // END int anzahlDerFehler()

} // END CLASS SCHEIBE

