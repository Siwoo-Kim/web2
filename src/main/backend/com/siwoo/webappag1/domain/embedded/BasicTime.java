package com.siwoo.webappag1.domain.embedded;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.siwoo.webappag1.converter.JsonLocalDateTimeDeSerializer;
import com.siwoo.webappag1.converter.JsonLocalDateTimeSerializer;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
@Getter @ToString
@EqualsAndHashCode(of={"created","updated"})
public class BasicTime {

    @JsonSerialize(using = JsonLocalDateTimeSerializer.class)
    @JsonDeserialize(using = JsonLocalDateTimeDeSerializer.class)
    private LocalDateTime created;
    @JsonSerialize(using = JsonLocalDateTimeSerializer.class)
    @JsonDeserialize(using = JsonLocalDateTimeDeSerializer.class)
    private LocalDateTime updated;

    protected BasicTime() {}

    public BasicTime(LocalDateTime created, LocalDateTime updated) {
        this.created = created;
        this.updated = updated;
    }
}
