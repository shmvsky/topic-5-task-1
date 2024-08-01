package ru.shmvsky.usingspringdatajpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.shmvsky.usingspringdatajpa.entity.Todo;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Integer>, PagingAndSortingRepository<Todo, Integer> {
}
