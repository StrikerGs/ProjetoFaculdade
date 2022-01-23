/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ProjectBeans.ProductModel;
import ProjectDao.ProductDao;
import Visao.Produtos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Striker
 */
public class ProductController {

    private final Produtos view;

    public ProductController(Produtos view) {
        this.view = view;
    }

    public void AdicionaProduto() throws SQLException {

        String nome = view.getTxtProduto().getText();
        Integer quant = Integer.parseInt(view.getTxtQuantidade().getText());
        Float preco = Float.parseFloat(view.getTxtPreco().getText());
        Integer cod = Integer.parseInt(view.getTxtCodigo().getText());

        ProductModel produto = new ProductModel(cod, nome, quant, preco);

        ProductDao productdao = new ProductDao();

        productdao.Insert(produto);

        JOptionPane.showMessageDialog(null, "Produto Cadastrado.");

    }

    public void ExcluiProduto() throws SQLException {

        Integer cod = Integer.parseInt(view.getTxtCodigo().getText());

        ProductModel codProd = new ProductModel(cod);

        ProductDao productdao = new ProductDao();

        productdao.delete(codProd);

        JOptionPane.showMessageDialog(null, "Produto excluido!");

    }

    public void EditaProduto() throws SQLException {

        Integer cod = Integer.parseInt(view.getTxtCodigo().getText());
        String nome = view.getTxtProduto().getText();
        Integer quant = Integer.parseInt(view.getTxtQuantidade().getText());
        Float preco = Float.parseFloat(view.getTxtPreco().getText());

        ProductModel editProd = new ProductModel(cod, nome, quant, preco);

        ProductDao productdao = new ProductDao();

        productdao.update(editProd);

        JOptionPane.showMessageDialog(null, "Produto editado!");

    }

    public ArrayList<ProductModel> buscaProduto(String nome) {

        ProductDao productdao = new ProductDao();
        try {
            return productdao.filter(nome);
        } catch (Exception ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public ArrayList<ProductModel> listaProdutos() {
        ProductDao productdao = new ProductDao();
        try {
            return productdao.selectAll();
        } catch (Exception ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
