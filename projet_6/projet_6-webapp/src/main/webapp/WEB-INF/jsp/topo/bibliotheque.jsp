<s:include value="../_include/prelude.jsp" />
<html>
<head>
	<s:include value="../_include/head.jsp" />
	
	<script lang='javascript'>
		function Confirmer(titre) {
			if (confirm("Voulez-vous vraiment retirer \""+titre+"\" de votre bibliotheque ?")) {
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

	<!-- =============== Si bibliothèque vide => Affiche message 'bibliotheque vide' avec un lien vers la liste des topos ================-->
	<s:if test="bibliotheque.isEmpty">
		<p>
			Vous n'avez aucun Topo dans votre bibliothèque.
		</p>
		<p>
			Si vous possédez un topo, pour l'ajouter, recherchez le dans le <s:a action="topo_list">catalogue des topos</s:a> 
			puis une fois sur sa fiche cliqué sur "Ajouter à ma bibliothèque"
		</p>
	</s:if>
	<!-- =========================== Sinon => Affiche la bibliothèque de l'utilisateur ===========================-->
	<s:else>
		<ul>
	        <s:iterator value="bibliotheque">
	            <li>
	            	<s:a action="topo_detail">
	            		<s:param name="idTopo" value="topo.idTopo" />
	            		<p>
	            			<s:property value="topo.titre"/>
	            			<br />
	            			Quantité: <s:property value="quantite"/>
	            		</p>
	            	</s:a>
	            	
	            	<!-- =========================== Possibilité de supprimer des topos ===========================-->
	            	<s:form action="remove_library" name="formulaire">
	            		<s:textfield name="quantiteTopo" label="Quantité" requiredLabel="true"/>
		           		<s:hidden name="idTopo" value="%{topo.idTopo}"/>
	            		<s:submit type="input" value="Retirer de la bibliothèque" onclick="return Confirmer('%{topo.titre}')"/>
	            	</s:form>   
	            			
	            </li>
	        </s:iterator>
	    </ul>
    </s:else>
	
	
	<s:include value="../_include/body_footer.jsp" />
</body>
</html>