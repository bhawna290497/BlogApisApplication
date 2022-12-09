package com.blog.Blog_App_Apis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.Blog_App_Apis.entities.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer> {

}
