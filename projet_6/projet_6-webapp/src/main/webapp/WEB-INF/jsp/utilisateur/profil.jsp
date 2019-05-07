<s:include value="../_include/prelude.jsp" />
<html>
<head>
	<s:include value="../_include/head.jsp" />
	
	<script lang='javascript'>
		function Confirmer(str) {
			if (confirm("Voulez-vous vraiment modifier votre "+str+" ?")) {
					return true;
			}
			else {
				return false;
			}
		}
	</script>
</head>
<body>
	<s:include value="../_include/body_header.jsp" />
	
	
	<!-- ================================= Présentation de l'utilisateur ================================= -->
	<h2>
		<s:property value="utilisateur.civilite" />
		<s:property value="utilisateur.nom" />
		<s:property value="utilisateur.prenom" />
	</h2>
	
	
	
	<!--  ================================================ Affichage de l'adresse mail de l'utilisateur =============================================== -->
	
	<h3><s:property value="utilisateur.mail" /></h3>
	
	<!-- Si l'utilisateur en session correspond au profil de l'utilisateur => Permettre la modification de l'adresse mail -->
	<p>	
		<s:if test="#session.utilisateur.idUtilisateur == utilisateur.idUtilisateur">
			<s:form action="modify_mail" >
			
				<s:textfield name="mail" type="email" maxlength="50" />
				<s:hidden name="idUtilisateur" value="%{ #session.utilisateur.idUtilisateur }"/>
						  
				<s:submit type="input" value="Modifier l'adresse mail" onclick="return Confirmer('adresse mail')"/>
			</s:form>
		</s:if>
	</p>
	
	
	
	<!--  ================================================ Affichage du pseudo de l'utilisateur =============================================== -->
	
	<h3><s:property value="utilisateur.pseudo" /></h3>
	
	<!-- Si l'utilisateur en session correspond au profil de l'utilisateur => Permettre la modification du pseudo -->
	<p>
		<s:if test="#session.utilisateur.idUtilisateur == utilisateur.idUtilisateur">
			<s:form action="modify_pseudo" >
			
				<s:textfield name="pseudo" maxlength="20" />
				<s:hidden name="idUtilisateur" value="%{ #session.utilisateur.idUtilisateur }"/>
			
				<s:submit type="input" value="Modifier le pseudo" onclick="return Confirmer('pseudo')"/>
			</s:form>
		</s:if>
	</p>
	
	
	
	<!--  ================================================ Affichage de la localisation de l'utilisateur =============================================== -->
	
	<h3><s:property value="utilisateur.localisation" /></h3>
		
	<!-- Si l'utilisateur en session correspond au profil de l'utilisateur => Permettre la modification de la localisation -->
	<p>
		<s:if test="#session.utilisateur.idUtilisateur == utilisateur.idUtilisateur">
			<s:form action="modify_localisation" >
			
				<s:select name="localisation"
	                  	  list="resourcesBundle.listLocalisation"
	                	  emptyOption="true"
						  requiredLabel="true" />
				<s:hidden name="idUtilisateur" value="%{ #session.utilisateur.idUtilisateur }"/>
						  
				<s:submit type="input" value="Modifier la localisation" onclick="return Confirmer('localisation')"/>
			</s:form>
		</s:if>
	</p>
	
	
	
	<!-- Si l'utilisateur en session correspond au profil de l'utilisateur => Permettre la modification du mot de passe -->
	<p>
		<s:if test="#session.utilisateur.idUtilisateur == utilisateur.idUtilisateur">
			<s:form action="modify_pass" >
			
				<s:password name="pass"  maxlength="30" />
				<s:password name="passBis" maxlength="30" />
				<s:hidden name="idUtilisateur" value="%{ #session.utilisateur.idUtilisateur }"/>
						  
				<s:submit type="input" value="Modifier le mot de passe"  onclick="return Confirmer('mot de passe')"/>
			</s:form>
		</s:if>
	</p>
		
		
		
	<s:include value="../_include/body_footer.jsp" />
</body>
</html>