package in.sp.repo;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import in.sp.beans.User;

@Repository
public class UserRepository {

	@Autowired
	private JdbcTemplate jdbc;
	
	public int save(User user) {
        String sql = "insert into student values(?,?,?,?,?,?)";
        return jdbc.update(sql, user.getName(), user.getAge(), user.getCity(),user.getPass(),user.getFname(),user.getMname());
    }
	
	public User findByName(String name) {
		String sql="select * from student where name =?";
		List<User> list=jdbc.query(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				User us =new User();
				us.setName(rs.getString("name"));
				us.setAge(rs.getInt("age"));
				us.setCity(rs.getString("city"));
				us.setPass(rs.getString("password"));
				us.setFname(rs.getString("fname"));
				us.setMname(rs.getString("mname"));
				
				return us;
			}
			
		},name);
		if(list.isEmpty()) return null;
		return list.get(0);
	}
	
	
}
