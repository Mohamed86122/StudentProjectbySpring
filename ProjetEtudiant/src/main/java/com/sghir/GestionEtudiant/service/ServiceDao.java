package com.sghir.GestionEtudiant.service;

import com.sghir.GestionEtudiant.model.Etudiant;

import java.util.List;

public interface ServiceDao
{
    public void ajouterEtudiant(Etudiant etudiant);

    public void miseajour(Etudiant etudiant);

    public List<Etudiant> etudiantlist ();


    public Etudiant deleteById(String id);

    public void deleteAll(Etudiant etudiant);

    public Etudiant recupererParId(String id);

    public Etudiant updateById(String id);

}
