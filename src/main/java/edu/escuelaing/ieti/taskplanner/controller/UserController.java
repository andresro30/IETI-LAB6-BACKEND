package edu.escuelaing.ieti.taskplanner.controller;

import edu.escuelaing.ieti.taskplanner.model.User;
import edu.escuelaing.ieti.taskplanner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/taskplanner")
public class UserController {

    @Autowired
    private UserService userService = null;

    @RequestMapping(value = "/hellow",method = RequestMethod.GET)
    public ResponseEntity<?> getHellow(){
        try{
            System.out.println("Hellow your api controller is working");
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE,null,e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(value = "/getUsers",method = RequestMethod.GET)
    public ResponseEntity<?> getAll(){
        try{
            List<User> users = userService.getAll();
            return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE,null,e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(value = "/getUser/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getUserById(@PathVariable String id){
        try{
            User user = userService.getById(id);
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE,null,e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody User user){
        try{
            User newUser = userService.create(user);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        }
        catch (Exception e){
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE,null,e);
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/changeUser",method = {RequestMethod.PATCH,RequestMethod.PUT})
    public ResponseEntity<?> updateUser(@RequestBody User user){
        try{
            System.out.println("vamos a mddificar");
            User newUser = userService.update(user);
            return new ResponseEntity<>(newUser, HttpStatus.OK);
        }
        catch (Exception e){
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE,null,e);
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/deleteUser/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable String id){
        try{
            userService.remove(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE,null,e);
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }







}
