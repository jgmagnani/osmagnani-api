package com.magnani.os.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magnani.os.domain.Cliente;
import com.magnani.os.domain.OS;
import com.magnani.os.domain.Tecnico;
import com.magnani.os.domain.enuns.Prioridade;
import com.magnani.os.domain.enuns.Status;
import com.magnani.os.repositories.ClienteRepository;
import com.magnani.os.repositories.OSRepository;
import com.magnani.os.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private OSRepository osRepository;
	
	
	public void instanciaDB(){
		

		Tecnico t1 = new Tecnico(null, "Joao Magnani", "048.532.849-66", "(47) 99255-5785");
		Cliente c1 = new Cliente(null, "Ana Teste", "961.386.640-00", "(47) 99999-8888");
		OS os1 = new OS(null, Prioridade.ALTA, "teste asdasd", Status.ABERTO, t1, c1);

		t1.getList().add(os1);
		c1.getList().add(os1);

		tecnicoRepository.saveAll(Arrays.asList(t1));
		clienteRepository.saveAll(Arrays.asList(c1));
		osRepository.saveAll(Arrays.asList(os1));

		
	}
	
}
