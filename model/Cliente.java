package model;

public class Cliente {
    //atributos
    private int idCliente;
    private String nomeCliente;
    private String cpf;
    private String telefone;
    private String cep;
    private String nrResidencia;
    private String bairro;
    private String municipio;
    private String uf;

    //construtores
    public Cliente() {
    }

    public Cliente(int idCliente, String nomeCliente, String cpf, String telefone, String cep, String nrResidencia, String bairro, String municipio, String uf) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.cpf = cpf;
        this.telefone = telefone;
        this.cep = cep;
        this.nrResidencia = nrResidencia;
        this.bairro = bairro;
        this.municipio = municipio;
        this.uf = uf;
    }

    //getters and setters

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNrResidencia() {
        return nrResidencia;
    }

    public void setNrResidencia(String nrResidencia) {
        this.nrResidencia = nrResidencia;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    //tostring


    @Override
    public String toString() {
        return "\nCliente{" +
                "idCliente=" + idCliente +
                ", nomeCliente='" + nomeCliente + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                ", nrResidencia='" + nrResidencia + '\'' +
                ", bairro='" + bairro + '\'' +
                ", municipio='" + municipio + '\'' +
                ", uf='" + uf + '\'' +
                '}';
    }

}
