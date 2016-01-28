package MaximumPathSum;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<Node> rowElements;
    private int noOfElements;

    public Row(){
        this.rowElements = new ArrayList<>();
    }

    public List<Node> getRow(){
        return this.rowElements;
    }

    public void setRow(String rowString){
        this.noOfElements = (rowString.length() + 1)/3;

        if(this.rowElements.isEmpty()){
            // initialize the row and set values for Nodes
            for(int i = 0; i < this.noOfElements; i++){
                this.rowElements.add(i, new Node(parseValFromString(rowString, i)));
            }
        }else{
            // remove nodes that are not longer needed
            for(int i = rowElements.size()-1; i >= this.noOfElements; i--){
                this.rowElements.remove(i);
            }

            // set values for the nodes
            for(int i = 0; i < this.noOfElements; i++){
                this.rowElements.get(i).setVal(parseValFromString(rowString, i));
            }
        }
    }

    private int parseValFromString(String rowString, int nodeNumber) {
        return Integer.parseInt(rowString.substring((nodeNumber *3), (nodeNumber *3)+2));
    }

    public void setMaxForRow(Row bottom){
        for (int i = 0; i < this.noOfElements; i++) {
            this.rowElements.get(i).setMax(Math.max(bottom.rowElements.get(i).getMax(), bottom.rowElements.get(i + 1).getMax()));
        }
    }

    public void initMaxForRow(){
        for(Node n : this.rowElements) {
            n.setMax(0);
        }
    }

}
