package com.acme.domain;

import com.acme.intr.WalkingEntity;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import org.jetbrains.annotations.NotNull;

public record Person(
    String firstName,
    String lastName,
    LocalDate dateOfBirth,
    List<Task> tasks) implements WalkingEntity {

    public Person(String firstName, String lastName, LocalDate dateOfBirth) {
        this(firstName, lastName, dateOfBirth, new ArrayList<>());
    }

    public int ageAt(LocalDate date) {
        return Period.between(dateOfBirth, date).getYears();
    }

    public int ageToday() {
        return ageAt(LocalDate.now());
    }

    public boolean olderThan(Person other) {
        return this.dateOfBirth.isBefore(other.dateOfBirth);
    }

    public void assign(Task task) {
        tasks.add(task);
    }

    public Optional<Task> findTaskById(int taskId) {
        return this.tasks
            .stream()
            .filter(byId(taskId))
            .findFirst();
    }

    @NotNull
    private Predicate<Task> byId(int taskId) {
        return task -> task.id() == taskId;
    }

    @Override
    public void walk() {
        System.out.println("Walking");
    }
}
