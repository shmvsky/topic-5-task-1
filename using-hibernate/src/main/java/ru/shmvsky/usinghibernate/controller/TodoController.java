package ru.shmvsky.usinghibernate.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.shmvsky.usinghibernate.dto.TodoDto;
import ru.shmvsky.usinghibernate.entity.Todo;
import ru.shmvsky.usinghibernate.service.TodoService;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public Todo createTodo(@Valid @RequestBody TodoDto todoDto) {
        return todoService.save(todoDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Todo getTodoById(@PathVariable Integer id) {
        return todoService.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Todo> getTodosPaged(@RequestParam(name = "page") int page,
                                    @RequestParam(name = "size", defaultValue = "5", required = false) int size) {
        return todoService.findAll(page, size);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Todo updateTodo(@PathVariable Integer id, @Valid @RequestBody TodoDto todoDto) {
        return todoService.update(id, todoDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTodo(@PathVariable Integer id) {
        todoService.delete(id);
    }

}
