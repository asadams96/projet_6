<s:include value="../_include/prelude.jsp" />
<html>
<head>
	<s:include value="../_include/head.jsp" />
</head>
<body>
	<s:include value="../_include/body_header.jsp" />
	
	
	
	<!-- ================================= Formulaire d'inscription ================================= -->
	
	
	
	<s:form value="inscription">
		<s:textfield name="mail" type="email" label="Adresse mail" requiredLabel="true" maxlength="50" />
		<s:textfield name="pseudo" label="Pseudo" requiredLabel="true" maxlength="20" />
		<s:textfield name="civilite" label="civilite" requiredLabel="true" maxlength="10" />
		<s:textfield name="nom" label="nom" requiredLabel="true" maxlength="30" />
		<s:textfield name="prenom" label="prenom" requiredLabel="true" maxlength="30" />
		
		<s:select name="localisation" label="Localisation"
                  list="resourcesBundle.listLocalisation"
                  emptyOption="true"
                  requiredLabel="true"/>
                  
       	<s:password name="pass" label="Mot de passe" requiredLabel="true" maxlength="30" />
		<s:password name="passBis" label="Retaper le mot de passe" requiredLabel="true" maxlength="30" />
	
		<s:submit value="S'inscrire"/>
		
	</s:form>
		
	
	
	<s:include value="../_include/body_footer.jsp" />
</body>
</html>