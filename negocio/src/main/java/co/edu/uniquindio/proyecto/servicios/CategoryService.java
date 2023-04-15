package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category createCategory(Category cat);
}
