<s:include value="../_include/prelude.jsp" />
<html>
<head>
	<s:include value="../_include/head.jsp" />
	
	<script lang='javascript'>
		function Confirmer() {
			if (confirm("Voulez-vous vraiment retirer ce topo de votre bibliothèque ?")) {
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

      <div class="col-lg-3">

        <h3 class="my-4 text-center">Bibliothèque</h3>
        
        <!-- =========================== Formulaire de sélection des critères de recherche ===========================-->
        
		<div class="list-group">
			<!-- =========================== Formulaire de sélection des critères de recherche ===========================-->
		
			<s:form action="remove_library">
										
	            <s:select name="idTopo" label="Topo" class="custom-select"
		                  list="bibliotheque"
		                  listKey="topo.idTopo"	    		     
	                      listValue="topo.titre" 
		                  emptyOption="true"
		                  requiredLabel="true"/>
		                  
		         <s:select name="quantiteTopo" label="Quantité" class="custom-select"
		                  list="{1,2,3,4,5,6,7,8,9,10}"
		                  emptyOption="true"
		                  requiredLabel="true"/>
		                  
		        <s:submit  class="form-check-outline btn-success" type="input" value="Retirer de la bibliothèque" onclick="return Confirmer()"/>  
	        </s:form>
        </div>

      </div>
      <!-- /.col-lg-3 -->




      <div class="col-lg-9  my-5">

      	<div class="row">
        
        	<!-- =============== Si bibliothèque vide => Affiche message 'bibliotheque vide' avec un lien vers la liste des topos ================-->
			<s:if test="bibliotheque.isEmpty">
				<div class="col-lg-12 my-5">
					<p class="text-justify">
						Vous n'avez aucun Topo dans votre bibliothèque.<br>Si vous possédez un topo, pour l'ajouter, recherchez le dans le 
							<s:a action="topo_list">catalogue de topo</s:a> 
						puis une fois sur sa fiche cliqué sur "Ajouter à ma bibliothèque".
					</p>
				</div>
			</s:if>
		
		
		
			<!-- =========================== Sinon => Affiche la bibliothèque de l'utilisateur ===========================-->
			<s:else>
		       	<s:iterator value="bibliotheque">
	        		<div class="col-lg-4 col-md-6 mb-4">
	        			<div class="card h-100">
	            
				             <img class="card-img-top" src="${pageContext.request.contextPath}/WebContent/classes/fr/openclassrooms/projet_6/webapp/images${ topo.urlImage }" alt="">
				              
				             <div class="card-body">
				             	<h4 class="card-title">
				                	<s:a action="topo_detail">
			
										<s:param name="idTopo" value="topo.idTopo" />
										<s:property value="topo.titre"/>
											           			
									</s:a>
				               </h4>
				               		<p class="card-text">
				               			Quantité possédé: <s:property value="quantite"/>
				               			<br>
				               			dont réservé/prêté: <s:property value="quantitePrete"/>
				               		</p>
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
        
	 	<s:if test="bibliotheque == null || bibliotheque.isEmpty || bibliotheque.size <= 3">
	  		<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	  		<s:if test="bibliotheque == null || bibliotheque.isEmpty">
	  			<br><br><br><br>
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