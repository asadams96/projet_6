<header>
	<s:if test="#session.utilisateur">
		<s:property value="#session.utilisateur.nom" /> 
		<s:property value="#session.utilisateur.prenom" /> 
		<s:a action="logout">Se déconnecter</s:a>
	</s:if>
	<s:else>
		<s:a action="login">Se Connecter</s:a>
		<s:a action="inscription">Se Connecter</s:a>
	</s:else>
</header>

<nav>
	<s:a action="#">#</s:a>
	<s:a action="#">#</s:a>
	<s:a action="#">#</s:a>
	<s:a action="#">#</s:a>
	<s:a action="#">#</s:a>
	<s:a action="#">#</s:a>
</nav>

<s:actionmessage />
<s:actionerror />