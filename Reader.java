import java.io.*;
import java.util.*;

class Reader{

  public static void main(String[] args) {
    System.out.println("Concentration values:\n" + getConcentrationVals());
  }

  public static ArrayList<Integer> getConcentrationVals(){
    Scanner x;
    ArrayList<Integer> out = new ArrayList<Integer>();
    String[] line;
    int val;

    try{
      x = new Scanner(new File("data.csv"));
      while(x.hasNextLine()){
        line = x.nextLine().split(",");
        try{
          val = Integer.parseInt(line[10]);
          out.add(val);
        }catch(NumberFormatException n){
          // do nothing
        }
      }
      x.close();
    }catch(FileNotFoundException e){
      throw new RuntimeException("Error: You must have a file called 'test.csv' in this folder.");
    }

    return out;
  }
}
