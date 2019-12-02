package mx.uaemex.fi.diseno.flyns.principal;



import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import mx.uaemex.fi.diseno.flyns.model.data.Juego;


@Component
public class JuegoRepository {
	private static final Log log = LogFactory.getLog(JuegoRepository.class);
	private DataSource dataSource;
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	public JuegoRepository(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplate = new NamedParameterJdbcTemplate(this.dataSource);
	}
	
	public Juego salvaJuego(Juego j) {
		log.info("Juego salvado: "+ j.getNombre());
		GeneratedKeyHolder holder = new GeneratedKeyHolder();
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", 599);
		params.addValue("juego", j.getNombre());
		params.addValue("activo", j.isActivo());
		params.addValue("url", j.getUrl());
		params.addValue("desc", "Esta es la desc");
		params.addValue("vers", "Esta es la ver");
		String insertSQL = "INSERT INTO juegos (id, juego, activo, url, descripcion, version) VALUES (:id,:juego, :activo, :url,:desc,:vers)";
		try {
			this.jdbcTemplate.update(insertSQL, params, holder);
		}catch(DataAccessException e) {
			log.error("Failed to save message", e);
			return null;
		}
		return new Juego(holder.getKey().intValue(), j.getNombre(), j.isActivo(), j.getUrl());
	}

	

}
