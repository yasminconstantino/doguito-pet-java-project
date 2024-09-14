package model;


public class Pet {
    //atributos
    private int idPet;
    private String namePet;
    private String tipoPet;
    private String sexoPet;
    private String racaPet;
    private String corPet;

    //ligando pet e cliente, ligação de classes
    Cliente cliente;

    // contrutores


    public Pet() {
    }

    public Pet(int idPet, String namePet, String tipoPet, String sexoPet, String racaPet, String corPet) {
        this.idPet = idPet;
        this.namePet = namePet;
        this.tipoPet = tipoPet;
        this.sexoPet = sexoPet;
        this.racaPet = racaPet;
        this.corPet = corPet;
    }

    public Pet(int idPet, String namePet, String tipoPet, String sexoPet, String racaPet, String corPet, Cliente cliente) {
        this.idPet = idPet;
        this.namePet = namePet;
        this.tipoPet = tipoPet;
        this.sexoPet = sexoPet;
        this.racaPet = racaPet;
        this.corPet = corPet;
        this.cliente = cliente;
    }

// getters & setters

    public int getIdPet() {
        return idPet;
    }

    public void setIdPet(int idPet) {
        this.idPet = idPet;
    }

    public String getNamePet() {
        return namePet;
    }

    public void setNamePet(String namePet) {
        this.namePet = namePet;
    }

    public String getTipoPet() {
        return tipoPet;
    }

    public void setTipoPet(String tipoPet) {
        this.tipoPet = tipoPet;
    }

    public String getSexoPet() {
        return sexoPet;
    }

    public void setSexoPet(String sexoPet) {
        this.sexoPet = sexoPet;
    }


    public String getRacaPet() {
        return racaPet;
    }

    public void setRacaPet(String racaPet) {
        this.racaPet = racaPet;
    }

    public String getCorPet() {
        return corPet;
    }

    public void setCorPet(String corPet) {
        this.corPet = corPet;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    //to string

    @Override
    public String toString() {
        return "\nPet{" +
                "idPet=" + idPet +
                ", namePet='" + namePet + '\'' +
                ", tipoPet='" + tipoPet + '\'' +
                ", sexoPet='" + sexoPet + '\'' +
                ", racaPet='" + racaPet + '\'' +
                ", corPet='" + corPet + '\'' +
                ", cliente=" + cliente.getIdCliente() +
                '}';
    }
}
