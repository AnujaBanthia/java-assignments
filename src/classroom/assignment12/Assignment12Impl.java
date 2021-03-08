package classroom.assignment12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Assignment12Impl {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(111, "Jiya Brein", 17, "Female", "Computer Science", 2018, 70.8));
        students.add(new Student(122, "Paul Niksui", 18, "Male", "Mechanical", 2016, 50.2));
        students.add(new Student(133, "Martin Theron", 17, "Male", "Electronic", 2017, 90.3));
        students.add(new Student(144, "Murali Gowda", 18, "Male", "Electrical", 2018, 80));
        students.add(new Student(155, "Nima Roy", 19, "Female", "Textile", 2016, 70));
        students.add(new Student(166, "Iqbal Hussain", 18, "Male", "Security", 2016, 70));
        students.add(new Student(177, "Manu Sharma", 16, "Male", "Chemical", 2018, 70));
        students.add(new Student(188, "Wang Liu", 20, "Male", "Computer Science", 2015, 80));
        students.add(new Student(199, "Amelia Zoe", 18, "Female", "Computer Science", 2016, 85));
        students.add(new Student(200, "Jaden Dough", 18, "Male", "Security", 2015, 82));
        students.add(new Student(211, "Jasna Kaur", 20, "Female", "Electronic", 2019, 83));
        students.add(new Student(222, "Nitin Joshi", 19, "Male", "Textile", 2016, 60.4));
        students.add(new Student(233, "Jyothi Reddy", 16, "Female", "Computer Science", 2015, 45.6));
        students.add(new Student(244, "Nicolus Den", 16, "Male", "Electronic", 2017, 95.8));
        students.add(new Student(255, "Ali Baig", 17, "Male", "Electronic", 2018, 88.4));
        students.add(new Student(266, "Sanvi Pandey", 17, "Female", "Electric", 2019, 72.4));
        students.add(new Student(277, "Anuj Chettiar", 18, "Male", "Computer Science", 2017, 57.5));


        //1. Print the name of all departments in the college?
        List<String> departmentNames = students.stream().map(student -> student.engDepartment).distinct().collect(Collectors.toList());
        for (String dept: departmentNames) {
            System.out.println(dept);
        }

        //2.Get the names of all students who have enrolled after 2018?
        students.stream().filter(student -> student.yearOfEnrollment == 2018).forEach(student -> System.out.println(student.name));

        //3. Get the details of all male student in the computer sci department?
        List<Student> maleStudentInCompScience = students.stream().filter(student -> student.gender.equals("Male") && student.engDepartment.equals("Computer Science")).collect(Collectors.toList());
        for (Student student:maleStudentInCompScience
             ) {
            System.out.println(student);
        }

        //4. How many male and female student are there ? (HINT:use Collectors.groupingBy() for grouping based on gender)
        long noOfFemaleStudents = students.stream().filter(student -> student.gender.equals("Female")).count();
        long noOfMaleStudents = students.stream().filter(student -> student.gender.equals("Male")).count();
        Map<String, Long> genderCountMap = students.stream().collect(Collectors.groupingBy(student -> student.gender,Collectors.counting()));

        System.out.println("Number of Female Students : "+noOfFemaleStudents);
        System.out.println("Number of Male Students : "+noOfMaleStudents);

        System.out.println(genderCountMap);

        //5.What is the average age of male and female students?
        Map<String, Double> averageAgeGenderMap = students.stream().collect(Collectors.groupingBy(student -> student.gender,Collectors.averagingInt(student -> student.age)));

        System.out.println(averageAgeGenderMap);

        //6.Get the details of highest student having highest percentage ?
        Student highestPerStudent = students.stream().max(Comparator.comparingDouble(Student::getPerTillDate)).get();
        System.out.println(highestPerStudent);

        //7.Count the number of students in each department? (Hint :use Collectors.groupingBy())
        Map<String, Long> mapStudentCount = students.stream().collect(Collectors.groupingBy(student -> student.engDepartment,Collectors.counting()));
        System.out.println(mapStudentCount);

        //8. What is the average percentage achieved in each department?
        Map<String, Double> averagePerDeptWiseMap = students.stream().collect(Collectors.groupingBy(student -> student.engDepartment,Collectors.averagingDouble(student -> student.perTillDate)));
        System.out.println(averagePerDeptWiseMap);

        //9. Get the details of youngest male student in the Electronic department?(Hint :Use Collectors.minBy)
        Student youngestMaleStudentInElectronics=students.stream().filter(student -> student.gender.equals("Male") && student.engDepartment.equals("Electronic")).collect(Collectors.minBy(Comparator.comparingInt(Student::getAge))).get();
        System.out.println(youngestMaleStudentInElectronics);

        //10.How many male and female students are there in the computer science department?
        Map<String, Long> gendercountInComputerScience = students.stream().filter(student -> student.getEngDepartment().equals("Computer Science")).collect(Collectors.groupingBy(student -> student.gender,Collectors.counting()));
        System.out.println(gendercountInComputerScience);
    }
}
