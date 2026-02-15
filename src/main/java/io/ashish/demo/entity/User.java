package io.ashish.demo.entity;

import java.math.BigInteger;

import io.ashish.demo.entity.converter.UserContestQuestionsConverter;
import io.ashish.demo.entity.helper.UserContestQuestions;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
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
@Table(name = "users")
public class User extends BaseEntity {
    @Column(unique = true)
    String username;

    BigInteger score;

    @Builder.Default
    @Convert(converter = UserContestQuestionsConverter.class)
    UserContestQuestions userContestQuestions = new UserContestQuestions();
}
