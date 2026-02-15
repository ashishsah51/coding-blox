package io.ashish.demo.entity;

import java.math.BigInteger;
import io.ashish.demo.constant.Level;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Builder
@Entity
@Table(name = "questions")
public class Question extends BaseEntity {
    String question;

    @Enumerated(EnumType.STRING)
    Level level;

    BigInteger score;
}
