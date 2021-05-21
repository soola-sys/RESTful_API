package kz.iitu.demo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

@Entity()
@Table(name="employees")
public class Restful {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , updatable = false)
    private  long id;
    @Column(name = "name" , nullable = false , columnDefinition = "TEXT")
    private String name;
    @Column(name = "password" ,nullable = false ,columnDefinition = "TEXT")
    private String password;
    @JsonFormat(pattern = "yyyy-MM-dd" , shape = JsonFormat.Shape.STRING)
    @Column(name = "date" , nullable = false , columnDefinition = "DATETIME")
    private String date;

    public Restful(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Restful(String name,String password, String date) {
        this.password = password;
        this.date = date;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Restful{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", date='" + date + '\'' +
                '}';
    }


}
