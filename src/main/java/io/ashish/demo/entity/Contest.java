package io.ashish.demo.entity;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;
import io.ashish.demo.constant.ContestStatus;
import io.ashish.demo.constant.Level;
import io.ashish.demo.entity.converter.ContestQuestionsConverter;
import io.ashish.demo.entity.helper.ContestQuestions;
// import io.ashish.demo.entity.helper.;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = false)
@Builder
@Entity
@Table(name = "contests")
public class Contest extends BaseEntity{
    String name;

    Long userId;

    @Enumerated(EnumType.STRING)
    Level level;

    @Enumerated(EnumType.STRING)
    ContestStatus status;

    @Convert(converter = ContestQuestionsConverter.class)
    ContestQuestions contestQuestions;
}
