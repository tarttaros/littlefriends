package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Category;
import co.edu.uniquindio.proyecto.repositorios.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImp implements CategoryService{

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public List<Category> findAll() {
        List<Category> busqueda = categoryRepo.findAll();
        if (busqueda.isEmpty())
        {
            return null;
        }else{
            return busqueda;
        }
    }

    @Override
    public Category createCategory(Category cat)
    {
        return categoryRepo.save(cat);
    }
}
