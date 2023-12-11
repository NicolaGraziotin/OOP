package it.unibo.composition;

public class Testing {

    public static void main(final String[] args) {

        // 1)Creare 3 studenti a piacere
        final Student student1 = new Student(1, "Nicola", "Graziotin", "ciao1", 2022);
        final Student student2 = new Student(2, "Francesco", "Marcatelli", "ciao2", 2022);
        final Student student3 = new Student(3, "Mattia", "Galli", "ciao3", 2022);

        // 2)Creare 2 docenti a piacere
        final Professor professor1 = new Professor(100, "Vittorio", "Ghini", "ciao100", args);
        final Professor professor2 = new Professor(101, "Mirko", "Viroli", "ciao101", args);

        // 3) Creare due aulee di esame, una con 100 posti una con 80 posti
        final ExamRoom room1 = new ExamRoom(100, "2.12", false, true);
        final ExamRoom room2 = new ExamRoom(80, "2.2 Lab", true, false);

        // 4) Creare due esami, uno con nMaxStudents=10, l'altro con
        // nMaxStudents=2
        final Exam exam1 = new Exam(1, 10, "analisi1", professor1, room1);
        final Exam exam2 = new Exam(2, 2, "algebra", professor2, room2);

        // 5) Iscrivere tutti e 3 gli studenti agli esami
        exam1.registerStudent(student1);
        exam1.registerStudent(student2);
        exam1.registerStudent(student3);

        exam2.registerStudent(student1);
        exam2.registerStudent(student2);
        exam2.registerStudent(student3);

        // 6) Stampare in stdout la rapresentazione in stringa dei due esami
        System.out.println(exam1.toString());
        System.out.println(exam2.toString());
    }
}
