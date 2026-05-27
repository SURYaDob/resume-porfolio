package com.portfolio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 50)
    private String category;

    @Column(name = "proficiency_level")
    private int proficiencyLevel;

    @Column(nullable = false)
    private boolean highlighted;

    @Column(name = "display_order")
    private int displayOrder;

    // Constructors
    public Skill() {}

    public Skill(String name, String category, int proficiencyLevel, boolean highlighted, int displayOrder) {
        this.name = name;
        this.category = category;
        this.proficiencyLevel = proficiencyLevel;
        this.highlighted = highlighted;
        this.displayOrder = displayOrder;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public int getProficiencyLevel() { return proficiencyLevel; }
    public void setProficiencyLevel(int proficiencyLevel) { this.proficiencyLevel = proficiencyLevel; }

    public boolean isHighlighted() { return highlighted; }
    public void setHighlighted(boolean highlighted) { this.highlighted = highlighted; }

    public int getDisplayOrder() { return displayOrder; }
    public void setDisplayOrder(int displayOrder) { this.displayOrder = displayOrder; }
}
