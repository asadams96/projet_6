<s:include value="../_include/prelude.jsp" />
<html>
<head>
	<s:include value="../_include/head.jsp" />
	
	<script lang='javascript'>
		function Confirmer(titre) {
			if (confirm("Voulez-vous vraiment "+titre+" ?")) {
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

				

		<!-- =========================== Pr�sentation topo ===========================-->
		
        <div class="card mt-4">
          	<img class="card-img-top img-fluid" src="${pageContext.request.contextPath}/WebContent/classes/fr/openclassrooms/projet_6/webapp/images${ topo.urlImage }" alt="">
          
          	<div class="card-body">
	            <h2 class="card-title"><s:property value="topo.titre" /></h2>
	            
	            <p class="card-text">�crit par <s:property value="topo.auteur" /> et publi� en <s:property value="topo.annee" /></p>
	            <hr>
	            <p class="card-text"><s:property value="topo.description" /></p>
	        </div>
        </div>
        <!-- /.card -->
	
	
	
		<!-- =========================== Si connect� => Possibilit� de demander le topo ===========================-->
		<s:if test="%{ listTamponProprietaireTopo != null && !listTamponProprietaireTopo.isEmpty() && #session.utilisateur}">
			<div class="card card-outline-secondary my-4">
		
	          	<div class="card-header">
		            	<h5 class="card-title">Demander le pr�t du topo</h5>
		        </div>
	          
	          	<div class="card-body">
		         
					<s:form action="pret_ask">
						<s:hidden name="idTopo" value="%{ topo.idTopo }"/>
						<s:hidden name="type" value="%{ getText('pret.type2') }"/>
						    	
						<s:select name="idProprietaire" label="Proprietaire" class="custom-select"
								  listKey="proprietaire.idUtilisateur"	    		     
					           	  list="listTamponProprietaireTopo" 
					              listValue="proprietaire.localisation + SPACE + proprietaire.pseudo" 
					 			  emptyOption="true"
					           	  requiredLabel="true"  />
					                  	  
					                  
						<s:textarea class="custom-switch" name="contenu" label="Message" requiredLabel="true" maxlength="500" rows="3" cols="50"/>
						<s:submit class="btn-outline-dark" value="Demander un pr�t" onclick="return Confirmer('demander '+'%{topo.titre}'+' en pr�t')"/>
					</s:form>
					
	         	</div>
        	</div>
        </s:if>
        <!-- /.card -->
				
	
	
	<!-- =========================== Si connect� => Possibilit� d'ajout du topo en biblioth�que ===========================-->
		<s:if test="#session.utilisateur">
			<div class="card card-outline-secondary my-4">
			
	          	<div class="card-header">
		            	<h5 class="card-title">Ajouter � la biblioth�que</h5>
		          </div>
		          
		          <div class="card-body">
			      		<s:form action="add_library" name="formulaire">
		    				<s:textfield class="custom-switch" name="quantiteTopo" label="Quantit�" requiredLabel="true"/>
							<s:hidden name="idTopo" value="%{ topo.idTopo }"/>
					    	<s:submit class="btn-outline-dark" type="input" value="Ajouter � la biblioth�que" onclick="return Confirmer('ajouter '+'%{topo.titre}'+' � votre bibilioth�que')"/>
						</s:form>
		         </div>
	        </div>
        </s:if>
        <!-- /.card -->
	
		
	
	<!-- =========================== Sites associ�s au topo (s'il y a des sites) ===========================-->
	
		<s:if test="%{ listSite != null && !listSite.isEmpty }">
			<div class="card card-outline-secondary my-4">
			
	          	<div class="card-header">
		            	<h5 class="card-title">Sites d�taill�s par le topo</h5>
		          </div>
		          
		          <div class="card-body">
			          	<s:iterator value="listSite">
			          		<p class="text-justify">
								<s:a action="site_detail">
									<s:param name="idSite" value="idSite" />
									<s:property value="nom"/>
								</s:a>
							</p>
			            </s:iterator>
		         </div>
	          
	        </div>
	        <!-- /.card -->
        </s:if>
        
        
    
        <!-- =========================== Commentaires associ�s au topo ===========================-->
	
	    <div class="card card-outline-secondary my-4">
	       	<div class="card-header">
	           	<h5 class="card-title">Commentaires</h5>
	       	</div>
		     <div class="card-body">
		     	<s:if test="listCommentaire != null && !listCommentaire.isEmpty">
			       	<s:iterator value="listCommentaire">
			        	<p><s:property value="contenu"/></p>
			            <small class="text-muted">
			            	Post� par 
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
		            
		        <!-- =========================== Si connect� => Possibilit� d'ajout d'un commentaire ===========================-->
	
				<s:if test="#session.utilisateur">
					<s:form action="topo_comment">
						<s:hidden name="idTopo" value="%{ topo.idTopo }"/>
						<s:textarea class="custom-switch" name="contenuCom" maxlength="500" rows="3" cols="50"/>
						<s:submit class="btn-outline-dark" value="Envoyer un commentaire" onclick="return Confirmer('ajouter un commentaire')" />
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