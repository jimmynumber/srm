package com.want.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.want.entity.Article;

public interface ArticleRepository extends JpaRepository<Article,Long> , JpaSpecificationExecutor<Article> {
    Article findById(long id);
}