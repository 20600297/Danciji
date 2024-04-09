package com.xiqi.wzq.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xiqi.wzq.entity.word.Word;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Vocabulary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    Long eid;

    @JsonIgnore
    Integer status;

    String category;

    @JsonIgnore
    @ManyToOne
    Person person;

    @OneToOne
    Word word;

}
