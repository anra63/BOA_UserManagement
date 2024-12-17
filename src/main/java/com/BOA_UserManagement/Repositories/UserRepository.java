package com.BOA_UserManagement.Repositories;

import com.BOA_UserManagement.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
