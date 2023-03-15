package testdata;


import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class PersonData {
    public static PersonData getData() {
        System.out.println("--------------" + GlobalConstants.PROJECT_PATH);

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);

            return mapper.readValue(
                    new File(GlobalConstants.PROJECT_PATH + "/src/main/java/testdata/Person.json"),
                    PersonData.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @JsonProperty("firstname")
    private String firstname;

    public String getFirstname() {
        return firstname;
    }

    @JsonProperty("lastname")
    private String lastname;

    public String getLastname() {
        return lastname;
    }

    @JsonProperty("fullname")
    private String fullname;

    public String getFullname() {
        return fullname;
    }

    @JsonProperty("ContactDetail")
    ContactDetail contactDetail;

    public static class ContactDetail {

        @JsonProperty("editFirstName")
        private String editFirstName;

        @JsonProperty("editLastName")
        private String editLastName;

    }

    public String getEditFirstName() {
        return contactDetail.editFirstName;
    }

    public String getEditLastName() {
        return contactDetail.editLastName;
    }

}
