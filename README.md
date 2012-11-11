Program: Sudoku Lint
====================
Author: Utkarsh C
-----------------
Sudoku Lint accepts a possible Sudoku Plus solution and evaluates whether or not it is a valid solution. 
Input should be in the form of a CSV (comma-separated value) text file with columns separated by commas 
and rows separated by ‘\n’ return characters. All input files should be placed in the "inputs" directory 
in the same folder as the SudokuLint.jar file. Example input files representing the examples are present 
in the zip archive that contains the program jar.

How To Run:
-------
1. Unzip the contents of the SudokuLint_Utkarshc.zip into its folder
2. Navigate to the folder where the files were unzipped
3. use "java -jar SudokuLint.jar"command to execute the program
4. You will see 3 options, please find below their usage
    Option 1: Validate Sudoku's: This option will validate all the probable Sudoku solutions provided in the .txt format in the "inputs" folder.
    Option 2: This doubles as a test script and a fucntion to calculate the execution times for a number of Sudoku's with N(length of the side)
              ranging from (2^2) - (30^2). The generateSudoku() fucntions creates root solutions i.e.valid NxN Sudoku's and the validateSudoku 
              tests its validity and eventually the checkExecutionTime() gives the run times for  the program.
    Option 3: This is to exit the Sudoku Lint program, it will run indefinitely waiting on user input unless exited by option 3            
5. You can add your own Sudoku plus solutions to validate against the program (Option 1) , but please note the input files must be placed in the 
"inputs" directory in the same folder as the SudokuLint.jar file and they should be in the form of a CSV (comma-separated value) text file with 
columns separated by commas and rows separated by ‘\n’ return characters. Sample input below:
1,4,2,3  
2,3,1,4  
4,2,3,1  
3,1,4,2  

Package Contents:
----------------
1. SudokuLint.jar - This is the main program.
2. 'inputs' directory -  This is the directory that contains the input proposed Sudoku solutions in .txt file format.
3. README.TXT - Instruction manual
4. TimeComplexity.xlsx - Spreadsheet containing data and chart showing the running time of the program when N(length of side) tends towards infinity.


Additional References:
----------------------
You can find the full source code for the program @ my [Sudoku Lint](https://github.com/cyberutkarsh/hacking "SudokuLint") GitHub repo.
