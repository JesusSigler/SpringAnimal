# Jesus Sigler

Run Project :
mvn clean install spring-boot:run

Open Your Browser : 
localhost:8080/

Corregido error al insertar datos, debido a que el método implementado de CrudRepository intenta insertar también el valor del id:

	insert into employee(id,nombre, emp_name, emp_designation, emp_salary) values(?,?,?,?);

	@Override
	public Employee saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return employeeRepository.save(emp);
	}

	El id es auto incrementable así que no es necesario introducirlo en el insert, así pues, en las vistas no hay ningún input para introducirlo, para solucionarlo he modificado el método
	utilizando jdbcTemplate para realizar el insert, inyectando el bean de jdbcTemplate y además cambiando el retorno del método a void y eliminando la propiedad id de la sentencia sql

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void saveEmployee(Employee emp) {
		String sql = "insert into employee(emp_name, emp_designation, emp_salary) values(?,?,?)";
		jdbcTemplate.update(sql, emp.getEmpName(), emp.getEmpDesignation(), emp.getEmpSalary());

		listaEmpleados.add(emp);

	}
