package fr.openclassrooms.projet_6.consumer.impl.rowmapper.pret;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.pret.PretDaoImpl;
import fr.openclassrooms.projet_6.model.pret.Pret;
import fr.openclassrooms.projet_6.model.topo.Topo;
import fr.openclassrooms.projet_6.model.utilisateur.Utilisateur;



/**
 * <p>RowMapper de la classe 'Pret'</p>
 * <p>Permet de stocker les informations de la table public.pret</p>
 * 
 * @see PretRM#mapRow(ResultSet, int)
 * @see PretDaoImpl#setRowMapper(RowMapper)
 * @see DaoFactoryImpl
 * @see Pret
 * @see RowMapper
 * @see Utilisateur
 * @see Topo
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class PretRM implements RowMapper<Pret> {

	
	
	@Override
	public Pret mapRow(ResultSet rs, int rowNum) throws SQLException {

		Pret pret = new Pret();
		
		pret.setIdPret(rs.getInt("id_pret"));
		pret.setDate(rs.getString("date"));
		pret.setEtat(rs.getString("etat"));
		pret.setUtilisateur(new Utilisateur(rs.getInt("id_utilisateur")));
		pret.setTopo(new Topo(rs.getInt("id_topo")));
		pret.setProprietaire(new Utilisateur(rs.getInt("id_proprietaire")));
		
		return pret;
	}
}
