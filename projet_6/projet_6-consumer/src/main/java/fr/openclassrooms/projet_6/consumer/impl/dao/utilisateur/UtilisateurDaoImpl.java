package fr.openclassrooms.projet_6.consumer.impl.dao.utilisateur;

import org.springframework.jdbc.core.RowMapper;

import fr.openclassrooms.projet_6.consumer.contract.dao.utilisateur.UtilisateurDao;
import fr.openclassrooms.projet_6.model.utilisateur.Utilisateur;

public class UtilisateurDaoImpl implements UtilisateurDao {

	private RowMapper<Utilisateur> rowMapper;

	public void setRowMapper(RowMapper<Utilisateur> rowMapper) {
		this.rowMapper = rowMapper;
	}
}
