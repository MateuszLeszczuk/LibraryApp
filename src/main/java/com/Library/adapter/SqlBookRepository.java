package com.Library.adapter;

import com.Library.model.Book;
import com.Library.model.BookRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface SqlBookRepository extends BookRepository, JpaRepository<Book, Integer> {




}
