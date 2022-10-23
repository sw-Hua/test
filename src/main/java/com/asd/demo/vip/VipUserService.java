package com.asd.demo.vip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VipUserService {
    @Autowired private VipUserRepository repo;
    public List<VipUser> listAll(){
        return (List<VipUser>) repo.findAll();
    }

    public void save(VipUser vipUser) {
        repo.save(vipUser);
    }

    public VipUser get(Integer id) throws UserNotFoundException {
        Optional<VipUser> result = repo.findById(id);
        if(result.isPresent()){
            return  result.get();
        }throw new UserNotFoundException("Could Not Find Any User " + id);
    }

    public void delete(Integer id) {
        /*
        Long count = repo.countById(id);
        if(count == null || count == 0){
            throw new UserNotFoundException("Could not find any users with ID" + id);
        }

         */
        repo.deleteById(id);
    }


}
