package br.unipe.javaweb.controleacademico.manual;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.unipe.javaweb.controleacademico.dao.AdministradorDAO;
import br.unipe.javaweb.controleacademico.model.Administrador;
import br.unipe.javaweb.controleacademico.model.Endereco;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class AdministradorRegister {
	@Autowired
	private AdministradorDAO administradorDAO;

	@Test
	public void testeSalvarAdministrador() {
		
		Endereco endereco = new Endereco();
		endereco.setCep("58057270");
		endereco.setLogradouro("Rua Anizio de Azevedo Lima");
		endereco.setNumero("232");
		endereco.setBairro("Mangabeira 2");
		endereco.setCidade("João Pessoa");
		endereco.setEstado("PB");
		endereco.setComplemento("Rua larga do posto texaco");
		
		Administrador adm = new Administrador();
		adm.setCpf("08678438452");
		adm.setDataNascimento(new Date());
		adm.setEmail("arthursilvestre@outlook.com");
		adm.setNome("Arthur Silvestre");
		adm.setSenha("lary7206");
		adm.setEndereco(endereco);
		
		adm = administradorDAO.save(adm);

		Assert.assertNotNull(adm.getId());
	}
	
	@Test
	public void getAdministradorById(){
		
		Administrador adm = administradorDAO.findOne(new Long(5));
		
		Assert.assertNotNull(adm);
	}

}
