


<!-- =========================== Menu de navigation ===========================-->

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
  
	<div class="container">
	
	<!-- =========================== Si connecté => Voir nom / prenom + 'Se déconnecter' ===========================-->
	<!-- =========================== Sinon 'Se connecter' & 'S'inscrire' ===========================-->
    	<s:if test="#session.utilisateur">
			<s:a class="navbar-brand" action="logout">Se déconnecter</s:a>
	  	</s:if>
	  	<s:else>
			<s:a class="navbar-brand" action="login">Se Connecter</s:a>
			<s:a class="navbar-brand" action="inscription">S'inscrire</s:a>
	  	</s:else>      
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <!-- =========================== Menu =========================== -->
      	<div class="collapse navbar-collapse" id="navbarResponsive">
        	<ul class="navbar-nav ml-auto">
        
        		<li class="nav-item active">
            		<s:a class="nav-link" action="index">Accueil
              			<span class="sr-only">(current)</span>
            		</s:a>
          		</li>
          		
          		<li class="nav-item active">
            		<s:a class="nav-link" action="site_list">Sites
              			<span class="sr-only">(current)</span>
            		</s:a>
          		</li>
          
          		<li class="nav-item active">
            		<s:a class="nav-link" action="topo_list">Topos
              			<span class="sr-only">(current)</span>
            		</s:a>
          		</li>
          		
          		<!-- =========================== Menu connecté =========================== -->
          		<s:if test="#session.utilisateur">
          		
	          		<li class="nav-item active">
	            		<s:a class="nav-link" action="library">Bibliothèque
	              			<span class="sr-only">(current)</span>
	            		</s:a>
	          		</li>
	          
	          		<li class="nav-item active">
	            		<s:a class="nav-link"  action="utilisateur_detail">Profil
							<s:param name="idUtilisateur" value="#session.utilisateur.idUtilisateur"/>
	              			<span class="sr-only">(current)</span>
	            		</s:a>
	          		</li>
	          		
	          		<li class="nav-item active">
	            		<s:a class="nav-link"  action="pret_list">Prêts
							<s:param name="type"><s:text name="pret.type1" /></s:param>
							<span class="sr-only">(current)</span>
						</s:a>
	          		</li>
	          		
	          		<li class="nav-item active">
	            		<s:a class="nav-link"  action="pret_list">Emprunts
							<s:param name="type"><s:text name="pret.type2" /></s:param>
							<span class="sr-only">(current)</span>
						</s:a>
	          		</li>
          		</s:if>
        	</ul>
      	</div>
	</div>
</nav>


<div class="offset-4">
	<div class="my-5">
		<s:actionmessage />
		<s:actionerror />
	</div>
</div>