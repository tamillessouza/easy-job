package mjv.spring.web.mvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mjv.spring.web.mvc.model.Cadastro;
import mjv.spring.web.mvc.repository.CadastroRepository;

@Service
public class CadastroServiceIm implements CadastroService {
	
	@Autowired
	private CadastroRepository cadastroRepository;
	
	@Override
	public List<Cadastro> getAllCadastros(){
		return cadastroRepository.findAll();
	}

	@Override
	public void saveCadastro(Cadastro cadastro) {
		this.cadastroRepository.save(cadastro);
		
	}

	@Override
	public Cadastro getCadastroById(long id) {
		Optional<Cadastro> optional = cadastroRepository.findById(null);
		Cadastro cadastro = null;
		if (optional.isPresent()) {
			cadastro = optional.get();
		} else {
			throw new RuntimeException("nao encontrado pelo id " + id);
		}
		return cadastro;
	}

	@Override
	public void deleteCadastroById(long id) {
		this.cadastroRepository.deleteById(id);
		
	}
}
