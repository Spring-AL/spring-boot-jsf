package br.com.primefaces.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.primefaces.domain.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {

}
