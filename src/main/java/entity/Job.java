package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Job {
    private int id;
    private String title;
    private String description;
    private String price;
    private String user;
    private int noOfComments;
}
