package com.aws.Service;

import java.util.List;

import com.aws.Model.Model;

public interface Aws_Service {
	public List<Model> getModel();

	public Model addModel(Model model);

	public Model updateModel(Model model);

	public void deleteModel(int roll);

}
