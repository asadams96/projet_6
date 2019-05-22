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

        <h2 class="my-4 text-center">Liste des topos</h2>
        
        <!-- =========================== Formulaire de sélection des critères de recherche ===========================-->
        
		<div class="list-group">
			<s:form action="topo_list">
				<s:select name="criteresType" label="Type" class="custom-select"
	                  list="resourcesBundle.listType"
	                  emptyOption="true"
	                  requiredLabel="true"/>
	                  
	        	<s:select name="criteresOrientation" label="Orientation" class="custom-select"
	                  list="resourcesBundle.listOrientation"
	                  emptyOption="true"
	                  requiredLabel="true"/>
	                  
	         	<s:select name="criteresLocalisation" label="Localisation" class="custom-select"
	                  list="resourcesBundle.listLocalisation"
	                  emptyOption="true"
	                  requiredLabel="true"/> 
	                  
	        	<s:submit class="form-check-outline btn-success" value="  Rechercher "/>
	        </s:form>
        </div>

      </div>
      <!-- /.col-lg-3 -->




      <div class="col-lg-9 my-5">

      	<div class="row">
        
        	<!-- =========================== Si aucun topo => Affiche message 'aucun topo' ===========================-->
        	<s:if test="listTopo.isEmpty">
        		<div class="col-lg-12 my-5">
					<p class="text-justify">Aucun topo ne correspond aux critères de recherche saisi.</p>
				</div>
			</s:if>
			
		
		
		
			<!-- =========================== Sinon => Affiche la liste des topos avec un lien vers leur fiche (topo.jsp) ===========================-->
			<s:else>
		       	<s:iterator value="listTopo">
	        		<div class="col-lg-4 col-md-6 mb-4">
	        			<div class="card h-100">
				             <img class="card-img-top" src="${pageContext.request.contextPath}/WebContent/classes/fr/openclassrooms/projet_6/webapp/images${ urlImage }"" alt="">
				              
				             <div class="card-body">
				             	<h4 class="card-title">
				                	<s:a action="topo_detail">
					       	    		<s:param name="idTopo" value="idTopo" />
					            		<s:property value="titre" />
					            	</s:a>
				               </h4>
				               <p class="card-text"><s:property value="description" /></p>
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
		 
	  <s:if test="listTopo == null || listTopo.isEmpty || listTopo.size <= 3">
	  		<br><br><br><br><br><br><br><br><br><br><br>
	  		<s:if test="listTopo == null || listTopo.isEmpty">
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