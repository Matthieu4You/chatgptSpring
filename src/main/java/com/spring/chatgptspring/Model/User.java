package com.spring.chatgptspring.Model;

import lombok.*;
import jakarta.persistence.*;

/**
 * @Autor: Mattu
 * @Date: 2025/5/26 09:58
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String email;

}
