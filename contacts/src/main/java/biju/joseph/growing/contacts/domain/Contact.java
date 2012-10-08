package biju.joseph.growing.contacts.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Biju Joseph
 * Created on : 10/7/12 6:10 PM
 */

@Entity
@Table(name="CONTACTS")
public class Contact
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @OrderBy
    private int id;
    @Column private String name;
    @Column private String address;
    @Column private String gender;
    @Column private Date dob;
    @Column private String email;
    @Column private String mobile;
    @Column
    private String phone;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
