package com.want.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(columnDefinition = "enum('male','female')")
    private String sex;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="teacher_student",joinColumns={@JoinColumn(name="s_id")},inverseJoinColumns={@JoinColumn(name="t_id")})
    private Set<Teacher> teachers;
    
    
    /**
     * Description:
     * 建立集合，指定关系是一对一，并且申明它在cart类中的名称
     * 关联的表为card表，其主键是id
     * 指定外键名为card_id
     */
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "card_id")
//    private Card card;
}

