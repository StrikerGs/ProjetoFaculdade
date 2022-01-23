/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ProjectDao.Conection;
import ProjectDao.UserDao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Visao.Login;
import Visao.Principal;
import ProjectBeans.UserModel;

/**
 *
 * @author Striker
 */
public class LoginController {

    Conection conex = new Conection();
    private final Login view;

    public LoginController(Login view) {
        this.view = view;
    }

    public void authenticate() throws SQLException {

        //buscar um usuario da tela
        String user = view.getTxtUsuario().getText();
        String password = view.getTxtSenha().getText();

        UserModel authenticate = new UserModel(user, password);

        //verificar se existe no banco de dados
        Connection conection = conex.con;
        UserDao userdao = new UserDao();

        boolean exist = userdao.userExist(authenticate);

        //se existir direciona para menu
        if (exist) {

            Principal principal = new Principal();
            principal.setVisible(true);
        } else {

            JOptionPane.showMessageDialog(view, "Usuario ou senha invalidos.");

        }

    }
}
