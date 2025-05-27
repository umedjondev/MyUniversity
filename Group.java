import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name;
    private List<Student> studentList;
    private Tutor currentTutor;
    private boolean isFinish=false;
    private int course=1;

    public Group(String name){
        studentList=new ArrayList<>();
        this.name=name;

    }
    public Group(String name,Tutor tyt){
        studentList=new ArrayList<>();
        this.name=name;
        currentTutor=tyt;
    }
    public String getName(){
        return name;
    }
    public Tutor getCurrentTutor(){
        return currentTutor;
    }
    public void setCurrentTutor(Tutor tyt){
        currentTutor=tyt;
    }
    public List<Student> getStudentList(){
        return studentList;
    }

    public void addStudent(Student std){
        studentList.add(std);
        System.out.println("successfully completed");
    }

    public void deleteStudent(int index){
        if(index<studentList.size())
        {
            System.out.println(studentList.get(index).getFio()+" is deleted from "+this.getName());
            studentList.remove(index);

        }
        else System.out.println("non-existent index ");

    }
    public void editGroupName(){}
    public void changeTutor(){}
    public void incCourse(){}
    public void finishedGroup(){}
    public void showStudents(){
        if(!studentList.isEmpty()){
            System.out.println("Students of "+this.getName()); // Group's name
        for (int i=0;i<studentList.size();i++){
            System.out.println(i+". "+studentList.get(i).getFio());
        }
        }
        else System.out.println("There are no students here.");
    }

}
