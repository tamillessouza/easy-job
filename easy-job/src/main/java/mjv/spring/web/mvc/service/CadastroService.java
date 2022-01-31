package mjv.spring.web.mvc.service;

import java.util.List;

import mjv.spring.web.mvc.model.Cadastro;

public interface CadastroService {
	List<Cadastro> getAllCadastros();
	void saveCadastro(Cadastro cadastro);
	Cadastro getCadastroById(long id);
	void deleteCadastroById(long id);
}
