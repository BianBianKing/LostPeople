package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class test {
 public static void main(String[] args) {
  try { 
   System.out.println("start");
   String image1 = "C:/Users/bbk/Desktop/FaceCompare_sdk/tx1.png";
   String image2 = "C:/Users/bbk/Desktop/FaceCompare_sdk/tx2.png";
   String cammond = "C:/Python27/python C:/Users/bbk/Desktop/FaceCompare_sdk/find_kid.py "+image1+" "+image2+" 0";
   
   Process pr = Runtime.getRuntime().exec(cammond);
   BufferedReader in = new BufferedReader(new InputStreamReader(
     pr.getInputStream()));
   String line;
   pr.waitFor();
   line = in.readLine();
	Double temp = Double.parseDouble(line);
	System.out.println(temp);
  
   System.out.println("end");
   in.close();
  } catch (Exception e) {
   e.printStackTrace();
  }
 }
}