package br.com.primefaces.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.primefaces.domain.Cargo;
import br.com.primefaces.repository.CargoRepository;

@Service
@Transactional(readOnly=true)
public class CargoService {

	@Autowired
	private CargoRepository cargoRepository;
	
	@Transactional(readOnly=false)
	public Cargo salvarCargo(Cargo cargo) {
		return cargoRepository.save(cargo); 
	}
	
	@Transactional(readOnly=false)
	public void excluirCargo(Integer idCargo) {
		cargoRepository.delete(idCargo);
	}
	
}
