<s:include value="../_include/prelude.jsp" />
<html>
<head>
	<s:include value="../_include/head.jsp" />
	
	<script lang='javascript'>
		function Confirmer() {
			if (confirm("Voulez-vous vraiment retirer ce topo de votre biblioth�que ?")) {
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

        <h3 class="my-4 text-center">Biblioth�que</h3>
        
        <!-- =========================== Formulaire de s�lection des crit�res de recherche ===========================-->
        
		<div class="list-group">
			<!-- =========================== Formulaire de s�lection des crit�res de recherche ===========================-->
		
			<s:form action="remove_library">
										
	            <s:select name="idTopo" label="Topo" class="custom-select"
		                  list="bibliotheque"
		                  listKey="topo.idTopo"	    		     
	                      listValue="topo.titre" 
		                  emptyOption="true"
		                  requiredLabel="true"/>
		                  
		         <s:select name="quantiteTopo" label="Quantit�" class="custom-select"
		                  list="{1,2,3,4,5,6,7,8,9,10}"
		                  emptyOption="true"
		                  requiredLabel="true"/>
		                  
		        <s:submit  class="form-check-outline btn-success" type="input" value="Retirer de la biblioth�que" onclick="return Confirmer()"/>  
	        </s:form>
        </div>

      </div>
      <!-- /.col-lg-3 -->




      <div class="col-lg-9  my-5">

      	<div class="row">
        
        	<!-- =============== Si biblioth�que vide => Affiche message 'bibliotheque vide' avec un lien vers la liste des topos ================-->
			<s:if test="bibliotheque.isEmpty">
				<div class="col-lg-12 my-5">
					<p class="text-justify">
						Vous n'avez aucun Topo dans votre biblioth�que.<br>Si vous poss�dez un topo, pour l'ajouter, recherchez le dans le 
							<s:a action="topo_list">catalogue de topo</s:a> 
						puis une fois sur sa fiche cliqu� sur "Ajouter � ma biblioth�que".
					</p>
				</div>
			</s:if>
		
		
		
			<!-- =========================== Sinon => Affiche la biblioth�que de l'utilisateur ===========================-->
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
				               			Quantit� poss�d�: <s:property value="quantite"/>
				               			<br>
				               			dont r�serv�/pr�t�: <s:property value="quantitePrete"/>
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