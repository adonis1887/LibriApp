/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



 
/*

- Aplikacion për Regjistrimin e Librave
- @author ADONIS
  */
  import javax.swing.*;
  import java.awt.*;
  import java.awt.event.*;
  import java.util.ArrayList;

public class LibriApp implements ActionListener {

JFrame f;
JLabel l1, l2, l3, l4, l5, l6;
JTextField t1, t2, t4;
JTextArea t3;
JScrollPane scroll;
JComboBox<String> combo;
JRadioButton rb1, rb2;
ButtonGroup bg;
JButton b1, b2, b3;

ArrayList<Libri> librat;

LibriApp() {
    librat = new ArrayList<>();
    // Shtimi i një libri ekzistues për testim
    librat.add(new Libri("Historia E Skenderbeut", "Naim Frasheri",
        "Faktit qe permendim epike historike prej 11,560 vargjesh qe Naim dridhet te kete aknesar para veti 1895, se perndimmin e fundit krejeses, u qe e shkrire te kryeveprave e vet [...]",
        "Edukativ", "Fizik"));

    f = new JFrame("Të dhënat e Librit");
    f.setSize(650, 650);
    f.setLayout(null);
    f.getContentPane().setBackground(Color.WHITE);

    // Titulli
    l1 = new JLabel("Titulli:");
    l1.setBounds(30, 30, 100, 25);
    l1.setFont(new Font("Arial", Font.BOLD, 14));
    l1.setForeground(new Color(70, 130, 180));

    t1 = new JTextField();
    t1.setBounds(30, 60, 570, 30);
    t1.setBackground(Color.WHITE);
    t1.setBorder(BorderFactory.createLineBorder(Color.GRAY));

    // Autori
    l2 = new JLabel("Autori:");
    l2.setBounds(30, 100, 100, 25);
    l2.setFont(new Font("Arial", Font.BOLD, 14));
    l2.setForeground(new Color(70, 130, 180));

    t2 = new JTextField();
    t2.setBounds(30, 130, 570, 30);
    t2.setBackground(Color.WHITE);
    t2.setBorder(BorderFactory.createLineBorder(Color.GRAY));

    // Përshkrimi
    l3 = new JLabel("Përshkrimi:");
    l3.setBounds(30, 170, 100, 25);
    l3.setFont(new Font("Arial", Font.BOLD, 14));
    l3.setForeground(new Color(70, 130, 180));

    t3 = new JTextArea();
    t3.setLineWrap(true);
    t3.setWrapStyleWord(true);
    t3.setBackground(Color.WHITE);
    scroll = new JScrollPane(t3);
    scroll.setBounds(30, 200, 570, 100);
    scroll.setBorder(BorderFactory.createLineBorder(Color.GRAY));

    // Zhanri
    l4 = new JLabel("Zhanri:");
    l4.setBounds(30, 320, 60, 25);
    l4.setFont(new Font("Arial", Font.BOLD, 14));
    l4.setForeground(new Color(70, 130, 180));

    String[] zhanret = {"Romancë", "Aksion", "Horror", "Edukativ"};
    combo = new JComboBox<>(zhanret);
    combo.setBounds(95, 320, 150, 30);
    combo.setBackground(Color.WHITE);

    // Lloji
    l5 = new JLabel("Lloji:");
    l5.setBounds(280, 320, 60, 25);
    l5.setFont(new Font("Arial", Font.BOLD, 14));
    l5.setForeground(new Color(70, 130, 180));

    rb1 = new JRadioButton("Fizik");
    rb1.setBounds(345, 320, 80, 25);
    rb1.setBackground(Color.WHITE);
    rb1.setSelected(true);

    rb2 = new JRadioButton("Elektronik");
    rb2.setBounds(430, 320, 120, 25);
    rb2.setBackground(Color.WHITE);

    bg = new ButtonGroup();
    bg.add(rb1);
    bg.add(rb2);

    // Shfaqje
    l6 = new JLabel("Shfaqje:");
    l6.setBounds(30, 370, 100, 25);
    l6.setFont(new Font("Arial", Font.BOLD, 14));
    l6.setForeground(new Color(70, 130, 180));

    t4 = new JTextField();
    t4.setBounds(30, 400, 570, 30);
    t4.setBackground(Color.WHITE);
    t4.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    t4.setEditable(false);

    // Butonat
    b1 = new JButton("Shto Libër");
    b1.setBounds(150, 460, 120, 35);
    b1.setBackground(new Color(70, 130, 180));
    b1.setForeground(Color.WHITE);
    b1.setFocusPainted(false);
    b1.addActionListener(this);

    b2 = new JButton("Pastro");
    b2.setBounds(280, 460, 100, 35);
    b2.setBackground(new Color(200, 200, 200));
    b2.setFocusPainted(false);
    b2.addActionListener(this);

    b3 = new JButton("Shfaq Librat");
    b3.setBounds(390, 460, 130, 35);
    b3.setBackground(new Color(100, 180, 100));
    b3.setForeground(Color.WHITE);
    b3.setFocusPainted(false);
    b3.addActionListener(this);

    // Shtimi i komponenteve në frame
    f.add(l1);
    f.add(t1);
    f.add(l2);
    f.add(t2);
    f.add(l3);
    f.add(scroll);
    f.add(l4);
    f.add(combo);
    f.add(l5);
    f.add(rb1);
    f.add(rb2);
    f.add(l6);
    f.add(t4);
    f.add(b1);
    f.add(b2);
    f.add(b3);

    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
}

public void actionPerformed(ActionEvent e) {
    if (e.getSource() == b1) {
        shtoLiber();
    } else if (e.getSource() == b2) {
        pastroCampet();
    } else if (e.getSource() == b3) {
        shfaqLibrat();
    }
}

