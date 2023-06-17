package com.simtech.sim.technology.entity;


import lombok.Data;
import lombok.Generated;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;


import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Node
@Data
public class ResearchEntity {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private ResearchEntity() {
        // Empty constructor required as of Neo4j API 2.0.5
    };

    @Relationship(type = "REQUIRES", direction = Relationship.Direction.INCOMING)
    public Set<ResearchEntity> postTech;

    public void requires(ResearchEntity tech) {
        if (postTech == null) {
            postTech = new HashSet<>();
        }
        postTech.add(tech);
    }

    public String toString() {

        return this.name + "'s post requisite => "
                + Optional.ofNullable(this.postTech).orElse(
                Collections.emptySet()).stream()
                .map(ResearchEntity::getName)
                .collect(Collectors.toList());
    }
}