package com.corejsf;

import javax.faces.component.UIComponent;

import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter( "com.corejsf.Card" )
public class CreditCardConverter implements Converter 
{
    private String separator;
    
    
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException 
	{
		if ( value == null ) return null;
		
		StringBuilder builder = new StringBuilder( value );
		int i = 0;
		
		while( i<builder.length() ) 
		{	    
			if ( Character.isDigit( builder.charAt(i) ) )
				i++;
			else 
				builder.deleteCharAt(i);
		}
		
		return new CreditCard( builder.toString() );
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) 
	{
		// comprimento 13 : xxxx xxx xxx xxx
		// comprimento 14 : xxxxx xxxx xxxxx
		// comprimento 15 : xxxx xxxxxx xxxxx
		// comprimento 16 : xxxx xxxx xxxx xxxx
		// comprimento 22 : xxxxxx xxxxxxxx xxxxxxxx

		if ( !( value instanceof CreditCard ) )
			throw new ConverterException();
		
		String v = ( ( CreditCard ) value).toString();
		String sep = this.separator;
		
		if ( sep == null) sep = " ";
		
		int[] boundaries = null;
		
		int length = v.length();
		
		if ( length == 13 ) {
			boundaries = new int[] { 4, 7, 10 };
		}else if ( length == 14 ) {
			boundaries = new int[] { 5, 9 };
		}else if ( length == 15 ) {
			boundaries = new int[] { 4, 10 };
		}else if ( length == 16 ) {
			boundaries = new int[] { 4, 8, 12 };
		}else if ( length == 22 ) {
			boundaries = new int[] { 6, 14 };
		}else
			return v;
		
		StringBuilder result = new StringBuilder();
		
		int start = 0;
		
		for( int i = 0; i< boundaries.length ; i++ ) {
			int end = boundaries[i];
			result.append( v.substring(start, end) );
			result.append( sep );
			start = end;
		}
		
		result.append(v.substring(start));
		return result.toString();
	}

	public String getSeparator() {
		return separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}
	
	

}
