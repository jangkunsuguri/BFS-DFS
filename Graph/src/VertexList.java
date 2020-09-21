import java.util.*;

public class VertexList
{

    private String name;
    private ArrayList<Vertex> neibs;

    public VertexList(String name) {
        this.name = new String(name);
    }

    public String toString() {
        return name + " " + neibs;
    }

    public String getName(){
        return name;
    }

    public ArrayList<Vertex> getNeibs()
    {
        return neibs;
    }

    public void setNeibs(ArrayList<Vertex> neibs)
    {
        this.neibs = neibs;
    }

}
