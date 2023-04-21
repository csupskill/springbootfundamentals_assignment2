package com.example.assignmenttwo.repositories;

import com.example.assignmenttwo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
