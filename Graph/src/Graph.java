import java.util.*;
import java.io.*;
import javax.swing.*;

public class Graph {

    ArrayList<VertexList> vList;
    int vCount;
    Queue<Integer> q = new Queue<>();
    private boolean[] dvisited;
    private boolean[] bvisited;


    public Graph(){
        this.vCount = readInteger("Number of Vertices", 1);

        this.vList = new ArrayList<VertexList>(vCount);

        int i;

        for (i = 1; i < vCount+1; i++){
            // Add vertex with label number, start with #1
            vList.add(i-1, new VertexList(""+i));


            int nCount = readInteger("Number of neighbors for vertex # " + i, 0);

            ArrayList<Vertex> neibs = new ArrayList<Vertex>(nCount);

            for (int k = 0; k < nCount; k++)
            {
                int vertexNum = readInteger("Enter neighbor # "  + (k+1) + " for vertex # " + i, 1);
                neibs.add(new Vertex("" + vertexNum));
            }
            vList.get(i-1).setNeibs(neibs);

        }
        dvisited = new boolean[vCount];
        bvisited = new boolean[vCount];
        display();
    }

    public Graph(String file) throws FileNotFoundException{
        Scanner in = new Scanner(new FileReader(file+".txt"));
        vCount = in.nextInt();
        vList = new ArrayList<VertexList>(vCount);
        for (int i = 1; i < vCount+1; i++) {
            vList.add(i-1, new VertexList(""+i));
            int nCount = in.nextInt();
            ArrayList<Vertex> neibs = new ArrayList<Vertex>(nCount);
            for (int j = 0; j < nCount; j++) {
                int vertNum = in.nextInt();
                neibs.add(new Vertex(""+vertNum));
            }
            vList.get(i-1).setNeibs(neibs);
        }
        dvisited = new boolean[vCount];
        bvisited = new boolean[vCount];
        display();
    }

    private void display(){
        for (int i = 1; i < vCount+1; i++)
        {
            ArrayList<Vertex> neibs = vList.get(i-1).getNeibs();

            System.out.print(""+ i + " neibs = ");
            Iterator<Vertex> it = neibs.iterator();

            System.out.print("[");

            while (it.hasNext())
            {
                System.out.print(it.next());
                if (it.hasNext())
                    System.out.print(", ");
            }

            System.out.print("]");

            System.out.println();
        }
    }

    public void callDfs(int v){
        clearDfs();
        dfs(v);
        System.out.println();
    }

    private void clearDfs() {
        for (int i = 0; i < dvisited.length; i++) {
            dvisited[i] = false;
        }
    }

    private void dfs(int v){
       dvisited[v-1] = true;
        ArrayList<Vertex> neibs = vList.get(v-1).getNeibs();
        System.out.print(vList.get(v-1).getName()+" ");
        for (int i = 0; i < neibs.size(); i++) {
            int n = Integer.parseInt(neibs.get(i).toString());
            if (!dvisited[n-1]){
                dfs(n);
            }
        }
    }

    public void callBfs(int v){
        clearBfs();
        bfs(v);
        System.out.println();
    }

    private void clearBfs() {
        for (int i = 0; i < bvisited.length; i++) {
            bvisited[i] = false;
        }
    }

    private void bfs(int v){
        bvisited[v-1] = true;
        q.enqueue(v);
        while (!q.isEmpty()){
            Integer n = q.dequeue()-1;
            System.out.print(vList.get(n).getName()+" ");
            ArrayList<Vertex> neibs = vList.get(n).getNeibs();
            for (int i = 0; i < neibs.size(); i++) {
                int j = Integer.parseInt(neibs.get(i).toString());
                if (!bvisited[j-1]){
                    bvisited[j-1] = true;
                    q.enqueue(j);
                }
            }
        }
    }

    private int readInteger(String prompt, int min) {

        int val = 0;

        do {
            String ans = JOptionPane.showInputDialog(null, prompt, "");

            try
            {
                val = Integer.parseInt(ans);
            }
            catch (NumberFormatException nfe) {  val = 0; }
        }

        while (val < min);

        return val;
    }
}
