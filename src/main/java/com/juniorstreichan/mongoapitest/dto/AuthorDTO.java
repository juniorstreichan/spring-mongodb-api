package com.juniorstreichan.mongoapitest.dto;

import com.juniorstreichan.mongoapitest.domain.User;

import java.util.Objects;

public class AuthorDTO {

    private String id;
    private String nome;

    public AuthorDTO() {
    }

    public AuthorDTO(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }


    public AuthorDTO(User usr) {
        this.id = usr.getId();
        this.nome = usr.getNome();
    }


    public AuthorDTO(UserDTO usr) {
        this.id = usr.getId();
        this.nome = usr.getNome();
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorDTO authorDTO = (AuthorDTO) o;
        return Objects.equals(id, authorDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
