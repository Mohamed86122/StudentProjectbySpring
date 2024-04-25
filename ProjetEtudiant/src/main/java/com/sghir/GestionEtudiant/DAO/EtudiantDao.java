package com.sghir.GestionEtudiant.DAO;

import com.sghir.GestionEtudiant.model.Etudiant;

import java.util.List;

public interface EtudiantDao
{
    public void persister(Etudiant etudiant);

    public void update(Etudiant etudiant);

    public List<Etudiant> recupererTous();

    public Etudiant recupererParId(String id);

}
