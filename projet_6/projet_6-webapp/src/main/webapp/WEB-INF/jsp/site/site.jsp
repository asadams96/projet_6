<s:include value="../_include/prelude.jsp" />
<html>
<head>
	<s:include value="../_include/head.jsp" />
	
	<script lang='javascript'>
		function Confirmer(titre) {
			if (confirm("Voulez-vous vraiment ajouter \""+titre+"\" � votre bibliotheque ?")) {
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



	<!-- =========================== Pr�sentation site ===========================-->
	
	<h3><s:property value="site.nom" /></h3>
	<p>Localisation : <s:property value="site.localisation" /></p>
	
	<!-- image site -->
	
	<h4>Description</h4>
	<p><s:property value="site.description" /></p>
	
	<h4>Acces</h4>
	<!-- Image acces -->
	<s:property value="site.infoAcces" />
	
	<h4>� proximit�</h4>
	<s:property value="site.infoProximite" />
	
	
	
	<!-- =========================== Secteus et voies associ�s au site ===========================-->
	
	 <h4>Secteur associ�s</h4>
	<ul>
		<s:iterator value="secteurListVoie" status="status">
			<s:if test="#status.count%2" >
				<h5><s:property value="nom"/></h5>
				<!-- Image secteur -->
				<p>
					<s:property value="type"/>
					<s:property value="orientation"/>
					<s:property value="info"/>
				</p>
			</s:if>
			<s:else>
				<s:iterator>
					<s:property value="numero"/>
					<s:property value="nom"/>
					<br />
				</s:iterator>
			</s:else>
		</s:iterator>
	</ul>
	
	
	
	<!-- =========================== Topos associ�s au site ===========================-->
	
	<h4>Topos associ�s</h4>
	<ul>
		<s:iterator value="listTopo">
			<li>
				<s:a action="topo_detail">
					<s:param name="idTopo" value="idTopo" />
					<s:property value="titre"/>
					
				</s:a>
			</li>
		</s:iterator>
	</ul>
	
	
	
	<!-- =========================== Commentaires associ�s au site ===========================-->
	
	<h4>Commentaires</h4>
	<ul>
		<s:iterator value="listCommentaire">
			<li>
				<s:property value="date"/>
				<s:property value="auteur.pseudo"/>
				<s:property value="contenu"/>
			</li>
		</s:iterator>
	</ul>
	
	
	
	<!-- =========================== Si connect� => Possibilit� d'ajout d'un commentaire ===========================-->
	
	<s:if test="#session.utilisateur">
		<s:form action="site_comment">
			<s:hidden name="idSite" value="%{ site.idSite }"/>
			<s:textarea name="contenu" label="Ajouter un commentaire" requiredLabel="true" maxlength="500" />
			<s:submit value="Envoyer"/>
		</s:form>
	</s:if>
	
		
		
	<s:include value="../_include/body_footer.jsp" />
</body>
</html>