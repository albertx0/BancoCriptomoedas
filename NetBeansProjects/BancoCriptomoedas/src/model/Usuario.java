/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author albert
 */
public class Usuario {
    private String nome , sobrenome , cpf , senha;
    private double saldoReal , saldoBTC , saldoETH , saldoXRP;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSaldoReal() {
        return saldoReal;
    }

    public void setSaldoReal(double saldoReal) {
        this.saldoReal = saldoReal;
    }

    public double getSaldoBTC() {
        return saldoBTC;
    }

    public void setSaldoBTC(double saldoBTC) {
        this.saldoBTC = saldoBTC;
    }

    public double getSaldoETH() {
        return saldoETH;
    }

    public void setSaldoETH(double saldoETH) {
        this.saldoETH = saldoETH;
    }

    public double getSaldoXRP() {
        return saldoXRP;
    }

    public void setSaldoXRP(double saldoXRP) {
        this.saldoXRP = saldoXRP;
    }

    public Usuario(String nome, String sobrenome, String cpf, String senha, double saldoReal, double saldoBTC, double saldoETH, double saldoXRP) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.senha = senha;
        this.saldoReal = saldoReal;
        this.saldoBTC = saldoBTC;
        this.saldoETH = saldoETH;
        this.saldoXRP = saldoXRP;
    }
}
