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
				
        <div class="card mt-4"> 
          	<img class="card-img-top img-fluid" src="${pageContext.request.contextPath}/WebContent/classes/fr/openclassrooms/projet_6/webapp/images${ pret.topo.urlImage }" alt="">
          
          	<div class="card-body">
	            <!-- ================================= Date du pr�t ================================= -->
				<p class="card-text">Date de la demande : <s:property value="pret.date"/></p>
	            
	            <!-- ================================= Topo concern� par le pret avec lien vers fiche ================================= -->
	            <hr>
				<p class="card-text">
					Topo concern� : 
					<s:a action="topo_detail">
						<s:param name="idTopo" value="pret.topo.idTopo"/>
						
						<s:property value="pret.topo.titre"/> de <s:property value="pret.topo.auteur"/>, �diton <s:property value="pret.topo.annee"/>
					</s:a> 
				</p>
	            
	            <!-- ================================= Affiche l'autre utilisateur concern� par le pr�t avec lien vers profil ================================= -->
	            <hr>
	            <p class="card-text">
					<s:if test="%{ type == getText('pret.type1')}">
						Emprunteur : 
						<s:a action="utilisateur_detail">
							<s:param name="idUtilisateur" value="pret.utilisateur.idUtilisateur"/>
							<s:property value="pret.utilisateur.pseudo"/>
						</s:a>
					</s:if>
					
					<s:if test="%{ type == getText('pret.type2')}">
						Proprietaire : 
						<s:a action="utilisateur_detail">
							<s:param name="idUtilisateur" value="pret.proprietaire.idUtilisateur"/>
							<s:property value="pret.proprietaire.pseudo"/>
						</s:a>
					</s:if>
				</p>
				
				<!-- ================================= Etat du pr�t ================================= -->
				<hr>
				<p class="card-text">�tat : <s:property value="pret.etat"/></p>
	        </div>
        </div>
        <!-- /.card -->
	
	
	
		<!-- ======================= Statuer sur une demande pret (si type = pret, etat = Demand� et utilisateur = proprietaire  ======================= -->
	
		<s:if test="%{#session.utilisateur.idUtilisateur == pret.proprietaire.idUtilisateur 
						&& type == getText('pret.type1')
						&& pret.etat == getText('pret.etat1')}">
						
			<div class="card card-outline-secondary my-4">
		
	          	<div class="card-header">
		            	<h5 class="card-title">Statuer sur la demande de pr�t</h5>
		        </div>
	          
	          	<div class="card-body">
		         
					<s:form action="pret_decide">
						<s:hidden name="etat" value="%{ getText('pret.etat2') }"/>	
						<s:hidden name="idPret" value="%{ pret.idPret }"/>
						<s:hidden name="type" value="%{ type }"/>		
						<s:submit class="btn-outline-dark" value="Accepter le pr�t" onclick="return Confirmer('accepter le pr�t')"/>	
					</s:form>
					<s:form action="pret_decide">
						<s:hidden name="etat" value="%{ getText('pret.etat5') }"/>	
						<s:hidden name="idPret" value="%{ pret.idPret }"/>
						<s:hidden name="type" value="%{ type }"/>		
						<s:submit class="btn-outline-dark" value=" Refuser le pr�t " onclick="return Confirmer('refuser le pr�t')"/>	
					</s:form>
					
	         	</div>
        	</div>
        </s:if>
        <!-- /.card -->
        
        
	
        <!-- ======================= D�clarer un pret termin� (si type = pret, etat = En cours et utilisateur = proprietaire  ======================= -->
	
		<s:if test="%{#session.utilisateur.idUtilisateur == pret.proprietaire.idUtilisateur 
					&& type == getText('pret.type1')
					&& pret.etat == getText('pret.etat2')}">
						
			<div class="card card-outline-secondary my-4">
		
	          	<div class="card-header">
		            	<h5 class="card-title">D�clarer le pr�t termin�</h5>
		        </div>
	          
	          	<div class="card-body">
		         
					<s:form action="pret_finish">
						<s:hidden name="etat" value="%{ getText('pret.etat3')}"/>	
						<s:hidden name="idPret" value="%{ pret.idPret }"/>
						<s:hidden name="type" value="%{ type }"/>		
						<s:submit class="btn-outline-dark" value="D�clarer le pr�t termin�" onclick="return Confirmer('d�clarer le pr�t termin�')"/>	
					</s:form>
	         	</div>
        	</div>
        </s:if>
        <!-- /.card -->
				
	
				
		<!-- ======================= Annuler une demande pret (si type = emprunt, etat = Demand� et utilisateur = emprunteur  ======================= -->
	
		<s:if test="%{#session.utilisateur.idUtilisateur == pret.utilisateur.idUtilisateur 
					&& type == getText('pret.type2')
					&& pret.etat == getText('pret.etat1')}">
						
			<div class="card card-outline-secondary my-4">
		
	          	<div class="card-header">
		            	<h5 class="card-title">Annuler la demande de pr�t</h5>
		        </div>
	          
	          	<div class="card-body">
		         
					<s:form action="pret_cancel">			
						<s:hidden name="etat" value="%{ getText('pret.etat4')}"/>
						<s:hidden name="idPret" value="%{ pret.idPret }"/>
						<s:hidden name="type" value="%{ type }"/>			
						<s:submit class="btn-outline-dark" value="Annuler la demande de pr�t" onclick="return Confirmer('annuler la demande de pr�t')"/>	
					</s:form>
	         	</div>
        	</div>
        </s:if>
        <!-- /.card -->
	
        
    
        <!-- ======================= Affiche la liste des messages de pret  ======================= -->
	
	    <div class="card card-outline-secondary my-4">
	       	<div class="card-header">
	           	<h5 class="card-title">Messages</h5>
	       	</div>
		     <div class="card-body">
		     	<s:if test="listMessage != null && !listMessage.isEmpty">
			       	<s:iterator value="listMessage">
			        	<p><s:property value="contenu"/></p>
			            <small class="text-muted">Post� par <s:property value="auteur.pseudo"/> le <s:property value="date"/></small>
			            <hr>
			        </s:iterator>
		        </s:if>
		        <s:else>
		        	<p>Il n'y a aucun message.</p>
		        	<hr>
		        </s:else>
		            
		        <!-- =========================== Si l'utilisateur est concern� par le pret => Possibilit� d'ajout un message ===========================-->
	
				<s:if test="%{#session.utilisateur.idUtilisateur == pret.utilisateur.idUtilisateur || #session.utilisateur.idUtilisateur == pret.proprietaire.idUtilisateur}">
					<s:form action="pret_message">
						<s:hidden name="idPret" value="%{ pret.idPret }"/>
						<s:hidden name="type" value="%{ type }"/>
						<s:textarea class="custom-switch" name="contenu" maxlength="500" rows="3" cols="50"/>
						<s:submit class="btn-outline-dark" value="Envoyer un message" onclick="return Confirmer('envoyer un message')"/>
					</s:form>					
				</s:if>
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