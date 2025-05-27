import java.io.IOException;
import java.util.Scanner;

public class TestUniversity {
    public static void mainMenu(){
        System.out.println("1. Add group");
        System.out.println("2. Add tutor");
        System.out.println("3. Select group");
        System.out.println("0. Exit");
    }
    public static void subMenu(){
        System.out.println("1. Add student");
        System.out.println("2. Delete student");
        System.out.println("3. Edit group name ?");
        System.out.println("4. Change tutor ?");
        System.out.println("5. Archive ?");
        System.out.println("0. Back main menu");
    }

    public static void main(String[] args) throws IOException {
        Scanner input=new Scanner(System.in);
        University myUniver=new University("BuxDU");
        while (true){
            mainMenu();
            System.out.print("Select number: ");
            int choice=input.nextInt();
            if(choice==0){
                myUniver.print();
                break;
            }
            switch (choice){
                case 1:
                    System.out.print("Enter group's name: ");
                    String grName=input.next();
                    myUniver.ShowTutors();
                    System.out.print("Enter tutor's id or add a new tutor (-1): ");
                    int tytId=input.nextInt();
                    Tutor tyt;
                    if(tytId!=-1){
                       tyt=myUniver.selectTutor(tytId);

                    }
                    else {
                        System.out.print("Enter tutor's name: ");
                        input.nextLine();
                        String tytName=input.nextLine();
                        System.out.print("Enter tutor's phone: ");
                        String tyttPhone=input.nextLine();
                        System.out.println("Enter country and region:");
                        Address tytAddress=new Address(input.next(),input.next());
                        tyt=new Tutor(tytName,tyttPhone,tytAddress);
                        myUniver.addTutor(tyt);
                    }
                    Group newGroup=new Group(grName,tyt);
                    myUniver.addGroup(newGroup);
                    break;
                case 2:
                    System.out.print("Enter tutor's name: ");
                    input.nextLine();
                    String tytName=input.nextLine();
                    System.out.print("Enter tutor's phone: ");
                    String tyttPhone=input.nextLine();
                    System.out.println("Enter country and region:");
                    Address tytAddress=new Address(input.next(),input.next());
                    tyt=new Tutor(tytName,tyttPhone,tytAddress);
                    myUniver.addTutor(tyt);
                    break;
                case 3:
                    System.out.println("List of groups");
                    myUniver.showGroups();

                    System.out.print("Enter group's id: ");
                    int grId=input.nextInt();
                    Group selectedGroup=myUniver.getGroup(grId);
                    System.out.println("……………………………");
                    System.out.println("Name: "+selectedGroup.getName());
                    System.out.println("Tutor: "+selectedGroup.getCurrentTutor().getFio());
                    System.out.println("Count of students: "+selectedGroup.getStudentList().size());
                    System.out.println("……………………………");
                    while (true){
                        subMenu();
                        System.out.print("Select number: ");
                        int choise2=input.nextInt();
                        if(choise2==0)break;  // back to main menu
                        switch (choise2){
                            case 1:
                                System.out.print("Enter student's name: ");
                                input.nextLine();
                                String stdName=input.nextLine();
                                System.out.print("Enter student's phone: ");
                                String stdPhone=input.nextLine();
                                System.out.println("Enter country and region:");
                                Address stdAddress=new Address(input.next(),input.next());
                                Student newStudent=new Student(stdName,stdPhone,stdAddress);
                                selectedGroup.addStudent(newStudent);
                                break;
                            case 2:
                                selectedGroup.showStudents();
                                System.out.print("Select the student ID to delete: ");
                                selectedGroup.deleteStudent(input.nextInt());
                                break;

                        }
                    }

                    break;
            }
        }
    }
}
