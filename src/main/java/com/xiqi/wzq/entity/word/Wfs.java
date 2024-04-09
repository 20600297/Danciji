package com.xiqi.wzq.entity.word;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "wfs")
public class Wfs {

    @Id //自增
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    Long eid;

    @JsonIgnore
    Long word_id;

    @JsonProperty("wfs")
    @Column(length = 10)
    String wfs;

    @JsonProperty("wfs_trans")
    @Column(length = 50)
    String wfs_trans;
}
