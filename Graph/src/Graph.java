import java.util.ArrayList;
import java.util.Iterator;

public class Graph {

    ArrayList<VertexList> vList;
    int vCount;
    //Queue<VertexList> q = new Queue<>();
    Queue<Integer> q = new Queue<>();
    private boolean[] dvisited;
    private boolean[] bvisited;


    public Graph(ArrayList<VertexList> vList, int vCount){
        this.vList = new ArrayList<VertexList>(vList);     //(ArrayList<VertexList>)vList.clone()
        this.vCount = vCount;
        dvisited = new boolean[vCount];
        bvisited = new boolean[vCount];
    }

    public void display(){
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

/*    public void dfs(VertexList startingVertex){
        int i = vList.indexOf(startingVertex);
        visited[i] = true;
        ArrayList<Vertex> neibs = vList.get(i).getNeibs();
        for (i = 0; i < neibs.size(); i++){
            if (visited[vList.indexOf()]){
                dfs(vList.indexOf());
            }
        }
    }
    for using VertexList as an input*/

    public void callDfs(int v){
        clearDfs();
        dfs(v);
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

/*    public void bfs(int v){
        int i = vList.indexOf(startingVertex);
        q.enqueue(startingVertex);
        visited[i] = true;
        while (!q.isEmpty()){
            q.dequeue()
        }
    }
    for using vertexList as an input*/

    public void callBfs(int v){
        clearBfs();
        bfs(v);
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
}
