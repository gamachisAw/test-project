package com.example.test_project.Repository;
import com.example.test_project.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface UserRepository extends JpaRepository<User, Long> {
    }


