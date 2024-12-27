package com.ust.TaskManager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {
    public Long id;

    @NotBlank(message = "Title is required")
    public String title;

    @NotBlank(message = "Description is required")
    public String description;

    @NotBlank(message = "Status is required")
    public String status; // Should be one of: NEW, IN_PROGRESS, COMPLETED, ON_HOLD

    @NotBlank(message = "Assignee is required")
    public String assignee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @NotNull(message = "Priority is required")
    public String priority; // Should be one of: LOW, MEDIUM, HIGH, URGENT
}