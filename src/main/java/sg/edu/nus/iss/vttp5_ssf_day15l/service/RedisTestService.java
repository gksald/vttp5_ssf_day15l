package sg.edu.nus.iss.vttp5_ssf_day15l.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.vttp5_ssf_day15l.repo.ListRepo;
import sg.edu.nus.iss.vttp5_ssf_day15l.repo.ValueRepo;

@Service
public class RedisTestService {
    
    @Autowired
    ListRepo lRepo;

    @Autowired
    ValueRepo vRepo;

    // write service functions that perform some operations on the two types of repo
    

}