/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc.persistencia.mysql;

import java.util.List;
import jdbc.persistencia.IUserDAO;
import model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class MySqlUserDAO implements IUserDAO {

    Connection conn = null;

    public MySqlUserDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public User login(String login, String senha) {
        User user = null;
        try {

            //PreparedStatement st = conn.prepareStatement("select id_usuario,nome_usuario, login_usuario, senha_usuario from tb_usuario where "
            //        + "login_usuario = ? and senha_usuario = ? ");
            PreparedStatement st = conn.prepareStatement("select id_usuario,nome_usuario, login_usuario, senha_usuario from "
                    + "tb_usuario where login_usuario = ? and senha_usuario = ?");

            st.setString(1, login);
            st.setString(2, senha);

            ResultSet rs = (st.executeQuery());

            while (rs != null && rs.next()) {
                user = new User(rs.getInt("id_usuario"), rs.getString("nome_usuario"), rs.getString("login_usuario"), rs.getString("senha_usuario"));
            }
            System.out.println(user);
            return user;
        } catch (Exception e) {

            System.out.println(e);

        }
        return user;
    }

    @Override
    public boolean novo(User vo) {
        try {
            PreparedStatement st = conn.prepareStatement("Insert into tb_usuario( login_usuario, nome_usuario, senha_usuario) "
                    + "values(?, ?, ?)");
            st.setString(1, vo.getLogin());
            st.setString(2, vo.getNome());
            st.setString(3, vo.getSenha());
            st.execute();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

        return true;
    }

    @Override
    public User buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<User> listaTodos() {
        List<User> usuarios = new ArrayList<User>();
        try {
            Statement st = conn.createStatement();

            ResultSet rs = (st.executeQuery("select id_usuario,nome_usuario, login_usuario, senha_usuario from tb_usuario"));

            while (rs.next()) {
                User usuario = new User(rs.getInt("id_usuario"), rs.getString("nome_usuario"), rs.getString("login_usuario"), rs.getString("senha_usuario"));

                usuarios.add(usuario);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return usuarios;
    }

    public User login(User user, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
