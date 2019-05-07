package fr.openclassrooms.projet_6.consumer.impl.rowmapper.utilisateur;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.utilisateur.UtilisateurDaoImpl;
import fr.openclassrooms.projet_6.model.utilisateur.Utilisateur;



/**
 * <p>RowMapper de la classe 'Utilisateur'</p>
 * <p>Permet de stocker les informations de la table public.utilisateur</p>
 * 
 * @see UtilisateurRM#mapRow(ResultSet, int)
 * @see UtilisateurDaoImpl#setRowMapper(RowMapper)
 * @see DaoFactoryImpl
 * @see Utilisateur
 * @see RowMapper
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class UtilisateurRM implements RowMapper<Utilisateur> {

	
	
	@Override
	public Utilisateur mapRow(ResultSet rs, int rowNum) throws SQLException {

		Utilisateur utilisateur = new Utilisateur();
		
		utilisateur.setIdUtilisateur(rs.getInt("id_utilisateur"));
	    utilisateur.setMail(rs.getString("mail"));
	    utilisateur.setPseudo(rs.getString("pseudo"));
	    utilisateur.setNom(rs.getString("nom"));
	    utilisateur.setPrenom(rs.getString("prenom"));
	    utilisateur.setCivilite(rs.getString("civilite"));
	    utilisateur.setLocalisation(rs.getString("localisation"));
	    utilisateur.setPass(null);
		
		return utilisateur;
	}

}
