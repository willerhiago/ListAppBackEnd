package com.groupoffive.listapp.routers;

import com.groupoffive.listapp.controllers.CategoriesController;
import com.groupoffive.listapp.exceptions.CategoryNameAlreadyInUseException;
import com.groupoffive.listapp.exceptions.CategoryNotFoundException;
import com.groupoffive.listapp.models.Categoria;
import com.groupoffive.listapp.models.Produto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@RequestMapping("/categories")
public class CategoriesRouter {

    private CategoriesController categoriesController;

    public CategoriesRouter(CategoriesController categoriesController) {
        this.categoriesController = categoriesController;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Set<Produto> getProductsFromCategory(@PathVariable("id") int categoryId) throws CategoryNotFoundException {
        return categoriesController.getProducts(categoryId);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Categoria addCategory(String nome) throws CategoryNameAlreadyInUseException {
        return categoriesController.addCategory(nome);
    }

}
