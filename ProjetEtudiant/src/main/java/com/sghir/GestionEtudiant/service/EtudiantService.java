package com.sghir.GestionEtudiant.service;

import com.sghir.GestionEtudiant.DAO.EtudiantDao;
import com.sghir.GestionEtudiant.model.Etudiant;
import com.sghir.generateur.Implementation.Idgen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class EtudiantService
{


    private EtudiantDao etudiantDao;

    private Idgen idGenerateur;


    public void ajouterEtudiant(Etudiant etudiant)
    {
        etudiant.setId(idGenerateur.genererId());
        etudiantDao.persister(etudiant);
    }

    public void miseajour(Etudiant etudiant)
    {
        etudiantDao.update(etudiant);
    }

    public List<Etudiant> etudiantlist ()
    {
        return etudiantDao.recupererTous();
    }

    public Etudiant recupererParId(String id)
    {
        Etudiant e = etudiantDao.recupererParId(id);
        return  e;
    }
}
