package fr.openclassrooms.projet_6.consumer.impl.rowmapper.liaison;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.liaison.TamponProprietaireTopoDaoImpl;
import fr.openclassrooms.projet_6.model.liaison.TamponProprietaireTopo;
import fr.openclassrooms.projet_6.model.topo.Topo;
import fr.openclassrooms.projet_6.model.utilisateur.Utilisateur;



/**
 * <p>RowMapper de la classe 'TamponProprietaireTopo'</p>
 * <p>Permet de stocker les informations de la table public.tampon_proprietaire_topo</p>
 * 
 * @see TamponProprietaireTopoRM#mapRow(ResultSet, int)
 * @see TamponProprietaireTopoDaoImpl#setRowMapper(RowMapper)
 * @see DaoFactoryImpl
 * @see TamponProprietaireTopo
 * @see RowMapper
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class TamponProprietaireTopoRM implements RowMapper<TamponProprietaireTopo> {

	@Override
	public TamponProprietaireTopo mapRow(ResultSet rs, int rowNum) throws SQLException {

		TamponProprietaireTopo tampon = new TamponProprietaireTopo();
		
		tampon.setProprietaire(new Utilisateur(rs.getInt("id_proprietaire")));
		tampon.setTopo(new Topo(rs.getInt("id_topo")));
		tampon.setQuantite(rs.getInt("quantite"));
				
		return tampon;
	}
}
