
$(document).ready(function (){   
   $("#Lookup").click(dict.findDict);
});

var dict = (function(){    
   
   function successFunction(data){
        $("#txt").html("");
       if (data !== ""){
           $(data).each(function(ind, itm){
               $("#txt").append("<p>" + (ind+1) + "(" + itm.wordtype + ") :: " + itm.definition  + "</p>");
           });
       }else{
           $("#txt").html("not found any data...");
       }
   }
   
   function errorFunction(){
       $("#txt").html("Error, try again later...");
   }
   
   return{
       findDict: function (){        
            var sWord = document.getElementById("searchText").value;            
            $.ajax({
                url: "findDefinition",
                type: "POST",
                data: {
                    word: sWord
                },
            success: successFunction,
            error: errorFunction
        }); 
   }
   };
   })();