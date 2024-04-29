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

    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void persister(Etudiant etudiant) {
        String sql = "INSERT INTO student values (?, ?, ?)";
        this.jdbcTemplate.update(sql, etudiant.getId(), etudiant.getPrenom(), etudiant.getNom());
    }

    @Override
    public void update(Etudiant etudiant) {
        String sql = "UPDATE student set prenom=?, nom=? WHERE id=?";
        this.jdbcTemplate.update(sql, etudiant.getId(), etudiant.getPrenom(), etudiant.getNom());
    }




    @Override
    public Etudiant DeleteById(String id)
    {
        String sql = "DELETE From student WHERE id=?";
        return this.jdbcTemplate.queryForObject(sql, new EtudiantRowMapper(), id);
    }


    @Override
    public void DeleteAll(Etudiant etudiant)
    {
        String sql = "DELETE From student ";
        this.jdbcTemplate.update(sql);
    }

    @Override
    public List<Etudiant> recupererTous()
    {
        String sql = "SELECT * FROM student";
        return this.jdbcTemplate.query(sql, new EtudiantRowMapper());
    }

    @Override
    public Etudiant recupererParId(String id)
    {
        return null;
    }
}
