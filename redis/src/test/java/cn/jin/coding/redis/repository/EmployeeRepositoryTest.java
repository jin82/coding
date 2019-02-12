package cn.jin.coding.redis.repository;

import cn.jin.coding.redis.domain.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by jin on 2019/1/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void findAllNormalEmployee() {

        List<Employee> allNormalEmployee = employeeRepository.findAllNormalEmployee(2);
        int size = allNormalEmployee.size();
        System.out.println(size);
        Assert.assertNotNull(allNormalEmployee);


    }
}