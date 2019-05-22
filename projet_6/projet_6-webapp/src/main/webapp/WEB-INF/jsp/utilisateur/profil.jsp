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
	
	
	
	 <!-- Page Content -->
  <div class="container">
    <div class="row">
    
    	<div class="col-lg-4">
    		<p></p>
    	</div>
    	<!-- /.col-lg-3 -->
    	
			<div class="my-5">
	
		        <div class="card mt-4">
		
		          	<!-- ================================= Présentation de l'utilisateur ================================= -->
		          	<div class="card-body">
			            <h2 class="card-title text-center"><s:property value="utilisateur.civilite" />. <s:property value="utilisateur.nom" /> <s:property value="utilisateur.prenom" /></h2>
			            
			            
			            
			            <!--  ================================================ Affichage de l'adresse mail de l'utilisateur =============================================== -->
			            <hr>
			            <h5>Adresse mail : <s:property value="utilisateur.mail" /></h5>
			            
			            <!-- Si l'utilisateur en session correspond au profil de l'utilisateur => Permettre la modification de l'adresse mail -->
						<p>	
							<s:if test="#session.utilisateur.idUtilisateur == utilisateur.idUtilisateur">
								<s:form action="modify_mail" >
								
									<s:textfield class="custom-switch" name="mail" type="email" maxlength="50" />
									<s:hidden name="idUtilisateur" value="%{ #session.utilisateur.idUtilisateur }"/>
											  
									<s:submit class="btn-success form-check" type="input" value="Modifier l'adresse mail" onclick="return Confirmer('adresse mail')"/>
								</s:form>
							</s:if>
						</p>
			            
			            
			            
						<!--  ================================================ Affichage du pseudo de l'utilisateur =============================================== -->
			            <hr>
			            <h5>Pseudo : <s:property value="utilisateur.pseudo" /></h5>
			            
			            <!-- Si l'utilisateur en session correspond au profil de l'utilisateur => Permettre la modification du pseudo -->
						<p>
							<s:if test="#session.utilisateur.idUtilisateur == utilisateur.idUtilisateur">
								<s:form action="modify_pseudo" >
								
									<s:textfield class="custom-switch" name="pseudo" maxlength="20" />
									<s:hidden name="idUtilisateur" value="%{ #session.utilisateur.idUtilisateur }"/>
								
									<s:submit class="btn-success form-check" type="input" value="Modifier le pseudo" onclick="return Confirmer('pseudo')"/>
								</s:form>
							</s:if>
						</p>
		
		
		
						<!--  ================================================ Affichage de la localisation de l'utilisateur =============================================== -->
			            <hr>	
			            <h5>Localisation : <s:property value="utilisateur.localisation" /></h5>
			            
			            <!-- Si l'utilisateur en session correspond au profil de l'utilisateur => Permettre la modification de la localisation -->
						<p>
							<s:if test="#session.utilisateur.idUtilisateur == utilisateur.idUtilisateur">
								<s:form action="modify_localisation" >
								
									<s:select name="localisation" class="custom-select" 
						                  	  list="resourcesBundle.listLocalisation"
						                	  emptyOption="true"
											  requiredLabel="true" />
									<s:hidden name="idUtilisateur" value="%{ #session.utilisateur.idUtilisateur }"/>
											  
									<s:submit class="btn-success form-check" type="input" value="Modifier la localisation" onclick="return Confirmer('localisation')"/>
								</s:form>
							</s:if>
						</p>
						
						
						
						<!--  ================================================ Affichage 'Mot de passe' =============================================== -->
						<!-- Si l'utilisateur en session correspond au profil de l'utilisateur => Permettre la modification du mot de passe -->
						<p>
							<s:if test="#session.utilisateur.idUtilisateur == utilisateur.idUtilisateur">
								<hr>	
			            		<h5>Mot de passe</h5>
			            		
								<s:form action="modify_pass" >
								
									<s:password class="custom-switch" name="pass"  maxlength="30" />
									<s:password class="custom-switch" name="passBis" maxlength="30" />
									<s:hidden name="idUtilisateur" value="%{ #session.utilisateur.idUtilisateur }"/>
											  
									<s:submit class="btn-success form-check" type="input" value="Modifier le mot de passe"  onclick="return Confirmer('mot de passe')"/>
								</s:form>
							</s:if>
						</p>
						
			         </div>
		        </div>
		        <!-- /.card -->
			<br><br>
			<s:if test="#session.utilisateur.idUtilisateur != utilisateur.idUtilisateur"> 
				<br><br><br><br><br><br><br><br><br><br><br><br><br>
			</s:if> 
			<s:if test="#session.utilisateur == null"> 
				<br><br><br><br><br><br><br><br><br><br><br><br><br>
			</s:if>
			</div>
			<!-- /.my-5 -->
    </div>
    <!-- /.row -->
  </div>
  <!-- /.container -->
  
		
	<s:include value="../_include/body_footer.jsp" />
</body>
</html>