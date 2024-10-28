package com.sayaliblog.blogappapis.controllers;



import com.sayaliblog.blogappapis.payloads.ApiResponse;
import com.sayaliblog.blogappapis.payloads.CategoryDto;
import com.sayaliblog.blogappapis.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
        @RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){

        CategoryDto createdCategory = this.categoryService.createCategory(categoryDto);

        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable("categoryId") Integer categoryId)
    {
        CategoryDto categoryDto1 = this.categoryService.getCategory(categoryId);
        CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto, categoryId);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("categoryId") Integer CId)
    {
       this.categoryService.deleteCategory(CId);
       return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully.", true), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategory()
    {
        return ResponseEntity.ok(this.categoryService.getAllCategory());
    }

    @GetMapping("/{CategoryId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("CategoryId") Integer UId)
    {
        CategoryDto categoryDto = this.categoryService.getCategory(UId);
        return ResponseEntity.ok(categoryDto);
    }








}
