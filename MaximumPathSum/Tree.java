package MaximumPathSum;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Tree {
    private Row top, bottom;

    public Tree(){
        top = new Row();
        bottom = new Row();
    }

    public void initBottom(String s){
        this.bottom.setRow(s);
        this.bottom.initMaxForRow(this.bottom);
    }

    public void setTopAndMax(String s){
        this.top.setRow(s);
        this.top.setMaxForRow(this.top, this.bottom);
    }

    public void swapRows(){
        Row temp;
        temp = this.bottom;
        this.bottom = this.top;
        this.top = temp;
    }

    public static int problem18(){
        Tree tree = new Tree();
        List<String> values = new ArrayList<>();

        String[] inData= {
                "75",
                "95 64",
                "17 47 82",
                "18 35 87 10",
                "20 04 82 47 65",
                "19 01 23 75 03 34",
                "88 02 77 73 07 63 67",
                "99 65 04 28 06 16 70 92",
                "41 41 26 56 83 40 80 70 33",
                "41 48 72 33 47 32 37 16 94 29",
                "53 71 44 65 25 43 91 52 97 51 14",
                "70 11 33 28 77 73 17 78 39 68 17 57",
                "91 71 52 38 17 14 91 43 58 50 27 29 48",
                "63 66 04 68 89 53 67 30 73 16 69 87 40 31",
                "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23" };

        for(String row : inData){
            values.add(row);
        }
        tree.initBottom(values.get(values.size()-1));

        for(int i = values.size()-2; i>0; i--){
            tree.setTopAndMax(values.get(i));
            tree.swapRows();
        }

        tree.setTopAndMax(values.get(0));

        return tree.top.getRow().get(0).getMax();
    }

    public static int problem67(){
        Tree tree = new Tree();
        int max = 0;
        try{
            List<String> list = Files.readAllLines(Paths.get("p067_triangle.txt"));
            tree.initBottom(list.get(list.size()-1));
            for(int i = list.size()-2; i>0; i--){
                tree.setTopAndMax(list.get(i));
                tree.swapRows();
            }

            tree.setTopAndMax(list.get(0));

            max =  tree.top.getRow().get(0).getMax();
        }catch(IOException e){
            e.printStackTrace();
        }
        return max;
    }

    public static void main(String[] args){
        System.out.println(problem67());
    }
}
