package com.siwoo.webappag1.domain;

import com.siwoo.webappag1.domain.embedded.BasicTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name="tbl_topic")
@Getter @Setter @ToString
public class Topic {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id")
    private Long id;
    private String name;
    private String description;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
        name="topic_documents",
        joinColumns = @JoinColumn(name="topic_id"))
    private List<Document> documents = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name="topic_reference",
            joinColumns = @JoinColumn(name="topic_id"))
    @OrderColumn(name="ref_idx")
    List<URL> references = new ArrayList<>();
    @Column(name ="topic_rate")
    private Double rate = 0.0;
    @Column(name ="topic_hit")
    private Integer hit = 0;
    @Column(name ="topic_lickes")
    private Integer likes = 0;
    private BasicTime basicTime;


    public void setCategory(Category category) {
        this.category = category;
        if(!category.getTopics().contains(this)) {
            category.addTopic(this);
        }
    }

}
