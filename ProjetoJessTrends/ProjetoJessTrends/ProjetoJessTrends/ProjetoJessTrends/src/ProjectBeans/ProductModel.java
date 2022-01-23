/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectBeans;

/**
 *
 * @author Striker
 */
public class ProductModel {
    
    private Integer cod;
    private String nome;
    private Integer quant;
    private Float preco;
    private String pesquisa;

    public ProductModel(Integer cod, String nome, Integer quant, Float preco) {
        this.cod = cod;
        this.nome = nome;
        this.quant = quant;
        this.preco = preco;
    }

    public ProductModel(Integer cod) {
        this.cod = cod;
    }

    public ProductModel() {
    }

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuant() {
        return quant;
    }

    public void setQuant(Integer quant) {
        this.quant = quant;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    
    
}
