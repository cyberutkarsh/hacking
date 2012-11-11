package sudokulint;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author Utkarsh C
 * Basic files utilities
 */
public class SudokuFileUtils {            
    final File folder;
    final FilenameFilter filter= new FilenameFilter() {

        @Override
        public boolean accept(File folder, String filename) {
            return filename.endsWith(".txt"); //list only the .txt files
        }
    };
    
    /**
     * Constructor: Define folder
     */
    SudokuFileUtils(){
        folder = new File("inputs");        
    }
    
    /**
     * I put all files in the folder in a map
     * @return hashmap of files names,paths
     */
    public HashMap<String,String> listFilesInFolder() {
        HashMap hmFiles= new HashMap();        
        for (final File fileEntry : folder.listFiles(filter)) {
            hmFiles.put(fileEntry.getName(),fileEntry.getPath());
        }
        
        return hmFiles;
    } 
    
    /**
     * I read files into 2D arrays
     * @param filename
     * @return 2D array
     * @throws IOException 
     */
    public int[][] readFiletoArray(String filename) throws IOException{                                        
        
        String line;
        int x=0,lines=0;
        int[][] inputgrid=null; //Empty grid
        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new FileReader(filename));
            reader.mark(10000); //Mark the stream to reset later
            
            while (reader.readLine() != null) lines++; //counting the rows which is =  columns
                       
            inputgrid = new int[lines][lines]; //now that we know the dimensions re-intialize it            
            
            /*Reset the reader to the start postion to now read the columns, 
             * should not be too much of an overhead as files size is low
            */
            reader.reset();
            
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
        }catch(Exception e) {            
            return null;
        }finally{
            if(reader!=null)
                reader.close();
        }	
        
        return inputgrid;
    }
    
}
