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
	 	Le but de ce site est de rassembler et de partager un maximum d'informations concernant les diff�rents sites de grimpe et topos existant.
	  	<br>
	  	Pour r�pondre au mieux � ce besoin, un syst�me de pr�t de topo a �t� mis en place o� tout utilisateur peut cr�er sa biblioth�que virtuelle � partir des ouvrages inclut dans le site.
	  	<br>
	  	<br>
	  	N'importe quel utilisateur peut demander le pr�t d'un topo, ce qui le r�serve aupr�s du proprietaire concern� jusqu'a ce qu'il d�cide de l'issus de la demande. Toutefois, il est � not� que la demande peut-�tre annul�e avant que le propri�taire ne prenne sa d�cision.
	  	<br>
	  	S'il accepte, une rencontre entre les deux personnes devrait avoir lieu pour proc�der au pr�t.
	  	<br>
	  	Pour planifier la rencontre un syst�me de messagerie est d�di� au pr�t.
	  	<br><br>
	  	Tout utilisateur peut laisser son impression sur chaque site ou topo r�pertori� gr�ce au commentaire. 
	  	<br>
	  	Nous vous demandons bien �videmment de rest� poli et courtois avec autruis. 
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