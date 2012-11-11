/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokulint;

import java.io.*;
import java.util.Arrays;

/**
 *
 * @author hacker
 */
public class SudokuLint {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {                        
        
        //Build the initial data
        SudokuFileUtils su = new SudokuFileUtils();
        final int[][] solutiongrid1 = su.readFiletoArray("inputs/sampleInput_4x4.txt");
        final int[][] solutiongrid2 = su.readFiletoArray("inputs/sampleInput_9x9.txt");
        final int[][] solutiongrid3 = su.readFiletoArray("inputs/sample_payal.txt");
        final int[][] solutiongrid4 = su.readFiletoArray("inputs/sample_mehul.txt");
        
        SudokuHelper sh = new SudokuHelper();
        //System.out.println(sh.calculateExecutionTime(solutiongrid1));
        //System.out.println(sh.calculateExecutionTime(solutiongrid2));
        //System.out.println(sh.validateSudoku(solutiongrid3));
        //System.out.println(sh.calculateExecutionTime(solutiongrid4));
        
        //Dump the system Info
        sh.getSystemInfo();
        
        //Testing running times
        for(int gridroot=2;gridroot<101;gridroot++){
            System.out.println("Sudoku Size: "+(gridroot*gridroot)+" x "+(gridroot*gridroot)+" Time in ms: "+sh.calculateExecutionTime(sh.generateSudoKu(gridroot)));
        }            
        
        //System.out.println(sh.validateSudoku(sh.generateSudoKu(100)));
    }
}
