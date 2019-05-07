<s:include value="../_include/prelude.jsp" />
<html>
<head>
	<s:include value="../_include/head.jsp" />
	
	<script lang='javascript'>
		function Confirmer(titre) {
			if (confirm("Voulez-vous vraiment ajouter \""+titre+"\" à votre bibliotheque ?")) {
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



	<!-- =========================== Présentation topo ===========================-->
	
	<h3><s:property value="topo.titre" /></h3>
	<p>
		<s:property value="topo.auteur" />
		<s:property value="topo.annee" />
		<s:property value="topo.description" />
	</p>
	
	
	
	<!-- =========================== Si connecté => Possibilité d'ajout du topo en bibliothèque ===========================-->
	
	<s:if test="#session.utilisateur">
		<s:form action="add_library" name="formulaire">
	    	<s:textfield name="quantiteTopo" label="Quantité" requiredLabel="true"/>
			<s:hidden name="idTopo" value="%{ topo.idTopo }"/>
	    	<s:submit type="input" value="Ajouter à la bibliothèque" onclick="return Confirmer('%{topo.titre}')"/>
		</s:form>
	</s:if>
	
	
	
	<!-- =========================== Sites associés au topo ===========================-->
	
	<h4>Sites associés</h4>
	<ul>
		<s:iterator value="listSite">
			<li>
				<s:a action="site_detail">
					<s:param name="idSite" value="idSite" />
					<s:property value="nom"/>
				</s:a>
			</li>
		</s:iterator>
	</ul>
	
	
	
	<!-- =========================== Commentaires associés au topo ===========================-->
	
	<h4>Commentaires</h4>
	<ul>
		<s:iterator value="listCommentaire">
			<li>
				<s:property value="date"/>
				<s:a action="utilisateur_detail">
					<s:param name="idUtilisateur" value="auteur.idUtilisateur"/>
					<s:property value="auteur.pseudo"/>
				</s:a>
				<s:property value="contenu"/>
			</li>
		</s:iterator>
	</ul>
	
	
	
	<!-- =========================== Si connecté => Possibilité d'ajout d'un commentaire ===========================-->
	
	<s:if test="#session.utilisateur">
		<s:form action="topo_comment">
			<s:hidden name="idTopo" value="%{ topo.idTopo }"/>
			<s:textarea name="contenu" label="Ajouter un commentaire" requiredLabel="true" maxlength="500" />
			<s:submit value="Envoyer"/>
		</s:form>
	</s:if>
	
		
		
	<s:include value="../_include/body_footer.jsp" />
</body>
</html>