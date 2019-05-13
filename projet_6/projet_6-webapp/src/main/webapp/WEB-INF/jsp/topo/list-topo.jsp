<s:include value="../_include/prelude.jsp" />
<html>
<head>
	<s:include value="../_include/head.jsp" />
</head>
<body>
	<s:include value="../_include/body_header.jsp" />
		

	
		<!-- =========================== Formulaire de sélection des critères de recherche ===========================-->
		
	<s:form action="topo_list">
		<s:select name="criteresType" label="Type" id="type"
                  list="resourcesBundle.listType"
                  emptyOption="true"
                  requiredLabel="true"/>
                  
       	<s:select name="criteresOrientation" label="Orientation"
                  list="resourcesBundle.listOrientation"
                  emptyOption="true"
                  requiredLabel="true"/>
                  
       	<s:select name="criteresLocalisation" label="Localisation"
                  list="resourcesBundle.listLocalisation"
                  emptyOption="true"
                  requiredLabel="true"/> 
                  
        <s:submit value="Rechercher"/>
       </s:form>       
                 
                 
                 
   <!-- =========================== Si aucun topo => Affiche message 'aucun topo' ===========================-->
   
	<s:if test="listTopo.isEmpty">
		<p>Aucun topo ne correspond aux critères de recherche saisi.</p>
	</s:if>
	
	
	
	 <!-- =========================== Sinon => Affiche la liste des topos avec un lien vers leur fiche (topo.jsp) ===========================-->
	 
	<s:else>
		<ul>
	        <s:iterator value="listTopo">
	            <li>
	            	<s:a action="topo_detail">
	       	    		<s:param name="idTopo" value="idTopo" />
	            		<p><s:property value="titre" /><p>
	            	</s:a>
	            </li>
	        </s:iterator>
	    </ul>
    </s:else>
    
	
	
	<s:include value="../_include/body_footer.jsp" />
</body>
</html>