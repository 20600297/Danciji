package com.xiqi.wzq.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Token {
    @Id
    String token;

    Date expires_time;

    String username;

    public Boolean isExpires(){return new Date().before(this.expires_time);}
}
