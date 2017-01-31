//// Made by Ben Shanahan

public class Coder
{
  private final String NEW_LINE = System.getProperty("line.separator");
  private final char FUNKY = '¨';
  private String word;
  private double key;
  private double m = 7.35997233;
  private double q = 19.6623979;
  private double p = 3.66128857;
  private int length;
  private String realAlphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+-=~`[]{}|;':,./<>? ";
  private String codeAlphabet = "";
  private int max = 400;
  
  public Coder (String w, double k)
  {
    word = w;
    key  = k;
    length = w.length();
    codeAlphabet = makeCodeAlphabet();
  }
  
  public Coder (String w, int k)
  {
    word = w;
    key  = (double)k;
    length = w.length();
    codeAlphabet = makeCodeAlphabet();
  }
  
  
  
  ////////////////////////
  //// PUBLIC METHODS ////
  ////////////////////////
  
  public void setKey (double k)
  {
    key  = (double)k;
    length = word.length();
    codeAlphabet = makeCodeAlphabet();
  }
  
  public void setKey (int k)
  {
    key  = (double)k;
    length = word.length();
    codeAlphabet = makeCodeAlphabet();
  }
  
  public void setWord (String w)
  {
    word = w;
    length = word.length();
    codeAlphabet = makeCodeAlphabet();
  }
  
  public String encode ()
  {
    return doEncode ();
  }
  
  public String decode ()
  {
    return doDecode ();
  }
  
  public String getWord ()
  {
    return word;
  }
  
  public String toString ()
  {
    return word;
  }
  
  
  
  
  /////////////////////
  // PRIVATE METHODS //
  /////////////////////
  
  private String doEncode ()
  {
    String newWord = "";
    
    for (int i = 0; i < word.length(); i++)
    {
      for (int j = 0; j < codeAlphabet.length(); j++)
      {
        if (word.charAt(i) == realAlphabet.charAt(j))
        {
          newWord = newWord + codeAlphabet.charAt(j);
        }
      }
      if (word.charAt(i) == '\n' && word.charAt(i + 1) == '\r' || word.charAt(i) == '\n')
      {
        i++;
        newWord = newWord + FUNKY;
      }
    }
    return newWord;
  }
  
  private String doDecode ()
  {
    String newWord = "";
    for (int i = 0; i < word.length(); i++)
    {
      for (int j = 0; j < codeAlphabet.length(); j++)
      {
        if (word.charAt(i) == codeAlphabet.charAt(j))
        {
          newWord = newWord + realAlphabet.charAt(j);
        }
      }
      if (word.charAt(i) == FUNKY)
      {
        newWord = newWord + NEW_LINE;
      }
    }
    return newWord;
  }
  
  private String makeCodeAlphabet ()
  {
    int l = length;
    int offset = 0;
    // make some seemingly random keys from the one entered 
    // dependent on the inputted string length
    for (int i = max; l < i; i--)
    {
      offset = l * (int)(l * q / p * key);
    }
    offset = offset % realAlphabet.length();
    return realAlphabet.substring(offset) + realAlphabet.substring(0, offset);
  }
}