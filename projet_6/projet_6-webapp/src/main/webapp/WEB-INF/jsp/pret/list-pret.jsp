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

      <div class="col-lg-3">

        <h3 class="my-4 text-center">Liste des <s:property value="%{ type }"/>s</h3>
        
        <!-- =========================== Formulaire de sélection des critères de recherche ===========================-->
        
		<div class="list-group">
			<!-- =========================== Formulaire de sélection des critères de recherche ===========================-->
		
			<s:form action="pret_list">
				<s:hidden name="type" value="%{ type }"/>
				
				<s:select name="etat" label="Filtrer par état" class="custom-select"
		                  list="resourcesBundle.listEtatPret"
		                  emptyOption="true"
		                  requiredLabel="true"/>
		                                    
		    	<s:submit class="form-check-outline btn-success" value="  Filter " />
		    </s:form>
        </div>

      </div>
      <!-- /.col-lg-3 -->




      <div class="col-lg-9 my-5">

      	<div class="row">
        
        	<!-- =========================== Si aucun pret => Affiche message 'aucun pret' ===========================-->
        	<s:if test="listPret.isEmpty || listPret == null">
				<div class="col-lg-12 my-5">
					<p class="text-justify">Vous n'avez pas aucun <s:property value="%{ type }"/> <s:property value="%{ etat.toLowerCase }"/>.</p>
				</div>
			</s:if>
		
		
		
			<!-- =========================== Sinon => Affiche la liste des sites avec un lien vers leur fiche (site.jsp) ===========================-->
			<s:else>
		       	<s:iterator value="listPret">
	        		<div class="col-lg-4 col-md-6 mb-4">
	        			<div class="card h-100">
	            
				             <img class="card-img-top" src="${pageContext.request.contextPath}/WebContent/classes/fr/openclassrooms/projet_6/webapp/images${ topo.urlImage }" alt="">
				              
				             <div class="card-body">
				             	<h4 class="card-title">
				                	<s:a action="pret_detail">
			
										<s:param name="type" value="%{ type }"/>
										<s:param name="idPret" value="%{ idPret }"/>
										
										<s:property value="topo.titre"/>
											
									</s:a>
					       	    		<s:param name="idSite" value="idSite" />
					            		<s:property value="nom" />
				               </h4>
				               <p class="card-text">
				               		<p class="card-text">Date : <s:property value="date"/></p>
				               		<p class="card-text">État : <s:property value="etat"/></p>
				               </p>
				               <s:if test="%{ type == getText('pret.type1')}">
				               		<p class="card-text">
				               			Emprunteur : 
										<s:a action="utilisateur_detail">
											<s:param name="idUtilisateur" value="utilisateur.idUtilisateur"/>
											<s:property value="utilisateur.pseudo"/>
										</s:a>
									</p>
				               </s:if>
				               <s:if test="%{ type == getText('pret.type2')}">
				               		<p class="card-text">
										Proprietaire : 
										<s:a action="utilisateur_detail">
											<s:param name="idUtilisateur" value="proprietaire.idUtilisateur"/>
											<s:property value="proprietaire.pseudo"/>
										</s:a>
									</p>
				               </s:if>
				            </div>
				              
				            <div class="card-footer">
				            	<small class="text-muted"></small>
				            </div>
				             
						</div>
			        </div>
	            
	        	</s:iterator>
   	 		</s:else>
         
        </div>
        <!-- /.row -->
        
		<s:if test="listPret == null || listPret.isEmpty || listPret.size <= 3">
	  		<br><br><br><br><br><br><br><br><br><br><br>
	  		<s:if test="listPret == null || listPret.isEmpty">
	  			<br><br><br><br><br><br><br><br><br><br>
	 		 </s:if>
	  </s:if>
	  
      </div>
      <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->	
	
	
	
	<s:include value="../_include/body_footer.jsp" />
</body>
</html>