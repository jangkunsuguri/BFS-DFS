import java.io.FileNotFoundException;
import java.util.*;
import javax.swing.*;

public class BuildAdjList2
{

    public static void main(String [] s) throws FileNotFoundException {
        Graph g;
        String str = ioString("Enter \"F\" for File, \"I\" for Intertive Input");
        if (str.equalsIgnoreCase("F")){
            String file = ioString("File Name");
            g = new Graph(file);
        }
        else{
            g = new Graph();
        }
        String startDV = " ";
        while (true) {
            startDV = ioString("Starting Index for DFS (X to quit)");
            if (startDV.equalsIgnoreCase("x")){
                break;
            }
            g.callDfs(Integer.parseInt(startDV));
        }
        String startBV = " ";
        while (true) {
            startBV = ioString("Starting Index for BFS (X to quit)");
            if (startBV.equalsIgnoreCase("x")){
                break;
            }
            g.callDfs(Integer.parseInt(startBV));
        }
/*        g.callDfs(1);
        g.callBfs(1);*/
    }

    private static String ioString(String str){
        return JOptionPane.showInputDialog(null, str,"");
    }
}