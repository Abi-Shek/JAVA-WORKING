// ========================================================================
 ///============================================================================
package com.instagram.scrapper;

import com.instagram.grabber.Grabber;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class InstagramScrapper {

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("InstaGram Scrapping");
        System.out.println("************************************");
        System.out.println("FOR EDUCATIONAL PROPOSE ONLY");
        System.out.println("**********************************");
        String baseurl="https://www.instagram.com/";
        
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the instagram  profile username  ");
        String link=input.next();
        try{
        
      String box=  Grabber.grab(baseurl + link);
            System.out.println(box);
            String regEx="https://(.*?).jpg";
            Pattern pattern= Pattern.compile(regEx);
            Matcher matcher= pattern.matcher(box);
            while(matcher.find()){
//                System.out.println(matcher.group(0));
           
            String imgPath = matcher.group(0);
            String path= (imgPath);
            String[] tokens = path.split("/");
            File file = new File("E:/instapic");
            if(!file.isDirectory()){
                file.mkdir();
                      }
            File file1=new File("E:/instapic/" + link);
            if(!file.isDirectory()){
                file.mkdir();
            }
                System.out.println("Downloading..............." + link);
                Grabber.downloadImage(path, "E:/instapic/" + link + tokens[tokens.length-1]);
            }
            System.out.println("The Download image is stored in  "+ link);
        }catch(IOException ioe){
      System.out.println(ioe.getMessage());
        }
        
        
        
        
        
        
        
    }
    
}
//=================================================================================
//============================================================================================