 void shtoLiber() {
    String titulli = t1.getText().trim();
    String autori = t2.getText().trim();
    String pershkrimi = t3.getText().trim();
    String zhanri = (String) combo.getSelectedItem();
    String lloji = rb1.isSelected() ? "Fizik" : "Elektronik";

    
    if (titulli.isEmpty() || autori.isEmpty()) {
        JOptionPane.showMessageDialog(f,
            "Ju lutem plotësoni të gjitha fushat e detyrueshme (Titulli dhe Autori)!",
            "Gabim",
            JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Kontrollimi nëse libri ekziston
    for (Libri libri : librat) {
        if (libri.getTitulli().equalsIgnoreCase(titulli)) {
            String mesazhi = String.format(
                "Titulli: %s\nAutori: %s\nPërshkrimi: %s\nZhanri: %s\nLloji: %s\nNë stek: Po",
                libri.getTitulli(),
                libri.getAutori(),
                libri.getPershkrimi(),
                libri.getZhanri(),
                libri.getLloji()
            );

            JOptionPane.showMessageDialog(f,
                mesazhi,
                "Të dhënat e librit",
                JOptionPane.INFORMATION_MESSAGE);
            return;
        }
    }

    // Shtimi i librit të ri
    Libri libriRi = new Libri(titulli, autori, pershkrimi, zhanri, lloji);
    librat.add(libriRi);

    t4.setText("Libri u shtua me sukses! Total libra: " + librat.size());

    JOptionPane.showMessageDialog(f,
        "Libri '" + titulli + "' u shtua me sukses në bibliotekë!",
        "Sukses",
        JOptionPane.INFORMATION_MESSAGE);

    pastroCampet();
}

private void pastroCampet() {
    t1.setText("");
    t2.setText("");
    t3.setText("");
    combo.setSelectedIndex(0);
    rb1.setSelected(true);
    t4.setText("");
    t1.requestFocus();
}

private void shfaqLibrat() {
    if (librat.isEmpty()) {
        JOptionPane.showMessageDialog(f,
            "Nuk ka libra të regjistruar!",
            "Info",
            JOptionPane.INFORMATION_MESSAGE);
        return;
    }

    StringBuilder sb = new StringBuilder();
    sb.append("LISTA E LIBRAVE NË BIBLIOTEKË\n");
    sb.append("==================================================\n\n");

    for (int i = 0; i < librat.size(); i++) {
        Libri l = librat.get(i);
        sb.append((i + 1)).append(". ").append(l.getTitulli())
          .append(" - ").append(l.getAutori())
          .append(" (").append(l.getZhanri()).append(", ")
          .append(l.getLloji()).append(")\n");
    }

    JTextArea textArea = new JTextArea(sb.toString());
    textArea.setEditable(false);
    textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));

    JScrollPane scrollPane = new JScrollPane(textArea);
    scrollPane.setPreferredSize(new Dimension(500, 300));

    JOptionPane.showMessageDialog(f,
        scrollPane,
        "Librat e Regjistruar",
        JOptionPane.INFORMATION_MESSAGE);
}

public static void main(String[] args) {
    new LibriApp();
}


}

// Klasa Libri për ruajtjen e të dhënave
class Libri {
String titulli;
String autori;
String pershkrimi;
String zhanri;
String lloji;


public Libri(String titulli, String autori, String pershkrimi, String zhanri, String lloji) {
    this.titulli = titulli;
    this.autori = autori;
    this.pershkrimi = pershkrimi;
    this.zhanri = zhanri;
    this.lloji = lloji;
}

public String getTitulli() { return titulli; }
public String getAutori() { return autori; }
public String getPershkrimi() { return pershkrimi; }
public String getZhanri() { return zhanri; }
public String getLloji() { return lloji; }

}




