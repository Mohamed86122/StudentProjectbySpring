package com.sghir;

import com.sghir.GestionEtudiant.model.Etudiant;
import com.sghir.GestionEtudiant.service.EtudiantService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{

    private static final Scanner scanner = new Scanner(System.in);

    public static void main( String[] args )
    {
        boolean continuer = true;
        EtudiantService etudiantService = obtenirEtudiantService();

        while (continuer) {
            afficherMenu();
            int choix = scanner.nextInt();
            scanner.nextLine(); // Pour consommer le retour à la ligne

            switch (choix) {
                case 1:
                    ajouterEtudiant(etudiantService);
                    break;
                case 2:
                    modifierEtudiant(etudiantService);
                    break;
                case 3:
                    supprimerEtudiant(etudiantService);
                    break;
                case 4:
                    afficherListeEtudiants(etudiantService);
                    break;
                case 5:
                    continuer = false;
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez choisir à nouveau.");
            }
        }

        System.out.println("Programme terminé.");
        scanner.close();
    }



    private static EtudiantService obtenirEtudiantService() {
        ApplicationContext app = new AnnotationConfigApplicationContext(com.sghir.GestionEtudiant.Configuration.AppConfig.class);
        return app.getBean("etudiantService", EtudiantService.class);
    }

    private static void afficherMenu() {
        System.out.println("Menu :");
        System.out.println("1. Ajouter un étudiant");
        System.out.println("2. Modifier un étudiant");
        System.out.println("3. Supprimer un étudiant");
        System.out.println("4. Afficher la liste des étudiants");
        System.out.println("5. Quitter");
        System.out.println("Choix : ");
    }

    private static void ajouterEtudiant(EtudiantService etudiantService) {
        System.out.println("Entrez le prénom de l'étudiant : ");
        String prenom = scanner.nextLine();
        System.out.println("Entrez le nom de l'étudiant : ");
        String nom = scanner.nextLine();

        Etudiant etudiant = new Etudiant(prenom, nom);
        etudiantService.ajouterEtudiant(etudiant);
        System.out.println("Étudiant ajouté avec succès.");
    }

    private static void modifierEtudiant(EtudiantService etudiantService) {
        System.out.println("Entrez l'ID de l'étudiant à modifier : ");
        String id = scanner.nextLine();
        System.out.println("Entrez le nouveau prénom de l'étudiant : ");
        String prenom = scanner.nextLine();
        System.out.println("Entrez le nouveau nom de l'étudiant : ");
        String nom = scanner.nextLine();

        Etudiant etudiant = new Etudiant( nom, prenom);
        etudiantService.miseajour(etudiant);
        System.out.println("Étudiant modifié avec succès.");
    }

    private static void supprimerEtudiant(EtudiantService etudiantService) {
        System.out.println("Entrez l'ID de l'étudiant à supprimer : ");
        String id = scanner.nextLine();

        etudiantService.deleteById(id);
        System.out.println("Étudiant supprimé avec succès.");
    }

    private static void afficherListeEtudiants(EtudiantService etudiantService) {
        List<Etudiant> etudiants = etudiantService.etudiantlist();
        for (Etudiant etudiant : etudiants) {
            System.out.println(etudiant);
        }
    }
}
