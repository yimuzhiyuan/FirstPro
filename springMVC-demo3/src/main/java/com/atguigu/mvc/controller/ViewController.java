package com.atguigu.mvc.controller;

import com.github.pagehelper.page.PageMethod;
import mybatis.mapper.EmpMapper;
import mybatis.pojo.Emp;
import mybatis.pojo.EmpExample;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.SqlSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Date:2021/7/7
 * Author:ybc
 * Description:
 * @author YX200
 */
@Controller
public class ViewController {
    @RequestMapping("/getEmpById")
    public String getEmpById(Integer employeeId,Model model){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.selectByPrimaryKey(employeeId);
        model.addAttribute("Emp",emp);
        return "newIndex";
    }

    @RequestMapping("/EmpPage/{PageOne}")
    public String empPage(@PathVariable("PageOne") Integer page,HttpServletRequest request){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        int allCount = mapper.countByExample(null);
        Integer allPage=0;
        if(allCount/5!=0){
            allPage=allCount/5+1;
        }
        PageMethod.startPage(page,5);
        List<Emp> emps = mapper.selectByExample(null);
        emps.forEach(System.out::println);
        HttpSession session = request.getSession();
        session.setAttribute("empList",emps);
        session.setAttribute("PageOne",page);
        session.setAttribute("AllPage",allPage);

        return "test";
    }


    @RequestMapping("/testUp")
    public String testUp(){
        return "update";
    }
    @RequestMapping("/Employee/{employeeId}")
    public String Emp(@PathVariable("employeeId") String employeeId, HttpServletRequest request,Model model) throws IOException {
        int ide = Integer.parseInt(employeeId);
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.selectByPrimaryKey(ide);
      model.addAttribute("empOne",emp);
        return "update";
    }
    @RequestMapping("/UpdateEmp")
    public void updateEmp(Emp emp,HttpServletResponse response) throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        EmpExample empExample = new EmpExample();
        EmpExample.Criteria criteria = empExample.createCriteria();
        criteria.andEmployeeIdEqualTo(emp.getEmployeeId());
        mapper.updateByExampleSelective(emp,empExample);

        response.sendRedirect("test");
    }
    @ResponseBody
    @RequestMapping("/delEmp/{employeeId}")
    public void delEmp(@PathVariable("employeeId")Integer employeeId,HttpServletResponse response) throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        mapper.deleteByPrimaryKey(employeeId);
        response.sendRedirect("test");
    }

    @RequestMapping("/addEmp")
    public void addEmp(Emp emp, HttpServletResponse response) throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        mapper.insert(emp);
        response.sendRedirect("test");

    }
//    @RequestMapping("/addEmp")
//    public  String addEmp(Emp emp){
//        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
//        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
//        mapper.insert(emp);
//        return "test";
//    }
    @RequestMapping("/add")
    public String add(){

        return "add";
    }
    @RequestMapping("/newIndex")
    public String index(){
        return "newIndex";
    }

@RequestMapping("/test")
public  String test(HttpServletRequest request){
    SqlSession sqlSession = SqlSessionUtils.getSqlSession();
    EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
    PageMethod.startPage(22,5);
    List<Emp> emps = mapper.selectByExample(null);
    emps.forEach(System.out::println);
    HttpSession session = request.getSession();
    session.setAttribute("empList",emps);
    return "test";
}

    @RequestMapping("/testThymeleafView")
    public String testThymeleafView(){
        return "success";
    }

    @RequestMapping("/testForward")
    public String testForward(){
        return "forward:/testThymeleafView";
    }

    @RequestMapping("/testRedirect")
    public String testRedirect(){
        return "redirect:/testThymeleafView";
    }

}
