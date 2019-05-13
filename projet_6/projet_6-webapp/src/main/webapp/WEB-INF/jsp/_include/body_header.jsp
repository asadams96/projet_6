


<!-- =========================== Si connect� => Voir nom / prenom + 'Se d�connecter' ===========================-->
<!-- =========================== Sinon 'Se connecter' & 'S'inscrire' ===========================-->



<header>
	<s:if test="#session.utilisateur">
		<s:property value="#session.utilisateur.nom" /> 
		<s:property value="#session.utilisateur.prenom" /> 
		<s:a action="logout">Se d�connecter</s:a>
	</s:if>
	<s:else>
		<s:a action="login">Se Connecter</s:a>
		<s:a action="inscription">S'inscrire</s:a>
	</s:else>
</header>



<!-- =========================== Menu de navigation ===========================-->



<nav>
	<s:a action="site_list">Consulter les sites</s:a>
	
	
	
	<s:a action="topo_list">Consulter les topos</s:a>
	
	
	
	<s:if test="#session.utilisateur">
		<s:a action="library">Biblioth�que</s:a>
	</s:if>
	
	
	
	<s:if test="#session.utilisateur">
		<s:a action="utilisateur_detail">Profil
			<s:param name="idUtilisateur" value="#session.utilisateur.idUtilisateur"/>
		</s:a>
	</s:if>
	
	
	
	<s:if test="#session.utilisateur">
		<s:a action="pret_list">Liste des pr�ts
			<s:param name="type"><s:text name="pret.type1" /></s:param>
		</s:a>
	</s:if>
	
	
	
	<s:if test="#session.utilisateur">
		<s:a action="pret_list">Liste des emprunts
			<s:param name="type"><s:text name="pret.type2" /></s:param>
		</s:a>
	</s:if>
		
		

</nav>

<s:actionmessage />
<s:actionerror />