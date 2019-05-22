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

        <h2 class="my-4 text-center">Liste des sites</h2>
        
        <!-- =========================== Formulaire de sélection des critères de recherche ===========================-->
        
		<div class="list-group">
			<s:form action="site_list">
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
        
        	<!-- =========================== Si aucun site => Affiche message 'aucun site' ===========================-->
        	<s:if test="listSite.isEmpty">
				<div class="col-lg-12 my-5">
					<p class="text-justify">Aucun site ne correspond aux critères de recherche saisi.</p>
				</div>
			</s:if>
		
		
		
			<!-- =========================== Sinon => Affiche la liste des sites avec un lien vers leur fiche (site.jsp) ===========================-->
			<s:else>
		       	<s:iterator value="listSite">
	        		<div class="col-lg-4 col-md-6 mb-4">
	        			<div class="card h-100">
	            
				             
				             <img class="card-img-top" src="${pageContext.request.contextPath}/WebContent/classes/fr/openclassrooms/projet_6/webapp/images${ urlImageSite }" alt="">
				             
				              
				             <div class="card-body">
				             	<h4 class="card-title">
				                	<s:a action="site_detail">
					       	    		<s:param name="idSite" value="idSite" />
					            		<s:property value="nom" />
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
        
		<s:if test="listSite == null || listSite.isEmpty || listSite.size <= 3">
	  		<br><br><br><br><br><br><br><br><br><br><br>
	  		<s:if test="listSite == null || listSite.isEmpty">
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