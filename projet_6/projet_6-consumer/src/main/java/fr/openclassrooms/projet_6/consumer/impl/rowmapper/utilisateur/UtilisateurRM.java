package fr.openclassrooms.projet_6.consumer.impl.rowmapper.utilisateur;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.openclassrooms.projet_6.model.utilisateur.Utilisateur;

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
	    utilisateur.setCodePostal(rs.getString("code_postal"));
	    utilisateur.setPass(rs.getString("pass"));
		
		return utilisateur;
	}

}
