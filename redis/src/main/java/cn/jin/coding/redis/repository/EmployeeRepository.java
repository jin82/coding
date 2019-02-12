package cn.jin.coding.redis.repository;

import cn.jin.coding.redis.domain.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jin on 2019/1/7.
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

    @Query(value = "SELECT e.* from f_company_employee e where e.company_id = ?1 and e.status = 1 "
            ,nativeQuery = true)
    List<Employee> findAllNormalEmployee(Integer companyId);

}
