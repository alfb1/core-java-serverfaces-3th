package com.corejsf;

import java.io.Serializable;

public class CreditCard implements Serializable 
{
   /**
	 * 
	 */
   private static final long serialVersionUID = -8674433002390231097L;
   private String number;
   
   public CreditCard(String number) {
	   this.number = number;
   }
   
   public String toString() {
	   return this.number;
   }
}
