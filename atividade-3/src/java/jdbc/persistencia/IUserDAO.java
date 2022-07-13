/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package jdbc.persistencia;

import jdbc.persistencia.IDAO;
import model.User;

/**
 *
 * @author User
 */
public interface IUserDAO extends IDAO<User> {

    public User login(String login, String senha);
};
