/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package nezet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modell.Kert;
import modell.Növény;

/**
 *
 * @author makra
 */
public class KertGui extends javax.swing.JFrame {

    private Kert kert;

    public KertGui() {
        // Kert objektum létrehozása
        kert = new Kert();

        initComponents();

        
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                kilepes();
            }
        });
        
        
        
        // További inicializációk
        betoltAllapot("mentett_adatok/kert.bin");
        betoltAzonositok();
        betoltNevek();
        kivalasztasID();
        kivalasztasNev();
    }

    private void betoltAllapot(String fileNev) {
        try ( FileInputStream fileIn = new FileInputStream(fileNev);  ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            ArrayList<Növény> novenyek = (ArrayList<Növény>) objectIn.readObject();
            kert.setNovenyek(novenyek); // Kert objektum beállítása a beolvasott növényekkel

            System.out.println("Allapot beolvasva: " + fileNev);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void kivalasztasID() {
        ActionListener novenyValasztasListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedID = novenyID.getSelectedItem().toString();
                Növény selectedNoveny = kert.getNovenyByNevOrAzonosito(selectedID);
                String nev = selectedNoveny.getName();
                int kor = selectedNoveny.getAge();
                NevLabel.setText(nev);
                korLabel1.setText(String.valueOf(kor));
            }
        };

        novenyID.addActionListener(novenyValasztasListener);
    }

    private void kivalasztasNev() {
        ActionListener novenyValasztasListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedNev = novenyNev.getSelectedItem().toString();
                Növény selectedNoveny = kert.getNovenyByNevOrAzonosito(selectedNev);
                String id = selectedNoveny.getId();
                int kor = selectedNoveny.getAge();
                IDLabel.setText(id);
                korLabel2.setText(String.valueOf(kor));
            }
        };

        novenyNev.addActionListener(novenyValasztasListener);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        novenyID = new javax.swing.JComboBox<>();
        novenyNev = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        IDLabel = new javax.swing.JLabel();
        NevLabel = new javax.swing.JLabel();
        korLabel1 = new javax.swing.JLabel();
        korLabel2 = new javax.swing.JLabel();
        torolGomb = new javax.swing.JButton();
        ujGomb = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        ujIDTextField = new javax.swing.JTextField();
        ujNevTextField = new javax.swing.JTextField();
        ujKorTextField = new javax.swing.JTextField();
        ujArTextField = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mentes = new javax.swing.JMenuItem();
        exitGomb = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(novenyID, 0, 102, Short.MAX_VALUE)
            .addComponent(novenyNev, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(novenyID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(novenyNev, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 36, Short.MAX_VALUE))
        );

        IDLabel.setText("AAAAA");

        NevLabel.setText("AAAA");

        korLabel1.setText("VDA");

        korLabel2.setText("BBBB");

        torolGomb.setText("torles");
        torolGomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                torolGombActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(NevLabel)
                        .addGap(101, 101, 101)
                        .addComponent(korLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(IDLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(korLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(torolGomb)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(korLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(NevLabel)))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IDLabel)
                    .addComponent(korLabel2)
                    .addComponent(torolGomb))
                .addGap(0, 25, Short.MAX_VALUE))
        );

        ujGomb.setText("uj");
        ujGomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ujGombActionPerformed(evt);
            }
        });

        ujIDTextField.setText("jTextField1");

        ujNevTextField.setText("jTextField2");

        ujKorTextField.setText("jTextField3");

        ujArTextField.setText("jTextField1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ujIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(ujNevTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(ujKorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(ujArTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ujIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ujNevTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ujKorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ujArTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jMenu1.setText("File");

        mentes.setText("mentés");
        mentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mentesActionPerformed(evt);
            }
        });
        jMenu1.add(mentes);

        exitGomb.setText("kilepes");
        exitGomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitGombActionPerformed(evt);
            }
        });
        jMenu1.add(exitGomb);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(ujGomb)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ujGomb)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mentesActionPerformed
        mentes();
    }//GEN-LAST:event_mentesActionPerformed

    private void torolGombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_torolGombActionPerformed

        Növény kivalasztottNoveny = getKivalasztottNoveny();
        if (kivalasztottNoveny != null) {
            kert.novenyTorles(kivalasztottNoveny);
            // Egyéb frissítési feladatok, üzenetek stb.
        }
    }//GEN-LAST:event_torolGombActionPerformed

    private void ujGombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ujGombActionPerformed
        String ujID = ujIDTextField.getText();
        String ujNev = ujNevTextField.getText();
        int ujKor = Integer.parseInt(ujKorTextField.getText());
        int ujAr = Integer.parseInt(ujArTextField.getText());

        Növény ujNoveny = new Növény(ujID, ujNev, ujAr, ujKor);

        kert.novenyUj(ujNoveny);

        // További frissítési feladatok, üzenetek stb.
    }//GEN-LAST:event_ujGombActionPerformed

    private void exitGombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitGombActionPerformed
        kilepes();
    }//GEN-LAST:event_exitGombActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KertGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KertGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KertGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KertGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KertGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IDLabel;
    private javax.swing.JLabel NevLabel;
    private javax.swing.JMenuItem exitGomb;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel korLabel1;
    private javax.swing.JLabel korLabel2;
    private javax.swing.JMenuItem mentes;
    private javax.swing.JComboBox<String> novenyID;
    private javax.swing.JComboBox<String> novenyNev;
    private javax.swing.JButton torolGomb;
    private javax.swing.JTextField ujArTextField;
    private javax.swing.JButton ujGomb;
    private javax.swing.JTextField ujIDTextField;
    private javax.swing.JTextField ujKorTextField;
    private javax.swing.JTextField ujNevTextField;
    // End of variables declaration//GEN-END:variables

    private void betoltAzonositok() {
        ArrayList<Növény> novenyek = (ArrayList<Növény>) kert.novenyekGet();
// Kert objektumból lekéred a növényeket
        for (Növény noveny : novenyek) {
            novenyID.addItem(noveny.getId());
        }
    }

    private void betoltNevek() {
        ArrayList<Növény> novenyek = (ArrayList<Növény>) kert.novenyekGet();
// Kert objektumból lekéred a növényeket
        for (Növény noveny : novenyek) {
            novenyNev.addItem(noveny.getName());
        }
    }

    private void mentes() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();

            try ( BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                for (Növény növény : kert.novenyekGet()) {
                    writer.write(növény.getId() + "," + növény.getName() + "," + növény.getPrice() + "," + növény.getAge());
                    writer.newLine();
                }
                JOptionPane.showMessageDialog(this, "Kert állapota sikeresen elmentve!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Hiba történt a mentés során!");
                e.printStackTrace();
            }
        }
    }

    private Növény getKivalasztottNoveny() {
        String selectedNovenyID = novenyID.getSelectedItem().toString();
        return kert.getNovenyByID(selectedNovenyID);
    }

    private void kilepes() {
        int válasz = JOptionPane.showOptionDialog(this, "Biztosan kilép a programból?", "Kilépés", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon("útvonal/a/képhez.png"), new Object[]{"Folytatás", "Kilépés"}, "Folytatás");

        if (válasz == JOptionPane.YES_OPTION) {
            // Itt történik a kilépés a programból
            System.exit(0);
        }
    }

}
