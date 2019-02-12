package cn.jin.coding.redis.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by jin on 2019/1/7.
 */
@Entity(name = "f_company_employee")
public class Employee {

    @Id
    private Integer id;

    @Column(name = "member_id")
    private String memberId;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "member_no")
    private String memberNo;

    @Column(name = "member_name")
    private String memberName;

    @Column(name = "code")
    private String code;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modify")
    private Date gmtModify;

}
