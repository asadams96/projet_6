<s:include value="../_include/prelude.jsp" />
<html>
<head>
	<s:include value="../_include/head.jsp" />
</head>
<body>
	<s:include value="../_include/body_header.jsp" />
		
	<h2 class="text-center">Accueil</h2>

	
	<!-- Page Content -->
  <div class="container">

    <div class="row">
	
      <div class="col-lg-12">
      
      
      <hr> 
      <h4 class="text-center">Bienvenue sur notre site communautaire d'escalade !</h4>
      
      <br><br> 
	  
	  <p>
	 	Le but de ce site est de rassembler et de partager un maximum d'informations concernant les différents sites de grimpe et topos existant.
	  	<br>
	  	Pour répondre au mieux à ce besoin, un système de prêt de topo a été mis en place où tout utilisateur peut créer sa bibliothèque virtuelle à partir des ouvrages inclut dans le site.
	  	<br>
	  	<br>
	  	N'importe quel utilisateur peut demander le prêt d'un topo, ce qui le réserve auprès du proprietaire concerné jusqu'a ce qu'il décide de l'issus de la demande. Toutefois, il est à noté que la demande peut-être annulée avant que le propriétaire ne prenne sa décision.
	  	<br>
	  	S'il accepte, une rencontre entre les deux personnes devrait avoir lieu pour procéder au prêt.
	  	<br>
	  	Pour planifier la rencontre un système de messagerie est dédié au prêt.
	  	<br><br>
	  	Tout utilisateur peut laisser son impression sur chaque site ou topo répertorié grâce au commentaire. 
	  	<br>
	  	Nous vous demandons bien évidemment de resté poli et courtois avec autruis. 
	  </p>
	  
	  <br><br>
	  
	  
		<hr>
        <div id="carouselA" class="carousel slide my-4" data-ride="carousel">
          <ol class="carousel-indicators">
          
          <s:iterator begin="0" end="8" step="1" status="status">
          		<s:if test="#status.index  == 0">
	            	<li data-target="#carouselA" data-slide-to="${ status.index }" class="active"></li>
	            </s:if> 
	            <s:else>
	            	<li data-target="#carouselA" data-slide-to="${ status.index }"></li>
	            </s:else>
          	</s:iterator>            
          </ol>
          
          <div class="carousel-inner" role="listbox">
          	<s:iterator begin="0" end="8" step="1" status="status">
          	
          		<s:if test="#status.index  == 0">
	            	<div class="carousel-item active">
	            </s:if> 
	            
	            <s:else>
	            	<div class="carousel-item">
	            </s:else>
	            
	              <img class="d-block img-fluid" src="${pageContext.request.contextPath}/WebContent/classes/fr/openclassrooms/projet_6/webapp/images/index/diapos/falaises/${ status.index }.jpg" alt="">
	            </div>
          	</s:iterator>
          </div>
          
          <a class="carousel-control-prev" href="#carouselA" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselA" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
          
          <p class="text-muted text-right">Diaporama de falaises</p> 
        </div>
        
		<br><br>
		
		
		<hr>
  		<div id="carouselB" class="carousel slide my-4" data-ride="carousel">
          <ol class="carousel-indicators">
          
          	<s:iterator begin="0" end="8" step="1" status="status">
          		<s:if test="#status.index  == 0">
	            	<li data-target="#carouselB" data-slide-to="${ status.index }" class="active"></li>
	            </s:if> 
	            <s:else>
	            	<li data-target="#carouselB" data-slide-to="${ status.index }"></li>
	            </s:else>
          	</s:iterator>        
    
          </ol>
          
          <div class="carousel-inner" role="listbox">
          	<s:iterator begin="0" end="8" step="1" status="status">
          	
          		<s:if test="#status.index  == 0">
	            	<div class="carousel-item active">
	            </s:if> 
	            
	            <s:else>
	            	<div class="carousel-item">
	            </s:else>
	            
	              <img class="d-block img-fluid" src="${pageContext.request.contextPath}/WebContent/classes/fr/openclassrooms/projet_6/webapp/images/index/diapos/blocs/${ status.index }.jpg" alt="">
	            </div>
          	</s:iterator>
            
          </div>
          
          <a class="carousel-control-prev" href="#carouselB" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselB" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
          
          <p class="text-muted text-right">Diaporama de blocs</p> 
        </div>
        
		<br><br>
 
      </div>
      <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->
	
	<s:include value="../_include/body_footer.jsp" />
</body>
</html>