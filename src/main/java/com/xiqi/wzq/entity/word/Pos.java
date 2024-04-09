package com.xiqi.wzq.entity.word;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pos")
public class Pos {

    @Id //自增
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    Long eid;

    @JsonIgnore
    Long word_id;

    @JsonProperty("pos")
    @Column(length = 20)
    String pos;

    @JsonProperty("pos_trans")
    @Column(length = 500)
    String pos_trans;
}
