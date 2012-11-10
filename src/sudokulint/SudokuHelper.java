/*
 * To change this template, choose Tools | Templates
 * and open the template reader the editor.
 */
package sudokulint;

import java.util.Arrays;
import java.io.*;
import java.util.*;

/**
 *
 * @author hacker
 */
public class SudokuHelper {    
    
    String solutionvalid;
    String solutioninvalid;
    
    SudokuHelper(){
        solutionvalid = "The sodoku solution is correct!";
        solutioninvalid = "The sodoku solution is In-Correct!";
    }
    
    // I generate root solutions
    public int[][] generateSudoKu(int gridroot){        
        final int[][] grid = new int[gridroot*gridroot][gridroot*gridroot];
        for (int i = 0; i < gridroot*gridroot; i++)
            for (int j = 0; j < gridroot*gridroot; j++)
                grid[i][j] = (i*gridroot + i/gridroot + j) % (gridroot*gridroot) + 1;
        
        return grid;        
    }
    
    // I check the Sudoku solutions
    public String validateSudoku(int[][] solutiongrid){                
        final int[][] rowarray = solutiongrid;
        final int[][] columnarray = transpose(solutiongrid);
        
        //Check all rows and columns for dupes
        for(int i=0;i<solutiongrid.length;i++){                                                
            if(checkDuplicates(rowarray[i]) || checkDuplicates(columnarray[i]))
                return solutioninvalid;
        }
        
        
        //Check the sub squares
        if(!checkSubGrids(solutiongrid))
            return solutioninvalid;
        
        return solutionvalid;
    }            
    
    //I check if the row is valid
    public boolean checkSubGrids(int[][] solutiongrid){                        
        //Number of subgrids
        final int numgrids = solutiongrid.length;
        final int squareroot = (int)Math.sqrt(numgrids);
        
        for (int i = 0; i < solutiongrid.length; i += squareroot){           
            for (int j = 0; j < solutiongrid[i].length; j += squareroot){
                // creating N subgrids                
                int[][] newArray = new int[squareroot][squareroot];
                int newRow = 0;
                for (int k = i; k < (i + squareroot); k++){
                    int newColumn = 0;
                    for (int l = j; l < (j + squareroot); l++){                        
                        newArray[newRow][newColumn] = solutiongrid[k][l];
                        newColumn++;                        
                    }
                    newRow++;
                }
                if(checkDuplicates(newArray))
                    return false;
            }
        }
        
        return true;
    }
    
    //I check duplicates in the 1D array
    private boolean checkDuplicates(final int[] inputarray){
        Set<Integer> cells = new HashSet<Integer>();
        for (int i : inputarray){
            if (cells.contains(i) || (i < 1 || i > inputarray.length)) return true;
            cells.add(i);
        }
        return false;
    }
    
    //I check duplicates in 2d arrays
    private boolean checkDuplicates(final int[][] inputarray){
        Set<Integer> cells = new HashSet<Integer>();
        for (int[] i : inputarray){
            for(int values : i){
                if (cells.contains(values) || (values < 1 || values > (inputarray.length*inputarray.length))) return true;
                cells.add(values);
            }
        }
        return false;
    }
    
    //I transpose the array
    private int[][] transpose(int [][] inputarray){
        int x = inputarray.length;
        int y = inputarray[x - 1].length;
        int [][] transposedarray = new int[y][x];
        for(int i = 0; i < x; ++i){
           for(int j = 0; j < y; ++j){
              transposedarray[j][i] = inputarray[i][j];
           }
        }
        return transposedarray;
    }            
}