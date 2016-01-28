package MaximumPathSum;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<Node> rowElements;
    private int noOfElements;

    public Row(){
        this.rowElements = new ArrayList<>();
    }

    public void setRow(String rowString){
        this.noOfElements = (rowString.length() + 1)/3;

        if(this.rowElements.size() == 0){
            for(int i = 0; i < this.noOfElements; i++){
                this.rowElements.add(i, new Node(Integer.parseInt(rowString.substring((i*3), (i*3)+2))));
            }
        }else{
            for(int i = rowElements.size()-1; i >= this.noOfElements; i--){
                this.rowElements.remove(i);
            }
            for(int i = 0; i < this.noOfElements; i++){
                this.rowElements.get(i).setVal(Integer.parseInt(rowString.substring((i*3), (i*3)+2)));
            }
        }
    }

    public void setMaxForRow(Row top, Row bottom){
        for (int i = 0; i < top.noOfElements; i++) {
            top.rowElements.get(i).setMax(Math.max(bottom.rowElements.get(i).getMax(), bottom.rowElements.get(i + 1).getMax()));
        }
    }

    public void initMaxForRow(Row row){
        for(Node n : row.rowElements) {
            n.setMax(0);
        }
    }
    public List<Node> getRow(){
        return this.rowElements;
    }
}
