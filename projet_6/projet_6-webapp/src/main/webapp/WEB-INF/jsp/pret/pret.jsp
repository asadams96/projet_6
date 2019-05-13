<s:include value="../_include/prelude.jsp" />
<html>
<head>
	<s:include value="../_include/head.jsp" />
</head>
<body>
	<s:include value="../_include/body_header.jsp" />
	
	
	
	<!-- ================================= Date du pr�t ================================= -->
	
	<p>Date de la demande : <s:property value="pret.date"/></p>
	


	<!-- ================================= Affiche l'autre utilisateur concern� par le pr�t avec lien vers profil ================================= -->

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
	
	
	
	<!-- ================================= Topo concern� par le pret avec lien vers fiche ================================= -->
	
	<p>
		Topo concern� : 
		<s:a action="topo_detail">
			<s:param name="idTopo" value="pret.topo.idTopo"/>
			
			<s:property value="pret.topo.titre"/> 
			de <s:property value="pret.topo.auteur"/>, 
			�diton <s:property value="pret.topo.annee"/>
		</s:a> 
	</p>
	
	
	
	<!-- ================================= Etat du pr�t ================================= -->
	
	<p>�tat : <s:property value="pret.etat"/></p>
	
	
	
	<!-- ======================= Statuer sur une demande pret (si type = pret, etat = Demand� et utilisateur = proprietaire  ======================= -->
	
	<s:if test="%{#session.utilisateur.idUtilisateur == pret.proprietaire.idUtilisateur 
					&& type == getText('pret.type1')
					&& pret.etat == getText('pret.etat1')}">
					
		<s:form action="pret_decide">
			<s:hidden name="etat" value="%{ getText('pret.etat2') }"/>	
			<s:hidden name="idPret" value="%{ pret.idPret }"/>
			<s:hidden name="type" value="%{ type }"/>		
			<s:submit value="Accepter le pr�t"/>	
		</s:form>
		<s:form action="pret_decide">
			<s:hidden name="etat" value="%{ getText('pret.etat5') }"/>	
			<s:hidden name="idPret" value="%{ pret.idPret }"/>
			<s:hidden name="type" value="%{ type }"/>		
			<s:submit value="Refuser le pr�t"/>	
		</s:form>
					
	</s:if>
	
	
	
	<!-- ======================= D�clar� un pret termin� (si type = pret, etat = En cours et utilisateur = proprietaire  ======================= -->
	
	<s:if test="%{#session.utilisateur.idUtilisateur == pret.proprietaire.idUtilisateur 
					&& type == getText('pret.type1')
					&& pret.etat == getText('pret.etat2')}">
					
		<s:form action="pret_finish">
			<s:hidden name="etat" value="%{ getText('pret.etat3')}"/>	
			<s:hidden name="idPret" value="%{ pret.idPret }"/>
			<s:hidden name="type" value="%{ type }"/>		
			<s:submit value="D�clarer le pr�t termin�"/>	
		</s:form>	
				
	</s:if>
	
	
	
	<!-- ======================= Annuler une demande pret (si type = emprunt, etat = Demand� et utilisateur = emprunteur  ======================= -->
	
	<s:if test="%{#session.utilisateur.idUtilisateur == pret.utilisateur.idUtilisateur 
					&& type == getText('pret.type2')
					&& pret.etat == getText('pret.etat1')}">
					
		<s:form action="pret_cancel">			
			<s:hidden name="etat" value="%{ getText('pret.etat4')}"/>
			<s:hidden name="idPret" value="%{ pret.idPret }"/>
			<s:hidden name="type" value="%{ type }"/>			
			<s:submit value="Annuler la demande de pr�t"/>	
		</s:form>
						
	</s:if>
	
	
	
	<!-- ======================= Affiche la liste des messages de pret  ======================= -->
	
	<s:iterator value="listMessage">
		<p>
			<s:property value="date"/> -- <s:property value="auteur.pseudo"/>     :     <s:property value="contenu"/>
		</p>
	</s:iterator>
	
	
	
	<!-- =========================== Si l'utilisateur est concern� par le pret => Possibilit� d'ajout un message ===========================-->
	
	<s:if test="%{#session.utilisateur.idUtilisateur == pret.utilisateur.idUtilisateur || #session.utilisateur.idUtilisateur == pret.proprietaire.idUtilisateur}">
	
		<s:form action="pret_message">
			<s:hidden name="idPret" value="%{ pret.idPret }"/>
			<s:hidden name="type" value="%{ type }"/>
			
			<s:textarea name="contenu" label="Ajouter un message" requiredLabel="true" maxlength="500" />
			
			<s:submit value="Envoyer"/>
		</s:form>
	</s:if>
	
	
	
	<s:include value="../_include/body_footer.jsp" />
</body>
</html>