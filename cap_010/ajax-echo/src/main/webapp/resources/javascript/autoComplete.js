
if (!com) var com = {}

if ( !com.corejsf2 ) 
{
	    var focusLostTimeout;
	    
	    com.corejsf2 = {  	    
	      errorHandler: function(data) { alert("Error occurred during Ajax call: " + data.description) }
	      ,
	      
	      updateCompletionItems: function(input, event) {
        	console.log("updCompItem");
	    	var keystrokeTimeout;
	    	
	    	jsf.ajax.addOnError( com.corejsf2.errorHandler );
	    	
	    	var ajaxRequest = function()
	    	{
	    		jsf.ajax.request( input, event, 
	    		{ 
	    			render : com.corejsf2.getListboxId(input),
	    			     x : Element.cumulativeOffset(input)[0],
	    			     y : Element.cumulativeOffset(input)[1] + Element.getHeight(input)
	    			
	    		});
	    	}
	    	
	    	window.clearTimeout( keystrokeTimeout );
	    	keystrokeTimeout = window.setTimeout( ajaxRequest, 350 );
	     },
	     
	     inputLostFocus : function(input){
	        var hideListbox = function(){
	          //Element.hide( getListboxId( input ))
	          document.getElementById( com.corejsf2.getListboxId( input ) ).style.display = 'none';
	        };
	        
	        focusLostTimeout = window.setTimeout( hideListbox, 1000 );
	      },

	      getListboxId : function( input ){
	          var clientId = new String( input.name );
	          var lastIndex = clientId.lastIndexOf(":");
	          
	          return clientId.substring( 0, lastIndex ) + ":listbox";
	      }
	        
	     }
}