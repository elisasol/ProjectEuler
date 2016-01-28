package MaximumPathSum;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/*
 * A Structure consist of two rows, top and bottom;
 * Bottom row is the nodes that are below the nodes in the top row
 * */
public class Structure {
    private Row top, bottom;

    public Structure(){
        top = new Row();
        bottom = new Row();
    }

    public void initBottom(String s){
        this.bottom.setRow(s);
        this.bottom.initMaxForRow();
    }

    public void setTopAndMax(String s){
        this.top.setRow(s);
        this.top.setMaxForRow(this.bottom);
    }

    public void swapRowsForReusage(){
        Row temp;
        temp = this.bottom;
        this.bottom = this.top;
        this.top = temp;
    }

    public Row getTop(){
        return this.top;
    }
}
