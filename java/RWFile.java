/**
 * RWFile Class
 * made by Ben Shanahan
 * 
 * Use:
 *   Constructor
 *    RWFile (String textToWrite, String filePath)
 */

import java.io.*;
import java.util.*;

public class RWFile
{
  private final String NEW_LINE = System.getProperty("line.separator");
  private String textToWrite = "";
  private String filePath = "";
  private ArrayList<String> code = new ArrayList<String>();
  
  public RWFile (String txt, String pathOfFile)
  {
    filePath = pathOfFile;
    textToWrite = txt;
  }
  
  public RWFile ()
  {
    // empty constructor
    // use setText() and setPath() methods to configure class
  }
  
  
  
  ////////////////////
  // PUBLIC METHODS //
  ////////////////////
  
  public void setText (String txt)
  {
    textToWrite = txt;
    System.out.println("Text set to \"" + textToWrite + "\".");
  }
  
  public void setPath (String pathOfFile)
  {
    filePath = pathOfFile;
    System.out.println("Path set to " + filePath + ".");
  }
  
  public void write ()
  {
    if (textToWrite.length() == 0)
    {
      if (filePath.length() == 0)
      {
        throw new Error ("A file path / name must be set.");
      }
      throw new Error ("No text to write to file.");
    }
    writeTextFile (textToWrite, filePath);
    System.out.println("File written.");
  }
  
  public void write (String txt)
  {
    textToWrite = txt;
    write ();
  }
  
  public void write (String txt, String pathOfFile)
  {
    textToWrite = txt;
    filePath = pathOfFile;
    write ();
  }
  
  public ArrayList<String> read ()
  {
    // file is read into an ArrayList
    // note - each new line of the textfile is it's own index in the ArrayList
    return readTextFile (filePath);
  }
  
  
  
  /////////////////////
  // PRIVATE METHODS //
  /////////////////////
  
  private void writeTextFile (String contents, String fullPathFilename)
  {
    try
    {
      BufferedWriter writer = new BufferedWriter(new FileWriter(fullPathFilename));
      writer.write(contents);
      writer.flush();
      writer.close(); 
    }
    catch (IOException e)
    {
      throw new Error (e);
    }
  }
  
  private ArrayList<String> readTextFile (String fullPathFilename)
  {
    try
    {
      String str;
      BufferedReader in = new BufferedReader(new FileReader(fullPathFilename));
      while ((str = in.readLine()) != null)
      {
        code.add(str);
      }
      in.close();
      return code;
    }
    catch (IOException e)
    {
      throw new Error (e);
    }
  }
}