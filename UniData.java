import java.util.ArrayList;

public class UniData implements Comparable<UniData> {
    private String Rank2024;
    private String Rank2023;
    private String institutionName;
    private String countryCode;
    private String country;
    private String size;
    private String focus;
    private String research;
    private String status;
    
    private String academicRepScore;
    private String academicRepRank;
    private String employerRepScore;
    private String employerRepRank;
    private String facultyStudentScore;
    private String facultyStudentRank;
    private String citationsScore;
    private String citationsRank;
    private String intlFacultyScore;
    private String intlFacultyRank;
    private String intlStudentsScore;
    private String intlStudentsRank;
    private String intlResearchScore;
    private String intlResearchRank;
    private String employmentScore;
    private String employmentRank;
    private String sustainabilityScore;
    private String sustainabilityRank;
    
    private String overallScore;
 
    public UniData(ArrayList<String> field) {
        this.Rank2023 = field.get(0);
        this.Rank2024 = field.get(1);
        this.institutionName = field.get(2);
        this.countryCode = field.get(3);
        this.country = field.get(4);
        this.size = field.get(5);
        this.focus = field.get(6);
        this.research = field.get(7);
        this.status = field.get(8);
        this.academicRepScore = field.get(9);
        this.academicRepRank = field.get(10);
        this.employerRepScore = field.get(11);
        this.employerRepRank = field.get(12);
        this.facultyStudentScore = field.get(13);
        this.facultyStudentRank = field.get(14);
        this.citationsScore = field.get(15);
        this.citationsRank = field.get(16);
        this.intlFacultyScore = field.get(17);
        this.intlFacultyRank = field.get(18);
        this.intlStudentsScore = field.get(19);
        this.intlStudentsRank = field.get(20);
        this.intlResearchScore = field.get(21);
        this.intlResearchRank = field.get(22);
        this.employmentScore = field.get(23);
        this.employmentRank = field.get(24);
        this.sustainabilityScore = field.get(25);
        this.sustainabilityRank = field.get(26);
        this.overallScore = field.get(27);
    }

    public String getInstitutionName() {
        return institutionName;
    }
    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }
    
    public String getCountry() {
        return country;
    }

    public String getAcademicRepScore() {
        return academicRepScore;
    }
    public void setAcademicRepScore(String academicRepScore) {
        this.academicRepScore = academicRepScore;
    }

    public String getEmployerRepScore() {
        return employerRepScore;
    }
    public void setEmployerRepScore(String employerRepScore) {
        this.employerRepScore = employerRepScore;
    }

    public String getFacultyStudentScore() {
        return facultyStudentScore;
    }
    public void setFacultyStudentScore(String facultyStudentScore) {
        this.facultyStudentScore = facultyStudentScore;
    }

    public String getCitationsScore() {
        return citationsScore;
    }
    public void setCitationsScore(String citationsScore) {
        this.citationsScore = citationsScore;
    }

    public String getIntlFacultyScore() {
        return intlFacultyScore;
    }
    public void setIntlFacultyScore(String intlFacultyScore) {
        this.intlFacultyScore = intlFacultyScore;
    }

    public String getIntlStudentsScore() {
        return intlStudentsScore;
    }
    public void setIntlStudentsScore(String intlStudentsScore) {
        this.intlStudentsScore = intlStudentsScore;
    }

    public String getIntlResearchScore() {
        return intlResearchScore;
    }
    public void setIntlResearchScore(String intlResearchScore) {
        this.intlResearchScore = intlResearchScore;
    }

    public String getEmploymentScore() {
        return employmentScore;
    }
    public void setEmploymentScore(String employmentScore) {
        this.employmentScore = employmentScore;
    }

    public String getSustainabilityScore() {
        return sustainabilityScore;
    }
    public void setSustainabilityScore(String sustainabilityScore) {
        this.sustainabilityScore = sustainabilityScore;
    }


    public String getOverallScore() {
        return overallScore;
    }
    public void setOverallScore(String overallScore) {
        this.overallScore = overallScore;
    }

    public String getRank2023() {
        return Rank2023;
    }
    public void setRank2023(String rank2023) {
        this.Rank2023 = rank2023;
    }

    public String getRank2024() {
        return Rank2024;
    }
    public void setRank2024(String rank2024) {
        this.Rank2024 = rank2024;
    }

     @Override
    public String toString() {
        String classificationLocation;
        String classificationSize;
        String classificationFocus;
        String classificationResearch;
        String classificationStatus;
        String academicReputationScore;
        String academicReputationRank;
        String employerReputationScore;
        String employerReputationRank;
        return escape(Rank2024) + "," +
            escape(Rank2023) + "," +
            escape(institutionName) + "," +
            escape(countryCode) + "," +
            escape(country) + "," +
            escape(size) + "," +
            escape(focus) + "," +
            escape(research) + "," +
            escape(status) + "," +
            escape(academicRepScore) + "," +
            escape(academicRepRank) + "," +
            escape(employerRepScore) + "," +
            escape(employerRepRank) + "," +
            escape(facultyStudentScore) + "," +
            escape(facultyStudentRank) + "," +
            escape(citationsScore) + "," +
            escape(citationsRank) + "," +
            escape(intlFacultyScore) + "," +
            escape(intlFacultyRank) + "," +
            escape(intlStudentsScore) + "," +
            escape(intlStudentsRank) + "," +
            escape(intlStudentsScore) + "," +
            escape(intlResearchRank) + "," +
            escape(employmentScore) + "," +
            escape(employmentRank) + "," +
            escape(sustainabilityScore) + "," +
            escape(sustainabilityRank) + "," +
            escape(overallScore) + "\n";
    }
        private String escape(String field) {
            if (field.contains(",")) {
                return "\"" + field + "\"";
            }
            return field;
        }
        @Override
        public int compareTo(UniData o) { 
        return this.institutionName.compareToIgnoreCase(o.institutionName);
        }
}
