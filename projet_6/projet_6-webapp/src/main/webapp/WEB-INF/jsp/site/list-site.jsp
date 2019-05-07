<s:include value="../_include/prelude.jsp" />
<html>
<head>
	<s:include value="../_include/head.jsp" />
</head>
<body>
	<s:include value="../_include/body_header.jsp" />
	
	<h2>Liste des sites :</h2>
	
	
	
		<!-- =========================== Formulaire de sélection des critères de recherche ===========================-->
		
		<s:form action="site_list">
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
                 
                 
                 
   	<!-- =========================== Si aucun site => Affiche message 'aucun site' ===========================-->
   
	<s:if test="listSite.isEmpty">
		<p>Aucun site ne correspond aux critères de recherche saisi.</p>
	</s:if>
	
	
	
	 <!-- =========================== Sinon => Affiche la liste des sites avec un lien vers leur fiche (site.jsp) ===========================-->
	 
	<s:else>
		<ul>
	        <s:iterator value="listSite">
	            <li>
	            	<s:a action="site_detail">
	       	    		<s:param name="idSite" value="idSite" />
	            		<p><s:property value="nom" /><p>
	            	</s:a>
	            </li>
	        </s:iterator>
	    </ul>
    </s:else>
		
		
	
	<s:include value="../_include/body_footer.jsp" />
</body>
</html>