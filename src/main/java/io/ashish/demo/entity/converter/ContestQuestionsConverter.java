package io.ashish.demo.entity.converter;

import io.ashish.demo.entity.helper.ContestQuestions;
import jakarta.persistence.AttributeConverter;
import tools.jackson.databind.ObjectMapper;

public class ContestQuestionsConverter implements AttributeConverter<ContestQuestions, String> {
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(ContestQuestions contestQuestions) {
        if (contestQuestions == null) {
            return null;
        }

        try {
            return objectMapper.writeValueAsString(contestQuestions);
        } catch (Exception e) {
            throw new RuntimeException(
                "Error converting ContestQuestions to JSON", e
            );
        }
    }

    @Override
    public ContestQuestions convertToEntityAttribute(String s) {
        if(s==null) {
            return new ContestQuestions();
        }

        try {
            return objectMapper.readValue(s, ContestQuestions.class);
        } catch (Exception e) {
            throw new RuntimeException(
                "Error converting ContestQuestions to JSON", e
            );
        }
    } 
}
