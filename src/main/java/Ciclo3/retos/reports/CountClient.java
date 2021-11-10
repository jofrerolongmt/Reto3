package Ciclo3.retos.reports;

import Ciclo3.retos.model.Cliente;



public class CountClient {
    private Long total;
    private Cliente client;

    public CountClient(Long total, Cliente client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }
}
