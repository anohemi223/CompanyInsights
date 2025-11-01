
public class Report {
    private String title;
    private Double period;
    private Company company;

    // TODO
    public Report(String title, Double period, Company company) {
        this.title = title;
        this.period = period;
        this.company = company;
    }

    public Report(Object report) {
		// TODO Auto-generated constructor stub
	}

	// TODO
    public String getTitle() {
        return title;
    }

    // TODO
    public void setTitle(String title) {
        this.title = title;
    }

    // TODO
    public Double getPeriod() {
        return period;
    }

    // TODO
    public void setPeriod(Double period) {
        this.period = period;
    }

    // TODO
    public Company getCompany() {
        return company;
    }

    // TODO
    public void setCompany(Company company) {
        this.company = company;
    }
}
