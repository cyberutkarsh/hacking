package sudokulint;

import java.io.*;
import java.util.*;

/**
 *
 * @author Utkarsh C
 */
public class SudokuLint {

    /**
     * @Main class requiring user input to run validation.
     */
    public static void main(String[] args) throws IOException{                        
        
        System.out.println("###############################");
        System.out.println("          Sudoku Lint          ");
        System.out.println("###############################");
        while(true){
            //Display Choices            
            System.out.println();
            System.out.println();
            System.out.println("1 Validate Sudoku's: Validates the Sudoku .txt files in the 'input' directory");
            System.out.println("2 See Execution Times: Runs the validator against Sudoku grids of various dimensions");
            System.out.println("3 Exit");
            System.out.println();
            System.out.print("Please enter your selection (1,2 or 3): ");

            //Read user input
            InputStreamReader in = new InputStreamReader(System.in); 
            BufferedReader br = new BufferedReader(in);
            int input=0;
            
            try{
                input = Integer.parseInt(br.readLine());
            } catch(NumberFormatException nfe){
                System.out.println();
                System.out.println("Please enter a valid selection");
            }

            //Initialize the objects
            SudokuHelper sh = new SudokuHelper();

            switch (input){
                case 1 :  HashMap hmFiles = new HashMap();        
                          SudokuFileUtils sfu = new SudokuFileUtils();                                                
                          hmFiles=sfu.listFilesInFolder(); //Get the files HashMap                        
                          Set set = hmFiles.entrySet();
                          Iterator i = set.iterator();
                          System.out.println();
                          while(i.hasNext()){ //Validating all the inputs files in the inputs directory
                            Map.Entry me = (Map.Entry)i.next();
                            System.out.println(">> Validating: "+me.getKey()+" - "+sh.validateSudoku(sfu.readFiletoArray((String)me.getValue())));
                            System.out.println();
                          }
                          break;
                case 2 :  sh.getSystemInfo(); //Dump the system Info
                          for(int gridroot=2;gridroot<31;gridroot++){ //Calculate running time
                            System.out.println("Sudoku Size: "+(gridroot*gridroot)+" x "+(gridroot*gridroot)+" Time in ms: "+sh.calculateExecutionTime(sh.generateSudoKu(gridroot)));
                          }
                          break;
                case 3 :  System.exit(0);
                default : System.out.println();
                          System.out.println("Please enter a valid selection");                            
                          break;
            }
        }
    }
}
