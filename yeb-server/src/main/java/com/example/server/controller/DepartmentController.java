package com.example.server.controller;


import com.example.server.pojo.Department;
import com.example.server.pojo.RespBean;
import com.example.server.service.DepartmentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Zeng
 * @since 2022-03-26
 */
@RestController
@RequestMapping("/system/basic/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @ApiOperation(value = "获取所有部门")
    @GetMapping("/")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @ApiOperation(value = "添加部门")
    @PostMapping("/")
    public RespBean addDep(@RequestBody Department dep){
        return departmentService.addDep(dep);
    }


    @ApiOperation(value = "删除部门")
    @DeleteMapping("/{id}")
    public RespBean deleteDep(@PathVariable Integer id){
        return departmentService.deleteDep(id);
    }
}



