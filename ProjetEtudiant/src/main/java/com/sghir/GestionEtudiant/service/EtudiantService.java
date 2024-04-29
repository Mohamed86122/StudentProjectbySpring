package com.sghir.GestionEtudiant.service;

import com.sghir.GestionEtudiant.DAO.EtudiantDao;
import com.sghir.GestionEtudiant.model.Etudiant;
import com.sghir.generateur.Implementation.Idgen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class EtudiantService
{


    @Autowired
    private EtudiantDao etudiantDao;


    @Autowired
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

    public Etudiant deleteById(String id)
    {
        Etudiant et = etudiantDao.DeleteById(id);
        return et ;
    }
    public void deleteAll(Etudiant etudiant)
    {
        etudiantDao.DeleteAll(etudiant);

    }
    public Etudiant recupererParId(String id)
    {
        Etudiant e = etudiantDao.recupererParId(id);
        return  e;
    }
}
