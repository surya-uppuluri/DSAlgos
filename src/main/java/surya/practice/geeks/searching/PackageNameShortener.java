package surya.practice.geeks.searching;

public class PackageNameShortener {


    public String shortenTheNameUsingJavaSplit(String packageName) {
        //com.group.team.application -> c.g.t.application
        StringBuilder response = new StringBuilder();
        String[] subpackageNames = packageName.split("\\.");
        for (int i = 0; i < subpackageNames.length - 1; i++) {
            response.append(subpackageNames[i].charAt(0)).append(".");
        }
        response.append(subpackageNames[subpackageNames.length - 1]);
        System.out.println("Response: "+ response);
        return response.toString();
    }


}
