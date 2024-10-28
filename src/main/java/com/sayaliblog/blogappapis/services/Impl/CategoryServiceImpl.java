package com.sayaliblog.blogappapis.services.Impl;

import aj.org.objectweb.asm.commons.Remapper;
import com.sayaliblog.blogappapis.entities.Category;
import com.sayaliblog.blogappapis.exceptions.ResourceNotFoundException;
import com.sayaliblog.blogappapis.payloads.CategoryDto;
import com.sayaliblog.blogappapis.repositories.CategoryRepo;
import com.sayaliblog.blogappapis.services.CategoryService;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//import static java.util.stream.Nodes.collect;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {

       Category category= this.modelMapper.map(categoryDto, Category.class);
       Category addedCategory = this.categoryRepo.save(category);
        return this.modelMapper.map(addedCategory, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {

        Category category1 = this.categoryRepo.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category", "id", categoryId));

        category1.setCategoryTitle(categoryDto.getCategoryTitle());
        category1.setCategoryDescription(categoryDto.getCategoryDescription());

        Category savedCategory = this.categoryRepo.save(category1);
        CategoryDto updatedCategoryDto = this.modelMapper.map(savedCategory, CategoryDto.class);
        return updatedCategoryDto;
    }

    @Override
    public void deleteCategory(Integer categoryId) {

        Category c1 = this.categoryRepo.findById(categoryId).
                orElseThrow(()-> new ResourceNotFoundException("Category", "id", categoryId));

        this.categoryRepo.delete(c1);
    }

    @Override
    public CategoryDto getCategory(Integer categoryId) {
        Category c1 = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "id", categoryId));
        CategoryDto categoryDto = this.modelMapper.map(c1, CategoryDto.class);

        return categoryDto;
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> categories = this.categoryRepo.findAll();
      List<CategoryDto> catDtos =  categories.stream().map((variable)->this.modelMapper.map(variable,CategoryDto.class)).collect(Collectors.toList());

        return catDtos;
//        List<CategoryDto> categoryDtos = new ArrayList<>();
//        for (Category c : categories) {
//            categoryDtos.add(this.modelMapper.map(c, CategoryDto.class));
//        }
//
//        return categoryDtos;
    }
}
