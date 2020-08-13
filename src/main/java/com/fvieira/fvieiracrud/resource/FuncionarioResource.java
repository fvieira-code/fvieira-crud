package com.fvieira.fvieiracrud.resource;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fvieira.fvieiracrud.repository.FuncionarioRepository;

import com.fvieira.fvieiracrud.model.Funcionario;

@RestController
//@RequestMapping("/funcionarios")
@RequestMapping(value = "/funcionarios", produces = { MediaType.APPLICATION_JSON_VALUE })
public class FuncionarioResource {
	
	@Autowired
    private FuncionarioRepository repository;
 
    public FuncionarioRepository getRepository() {
        return repository;
    }
 
    public void setRepository(FuncionarioRepository repository) {
        this.repository = repository;
    }
 
    @GetMapping(value = "/listar")
    public List<Funcionario> getAllEmployees() {
        return repository.findAll();
    }
 
    @PostMapping("/salvar")
    Funcionario createOrSaveEmployee(@RequestBody Funcionario newFuncionario) {
        return repository.save(newFuncionario);
    }
 
    @GetMapping("/listar-codigo/{id}")
    Funcionario getEmployeeById(@PathVariable Long id) {
        return repository.findById(id).get();
    }
 
    @PutMapping("/alterar/{id}")
    Funcionario updateFuncionario(@RequestBody Funcionario newFuncionario, @PathVariable Long id) {
 
        return repository.findById(id).map(funcionario -> {
        	
        	funcionario.setNome(newFuncionario.getNome());        	
        	//funcionario.setSobreNome(newFuncionario.getSobreNome());   
        	funcionario.setSobrenome(newFuncionario.getSobrenome());
        	funcionario.setEmail(newFuncionario.getEmail());        	
        	
        	
            return repository.save(funcionario);
        }).orElseGet(() -> {
            newFuncionario.setCodigo(id);
            return repository.save(newFuncionario);
        });
    }
 
    @DeleteMapping("/excluir/{id}")
    void deleteFuncionario(@PathVariable Long id) {
        repository.deleteById(id);
    }
}