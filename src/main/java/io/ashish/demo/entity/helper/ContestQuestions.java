package io.ashish.demo.entity.helper;

import java.util.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ContestQuestions {
    List<Long> questions = new ArrayList<>();
}
