package br.com.osmarsouza.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Users extends AbstractModel<Long> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
    private String email;
    private String password;
    

    public Users() {}


    public Users(String name, String email, String login, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
