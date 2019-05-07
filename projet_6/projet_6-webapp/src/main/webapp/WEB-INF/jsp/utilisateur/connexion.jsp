<s:include value="../_include/prelude.jsp" />
<html>
<head>
	<s:include value="../_include/head.jsp" />
</head>
<body>
	<s:include value="../_include/body_header.jsp" />
	
	
	<!-- ================================= Formulaire de connexion ================================= -->
	
	
	
	<s:form value="login" >
		<s:textfield name="mail" type="email" label="Adresse mail" requiredLabel="true" maxlength="50" />
		<s:password name="pass" label="Mot de passe" requiredLabel="true" maxlength="30" />
		
		<s:submit value="Se connecter"/>
	</s:form>
		
	
	<s:include value="../_include/body_footer.jsp" />
</body>
</html>