package com.employee.employeeManagement.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4411689027547764663L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	private String employee ;
	private Double salary;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/NewDelhi")
	private Date time;

	protected Employee() {
	}

	public Employee(String employee , Double salary) {
		this.employee  = employee ;
		this.salary = salary;
	}

	 public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof Employee))
	      return false;
	    Employee employee = (Employee) o;
	    return Objects.equals(this.id, employee.id) && Objects.equals(this.employee, employee.employee)
	        && Objects.equals(this.salary, employee.salary);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.id, this.employee, this.salary);
	  }

	  @Override
	  public String toString() {
	    return "Employee{" + "id=" + this.id + ", name='" + this.employee + '\'' + ", salary='" + this.salary + '\'' + ", date='" + this.time + '\'' + '}';
	  }
	
}
