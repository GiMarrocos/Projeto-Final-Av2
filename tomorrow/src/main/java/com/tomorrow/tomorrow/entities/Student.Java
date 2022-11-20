@Entity
@Table

public class Student {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long student_id; 

    @Colunn (nullable = false, length = 45)
    private String name; 

    @Colunn (nullable = false, lenght = 20)
    private String phone; 

    @Colunn (nullable = false, lenght = 45)
    private String address; 

   @Colunn (nullable = false, lenght = 20)
    private String cpf; 

    public Student () {

    }

    Public Student (Long student_id, String name, String phone, Steing address, String cpf) {
        this.student_id = student_id;
        this.name = name; 
        this.phone = phone; 
        this.address = address; 
        this.cpf = cpf;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone(){
        return phone; 
    }

    public void setPhone (String phone){
        this.phone = phone;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress (String address){
        this.address = address; 
    }

    public String getCpf (){
        return cpf;
    }
    
    public void setCpf (String cpf){
        this.cpf = cpf;
    }

    public String getStudent_id(){
        return student_id;
    }

    public void setStudent_id (String student_id){
        this.student_id = student_id;
    }
}