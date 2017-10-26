package com.sabel.jungwirth;

/**
 * @author jungwirth
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Anlage extends JFrame {

    // DATAFIELD
    private JButton jButtonFehlerMann, jButtonFehlerFrau, jButtonFehlerGesamt;
    private Scheibe scheibeFrauLiegend, scheibeFrauStehend, scheibeMannLiegend, scheibeMannStehend;
    private JLabel jLabelAthlet1, jLabelAthlet2, jLabelFehlerMann, jLabelFehlerFrau, jLabelFehlerGesamt;
    private JPanel jPanelCenter, jPanelSouth;

    // CONSTRUCTOR
    public Anlage() {
        super("Simple-Mixed-Relay");
        this.setSize(550, 200);
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
        initComponents();
        initEvents();
        this.setVisible(true);
    } // END CONSTRUCTOR

    // METHODS

    // COMPONENTS
    private void initComponents() {
        // JPanelCenter
        jPanelCenter = new JPanel();
        jPanelSouth = new JPanel();

        // Athlet 1
        jLabelAthlet1 = new JLabel("Athlet 1");
        scheibeMannLiegend = new Scheibe("liegend");
        scheibeMannStehend = new Scheibe("stehend");
        jButtonFehlerMann = new JButton("Fehler ermitteln");
        jLabelFehlerMann = new JLabel("? Fehler");

        // Athlet 2
        jLabelAthlet2 = new JLabel("Athlet 2");
        scheibeFrauLiegend = new Scheibe("liegend");
        scheibeFrauStehend = new Scheibe("stehend");
        jButtonFehlerFrau = new JButton("Fehler ermitteln");
        jLabelFehlerFrau = new JLabel("? Fehler");

        // Gesamt Fehler (SOUTH)
        jButtonFehlerGesamt = new JButton("Gesamtfehler");
        jLabelFehlerGesamt = new JLabel("? Gesamtfehler");

        // Add Elements to Panel
        jPanelCenter.add(jLabelAthlet1);
        jPanelCenter.add(scheibeMannLiegend);
        jPanelCenter.add(scheibeMannStehend);
        jPanelCenter.add(jButtonFehlerMann);
        jPanelCenter.add(jLabelFehlerMann);
        jPanelCenter.add(jLabelAthlet2);
        jPanelCenter.add(scheibeFrauLiegend);
        jPanelCenter.add(scheibeFrauStehend);
        jPanelCenter.add(jButtonFehlerFrau);
        jPanelCenter.add(jLabelFehlerFrau);
        jPanelSouth.add(jButtonFehlerGesamt);
        jPanelSouth.add(jLabelFehlerGesamt);

        // Panel to Frame
        this.add(jPanelCenter, BorderLayout.CENTER);
        this.add(jPanelSouth, BorderLayout.SOUTH);

    } // END void initComponents()


    // EVENT-HANDLING
    private void initEvents() {
        // WINDOWS ON CLOSING
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exit();
            }
        });

        // JBUTTON FEHLER GESAMT
        this.jButtonFehlerGesamt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jLabelFehlerGesamt.setText(anzahlGesamt() + " Fehler");
            }
        });

        // JBUTTON FAILURE ATHLETH 1
        this.jButtonFehlerMann.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jLabelFehlerMann.setText(anzahlAthlet1() + " Fehler");
            }
        });
        // JBUTTON FAILURE ATHLETH 2
        this.jButtonFehlerFrau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jLabelFehlerFrau.setText(anzahlAthlet2() + " Fehler");
            }
        });
    } // END void initEvents()

    // METHOD ON CLOSING WINDOW
    private void exit() {
        JOptionPane.showMessageDialog(Anlage.this, "Das Programm wird beendet und die Strafpunkte werden gespeichert", "Programmende ", JOptionPane.INFORMATION_MESSAGE);
    } // END void exit()

    // METHOD FAILUREPOINTS ATHLET 1
    public int anzahlAthlet1() {
        return scheibeMannLiegend.anzahlDerFehler() + scheibeMannStehend.anzahlDerFehler();
    } // END int anzahlAthlet1()

    // METHOD FAILUREPOINTS ATHLET 1
    public int anzahlAthlet2() {
        return scheibeFrauLiegend.anzahlDerFehler() + scheibeFrauStehend.anzahlDerFehler();
    } // END int anzahlAthlet2()

    // METHOD FAILUREPOINTS ATHLET 1 + ATHLET 2
    public int anzahlGesamt() {
        return scheibeMannLiegend.anzahlDerFehler() + scheibeMannStehend.anzahlDerFehler() + scheibeFrauLiegend.anzahlDerFehler() + scheibeFrauStehend.anzahlDerFehler();
    } // END int anzahlGesamt()

} // END CLASS ANLAGE
