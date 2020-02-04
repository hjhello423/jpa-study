package com.hongjun423.jpastudy.practice;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GrandChildId implements Serializable {
    private ChildId childId; //@MapsId("childId") 매핑

    @Column(name = "grandchild_id")
    private String id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrandChildId that = (GrandChildId) o;
        return childId.equals(that.childId) &&
                id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(childId, id);
    }
}
