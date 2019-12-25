package com.imooc.service;

import com.imooc.entity.Girl;
import com.imooc.exception.GirlException;
import com.imooc.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    /**
     * 测试，插入两个新girl
     */
    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRepository.save(girlA);


        Girl girlB = new Girl();
        girlB.setCupSize("BBBB");
        girlB.setAge(19);
        girlRepository.save(girlB);
    }

    /**
     * 通过id获取年龄
     * @param id
     * @return
     * @throws Exception
     */
    public Integer getAge(Integer id) throws Exception {
        Girl girl = girlRepository.findById(id).get();
        Integer age = girl.getAge();
        if (age < 12) {
            throw new GirlException(-2001, "你可能还在上小学");
        } else if (age >= 12 && age < 16) {
            throw new GirlException(-2002, "你可能还在上初中");
        }
        return age;
    }
}
