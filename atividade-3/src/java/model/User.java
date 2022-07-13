/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author User
 */
public class User {

    Integer id;
    String nome;
    String login;
    String senha;

    public User() {

    }

    ;
    
      public User(
            Integer id,
            String nome,
            String login,
            String senha) {
        this.nome = nome;
        this.senha = senha;
        this.login = login;
        this.id = id;
    }

    ;
      
       public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    ;
      public String getLogin() {
        return login;
    }

    ;
      public String getSenha() {
        return senha;
    }

    ;
      
        public void setId(Integer str) {
        this.id = str;
    }

    public void setNome(String str) {
        this.nome = str;
    }

    ;
       public void setLogin(String str) {
        this.login = str;

    }

    ;
        public void setSenha(String str) {
        this.senha = str;

    }
;

}
