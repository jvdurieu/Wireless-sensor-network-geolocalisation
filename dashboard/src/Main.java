/**
 * Main class
 *
 * @author Jean-Vital Durieu
 * @version 0.01
 * Created by jvdur on 09/05/2016.
 */

import app.AppContext;
import app.Pgm;

import java.util.logging.Level;

import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

public final class Main {



    /**
     * private and empty constructor
     */
    private Main() {
    }

    /**
     * main method !!
     *
     * @param args boot arguments
     * @throws UnsupportedLookAndFeelException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws ClassNotFoundException
     */
    public static void main(final String[] args) {

        try {

            String propFile;
            if (args.length >= 1) {
                propFile = args[0];
            } else {
                propFile = AppContext.PROP_DEFAULT;
            }

            AppContext.INSTANCE.loadAndConfig(propFile);
            new Pgm();
        } catch (Exception e) {
            String errMsg = "Error while loading the app";
            System.out.println(errMsg + " : " + e.getMessage());
            JOptionPane.showMessageDialog(null, errMsg+"\n", "Fatal Error !", JOptionPane.ERROR_MESSAGE);
            AppContext.INSTANCE.getLogger().log(Level.SEVERE,errMsg + ": "+ e.toString());
        }
    }

}
