public class Student {
    private String fio;
    private String phone;
    private Address address;
    public Student(String fio,String phone, Address address){
        this.fio=fio;
        this.phone=phone;
        this.address=address;
    }
    public String getFio(){
        return fio;
    }

}
