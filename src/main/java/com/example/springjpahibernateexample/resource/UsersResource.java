package com.example.springjpahibernateexample.resource;

import com.example.springjpahibernateexample.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.example.springjpahibernateexample.repository.UsersRepository;

@RestController
@RequestMapping("/rest/users")
public class UsersResource{

        @Autowired
        UsersRepository usersRepository;
    @GetMapping("All")
    public List<Users> getAll(){

        return usersRepository.findAll();
    }

    @GetMapping("/{name}")
    public List<Users> getUser(@PathVariable("name")final String name){

        Optional<List<Users>> listOptional=usersRepository.findByName(name);

        List<Users> users= listOptional
                .orElse(new ArrayList<>());

        return users;


    }

    @GetMapping("/id/{id}")
    public Optional<Users> getId(@PathVariable("id") final Integer id){
        /* return usersRepository.findById(id); */

    return usersRepository.findById(id);

    }
    @GetMapping("/update{id}/{name}")
    public Users update(@PathVariable("id") final Integer id, @PathVariable("name") final String name){
        Optional<Users> users=getId(id);
        Users u1=new Users();
        u1.setName(name);
        return usersRepository.save(u1);

    }

}