/**
 * 
 */

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

/**
 * 
 */
public class User extends Company{
	private String name;
	private String email;
	private List<Company> companies;
	private Object report;
	// Constructor for creating a user with a name and email
	private User(String name, String email) {
		this.name = name;
        this.email = email;
        this.setCompanies(new ArrayList<>());

	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @return the companies
	 */
	public List<Company> getCompanies() {
		return companies;
	}
	/**
	 * @param companies the companies to set
	 */
	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	 public void launchReportGUI() {
	        SwingUtilities.invokeLater(() -> {
	            Report gui = new Report(this.report);
	            gui.setVisible(true);
	        });
	    }

}

