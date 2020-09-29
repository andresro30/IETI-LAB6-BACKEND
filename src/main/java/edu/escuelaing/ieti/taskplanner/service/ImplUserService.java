package edu.escuelaing.ieti.taskplanner.service;

import edu.escuelaing.ieti.taskplanner.model.User;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ImplUserService implements UserService {

    private List<User> users;

    public ImplUserService(){
        users = new LinkedList<User>();
        users.add(new User("Andres","andres@hotmail.com","3015","1"));
        users.add(new User("Sara","sara@hotmail.com","1000","2"));
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User getById(String userId) {
        User lu_return  = null;
        for(User iterator:users)
        {
            if(iterator != null)
            {
                String id = iterator.getId();
                if(id != null)
                {
                    if(id.equals(userId))
                        lu_return = iterator;
                }
            }
        }
        return lu_return;
    }

    @Override
    public User create(User user) {
        User lu_return = null;

        int id = users.size();
        System.out.println(id+1);
        if(user != null){
            user.setId(String.valueOf(id+1));
            users.add(user);
            lu_return = user;
        }
        return lu_return;
    }

    @Override
    public User update(User user) throws Exception {
        User lu_return = null;
        if(user != null){
            String id = user.getId();
            if(id != null){
                User actualUser = getById(id);
                if(user.getEmail() != null)
                    actualUser.setEmail(user.getEmail());
                if(user.getName() != null)
                    actualUser.setName(user.getName());
                if(user.getPassword() != null)
                    actualUser.setPassword(user.getPassword());
                lu_return = actualUser;
            }
        }
        return lu_return;
    }

    @Override
    public void remove(String userId) {
        if(userId != null){
            User user = getById(userId);
            if(user != null){
                users.remove(user);
            }
        }
    }
}
