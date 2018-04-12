package com.siwoo.webappag1.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.siwoo.webappag1.converter.JsonLocalDateTimeDeSerializer;
import com.siwoo.webappag1.converter.JsonLocalDateTimeSerializer;
import com.siwoo.webappag1.domain.embedded.BasicTime;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity @Table(name="tbl_webpage",
        uniqueConstraints =
        @UniqueConstraint(name = "uniq_name",columnNames = "name"))
@Getter @Setter @ToString(exclude = {"images","categories"})
@EqualsAndHashCode(of={"name","URL"})
public class WebPage {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String greeting;

    @Column(length = 1000)
    private String introduction;

    @Column(length = 700)
    private String description;

    @Column(name="webpage_help")
    private String help;

    @Column(name="webpage_aim")
    private String aim;


    @ElementCollection
    @CollectionTable(name ="tbl_webpage_images",
    joinColumns = @JoinColumn(name ="webpage_name"))
    @MapKeyColumn(name="img_name")
    @Column(name = "images")
    private Map<String,String> images = new HashMap<>();

    @Column(name="urls")
    private URL url;

    @JsonSerialize(using = JsonLocalDateTimeSerializer.class)
    @JsonDeserialize(using = JsonLocalDateTimeDeSerializer.class)
    private LocalDateTime lastUpdated;

    @Embedded
    private BasicTime basicTime;

    @JsonIgnore
    @OneToMany(mappedBy = "webPage",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    List<Category> categories = new ArrayList<>();

    public void setCategories(List<Category> categories) {
        this.categories.clear();
        for(Category category: categories) {
            addCategory(category);
        }
    }

    private void addCategory(Category category) {
        this.categories.add(category);
        if(category != null && category.getWebPage() != this){
            category.setWebPage(this);
        }
    }
}
