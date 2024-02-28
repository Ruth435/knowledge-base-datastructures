//Ruth-ann Rudolph RDLRUT001
//25/02/2024
//CSC2001F Assignment 1

/**
* Class to store the key phrase, factual statement and confidence level
* 
*/
public class Facts
{
   private String key;
   private String info;
   private double confidence;
   
/**
* empty constructor sets the values to blank or zero
*/
   public Facts()
   {
      info = "";
      key = "";
      confidence = 0;
   }
   
/**
* constructor takes in the key phrase, factual statement and confidence level
*/
   public Facts(String k, String in, double c)
   {
      key = k;
      info = in;
      confidence = c;
   }
   
/**
* returns the key value phrase
*/
   public String getKey()
   {
      return key;
   }

/**
* returns the factual stement
*/
   public String getInfo()
   {
      return info;
   }
   
/**
* returns the confidencee level
*/
   public double getConfidence()
   {
      return confidence;
   }

/**
* changes the factual statement 
*/
   public void setInfo(String in)
   {
      info = in;
   }
   
/**
* changes the confidence level
*/
   public void setConfidence(double c)
   {
      confidence = c;
   }

/**
* changes the factual statement and confidence level associated with the key phrase
*/
   public void update(String in, double c)
   {
      setInfo(in);
      setConfidence(c);
   }
}