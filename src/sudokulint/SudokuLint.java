package sudokulint;

import java.io.*;
import java.util.*;

/**
 *
 * @author Utkarsh C
 */
public class SudokuLint {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{                        
        
        //Display Choices
        System.out.println("#####################");
        System.out.println("     Sudoku Lint     ");
        System.out.println("#####################");
        System.out.println();
        System.out.println();
        System.out.println("1. Validate Sudoku's: Validates the Sudoku .txt files in the 'input' directory");
        System.out.println("2. See Execution Times: Runs the validator against Sudoku grids of various dimensions");
        System.out.println();
        System.out.print("Please enter your selection: ");
        
        //Read user input
        InputStreamReader in = new InputStreamReader(System.in); 
        BufferedReader br = new BufferedReader(in);        
        int input = Integer.parseInt(br.readLine());        
        
        //Initialize the objects
        SudokuHelper sh = new SudokuHelper();
        
        switch (input){
            case 1 :  HashMap hmFiles = new HashMap();        
                      SudokuFileUtils sfu = new SudokuFileUtils();                                                
                      hmFiles=sfu.listFilesInFolder(); //Get the files HashMap                        
                      Set set = hmFiles.entrySet(); //Validate all the inputs files in the inputs directory
                      Iterator i = set.iterator();
                      System.out.println();
                      while(i.hasNext()){
                        Map.Entry me = (Map.Entry)i.next();
                        System.out.println("Validating: "+me.getKey()+" - "+sh.validateSudoku(sfu.readFiletoArray((String)me.getValue())));
                        System.out.println();
                      }
                      break;
            case 2 :  sh.getSystemInfo(); //Dump the system Info
                      for(int gridroot=2;gridroot<101;gridroot++){
                        System.out.println("Sudoku Size: "+(gridroot*gridroot)+" x "+(gridroot*gridroot)+" Time in ms: "+sh.calculateExecutionTime(sh.generateSudoKu(gridroot)));
                      }
                        break;
            default : System.err.println("Please enter a valid selection");
                      break;
        }                                               
    }
}
