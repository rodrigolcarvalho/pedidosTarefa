package br.com.bb.compra.service.impl;

import br.com.bb.compra.model.Cliente;
import br.com.bb.compra.service.ClienteService;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@ApplicationScoped
@Slf4j
@Named("clienteServiceInMemory")
public class ClienteServiceInMemory implements ClienteService {

    private static Map<Long, Cliente> MAP = new HashMap<>();
    private static AtomicLong GERADOR_ID = new AtomicLong();

    public void salvarCliente(Cliente cliente) {
        cliente.setId(GERADOR_ID.incrementAndGet());
        MAP.put(cliente.getId(), cliente);
        log.trace("Cliente salvo: {}", cliente);
    }

    public List<Cliente> getClientes() {
        return new ArrayList<>(MAP.values());
    }

}
