package com.imooc.controller;

import com.imooc.entity.Girl;
import com.imooc.repository.GirlRepository;
import com.imooc.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GirlController {
    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping(value = "/getgirllist")
    public List<Girl> getGirlList() {
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     * @param girl
     * @return
     */
    @PostMapping(value = "/addgirl")
    public Girl addGirl(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        } else {
            girl.setCupSize(girl.getCupSize());
            girl.setAge(girl.getAge());
        }

        return girlRepository.save(girl);
    }

    //查询一个女生
    @GetMapping(value = "/getgirl")
    public Girl getGirl(@RequestParam("id") Integer id) {
        return girlRepository.findById(id).orElse(null);
    }

    //更新
    @PutMapping(value = "/updategirl")
    public Girl updateGirl(@RequestParam("id") Integer id, @RequestParam("cupSize") String cupSize, @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return girlRepository.save(girl);
    }

    //删除
    @DeleteMapping(value = "/deletegirl")
    public void deleteGirl(@RequestParam("id") Integer id) {
        Girl girl = girlRepository.findById(id).orElse(null);
        girlRepository.delete(girl);
    }

    //通过年龄查询女生列表
    @GetMapping(value = "/getgirllistbyage")
    public List<Girl> getGirlListByAge(@RequestParam("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void girlTwo() {
        girlService.insertTwo();
    }
}
