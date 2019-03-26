package bean;

import java.util.Date;

import lombok.Data;

@Data
public class UserBean {
	private String userName;
	private String password;
	private String phone;
	private String email;
	private Date created;
	private Date updated;
}
