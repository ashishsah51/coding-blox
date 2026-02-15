package io.ashish.demo.entity.converter;

import io.ashish.demo.entity.helper.UserContestQuestions;
import jakarta.persistence.AttributeConverter;
import tools.jackson.databind.ObjectMapper;

public class UserContestQuestionsConverter implements AttributeConverter<UserContestQuestions, String> {
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(UserContestQuestions userContestQuestions) {
        if(userContestQuestions == null) return "";

        try {
            return objectMapper.writeValueAsString(userContestQuestions);
        } catch (Exception e) {
            throw new RuntimeException(
                "Error converting ContestQuestions to JSON", e
            );
        }
    }

    @Override
    public UserContestQuestions convertToEntityAttribute(String s) {
        if(s==null || s.isEmpty()) return new UserContestQuestions();

        try {
            return objectMapper.readValue(s, UserContestQuestions.class);
        } catch(Exception e) {
            throw new RuntimeException(
                "Error converting ContestQuestions to JSON", e
            );
        }
    }
}
