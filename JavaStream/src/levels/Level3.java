package levels;

import models.Subject;
import models.Teacher;
import org.w3c.dom.ls.LSOutput;
import utils.Data;

import java.util.*;
import java.util.stream.Collectors;

public class Level3 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();


        System.out.println(" TO DO 1: Retourner une chaine de caractère qui contient tous les noms des enseignants " +
                "en majuscule separés par #  ");
        String names = teachers.stream().map(teacher -> teacher.getName().toUpperCase())
                .reduce("names : ", (a, b) -> a + "#" + b);

        System.out.println(" TO DO 2: Retourner une set d'enseignants Java dont le salaire > 80000 ");
        Set<Teacher> teachers1 = teachers.stream().filter(teacher -> teacher.getSubject()
                        .equals(Subject.JAVA)).filter(teacher -> teacher.getSalary() > 80000)
                .collect(Collectors.toSet());

        System.out.println(" TO DO 3: Retourner une TreeSet d'enseignants (tri par nom et" +
                " en cas d'égalité tri par salaire) ");

        TreeSet<Teacher> teachers2 = teachers.stream()
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Teacher::getName)
                        .thenComparing(Teacher::getSalary))));

        System.out.println(" TO DO 4: Retourner une Map qui regroupe les enseignants par module ");
        Map<Subject, List<Teacher>> map = teachers.stream().collect(Collectors.groupingBy(Teacher::getSubject));

        System.out.println("TO DO 5: Retourner une Map qui regroupe les nom des enseignants par salaire ");

        Map<Integer, List<Teacher>> map1 = teachers.stream().collect(Collectors.groupingBy(Teacher::getSalary));


        System.out.println("TO DO 6: Afficher les nom des enseignants de chaque module ");

        for (Map.Entry<Subject, List<Teacher>> entry : map.entrySet()) {
            Subject subject = entry.getKey();
            List<Teacher> teachersForSubject = entry.getValue(); //liste des enseigants

            System.out.println("Module " + subject.name() + ":"); //liste des modules
            for (Teacher teacher : teachersForSubject) {
                System.out.println(" - " + teacher.getName()); //affichage des noms des enseingnats
            }
        }
    }
}