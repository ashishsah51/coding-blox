package io.ashish.demo.entity.helper;

import java.util.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserContestQuestions {
    Map<Long, List<Long>> contestQuestionsMap = new HashMap<>();
}
