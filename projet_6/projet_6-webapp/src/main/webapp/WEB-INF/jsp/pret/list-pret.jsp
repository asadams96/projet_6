<s:include value="../_include/prelude.jsp" />
<html>
<head>
	<s:include value="../_include/head.jsp" />
</head>
<body>
	<s:include value="../_include/body_header.jsp" />
	
	
	
	<!-- =========================== Formulaire de sélection des critères de recherche ===========================-->
		
	<s:form action="pret_list">
	
		<s:hidden name="type" value="%{ type }"/>
		<s:select name="etat" label="Filtrer par état"
                  list="resourcesBundle.listEtatPret"
                  emptyOption="true"
                  requiredLabel="true"/>
                                    
    	<s:submit value="Filter"/>
    </s:form>
	
	
	
	<!-- =========================== Si l'utilisateur possede des prêts, les affiche avec un lien vers fiche ===========================  -->
	<s:if test="listPret.isEmpty || listPret == null">
		<p>Vous n'avez pas aucun <s:property value="%{ type }"/> <s:property value="%{ etat.toLowerCase }"/></p>
	</s:if>
	<s:iterator value="listPret">
		<s:a action="pret_detail">
		
		<s:param name="type" value="%{ type }"/>
		<s:param name="idPret" value="%{ idPret }"/>
		
			<s:if test="%{ type == getText('pret.type1')}">
				<s:property value="date"/> --- <s:property value="utilisateur.pseudo"/> --- <s:property value="topo.titre"/> --- <s:property value="etat"/>
			</s:if>
			
			<s:if test="%{ type == getText('pret.type2')}">
				<s:property value="date"/> --- <s:property value="proprietaire.pseudo"/> --- <s:property value="topo.titre"/> --- <s:property value="etat"/>
			</s:if>
			
		</s:a>
	</s:iterator>
	
	
	
	<s:include value="../_include/body_footer.jsp" />
</body>
</html>