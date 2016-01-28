package MaximumPathSum;

public class Node {
    private int val, max;

    public Node(int val){
        this.val = val;
    }

    public void setVal(int val){
        this.val = val;
    }

    public void setMax(int n){
        this.max = n+this.val;
    }

    public int getMax(){
        return this.max;
    }
}
