<s:include value="../_include/prelude.jsp" />
<html>
<head>
	<s:include value="../_include/head.jsp" />
	
	<script lang='javascript'>
		function Confirmer() {
			if (confirm("Voulez-vous vraiment envoyer un commentaire ?")) {
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

      <div class="col-lg-12">



		<!-- =========================== Présentation site ===========================-->
        <div class="card mt-4">
          	<img class="card-img-top img-fluid" src="${pageContext.request.contextPath}/WebContent/classes/fr/openclassrooms/projet_6/webapp/images${ site.urlImageSite }" alt="">
            
          	<div class="card-body">
	            <h2 class="card-title"><s:property value="site.nom" /></h2>
	            
	            <p class="card-text"><s:property value="site.description" /></p>
	            <hr>
	            <h5>Localisation</h5>
	            <p class="card-text"><s:property value="site.localisation" /></p>
	            <hr>
	            <h5>Acces</h5>
	            <p class="card-text"><s:property value="site.infoAcces" /></p>
	            <hr>	
	            <h5>À proximité</h5>
	            <p class="card-text"><s:property value="site.infoProximite" /></p>
	            
	         </div>
        </div>
        <!-- /.card -->



		<!-- =========================== Secteus et voies associés au site ===========================-->
		<s:if test="%{ secteurListVoie != null && !secteurListVoie.isEmpty }">
			<s:iterator value="secteurListVoie" status="status">
			
				<s:if test="#status.count%2" >
					<div class="card card-outline-secondary my-4">
						<div class="card-header">
	            			 <h5 class="card-title"><s:property value="nom"/></h5>
	          			</div>
          			
					
						<div class="card-body">
							<p class="card-text">Type : <s:property value="type"/></p>
							<p class="card-text">Orientation : <s:property value="orientation"/></p>
							<p class="card-text">Information : <s:property value="info"/></p>
				</s:if>
				
				<s:else>
							<br>
							<h6>Voies</h6>
							<hr>
							<s:iterator>
								<p class="card-text">
									<s:property value="numero"/>.
									<s:property value="nom"/>
								</p>
							</s:iterator>
						</div>
						<!-- /.card-body -->
					</div>
       			<!-- /.card -->
				</s:else>
			</s:iterator>
		</s:if>





	<!-- =========================== Topos associés au site (s'il y a des topos) ===========================-->
		<s:if test="%{ listTopo != null && !listTopo.isEmpty }">
			<div class="card card-outline-secondary my-4">
			
	          	<div class="card-header">
		            	<h5 class="card-title">Topos détaillant le site</h5>
		          </div>
		          
		          <div class="card-body">
			          	<s:iterator value="listTopo">
			          		<p class="text-justify">
								<s:a action="topo_detail">
									<s:param name="idTopo" value="idTopo" />
									<s:property value="titre"/>
								</s:a>
							</p>
			            </s:iterator>
		         </div>
	        </div>
	        <!-- /.card -->
	 	</s:if>
        
        
        
        <!-- =========================== Commentaires associés au site ===========================-->
	    <div class="card card-outline-secondary my-4">
	       	<div class="card-header">
	           	<h5 class="card-title">Commentaires</h5>
	       	</div>
		     <div class="card-body">
		     	<s:if test="listCommentaire != null && !listCommentaire.isEmpty">
			       	<s:iterator value="listCommentaire">
			        	<p><s:property value="contenu"/></p>
			            <small class="text-muted">
			            	Posté par 
			            	<s:a action="utilisateur_detail">
			            		<s:param name="idUtilisateur" value="auteur.idUtilisateur"/>
			            		<s:property value="auteur.pseudo"/>
			            	</s:a>
			            	 le <s:property value="date"/>
			            </small>
			            <hr>
			        </s:iterator>
		        </s:if>
		        <s:else>
		        	<p>Il n'y a aucun commentaire.</p>
		        	<hr>
		        </s:else>
		            
		        <!-- =========================== Si connecté => Possibilité d'ajout d'un commentaire ===========================-->
	
				<s:if test="#session.utilisateur">
					<s:form action="site_comment">
						<s:hidden name="idSite" value="%{ site.idSite }"/>
						<s:textarea class="custom-switch" name="contenu" maxlength="500" rows="3" cols="50"/>
						<s:submit class="btn-outline-dark" value="Envoyer un commentaire" onclick="return Confirmer()"/>
					</s:form>					
				</s:if>
				
				<s:else>
					<p>Pour ajouter un commentaire, veuillez-vous connecter.</p>
				</s:else>
		    </div>
	      </div>
	      <!-- /.card -->
       
       
       
      </div>
      <!-- /.col-lg-12 -->

    </div>

  </div>
  <!-- /.container -->
	
	
	
		
		
	<s:include value="../_include/body_footer.jsp" />
</body>
</html>