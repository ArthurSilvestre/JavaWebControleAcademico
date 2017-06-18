package br.unipe.javaweb.controleacademico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class AbstractService<DAO extends JpaRepository<Entity, Long>, Entity> {
	
	protected DAO dao;

    @Autowired
    public void setDao(DAO dao) {
        this.dao = dao;
    }
    
	public List<Entity> listar(){
		return dao.findAll();
	}
	
	public Entity salvar(Entity entity){
		return dao.save(entity);
	}
	
	public List<Entity> saveAll(List<Entity> entitys){
		return dao.save(entitys);
	}
	
	public boolean deletar(Entity entity){
		try {
			dao.delete(entity);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Entity findById(Long id){
		return dao.findOne(id);
	}
}
