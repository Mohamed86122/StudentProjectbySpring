package com.sghir.GestionEtudiant.DAO.Implementation;

import com.sghir.GestionEtudiant.DAO.EtudiantDao;
import com.sghir.GestionEtudiant.Mapper.row.EtudiantRowMapper;
import com.sghir.GestionEtudiant.model.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
@Repository
public class MySQLimpl implements EtudiantDao {

    JdbcTemplate jdbcTemplate ;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void persister(Etudiant etudiant)
    {
        String sql = "INSERT INTO etudiant values (?, ?, ?)";
        this.jdbcTemplate.update(sql, etudiant.getId(), etudiant.getPrenom(), etudiant.getNom());
    }

    @Override
    public void update(Etudiant etudiant)
    {
        String sql = "UPDATE etudiant set prenom=?, nom=? WHERE id=?";
        this.jdbcTemplate.update(sql, etudiant.getId(), etudiant.getPrenom(), etudiant.getNom());
    }

    @Override
    public List<Etudiant> recupererTous()
    {
        String sql = "SELECT * FROM etudiant";
        return this.jdbcTemplate.query(sql, new EtudiantRowMapper());
    }

    @Override
    public Etudiant recupererParId(String id)
    {
        return null;
    }
}
