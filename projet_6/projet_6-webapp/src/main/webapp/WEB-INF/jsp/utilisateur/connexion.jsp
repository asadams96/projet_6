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
		        	 	<h2 class="card-title text-center">Connexion</h2>
						<br>
						<!-- ================================= Formulaire de connexion ================================= -->
						<s:form value="login" >
							<s:textfield class="custom-switch" labelposition="top" name="mailBis" type="email" label="Adresse mail" requiredLabel="true" maxlength="50"/>
							<s:password class="custom-switch" labelposition="top" name="passTer" label="Mot de passe" requiredLabel="true" maxlength="30"/>
							<s:submit class="btn-success form-check-inline" value="Se connecter"/>
						</s:form> 
					</div>
					<!-- /.card-body-->
				</div>
				<!-- /.card mt-4 -->
				<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
			</div>
			<!-- /.my-5 -->
      	</div>
      <!-- /.row -->
    </div>
     <!-- /.container -->
  
 	
	
	<s:include value="../_include/body_footer.jsp" />
</body>
</html>