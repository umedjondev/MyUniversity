public class Tutor {
    private String fio;
    private String phone;
    private Address address;

    public Tutor(String fio,String phone, Address address){
        this.fio=fio;
        this.phone=phone;
        this.address=address;
    }
    public Tutor(String fio){
        this.fio=fio;
    }
    public String getFio(){
        return fio;
    }
}
