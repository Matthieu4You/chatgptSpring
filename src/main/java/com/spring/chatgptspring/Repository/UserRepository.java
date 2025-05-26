package com.spring.chatgptspring.Repository;

import com.spring.chatgptspring.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Autor: Mattu
 * @Date: 2025/5/26 10:08
 */
public interface UserRepository extends JpaRepository<User,Long> {
}
