package com.sghir.GestionEtudiant.Mapper.row;

import com.sghir.GestionEtudiant.model.Etudiant;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EtudiantRowMapper implements RowMapper<Etudiant>
{


    @Override
    public Etudiant mapRow(ResultSet rs, int rowNum) throws SQLException {
        Etudiant etudiant = new Etudiant(
                rs.getString("nom"),
                rs.getString("prenom"));
        etudiant.setId(rs.getString("id"));
        return etudiant;
    }
}
