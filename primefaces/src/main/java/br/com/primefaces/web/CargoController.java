package br.com.primefaces.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.primefaces.domain.Cargo;
import br.com.primefaces.repository.CargoRepository;
import br.com.primefaces.service.CargoService;

@Component
@Scope("view")
@Qualifier("cargoController")
public class CargoController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Cargo cargo;
	
	@SuppressWarnings("unused")
	private List<Cargo> listaDeCargos;
	
	@Autowired
	private CargoRepository cargoRepository;
	
	@Autowired
	private CargoService cargoService;
	
	public CargoController() {
		listaDeCargos = new ArrayList<Cargo>();
		cargo = new Cargo();
	}
	
	public String getEditCargo() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Map<String,String> params = facesContext.getExternalContext().getRequestParameterMap();
		if(params.get("id") != null) {
			Integer id = Integer.parseInt(params.get("id"));
			this.cargo = cargoRepository.findOne(id);
		}
		return "form";
	}
	
	public String redirectEditCargo(){
		return "form?faces-redirect=true&amp;id=" + cargo.getId();
	}
	
	public String salvarCargo() {
		cargoService.salvarCargo(this.cargo);
		return "list";
	}
	
	public String deletarCargo(){
		cargoService.excluirCargo(this.cargo.getId());
		return "list";
	}

	public List<Cargo> getListaDeCargos() {
		return cargoRepository.findAll();
	}

	public void setListaDeCargos(List<Cargo> listaDeCargos) {
		this.listaDeCargos = listaDeCargos;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
}
