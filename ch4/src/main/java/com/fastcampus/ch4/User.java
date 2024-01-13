package com.fastcampus.ch4;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class User {
    @Id // 기본키로 지정
    @Column(name="user_id")
    private String id;
    private String password;
    private String name;
    private String email;

    @OneToMany(mappedBy="user", fetch= FetchType.EAGER) // FK가 생기지 않음.
    // @OneToMany(mappedBy="user", fetch= FetchType.LAZY)
    List<Board> list = new ArrayList<>();

    // FetchType.EAGER - join을 통해 두 엔티티의 정보를 같이 가져옴.
    // FetchType.LAZY(기본값) - getList()를 통해 두 엔티티의 정보를 따로 가져옴.


    private Date inDate; // 입력일
    private Date upDate; // 변경일

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", list=" + list +
                ", inDate=" + inDate +
                ", upDate=" + upDate +
                '}';
    }

    public List<Board> getList() {
        return list;
    }

    public void setList(List<Board> list) {
        this.list = list;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Date getUpDate() {
        return upDate;
    }

    public void setUpDate(Date upDate) {
        this.upDate = upDate;
    }
}
