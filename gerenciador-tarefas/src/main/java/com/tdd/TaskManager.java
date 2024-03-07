package com.tdd;

import javax.annotation.Nullable;
import java.util.Date;
import java.util.List;

public interface TaskManager {

    Task create(String title, String description, Date dueDate, Priority priority);

    Task update(Long id, @Nullable String title, @Nullable String description, @Nullable Date dueDate, @Nullable Priority priority);

    boolean delete(Long id);

    List<Task> getAll();

    Task changePriority(Long id, Priority priority);

    boolean isEmpty();

    int size();

}
