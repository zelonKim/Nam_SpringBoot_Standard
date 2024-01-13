package com.fastcampus.ch4;

import javax.persistence.*;

@Entity
public class Cart {
    @Id
    @Column(name="cartId")
    private Long id;

    @OneToOne // FK가 생김.
    @JoinColumn(name="member_id", nullable = false) // inner Join
    private Member member;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
//                ", member=" + member +
                '}';
    }
}
