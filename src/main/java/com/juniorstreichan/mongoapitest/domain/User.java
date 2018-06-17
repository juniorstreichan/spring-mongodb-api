package com.juniorstreichan.mongoapitest.domain;

import com.juniorstreichan.mongoapitest.dto.UserDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Objects;

@Document(collection = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    @NotEmpty
    private String nome;

    @Email
    @NotEmpty
    private String email;


    public User() {
    }

    public User(String id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public User(UserDTO usr) {
        this.id = usr.getId();
        this.nome = usr.getNome();
        this.email = usr.getEmail();
    }

    public User(String nome, String email) {

        this.nome = nome;
        this.email = email;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
