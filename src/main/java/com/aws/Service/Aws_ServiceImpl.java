package com.aws.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aws.DAO.Aws_DAO;
import com.aws.Model.Model;

@Service
public class Aws_ServiceImpl implements Aws_Service {
	
	@Autowired
	public Aws_DAO aws_DAO;

	@Override
	public List<Model> getModel() {
		return this.aws_DAO.findAll();
	}

	@Override
	public Model addModel(Model model) {
		this.aws_DAO.save(model);
		return model;
	}

	@Override
	public Model updateModel(Model model) {
		this.aws_DAO.save(model);
		return model;
	}

	@Override
	public void deleteModel(int roll) {
		Model model=this.aws_DAO.getOne(roll);
		this.aws_DAO.delete(model);
	}

}
