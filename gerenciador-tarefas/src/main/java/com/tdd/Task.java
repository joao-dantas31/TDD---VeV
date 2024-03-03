package com.tdd;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@Setter(AccessLevel.NONE)
@Builder(toBuilder=true)
public class Task implements Comparable<Task> {

    private Long id;

    private String title;

    private String description;

    private Date dueDate;

    private Priority priority;

    @Override
    public int compareTo(Task o) {
        if (!this.priority.equals(o.getPriority())) {
            return -1 * Integer.compare(this.priority.getPriority(), o.getPriority().getPriority());
        }

        if (!this.dueDate.equals(o.getDueDate())) {
            return this.dueDate.compareTo(o.getDueDate());
        }

        return 0;
    }
}
