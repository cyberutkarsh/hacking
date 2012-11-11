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
    public static void main(String[] args) {                        
        
        //Initialize the objects
        HashMap hmFiles = new HashMap();
        SudokuHelper sh = new SudokuHelper();
        SudokuFileUtils sfu = new SudokuFileUtils();                
        
        //Dump the system Info
        sh.getSystemInfo();
        
        //Get the files HashMap
        hmFiles=sfu.listFilesInFolder();
        
        //Validate all the inputs files in the inputs directory
        Set set = hmFiles.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
            Map.Entry me = (Map.Entry)i.next();
            System.out.println("Validating: "+me.getKey()+" - "+sh.validateSudoku(sfu.readFiletoArray((String)me.getValue())));
            System.out.println();
        }
        
        //Testing running times
        for(int gridroot=2;gridroot<101;gridroot++){
            System.out.println("Sudoku Size: "+(gridroot*gridroot)+" x "+(gridroot*gridroot)+" Time in ms: "+sh.calculateExecutionTime(sh.generateSudoKu(gridroot)));
        }            
        
        //System.out.println(sh.validateSudoku(sh.generateSudoKu(100)));
    }
}
