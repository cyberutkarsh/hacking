package sudokulint;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author Utkarsh C
 */
public class SudokuFileUtils {            
    final File folder;
            
    SudokuFileUtils(){
        folder = new File("inputs");        
    }
    
    //I return all files in the directory
    public HashMap<String,String> listFilesInFolder() {
        HashMap hmFiles= new HashMap();        
        for (final File fileEntry : folder.listFiles()) {
            hmFiles.put(fileEntry.getName(),fileEntry.getPath());
        }
        
        return hmFiles;
    } 
    
    //I read files into arrays
    public int[][] readFiletoArray(String filename){                                        
        
        String line;
        int x=0,lines=0;
        int[][] inputgrid=null; //Empty grid    
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            reader.mark(1000); //Mark the stream to reset later
            
            while (reader.readLine() != null) lines++; //counting the rows which is =  columns
                       
            inputgrid = new int[lines][lines]; //now that we know the dimensions re-intialize it            
            
            reader.reset(); //Reset the reader to the start postion
            
            while ((line = reader.readLine()) != null){
               String[] values = line.split(",");
               int y=0;
               for (String str : values){
                  int cellvalue = Integer.parseInt(str);
                  inputgrid[x][y]=cellvalue;
                  //System.out.print(inputgrid[x][y] + " "); //debug
                  y=y+1;
               }
               x=x+1;
               //System.out.println(""); // debug
            }            
            reader.close();
        }catch(IOException ioException ) {
            System.out.println(ioException.getMessage());
        }	
        
        return inputgrid;
    }
    
}
