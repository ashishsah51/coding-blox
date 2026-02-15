package io.ashish.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "notifications")
public class Notification extends BaseEntity {
    @NotEmpty
    private String message;

    @NonNull
    private Long userId;
}
