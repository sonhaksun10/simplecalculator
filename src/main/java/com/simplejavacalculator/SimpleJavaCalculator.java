/**
 * @name        Simple Java Calculator
 * @file        SimpleJavaCalculator.java
 * @author      SORIA Pierre-Henry
 * @copyright   Copyright Pierre-Henry SORIA, All Rights Reserved.
 * @license     Apache (http://www.apache.org/licenses/LICENSE-2.0)
 */

package com.simplejavacalculator;

/*This class contains main function*/
public class SimpleJavaCalculator {
   
   public static void main(String[] args) {
      try {
         UI uiCal = new UI();
         uiCal.init();
      }
      //print error message when error occurred
      catch (Exception e) {
         System.out.println(e.getMessage());   
      }
      
   }
}
