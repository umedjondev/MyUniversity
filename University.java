import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private List<Group> groupList;
    private List<Tutor> tutorList;

    public University(String name){
        this.name=name;
        groupList=new ArrayList<>();
        tutorList=new ArrayList<>();
        tutorList.add(new Tutor("Akmalov T."));
        tutorList.add(new Tutor("Halimov A."));
        groupList.add(new Group("1-1PM-20",new Tutor("noName")));
        groupList.add(new Group("1-2PM-20",new Tutor("noName")));

      }
    public Group getGroup(int index)throws NullPointerException{
        if(index<groupList.size()) return groupList.get(index);
        throw new NullPointerException("non-existent index");
    }
    public void addGroup(Group newGroup){
        groupList.add(newGroup);
        System.out.println("successfully completed");
    }
    public void addTutor(Tutor newTyt){
        tutorList.add(newTyt);
        System.out.println("successfully completed");
    }
    public Group selectGroup(int index)throws NullPointerException{
       if(index<groupList.size())
           return groupList.get(index);
       throw new NullPointerException("non-existent index");
    }
    public Tutor selectTutor(int index)throws NullPointerException{
        if(index<tutorList.size())
            return tutorList.get(index);
        throw new NullPointerException("non-existent index");
    }
    public void showGroups(){
        for (int i=0;i<groupList.size();i++){
            Group gr=groupList.get(i);
            System.out.println(i+". "+gr.getName()+": "+gr.getCurrentTutor().getFio());
        }
    }
    public void ShowTutors(){
        for (int i=0;i<tutorList.size();i++){
            System.out.println(i+". "+tutorList.get(i).getFio());
        }
    }
    public void print() throws IOException {
        PrintWriter output=new PrintWriter("src/db.txt");
        output.println(this.name);
        output.println("List of tutors");
        this.ShowTutors();
        output.println();
        this.showGroups();
        output.println();
        for (Group gr:groupList){
            output.println("Group's name: "+gr.getName());
            gr.showStudents();
        }
        output.close();

    }


}
