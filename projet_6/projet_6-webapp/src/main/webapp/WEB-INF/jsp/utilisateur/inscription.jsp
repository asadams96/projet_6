<s:include value="../_include/prelude.jsp" />
<html>
<head>
	<s:include value="../_include/head.jsp" />
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
		        	<div class="card-body">
		        	 	<h2 class="card-title text-center">Inscription</h2>
		        	 	<br>
		        	 	
							<!-- ================================= Formulaire d'inscription ================================= -->
							<s:form value="inscription">
								<s:textfield class="custom-switch" labelposition="top" name="mail" type="email" label="Adresse mail" requiredLabel="true" maxlength="50" />
								<s:textfield class="custom-switch" labelposition="top" name="pseudo" label="Pseudo" requiredLabel="true" maxlength="20" />
								<s:textfield class="custom-switch" labelposition="top" name="civilite" label="Civilite" requiredLabel="true" maxlength="10" />
								<s:textfield class="custom-switch" labelposition="top" name="nom" label="Nom" requiredLabel="true" maxlength="30" />
								<s:textfield class="custom-switch" labelposition="top" name="prenom" label="Prenom" requiredLabel="true" maxlength="30" />
								
								<s:select name="localisation" label="Localisation" class="custom-select"  labelposition="top"
						                  list="resourcesBundle.listLocalisation"
						                  emptyOption="true"
						                  requiredLabel="true"/>
						                  
						       	<s:password class="custom-switch" labelposition="top" name="pass" label="Mot de passe" requiredLabel="true" maxlength="30" />
								<s:password class="custom-switch" labelposition="top" name="passBis" label="Retaper le mot de passe" requiredLabel="true" maxlength="30" />
							
								<s:submit class="btn-success form-check-inline" value="S'inscrire"/>
								
							</s:form>
							
					</div>
				</div>
				<br><br>
			</div>
			<!-- /.my-5 -->
    </div>
    <!-- /.row -->
  </div>
  <!-- /.container -->
	
	
	
	<s:include value="../_include/body_footer.jsp" />
</body>
</html>