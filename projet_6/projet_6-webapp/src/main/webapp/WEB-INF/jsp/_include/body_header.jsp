<!-- =========================== Si connecté => Voir nom / prenom + 'Se déconnecter' ===========================-->
<!-- =========================== Sinon 'Se connecter' & 'S'inscrire' ===========================-->
<header>
	<s:if test="#session.utilisateur">
		<s:property value="#session.utilisateur.nom" /> 
		<s:property value="#session.utilisateur.prenom" /> 
		<s:a action="logout">Se déconnecter</s:a>
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
		<s:a action="library">Ma bibliothèque</s:a>
	</s:if>
	<s:if test="#session.utilisateur">
		<s:a action="utilisateur_detail">
		<s:param name="idUtilisateur" value="#session.utilisateur.idUtilisateur"/>
		Profil
		</s:a>
	</s:if>
	<s:a action="#">#</s:a>
	<s:a action="#">#</s:a>
	<s:a action="#">#</s:a>
</nav>

<s:actionmessage />
<s:actionerror />