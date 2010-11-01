/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hrzafer.javanta;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author hrzafer
 */
public class GUI {
     /*
     * Pencerenin (JFrame frame) Look and Feel'ini değiştirir. (String laf)
     */
     public static void setLookandFeel(String laf, JFrame frame) {
        try {
            UIManager.setLookAndFeel(laf);
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        SwingUtilities.updateComponentTreeUI(frame);
        frame.pack();
    }

    /*
     * Ekranda Tek Butonlu Mesaj Kutusu Gösterir
     */
    public static void messageBox(String message, String title) {
        JOptionPane.showConfirmDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }

}
