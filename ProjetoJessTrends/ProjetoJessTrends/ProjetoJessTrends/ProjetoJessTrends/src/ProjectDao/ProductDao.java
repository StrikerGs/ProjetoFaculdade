/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectDao;

import ProjectBeans.ProductModel;
import controller.ProductController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Striker
 */
public class ProductDao {

    Conection conex = new Conection();

    public void Insert(ProductModel product) throws SQLException {

        conex.Conection();
        String sql = "INSERT INTO produtos(nome, cod, quant, preco) VALUES (?, ?, ?, ?)";

        PreparedStatement statement = conex.con.prepareStatement(sql);
        statement.setString(1, product.getNome());
        statement.setInt(2, product.getCod());
        statement.setInt(3, product.getQuant());
        statement.setFloat(4, product.getPreco());
        statement.execute();

        conex.desconecta();

    }

    public void update(ProductModel product) throws SQLException {

        conex.Conection();
        String sql = "update produtos set nome = ?, preco = ?, quant = ? where cod = ?";
        PreparedStatement statement = conex.con.prepareStatement(sql);
        statement.setString(1, product.getNome());
        statement.setFloat(2, product.getPreco());
        statement.setInt(3, product.getQuant());
        statement.setInt(4, product.getCod());

        statement.execute();

        conex.desconecta();
    }

    public void delete(ProductModel product) throws SQLException {

        conex.Conection();
        String sql = "delete from produtos where cod = ?";
        PreparedStatement statement = conex.con.prepareStatement(sql);
        statement.setInt(1, product.getCod());

        statement.execute();

        conex.desconecta();

    }

    public ArrayList<ProductModel> selectAll() {
        try {
            conex.Conection();
            String sql = "SELECT * FROM produtos ORDER BY cod ASC";
            Statement stmt = conex.con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            ArrayList<ProductModel> produtos = new ArrayList<ProductModel>();

            while (rs.next()) {
                ProductModel p = new ProductModel();
                p.setCod(rs.getInt("cod"));
                p.setNome(rs.getString("nome"));
                p.setQuant(rs.getInt("quant"));
                p.setPreco(rs.getFloat("preco"));
                produtos.add(p);
            }

            rs.close();
            stmt.close();
            conex.desconecta();

            return produtos;
        } catch (SQLException e) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    public ArrayList<ProductModel> filter(String nome) {
        try {
            conex.Conection();
            String sql = "SELECT * FROM produtos WHERE nome LIKE '%" + nome + "%' ORDER BY cod ASC";
            Statement stmt = conex.con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            ArrayList<ProductModel> produtos = new ArrayList<ProductModel>();

            while (rs.next()) {
                ProductModel p = new ProductModel();
                p.setCod(rs.getInt("cod"));
                p.setNome(rs.getString("nome"));
                p.setQuant(rs.getInt("quant"));
                p.setPreco(rs.getFloat("preco"));
                produtos.add(p);
            }

            rs.close();
            stmt.close();
            conex.desconecta();

            return produtos;
        } catch (SQLException e) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

}
