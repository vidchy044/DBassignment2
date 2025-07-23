//vidchayada abhicharttibutra 672115044

import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<UniData> university = new ArrayList<>();

    public static String[] parseCSVLine(String line) {
        List<String> tokens = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean inQuotes = false;

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);

            if (ch == '"') {
                inQuotes = !inQuotes; 
            } else if (ch == ',' && !inQuotes) {
                tokens.add(sb.toString());
                sb.setLength(0);
            } else {
                sb.append(ch);
            }
        }
        tokens.add(sb.toString());
        return tokens.toArray(new String[0]);
    }
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("2024 QS World University Rankings 1.2 (For qs.com).csv");
        Scanner sc = new Scanner(inputFile);
        sc.nextLine();
        sc.nextLine();
        sc.nextLine();
        sc.nextLine();
        
        while(sc.hasNextLine()){
            String dtLine = sc.nextLine();
            String[] field = parseCSVLine(dtLine);
            ArrayList<String> arr = new ArrayList<>();

            for(int i=0; i<28; i++){
                if(i<field.length){
                    String token = field[i].trim();
                    if (token.isEmpty()) {
                        arr.add("0");
                    } else {arr.add(token);}
                }else{arr.add("0");}
            }
        university.add(new UniData(arr));
        System.out.println(dtLine);
        }
        Print("ChiangMai Universtity");

        ArrayList<UniData> universities = university;
        Collections.sort(universities);

        toLowerCase(universities);
        replaceNull(universities);
        Round(universities);
        remove(universities);
        Print(universities);

        Collections.sort(universities);
        
    }

    public static void Print(String UniName)throws FileNotFoundException{
        File f = new File("QS_World University Ranking 2024.csv");
        boolean found = false;
        for(UniData y : university){
            if(y.getInstitutionName().equalsIgnoreCase(UniName)){
                PrintWriter display = new PrintWriter(f);
                display.print(y);
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("Not found University");
        }
    }

    public static void Print(ArrayList<UniData> u)throws FileNotFoundException{
        File f = new File("QS_World University Ranking 2024-updated.csv");
        PrintWriter display = new PrintWriter(f);
        for(UniData y : u){
            display.print(y);
        }
    }

    public static void toLowerCase(List<UniData> uniName) {
        String temp;
        for (UniData data: uniName) {
            temp = data.getInstitutionName().toLowerCase();
            data.setInstitutionName(temp);
        }
    }

    public static void replaceNull(List<UniData> scores) {
        for (UniData data: scores) {
            if (data.getAcademicRepScore() == null) {
                data.setAcademicRepScore("0");
            }
            if (data.getEmployerRepScore() == null) {
                data.setEmployerRepScore("0");
            }
            if (data.getFacultyStudentScore() == null) {
                data.setFacultyStudentScore("0");
            }
            if (data.getCitationsScore() == null) {
                data.setCitationsScore("0");
            }
            if (data.getIntlFacultyScore() == null) {
                data.setIntlFacultyScore("0");
            }
            if (data.getIntlStudentsScore() == null) {
                data.setIntlStudentsScore("0");
            }
            if (data.getIntlResearchScore() == null) {
                data.setIntlResearchScore("0");
            }
            if (data.getEmploymentScore() == null) {
                data.setEmploymentScore("0");
            }
            if (data.getSustainabilityScore() == null) {
                data.setSustainabilityScore("0");
            }
            if (data.getOverallScore() == null) {
                data.setOverallScore("0");
            }
        }
    }

    private static String roundScore(String score) {
        if (score == null || score.isEmpty()) {
            return "0";
        }
        try {
            double value = Double.parseDouble(score.trim());
            return String.valueOf(Math.round(value));
        } catch (NumberFormatException e) {
            return "0";
        }
    }
    public static void Round(List<UniData> scores) {
        for (UniData data: scores) {
            data.setAcademicRepScore(roundScore(data.getAcademicRepScore()));
            data.setEmployerRepScore(roundScore(data.getEmployerRepScore()));
            data.setFacultyStudentScore(roundScore(data.getFacultyStudentScore()));
            data.setCitationsScore(roundScore(data.getCitationsScore()));
            data.setIntlFacultyScore(roundScore(data.getIntlFacultyScore()));
            data.setIntlStudentsScore(roundScore(data.getIntlStudentsScore()));
            data.setIntlResearchScore(roundScore(data.getIntlResearchScore()));
            data.setEmploymentScore(roundScore(data.getEmploymentScore()));
            data.setSustainabilityScore(roundScore(data.getSustainabilityScore()));
            data.setOverallScore(roundScore(data.getOverallScore()));
        }
    }

    public static void remove(List<UniData> rankList) {
        rankList.removeIf(data -> {
            String rank2023 = data.getRank2023();
            String rank2024 = data.getRank2024();
            return !isNumeric(rank2023) || !isNumeric(rank2024);
        });
    }
    private static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) return false;
        str = str.trim();
        if (str.contains("=") || str.contains("-")) return false;
        return str.matches("\\d+");
    }


}
